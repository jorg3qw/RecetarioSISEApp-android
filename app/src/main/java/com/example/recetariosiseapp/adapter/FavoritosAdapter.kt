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

class FavoritosAdapter(
    private val favoritos: List<RecetaModel>,
    private val onFavoritoClick: ((RecetaModel) -> Unit)? = null,
    private val onItemClick: ((RecetaModel) -> Unit)? = null
) : RecyclerView.Adapter<FavoritosAdapter.FavoritosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receta, parent, false)
        return FavoritosViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritosViewHolder, position: Int) {
        val receta = favoritos[position]
        holder.nombre.text = receta.nombre
        holder.descripcion.text = receta.descripcion
        holder.creador.text = "Usuario ID: ${receta.usuarioId}" // Se usa el ID del creador para el ejemplo
        holder.favorito.isChecked = true // Se asume que todos son favoritos en esta lista

        // Eventos
        holder.favorito.setOnClickListener {
            onFavoritoClick?.invoke(receta)
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(receta)
        }
    }

    override fun getItemCount(): Int = favoritos.size

    inner class FavoritosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.ivRecetaImagen)
        val nombre: TextView = itemView.findViewById(R.id.tvRecetaNombre)
        val descripcion: TextView = itemView.findViewById(R.id.tvRecetaDescripcion)
        val creador: TextView = itemView.findViewById(R.id.tvRecetaCreador)
        val favorito: CheckBox = itemView.findViewById(R.id.cbFavorito)
    }
}
