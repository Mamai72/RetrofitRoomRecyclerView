package com.ib.retrofitroomrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ib.retrofitroomrecyclerview.R
import com.ib.retrofitroomrecyclerview.model.RecyclerData
import com.ib.retrofitroomrecyclerview.model.RecyclerList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_api.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var items = ArrayList<RecyclerData>()

    fun setUpdatedData(items: ArrayList<RecyclerData>) {
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun bind(data: RecyclerData){
        itemView.tvTitle.text = data.name
            itemView.tvDesc.text = data.description

            val url = data.owner.avatar_url
            Picasso.get()
                .load(url)
                .into(itemView.image_thumb)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_api, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}