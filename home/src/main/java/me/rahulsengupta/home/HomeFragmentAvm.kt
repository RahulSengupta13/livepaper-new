package me.rahulsengupta.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import me.rahulsengupta.abstractor.repository.IHomeFragmentRepository
import me.rahulsengupta.home.model.HomeFragmentViewModel
import me.rahulsengupta.shared.coroutine.ScopedViewModel

class HomeFragmentAvm(private val repo: IHomeFragmentRepository) : ScopedViewModel() {

    private val logic: HomeFragmentLogic

    private val _present = MutableLiveData<HomeFragmentViewModel>()
    val present: LiveData<HomeFragmentViewModel>
        get() = _present

    init {
        val listener = object : HomeFragmentLogic.Listener {
            override fun present(viewModel: HomeFragmentViewModel) = _present.postValue(viewModel)
        }
        logic = HomeFragmentLogic(repo, listener)
    }

    fun setup() {
        coroutineScope.launch { logic.setup() }
    }
}