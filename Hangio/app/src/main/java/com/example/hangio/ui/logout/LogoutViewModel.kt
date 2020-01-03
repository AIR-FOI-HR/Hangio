package com.example.hangio.ui.logout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogoutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Kliknite na gumb da bi se odjavili s ovog računa. \nPri novom pokretanju aplikacije morat ćete unijeti email i lozinku."
    }
    val text: LiveData<String> = _text
}