package com.grl.paises.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.grl.paises.Pais
import com.grl.paises.databinding.ItemPaisBinding

class PaisViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private var binding = ItemPaisBinding.bind(view)

    fun render(pais: Pais, onClickListener: (Pais) -> Unit){
        binding.nombrePais.text = pais.nombre
        binding.bandera.setImageResource(pais.bandera)
        binding.europea.setImageResource(pais.imagenEuropa)
        itemView.setOnClickListener{
            onClickListener(pais)
        }
    }
}