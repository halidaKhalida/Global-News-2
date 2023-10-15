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
import com.example.globalnews.model.ArticlesItem3

class PopularAdapter:RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    var itemClickPopular:((Int)->Unit)?=null
    var itemClick:((Int)->Unit)?=null
    private val popularList=ArrayList<ArticlesItem>()

    fun sublistPopular(popularListttt:ArrayList<ArticlesItem>){
        this.popularList.clear()
        this.popularList.addAll(popularListttt)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular,parent,false))
    }

    override fun getItemCount()=popularList.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val popularNews=popularList[position]
        Glide.with(holder.ivPopular).load(popularNews.urlToImage).into(holder.ivPopular)


        holder.tvPopularAuther.text= popularNews.author.toString()
        holder.tvPopularTitle.text=popularNews.title
        holder.tvPopularPublAt.text=popularNews.publishedAt

        holder.apply {
            tvPopularTitle.text=popularNews.title
            Log.d("@@@","onPopularViewHolder: $popularNews")
        }
        holder.llPopular.setOnClickListener{
            itemClick?.invoke(position)
        }
    }
    class PopularViewHolder(view:View):RecyclerView.ViewHolder(view){
        val ivPopular=view.findViewById<ImageView>(R.id.iv_popular)
        val tvPopularAuther=view.findViewById<TextView>(R.id.tv_popular_auther)
        val tvPopularTitle=view.findViewById<TextView>(R.id.tv_popular_title)
        val tvPopularPublAt=view.findViewById<TextView>(R.id.tv_popular_publishedat)
        val llPopular=view.findViewById<LinearLayout>(R.id.ll_item_for_you)
    }
}