package com.example.lesson6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson6.databinding.ActivityMainBinding
import com.example.lesson6.databinding.ItemTextBinding

class TextAdapter(private  val listText : MutableList<TextModel>,
                   private val  OnItemTextListener:OnItemTextListener):
    RecyclerView.Adapter<TextAdapter.TextViewHolder>(), View.OnClickListener {
    inner class TextViewHolder(private val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(textModel: TextModel) {
            binding.txtText.text = textModel.text
            itemView.setOnClickListener {
                listText.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                true
            }
            binding.txtText.text = textModel.text
            itemView.setOnClickListener{
                OnItemTextListener.onClick(textModel)
                binding.txtText.text = textModel.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(listText[position])
        holder.itemView.setOnClickListener{
            listText.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int = listText.size

    override fun onLongClick(view: View?): Boolean{
        OnItemTextListener.onLongClick(view?.tag as TextModel)
        return true
    }
}