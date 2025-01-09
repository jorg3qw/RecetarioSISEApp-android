package com.example.recetariosiseapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recetariosiseapp.adapter.RecetaAdapter
import com.example.recetariosiseapp.databinding.ActivityMainBinding
import com.example.recetariosiseapp.model.RecetaModel
import com.example.recetariosiseapp.repository.RecetaRepository
import com.example.recetariosiseapp.retrofit.GenericViewModelFactory
import com.example.recetariosiseapp.viewmodel.RecetaViewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val recetaViewModel: RecetaViewModel by viewModels {
        GenericViewModelFactory { RecetaViewModel(RecetaRepository()) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Datos de ejemplo para las recetas
        val recetasEjemplo = listOf(
            RecetaModel(1, 1, "Tacos", "Deliciosos tacos mexicanos", "", 30, 4),
            RecetaModel(2, 2, "Pizza", "Pizza napolitana con queso", "", 25, 2),
            RecetaModel(3, 3, "Hamburguesa", "Hamburguesa con papas fritas", "", 20, 1),
            RecetaModel(1, 1, "Tacos", "Deliciosos tacos mexicanos", "", 30, 4),
            RecetaModel(2, 2, "Pizza", "Pizza napolitana con queso", "", 25, 2),
            RecetaModel(3, 3, "Hamburguesa", "Hamburguesa con papas fritas", "", 20, 1),
            RecetaModel(1, 1, "Tacos", "Deliciosos tacos mexicanos", "", 30, 4),
            RecetaModel(2, 2, "Pizza", "Pizza napolitana con queso", "", 25, 2),
            RecetaModel(3, 3, "Hamburguesa", "Hamburguesa con papas fritas", "", 20, 1)
        )

        // Configurar RecyclerView con datos de ejemplo
        val adapter = RecetaAdapter(
            recetas = recetasEjemplo,
            onFavoritoClick = { receta ->
                Log.d("MainActivity", "Receta marcada como favorita: ${receta.nombre}")
            },
            onRecetaClick = { receta ->
                Log.d("MainActivity", "Receta seleccionada: ${receta.nombre}")
            }
        )

        binding.rvRecetas.layoutManager = LinearLayoutManager(this)
        binding.rvRecetas.adapter = adapter

        // Evento de clic para "Mis Recetas"
        binding.ivMisRecetas.setOnClickListener {
            val intent = Intent(this, MisRecetasActivity::class.java)
            startActivity(intent)
        }

        binding.ivFavoritos.setOnClickListener {
            val intent = Intent(this, FavoritosActivity::class.java)
            startActivity(intent)
        }

        // Simular carga desde ViewModel (puedes integrar el API más adelante)
        recetaViewModel.listarRecetas()
        observerRecetas()
    }

    private fun observerRecetas() {
        recetaViewModel.recetas.observe(this) { listRecetas ->
            Log.d("MainActivity", "Recetas cargadas: $listRecetas")
            // Aquí se puede actualizar el adaptador dinámicamente
        }
        recetaViewModel.error.observe(this) { errorMessage ->
            Log.e("MainActivity", "Error: $errorMessage")
        }
    }
}