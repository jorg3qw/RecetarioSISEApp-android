package com.example.recetariosiseapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recetariosiseapp.model.RecetaModel
import com.example.recetariosiseapp.repository.RecetaRepository

class RecetaViewModel(private val recetaRepository: RecetaRepository) : ViewModel() {

    private val _recetas = MutableLiveData<List<RecetaModel>>()
    val recetas : LiveData<List<RecetaModel>> get() = _recetas

    private val _error = MutableLiveData<String>()
    val error :LiveData<String> get() = _error

    fun listarRecetas(){
        recetaRepository.listarRecetas(
            onSuccess = {
                recetaList -> _recetas.postValue(recetaList)
            },
            onError = {
                errorMessage -> _error.postValue(errorMessage)
            }
        )
    }
}