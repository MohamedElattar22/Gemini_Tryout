package com.mobjoy.gemini_tryout.viewMolde

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobjoy.gemini_tryout.modelIntialize
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val promptText = MutableLiveData<String>()
    val result = MutableLiveData<String?>()
    val headerText =MutableLiveData<String>()


    fun generateAnswer(){
        isLoading.value = true
        viewModelScope.launch {
            try{
                val generativeModel = modelIntialize.intializeModel()
                val response = generativeModel.generateContent(promptText.value!!)
                result.postValue(response.text)
                headerText.postValue(promptText.value)
            }
            catch (e:Exception){
                isLoading.value = false
            }
            finally {
                isLoading.value = false
            }

        }
    }


}