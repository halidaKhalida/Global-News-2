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

class ItemForYouAdapter (): RecyclerView.Adapter<ItemForYouAdapter.ForYouViewHolder>(){

    var itemClick: ((Int) -> Unit)? = null
    val onItemLongClick:((Int)->Unit)?=null
    private var Forlist = ArrayList<ArticlesItem>()

    fun submitList(list:ArrayList<ArticlesItem>){
        this.Forlist.clear()
        this.Forlist.addAll(list)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForYouViewHolder {
        return ForYouViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_for_you,parent,false))
    }

    override fun getItemCount()=Forlist.size

    override fun onBindViewHolder(holder: ForYouViewHolder, position: Int) {
        val currentnews=Forlist[position]
        Glide.with(holder.ivForYou).load(currentnews.urlToImage).into(holder.ivForYou)


        if (currentnews.author == null){
            holder.tvForYouTitle.visibility=View.GONE
            holder.ivForYou.visibility=View.GONE
            holder.tvForYouPunlishedAt.visibility=View.GONE
            holder.tvForYouAuther.visibility = View.GONE
        }
        if (currentnews.title==null){
            holder.ivForYou.visibility=View.GONE
            holder.tvForYouAuther.visibility = View.GONE
            holder.tvForYouAuther.visibility=View.GONE
            holder.tvForYouPunlishedAt.visibility=View.GONE
        }
        if (currentnews.urlToImage==null){
            holder.ivForYou.visibility=View.GONE
            holder.tvForYouAuther.visibility = View.GONE
            holder.tvForYouAuther.visibility=View.GONE
            holder.tvForYouPunlishedAt.visibility=View.GONE
        }
        holder.tvForYouAuther.text= currentnews.author.toString()

        holder.tvForYouTitle.text=currentnews.title
//        holder.tvForYouDescription.text=currentnews.description
        holder.tvForYouPunlishedAt.text=currentnews.publishedAt
//        holder.tvForYouContent.text=currentnews.content
        holder.apply {
            tvForYouTitle.text=currentnews.title
            Log.d("@@@@@","onBindingViewHolder: $currentnews")
        }
        holder.llForYou.setOnClickListener{
            itemClick?.invoke(position)
        }


    }
    class ForYouViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ivForYou=view.findViewById<ImageView>(R.id.iv_for_you)
        val tvForYouAuther=view.findViewById<TextView>(R.id.tv_auther)
        val tvForYouTitle=view.findViewById<TextView>(R.id.tv_foryou_title)
//        val tvName=view.findViewById<TextView>(R.id.tv_name)
//        val tvForYouDescription=view.findViewById<TextView>(R.id.tv_for_you_description)
        val tvForYouPunlishedAt=view.findViewById<TextView>(R.id.tv_foryou_publishedat)
//        val tvForYouContent=view.findViewById<TextView>(R.id.tv_foryou_content)

        val llForYou=view.findViewById<LinearLayout>(R.id.ll_item_for_you)


    }
}