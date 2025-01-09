package com.example.recetariosiseapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recetariosiseapp.adapter.FavoritosAdapter
import com.example.recetariosiseapp.databinding.ActivityFavoritosBinding
import com.example.recetariosiseapp.model.RecetaModel

class FavoritosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Datos simulados
        val favoritosEjemplo = listOf(
            RecetaModel(1, 1, "Tacos", "Deliciosos tacos mexicanos", "", 30, 2),
            RecetaModel(2, 1, "Pizza", "Pizza napolitana con queso", "", 45, 4),
            RecetaModel(3, 1, "Hamburguesa", "Hamburguesa con papas fritas", "", 25, 1),
            RecetaModel(1, 1, "Tacos", "Deliciosos tacos mexicanos", "", 30, 2),
            RecetaModel(2, 1, "Pizza", "Pizza napolitana con queso", "", 45, 4),
            RecetaModel(3, 1, "Hamburguesa", "Hamburguesa con papas fritas", "", 25, 1),
            RecetaModel(1, 1, "Tacos", "Deliciosos tacos mexicanos", "", 30, 2),
            RecetaModel(2, 1, "Pizza", "Pizza napolitana con queso", "", 45, 4),
            RecetaModel(3, 1, "Hamburguesa", "Hamburguesa con papas fritas", "", 25, 1)
        )

        // Configurar RecyclerView
        val adapter = FavoritosAdapter(favoritosEjemplo)
        binding.rvFavoritos.layoutManager = LinearLayoutManager(this)
        binding.rvFavoritos.adapter = adapter

        // Configurar eventos para los botones del menú inferior
        binding.ivRecetas.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.ivMisRecetas.setOnClickListener {
            val intent = Intent(this, MisRecetasActivity::class.java)
            startActivity(intent)
        }

        binding.ivFavoritos.setOnClickListener {
            // Ya estás en la pantalla de Favoritos, no haces nada
        }
    }
}
