package com.example.recetariosiseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recetariosiseapp.R
import com.example.recetariosiseapp.model.RecetaModel

class RecetaAdapter(
    private val recetas: List<RecetaModel>,
    private val onFavoritoClick: (RecetaModel) -> Unit,
    private val onRecetaClick: (RecetaModel) -> Unit
) : RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receta, parent, false)
        return RecetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val receta = recetas[position]
        holder.bind(receta)
    }

    override fun getItemCount(): Int = recetas.size

    inner class RecetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imagen: ImageView = itemView.findViewById(R.id.ivRecetaImagen)
        private val nombre: TextView = itemView.findViewById(R.id.tvRecetaNombre)
        private val descripcion: TextView = itemView.findViewById(R.id.tvRecetaDescripcion)
        private val creador: TextView = itemView.findViewById(R.id.tvRecetaCreador)
        private val favorito: CheckBox = itemView.findViewById(R.id.cbFavorito)

        fun bind(receta: RecetaModel) {
            nombre.text = receta.nombre
            descripcion.text = receta.descripcion
            creador.text = "Por: Usuario ${receta.usuarioId}"
            favorito.isChecked = false

            // Configurar imagen (puedes usar Glide o Picasso más adelante)
            imagen.setImageResource(R.drawable.icon1)

            // Eventos de clic
            favorito.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) onFavoritoClick(receta)
            }

            itemView.setOnClickListener {
                onRecetaClick(receta)
            }
        }
    }
}
