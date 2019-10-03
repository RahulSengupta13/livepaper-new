package me.rahulsengupta.network.core.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import me.rahulsengupta.domain.ports.UnsplashApiPort
import me.rahulsengupta.network.BuildConfig
import me.rahulsengupta.network.adapter.UnsplashAdapter
import me.rahulsengupta.network.service.UnsplashEndpoints
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModules {

    private const val BASE_URL_UNSPLASH = "https://api.unsplash.com/"

    private val retrofitModule = module {
        single { createUnsplashRetrofitClient() }
    }

    private val serviceModule = module {
        single { get<Retrofit>().create(UnsplashEndpoints::class.java) }
    }

    private val portModule = module {
        single<UnsplashApiPort> { UnsplashAdapter(get()) }
    }

    val modules: List<Module>
        get() = listOf(retrofitModule, serviceModule, portModule)

    private fun createUnsplashRetrofitClient(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
        val headerAuthorizationInterceptor = Interceptor { chain ->
            val request = chain.request()
            val originalHttpUrl = request.url()

            val url = originalHttpUrl
                .newBuilder()
                .build()

            val requestBuilder = request
                .newBuilder()
                .addHeader("Authorization", "Client-ID ${BuildConfig.LivePaper_Unsplash_AccessKey}")
                .url(url)

            chain.proceed(requestBuilder.build())
        }

        okHttpClient.apply {
            addInterceptor(headerAuthorizationInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL_UNSPLASH)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().disableHtmlEscaping().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}