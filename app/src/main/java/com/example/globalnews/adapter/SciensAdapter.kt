package com.example.globalnews.adapter

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

class SciensAdapter:RecyclerView.Adapter<SciensAdapter.ScienceViewHolder>() {
    var itemClickHealth:((Int)->Unit)?=null
    var itemClick:((Int)->Unit)?=null
    val scienceList=ArrayList<ArticlesItem>()

    fun sublistScience(sciencee:ArrayList<ArticlesItem>){
        this.scienceList.clear()
        this.scienceList.addAll(sciencee)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScienceViewHolder {
        return ScienceViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sience,parent,false))
    }

    override fun getItemCount()=scienceList.size

    override fun onBindViewHolder(holder: ScienceViewHolder, position: Int) {
        val sienceNews=scienceList[position]
        Glide.with(holder.ivScience).load(sienceNews.urlToImage).into(holder.ivScience)
        if (sienceNews.author == null){
            holder.tvScienceAuther.visibility = View.GONE
            holder.tvScienceTitle.visibility=View.GONE
            holder.ivScience.visibility=View.GONE
            holder.tvSciencePublAt.visibility=View.GONE
        }
        if (sienceNews.urlToImage==null){
            holder.ivScience.visibility=View.GONE
            holder.tvScienceAuther.visibility = View.GONE
            holder.tvScienceTitle.visibility=View.GONE
            holder.tvSciencePublAt.visibility=View.GONE
        }
        holder.tvScienceAuther.text=sienceNews.author.toString()
        holder.tvScienceTitle.text=sienceNews.title
        holder.tvSciencePublAt.text=sienceNews.publishedAt
        holder.llScience.setOnClickListener{
            itemClick?.invoke(position)
        }
    }
    class ScienceViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivScience=view.findViewById<ImageView>(R.id.iv_sience)
        val tvScienceAuther=view.findViewById<TextView>(R.id.tv_sience_auther)
        val tvScienceTitle=view.findViewById<TextView>(R.id.tv_sience_title)
        val tvSciencePublAt=view.findViewById<TextView>(R.id.tv_sience_publishedat)
        val llScience=view.findViewById<LinearLayout>(R.id.ll_since)
    }
}