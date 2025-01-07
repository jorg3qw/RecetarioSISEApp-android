package com.example.recetariosiseapp.retrofit

import com.example.recetariosiseapp.model.RecetaModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceReceta { //Este es el endpoint

    @GET("Recetas/ObtenerRecetas")
    fun listaRecetas() : Call<List<RecetaModel>>
}