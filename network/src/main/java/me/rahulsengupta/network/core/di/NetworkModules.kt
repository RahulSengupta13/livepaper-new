package me.rahulsengupta.network.core.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import me.rahulsengupta.domain.ports.TypiCodeApiPort
import me.rahulsengupta.network.adapter.TypiCodeAdapter
import me.rahulsengupta.network.service.TypicodeEndpoints
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModules {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val retrofitModule = module {
        single { createRetrofitClient() }
    }

    private val serviceModule = module {
        single { get<Retrofit>().create(TypicodeEndpoints::class.java) }
    }

    private val portModule = module {
        single<TypiCodeApiPort> { TypiCodeAdapter(get()) }
    }

    val modules: List<Module>
        get() = listOf(retrofitModule, serviceModule, portModule)

    private fun createRetrofitClient(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val headerAuthorizationInterceptor = Interceptor { chain ->
            val request = chain.request()
            val originalHttpUrl = request.url()

            val url = originalHttpUrl
                .newBuilder()
                .build()

            val requestBuilder = request
                .newBuilder()
                .url(url)

            chain.proceed(requestBuilder.build())
        }

        okHttpClient.apply {
            addInterceptor(headerAuthorizationInterceptor)
//            addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().disableHtmlEscaping().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}