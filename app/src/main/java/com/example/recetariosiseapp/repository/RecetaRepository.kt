package com.example.recetariosiseapp.repository

import com.example.recetariosiseapp.model.RecetaModel
import com.example.recetariosiseapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecetaRepository {

    private val api = RetrofitClient.instance
    fun listarRecetas(onSuccess : (List<RecetaModel>) -> Unit, onError :(String) -> Unit){
        api.listaRecetas().enqueue(object : Callback<List<RecetaModel>> {
            override fun onResponse(
                call: Call<List<RecetaModel>>,
                response: Response<List<RecetaModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let{
                        onSuccess(it)
                    } ?: onError ("Data no habilitada")
                } else{
                    onError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<RecetaModel>>, t: Throwable) {
                onError("Mensaje de error: ${t.message}")
            }
        })
    }
}