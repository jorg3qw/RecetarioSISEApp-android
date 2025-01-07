package com.example.recetariosiseapp.model

import com.google.gson.annotations.SerializedName

data class RecetaModel(

    @SerializedName("id")
    val id :Int,
    @SerializedName("usuarioId")
    val usuarioId :Int,
    @SerializedName("nombre")
    val nombre :String,
    @SerializedName("descripcion")
    val descripcion :String,
    @SerializedName("fotoUrl")
    val fotoUrl :String,
    @SerializedName("tiempoPreparacion")
    val tiempoPreparacion :Int,
    @SerializedName("numeroPorciones")
    val numeroPorciones :Int
)