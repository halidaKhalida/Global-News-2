package com.example.globalnews.ui.fragment.headlinesfragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.globalnews.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.System.load


class AppIconFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_icon, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }






    private fun initView(view: View) {

        Handler().postDelayed({

          loadList()
        },2000)

    }

    private fun loadList() {

        findNavController().navigate(R.id.action_appIconFragment_to_forYouFragment)
    }


}