package com.example.recetariosiseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recetariosiseapp.R
import com.example.recetariosiseapp.model.RecetaModel

class RecetaAdapter(private var recetas: List<RecetaModel>) :
    RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receta, parent, false)
        return RecetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val receta = recetas[position]
        holder.nombre.text = receta.nombre
        holder.descripcion.text = "${receta.descripcion} - ${receta.tiempoPreparacion} min"

        Glide.with(holder.itemView.context)
            .load(receta.fotoUrl)
            .placeholder(R.drawable.icon1) // Imagen de carga
            .error(R.drawable.icon1) // Imagen de error
            .into(holder.imagen)
    }

    override fun getItemCount(): Int = recetas.size

    fun updateData(newRecetas: List<RecetaModel>) {
        recetas = newRecetas
        notifyDataSetChanged()
    }

    inner class RecetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.ivRecetaImagen)
        val nombre: TextView = itemView.findViewById(R.id.tvRecetaNombre)
        val descripcion: TextView = itemView.findViewById(R.id.tvRecetaDescripcion)
    }
}
