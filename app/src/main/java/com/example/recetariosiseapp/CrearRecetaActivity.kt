package com.example.recetariosiseapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recetariosiseapp.databinding.ActivityCrearRecetaBinding

class CrearRecetaActivity : AppCompatActivity() {
    private var _binding :ActivityCrearRecetaBinding? = null
    private val binding :ActivityCrearRecetaBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCrearRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}