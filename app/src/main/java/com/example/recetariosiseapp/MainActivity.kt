package com.example.recetariosiseapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recetariosiseapp.adapter.RecetaAdapter
import com.example.recetariosiseapp.databinding.ActivityMainBinding
import com.example.recetariosiseapp.model.RecetaModel
import com.example.recetariosiseapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recetaAdapter: RecetaAdapter

    // Datos de ejemplo en caso de error o falta de datos de la API
    private val recetasDeEjemplo = listOf(
        RecetaModel(1, 1, "Tacos", "Tacos mexicanos con salsa", "https://via.placeholder.com/150", 30, 4),
        RecetaModel(2, 2, "Pizza", "Pizza con queso y tomate", "https://via.placeholder.com/150", 20, 2),
        RecetaModel(3, 3, "Hamburguesa", "Hamburguesa con papas fritas", "https://via.placeholder.com/150", 15, 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupBottomMenu()
        fetchRecetasFromApi()
    }

    private fun setupRecyclerView() {
        recetaAdapter = RecetaAdapter(emptyList())
        binding.rvRecetas.layoutManager = LinearLayoutManager(this)
        binding.rvRecetas.adapter = recetaAdapter
    }

    private fun setupBottomMenu() {
        binding.ivRecetas.setOnClickListener {
            Log.i("MainActivity", "Ya estás en la pantalla de Recetas")
        }

        binding.ivMisRecetas.setOnClickListener {
            val intent = Intent(this, MisRecetasActivity::class.java)
            startActivity(intent)
        }

        binding.ivFavoritos.setOnClickListener {
            val intent = Intent(this, FavoritosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchRecetasFromApi() {
        Log.i("MainActivity", "Iniciando conexión con la API...")

        val apiService = RetrofitClient.instance

        apiService.listaRecetas().enqueue(object : Callback<List<RecetaModel>> {
            override fun onResponse(call: Call<List<RecetaModel>>, response: Response<List<RecetaModel>>) {
                if (response.isSuccessful) {
                    val recetas = response.body()
                    if (!recetas.isNullOrEmpty()) {
                        Log.i("MainActivity", "Conexión exitosa y datos recibidos de la API")
                        recetaAdapter.updateData(recetas)
                    } else {
                        Log.w("MainActivity", "Conexión exitosa, pero no se recibieron datos de la API")
                        recetaAdapter.updateData(recetasDeEjemplo)
                    }
                } else {
                    Log.e("MainActivity", "Error en la respuesta de la API: ${response.code()} - ${response.message()}")
                    recetaAdapter.updateData(recetasDeEjemplo)
                }
            }

            override fun onFailure(call: Call<List<RecetaModel>>, t: Throwable) {
                Log.e("MainActivity", "Fallo en la conexión con la API: ${t.message}", t)
                Toast.makeText(
                    this@MainActivity,
                    "No se pudo conectar a la API. Verifica tu conexión.",
                    Toast.LENGTH_LONG
                ).show()
                recetaAdapter.updateData(recetasDeEjemplo)
            }
        })
    }
}
