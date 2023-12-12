package com.grl.paises.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grl.paises.Pais
import com.grl.paises.R

class PaisAdapter(
    private val listaPaises: List<Pais>,
    private val onClickListener: (Pais) -> Unit
) :
    RecyclerView.Adapter<PaisViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PaisViewHolder(layoutInflater.inflate(R.layout.item_pais, parent, false))
    }

    override fun getItemCount(): Int = listaPaises.size

    override fun onBindViewHolder(holder: PaisViewHolder, position: Int) {
        val item = listaPaises[position]
        holder.render(item, onClickListener)
    }
}