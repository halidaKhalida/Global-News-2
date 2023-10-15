package com.example.globalnews.adapter

import android.annotation.SuppressLint
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
import com.example.globalnews.model.ArticlesItem2



class BusinessAdapter:RecyclerView.Adapter<BusinessAdapter.BusinessViewHoldel>() {
    var itemClickBusiness:((Int)->Unit)?=null
    var itemClickk:((Int)->Unit)?=null
    private val businessList=ArrayList<ArticlesItem2>()

    fun sublistBusiness(bisnesList: ArrayList<ArticlesItem2>){
        this.businessList.clear()
        this.businessList.addAll(bisnesList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHoldel {
        return BusinessViewHoldel(LayoutInflater.from(parent.context).inflate(R.layout.item_business,parent,false))
    }

    override fun getItemCount()=businessList.size

    override fun onBindViewHolder(holder: BusinessViewHoldel, position: Int) {
        val bissnesNews=businessList[position]
        Glide.with(holder.ivBisness).load(bissnesNews.urlToImage).into(holder.ivBisness)

        holder.tvBisnessAuther.text=bissnesNews.author
        holder.tvBisnessTitle.text=bissnesNews.title
        holder.tvBisnessPublAt.text=bissnesNews.publishedAt

            holder.tvBisnessTitle.text=bissnesNews.title
            Log.d("@","onBisnesViewHoldel:$bissnesNews")


        holder.llBisness.setOnClickListener{
            itemClickk?.invoke(position)
        }
    }

    class BusinessViewHoldel(view: View):RecyclerView.ViewHolder(view){
        val ivBisness=view.findViewById<ImageView>(R.id.iv_bisness)
        val tvBisnessAuther=view.findViewById<TextView>(R.id.tv_bisnes_auther)
        val tvBisnessTitle=view.findViewById<TextView>(R.id.tv_bisnes_title)
        val tvBisnessPublAt=view.findViewById<TextView>(R.id.tv_bisnes_publishedat)
        val llBisness=view.findViewById<LinearLayout>(R.id.ll_bussnis)

    }
}