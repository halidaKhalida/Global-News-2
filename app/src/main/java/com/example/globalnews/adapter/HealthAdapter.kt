package com.example.globalnews.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.globalnews.R
import com.example.globalnews.model.ArticlesItem

class HealthAdapter:RecyclerView.Adapter<HealthAdapter.HealthViewHolder>() {
    var itemClickHealth:((Int)->Unit)?=null
    var itemClick:((Int)->Unit)?=null
    val healthList=ArrayList<ArticlesItem>()

    fun sublistHealth(healthlist:ArrayList<ArticlesItem>){
        this.healthList.clear()
        this.healthList.addAll(healthlist)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {
        return HealthViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_health,parent,false))
    }

    override fun getItemCount()=healthList.size

    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {
        val healthNews=healthList[position]
        Glide.with(holder.ivHealth).load(healthNews.urlToImage).into(holder.ivHealth)
        if (healthNews.author == null){
            holder.tvHealthAuther.visibility = View.GONE
            holder.tvHealthTitle.visibility=View.GONE
            holder.ivHealth.visibility=View.GONE
            holder.tvHealthPublAt.visibility=View.GONE
        }
        if (healthNews.urlToImage==null){
            holder.ivHealth.visibility=View.GONE
            holder.tvHealthAuther.visibility = View.GONE
            holder.tvHealthTitle.visibility=View.GONE
            holder.tvHealthPublAt.visibility=View.GONE
        }
//        if (healthNews.title==null){
//            holder.tvHealthTitle.visibility=View.GONE
//        }
        holder.tvHealthAuther.text=healthNews.author.toString()
        holder.tvHealthTitle.text=healthNews.title
        holder.tvHealthPublAt.text=healthNews.publishedAt

        holder.apply {
            tvHealthTitle.text=healthNews.title
            Log.d("@@","onHelthViewHolder: $healthNews")
        }
        holder.llHealth.setOnClickListener{
            itemClick?.invoke(position)
        }
    }
    class HealthViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivHealth=view.findViewById<ImageView>(R.id.iv_health)
        val tvHealthAuther=view.findViewById<TextView>(R.id.tv_health_auther)
        val tvHealthTitle=view.findViewById<TextView>(R.id.tv_health_title)
        val tvHealthPublAt=view.findViewById<TextView>(R.id.tv_health_publishedat)
        val llHealth=view.findViewById<LinearLayout>(R.id.ll_item_health)
    }
}