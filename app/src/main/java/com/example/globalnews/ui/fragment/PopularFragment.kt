package com.example.globalnews.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globalnews.R
import com.example.globalnews.adapter.PopularAdapter
import com.example.globalnews.data.remote.ApiClient
import com.example.globalnews.model.ArticlesItem
import com.example.globalnews.model.ArticlesItem3
import com.example.globalnews.model.Popular
import com.example.globalnews.model.USANews
import com.example.globalnews.utils.Extensions.isInternetAvailable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PopularFragment : Fragment(R.layout.fragment_popular) {
    lateinit var adapterrrr:PopularAdapter
    lateinit var popularr:ArrayList<ArticlesItem>
    lateinit var loadingProgressBarPopular:ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        loadList()
        popularr= ArrayList()
        adapterrrr= PopularAdapter()

        loadingProgressBarPopular=view.findViewById(R.id.loading7)
        if (isInternetAvailable()) loadList()
        else
            Toast.makeText(requireContext(), "No internet", Toast.LENGTH_SHORT).show()

        val recyclePopular:RecyclerView=view.findViewById(R.id.recycleview_popular)
        recyclePopular.adapter=adapterrrr
        recyclePopular.layoutManager=LinearLayoutManager(requireContext())
        adapterrrr.itemClick={
            val bundle = Bundle()
            bundle.putString("noteId",popularr[it].url)
            findNavController().navigate(R.id.action_pressaFragment_to_detailFragment,bundle)
        }

    }

    private fun loadList() {
        Log.d("@@@","loaadLiist:")
        ApiClient.apiService.getCategoryPopular().enqueue(object :Callback<USANews>{
            override fun onResponse(
                call: Call<USANews>,
                response: Response<USANews>
            ) {
                if (response.isSuccessful){
                    showLoading()
                    popularr.clear()
                    Log.d("@@@","onResponse:${response.body()}")
                    response.body()?.articles?.forEach {


                        popularr.add(it)
                    }
                    adapterrrr.sublistPopular(popularr)
                    hideLoading()
                }
            }

            override fun onFailure(call: Call<USANews>, t: Throwable) {

            }

        })
    }
    fun showLoading() {
        loadingProgressBarPopular.visibility = View.VISIBLE
    }

    fun hideLoading() {
        loadingProgressBarPopular.visibility = View.GONE
    }

}