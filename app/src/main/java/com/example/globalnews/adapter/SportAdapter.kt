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

class SportAdapter:RecyclerView.Adapter<SportAdapter.SportViewHolder>() {
    var itemClickHealth:((Int)->Unit)?=null
    var itemClick:((Int)->Unit)?=null
    val sportList=ArrayList<ArticlesItem>()

    fun sublistSport(sportt:ArrayList<ArticlesItem>){
        this.sportList.clear()
        this.sportList.addAll(sportt)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        return SportViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sport,parent,false))
    }

    override fun getItemCount()=sportList.size

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val sportNews=sportList[position]
        Glide.with(holder.ivSport).load(sportNews.urlToImage).into(holder.ivSport)
        if (sportNews.author == null){
            holder.tvSportAuther.visibility = View.GONE
            holder.tvSportTitle.visibility=View.GONE
            holder.ivSport.visibility=View.GONE
            holder.tvSportPublAT.visibility=View.GONE
        }
        if (sportNews.urlToImage==null){
            holder.ivSport.visibility=View.GONE
            holder.tvSportAuther.visibility = View.GONE
            holder.tvSportTitle.visibility=View.GONE
            holder.tvSportPublAT.visibility=View.GONE
        }
        holder.tvSportAuther.text=sportNews.author.toString()
        holder.tvSportTitle.text=sportNews.title
        holder.tvSportPublAT.text=sportNews.publishedAt
        holder.llSport.setOnClickListener{
            itemClick?.invoke(position)
        }
    }
    class SportViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivSport=view.findViewById<ImageView>(R.id.iv_sport)
        val tvSportAuther=view.findViewById<TextView>(R.id.tv_sport_auther)
        val tvSportTitle=view.findViewById<TextView>(R.id.tv_sport_title)
        val tvSportPublAT=view.findViewById<TextView>(R.id.tv_sport_publishedat)
        val llSport=view.findViewById<LinearLayout>(R.id.ll_item_sport)
    }
}