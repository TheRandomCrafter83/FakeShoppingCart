package com.coderz.f1.sumtesting.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coderz.f1.sumtesting.databinding.RecyclerviewItemBinding
import com.coderz.f1.sumtesting.domain.model.ShoppingCartItem
import com.coderz.f1.sumtesting.utils.Utils
import java.text.NumberFormat
import java.util.*


class ShoppingCartRecyclerAdapter:
    ListAdapter<ShoppingCartItem, ShoppingCartRecyclerAdapter.ViewHolder>(DiffCallback()) {
    inner class ViewHolder (private val binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.apply {

            }
        }
        fun bind(item:ShoppingCartItem){
            binding.apply {
                textviewDescription.text = item.description
                textviewPrice.text = Utils.formatCurrency(item.price)
                if(adapterPosition % 2 == 0){
                    root.setCardBackgroundColor(Color.DKGRAY)
                } else {
                    root.setCardBackgroundColor(Color.TRANSPARENT)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:RecyclerviewItemBinding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class DiffCallback: DiffUtil.ItemCallback<ShoppingCartItem>(){
        override fun areItemsTheSame(
            oldItem: ShoppingCartItem,
            newItem: ShoppingCartItem
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ShoppingCartItem,
            newItem: ShoppingCartItem
        ): Boolean = oldItem.id == newItem.id

    }
}