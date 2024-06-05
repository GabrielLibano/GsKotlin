package com.example.gustavogadini95909.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gustavogadini95909.R
import com.example.gustavogadini95909.model.PraiaModel

class PraiasAdapter : RecyclerView.Adapter<PraiasAdapter.ItemViewHolder>() {

    private val items = mutableListOf<PraiaModel>()

    fun addItem(newItem: PraiaModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: PraiaModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    fun removeAllItens() {
        items.removeAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.praia_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome = view.findViewById<TextView>(R.id.textViewNomePraia)
        val cidade = view.findViewById<TextView>(R.id.textViewCidade)
        val estado = view.findViewById<TextView>(R.id.textViewEstado)
        val button = view.findViewById<Button>(R.id.buttonExcluir)

        fun bind(praia: PraiaModel) {
            nome.text = praia.nome
            cidade.text = praia.cidade
            estado.text = praia.estado

            button.setOnClickListener {
                praia.onRemove(praia)
            }
        }
    }
}