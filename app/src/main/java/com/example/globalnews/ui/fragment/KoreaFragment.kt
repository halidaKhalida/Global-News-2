package com.example.globalnews.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globalnews.R
import com.example.globalnews.adapter.KoreaAdapter
import com.example.globalnews.data.remote.ApiClient
import com.example.globalnews.model.ArticlesItem
import com.example.globalnews.model.ArticlesItem5
import com.example.globalnews.model.Search
import com.example.globalnews.model.USANews
import com.example.globalnews.utils.Extensions.isInternetAvailable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KoreaFragment : Fragment(R.layout.fragment_korea) {
    lateinit var adapterr:KoreaAdapter
    lateinit var koooreaa:ArrayList<ArticlesItem5>
    lateinit var loadingProgressBarKorea: ProgressBar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {

        koooreaa= ArrayList()
        adapterr= KoreaAdapter()

        loadingProgressBarKorea=view.findViewById(R.id.loading8)
        if (isInternetAvailable()) loadList(q = String())
        else
            Toast.makeText(requireContext(), "No internet", Toast.LENGTH_SHORT).show()

        val recycleKorea:RecyclerView=view.findViewById(R.id.rvSearchNews)
        recycleKorea.adapter=adapterr
        val editText=view.findViewById<EditText>(R.id.etSearch)
        editText.addTextChangedListener {
            loadList(it.toString())
        }

        adapterr.itemClick={
            val bundle = Bundle()
            bundle.putString("noteId",koooreaa[it].url)
            findNavController().navigate(R.id.action_koreaFragment_to_detailFragment,bundle)
        }
    }

    private fun loadList(q:String) {
        ApiClient.apiService.getCtegoryKorea(q = q).enqueue(object :Callback<Search>{
            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                if (response.isSuccessful){
                    showLoading()
                    koooreaa.clear()
                    response.body()?.articles?.forEach {
                        koooreaa.add(it)
                    }
                    adapterr.sublistKorea(koooreaa)
                    hideLoading()
                }
            }

            override fun onFailure(call: Call<Search>, t: Throwable) {

            }

        })
    }
    fun showLoading() {
        loadingProgressBarKorea.visibility = View.VISIBLE
    }

    fun hideLoading() {
        loadingProgressBarKorea.visibility = View.GONE
    }

}