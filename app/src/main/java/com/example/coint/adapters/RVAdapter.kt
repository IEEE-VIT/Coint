package com.example.coint.adapters

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coint.R
import com.example.coint.models.CoinData

class RVAdapter(
    val context: Context
): RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    private val allEntries = ArrayList<CoinData>()
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTV =itemView.findViewById<TextView>(R.id.tvCoinTitle)
        val descTV= itemView.findViewById<TextView>(R.id.tvCoinDescription)
        val valueTV =itemView.findViewById<TextView>(R.id.tvCoinValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_coin,parent,false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTV.setText(allEntries.get(position).abbrev)
        holder.descTV.setText(allEntries.get(position).full)
        holder.valueTV.setText(allEntries.get(position).value.toString())

    }

    override fun getItemCount(): Int {
        return allEntries.size
    }

    fun updateList(newList: List<CoinData>){
        allEntries.clear()
        allEntries.addAll(newList)
        notifyDataSetChanged()
    }
}