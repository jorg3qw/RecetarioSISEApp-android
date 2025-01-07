package com.example.recetariosiseapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recetariosiseapp.databinding.ActivityMainBinding
import com.example.recetariosiseapp.repository.RecetaRepository
import com.example.recetariosiseapp.retrofit.GenericViewModelFactory
import com.example.recetariosiseapp.viewmodel.RecetaViewModel

class MainActivity : AppCompatActivity() {

    private var _binding :ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!

    private val recetaViewModel : RecetaViewModel by viewModels(){
        GenericViewModelFactory {RecetaViewModel(RecetaRepository())}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recetaViewModel.listarRecetas()
        observerRecetas()
    }

    private fun observerRecetas() {
        recetaViewModel.recetas.observe(this){listRecetas ->
            Log.e("mensaje","La lista es: $listRecetas")

        }
        recetaViewModel.error.observe(this){errorMessage ->
            Log.e("mensaje","Error: $errorMessage")

        }
    }
}