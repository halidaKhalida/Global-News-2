package com.example.globalnews.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.globalnews.R
import com.example.globalnews.model.ArticlesItem

class EntertaimentsAdapter:RecyclerView.Adapter<EntertaimentsAdapter.EntertaimentsViewHolder>() {
    var itemClickHealth:((Int)->Unit)?=null
    var itemClick:((Int)->Unit)?=null
    val entertaimentList=ArrayList<ArticlesItem>()

    fun sublistEntertaiments(entertaiment:ArrayList<ArticlesItem>){
        this.entertaimentList.clear()
        this.entertaimentList.addAll(entertaiment)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntertaimentsViewHolder {
        return EntertaimentsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_entertaiments,parent,false))
    }

    override fun getItemCount()=entertaimentList.size

    override fun onBindViewHolder(holder: EntertaimentsViewHolder, position: Int) {
        val entartaimentsNews=entertaimentList[position]
        Glide.with(holder.ivEntertaiments).load(entartaimentsNews.urlToImage).into(holder.ivEntertaiments)
        if (entartaimentsNews.author == null){
            holder.tvEntertaimentsAuther.visibility = View.GONE
            holder.tvEntertaimentsTitle.visibility=View.GONE
            holder.ivEntertaiments.visibility=View.GONE
            holder.tvEntertaimentsPublAt.visibility=View.GONE
        }
        if (entartaimentsNews.urlToImage==null){
            holder.ivEntertaiments.visibility=View.GONE
            holder.tvEntertaimentsAuther.visibility = View.GONE
            holder.tvEntertaimentsTitle.visibility=View.GONE
            holder.tvEntertaimentsPublAt.visibility=View.GONE
        }
        holder.tvEntertaimentsAuther.text=entartaimentsNews.author.toString()
        holder.tvEntertaimentsTitle.text=entartaimentsNews.title
        holder.tvEntertaimentsPublAt.text=entartaimentsNews.publishedAt
        holder.llEntertaiments.setOnClickListener{
            itemClick?.invoke(position)
        }

    }
    class EntertaimentsViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivEntertaiments=view.findViewById<ImageView>(R.id.iv_entertaiments)
        val tvEntertaimentsAuther=view.findViewById<TextView>(R.id.tv_entertaiments_auther)
        val tvEntertaimentsTitle=view.findViewById<TextView>(R.id.tv_entertaiments_title)
        val tvEntertaimentsPublAt=view.findViewById<TextView>(R.id.tv_entertaiments_publishedat)
        val llEntertaiments=view.findViewById<LinearLayout>(R.id.ll_item_entertaiments)
    }
}