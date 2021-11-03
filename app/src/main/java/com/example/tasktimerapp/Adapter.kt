package com.example.tasktimerapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimerapp.databinding.ItemRowBinding

class Adapter(val active:ViewTask,var list:ArrayList<List<Any>>): RecyclerView.Adapter<Adapter.ItemBinding>() {
    class ItemBinding (val bin :ItemRowBinding):RecyclerView.ViewHolder(bin.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBinding {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemBinding, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}