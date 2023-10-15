package com.example.globalnews.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.airbnb.lottie.LottieAnimationView
import com.example.globalnews.R
import com.example.globalnews.utils.DetailFragmentArgs


class DetailFragment : Fragment(R.layout.fragment_detail) {
    var myUrl=""
    lateinit var loading: LottieAnimationView
    lateinit var wb_webView:WebView
    val args:DetailFragmentArgs by navArgs()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews(view: View) {
        val wb_webView= view.findViewById<WebView>(R.id.wb_webView)
//        wb_webView?.loadUrl("https://www.space.com/osiris-rex-asteroid-sample-return-telescope-livestream")
        myUrl=args.noteId?:"https://www.space.com/osiris-rex-asteroid-sample-return-telescope-livestream"
        wb_webView?.apply {
            webViewClient= WebViewClient()
            loadUrl(myUrl)

        }
    }



}