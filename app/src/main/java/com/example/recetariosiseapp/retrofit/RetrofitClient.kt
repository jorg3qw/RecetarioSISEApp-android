package com.example.recetariosiseapp.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    // Cambia la IP a 10.0.2.2 para emuladores o usa la IP de tu máquina en la red local si es un dispositivo físico
    private const val BASE_URL = "http://10.0.2.2:8080/api/"

    // Configuración personalizada del cliente HTTP con mayor tiempo de espera
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS) // Tiempo de espera para establecer conexión
        .readTimeout(15, TimeUnit.SECONDS)    // Tiempo de espera para leer datos
        .writeTimeout(15, TimeUnit.SECONDS)   // Tiempo de espera para enviar datos
        .build()

    val instance: ApiServiceReceta by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // Usa el cliente HTTP con configuraciones personalizadas
            .build()
        retrofit.create(ApiServiceReceta::class.java)
    }
}
