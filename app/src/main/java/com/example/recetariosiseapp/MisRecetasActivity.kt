package com.example.recetariosiseapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recetariosiseapp.adapter.MisRecetasAdapter
import com.example.recetariosiseapp.databinding.ActivityMisRecetasBinding
import com.example.recetariosiseapp.model.RecetaModel

class MisRecetasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMisRecetasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMisRecetasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Datos simulados
        val misRecetasEjemplo = listOf(
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
        val adapter = MisRecetasAdapter(misRecetasEjemplo)
        binding.rvMisRecetas.layoutManager = LinearLayoutManager(this)
        binding.rvMisRecetas.adapter = adapter

        // Configurar eventos para los botones del menú inferior
        binding.ivRecetas.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.ivMisRecetas.setOnClickListener {
            // Ya estás en la pantalla de Mis Recetas, no haces nada
        }

        binding.ivFavoritos.setOnClickListener {
            val intent = Intent(this, FavoritosActivity::class.java)
            startActivity(intent)
        }
    }
}
