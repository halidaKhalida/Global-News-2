package com.example.globalnews.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.globalnews.R
import com.example.globalnews.adapter.ItemForYouAdapter
import com.example.globalnews.model.USANews
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ItemForYouAdapter
    lateinit var newws: ArrayList<USANews>
    lateinit var loadingProgressBar: ProgressBar
    lateinit var navControllerr:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {


        newws= ArrayList()
        adapter= ItemForYouAdapter()
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nave_fragment) as NavHostFragment
        val navController=navHostFragment.navController
        val bNavForYou=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bNavForYou.setupWithNavController(navController)

        Handler().postDelayed({
            loadList()

        },2000)

    }

    private fun loadList() {
        val bNavForYou=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bNavForYou.visibility=View.VISIBLE

    }


}