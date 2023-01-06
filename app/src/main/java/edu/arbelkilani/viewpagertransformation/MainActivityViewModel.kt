package edu.arbelkilani.viewpagertransformation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _cardFragmentHeight = MutableLiveData<Int>()
    val cardFragmentHeight: LiveData<Int> = _cardFragmentHeight

    fun setFragmentHeight(height: Int) {
        if (_cardFragmentHeight.value == null) {
            _cardFragmentHeight.value = height
        }
    }

}