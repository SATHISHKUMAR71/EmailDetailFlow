package com.example.customemaildetailflow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var isDualPane = false
    val fragmentEmailList = EmailListFragment()
    val fragmentEmailDetail = EmailDetailFragment()
    lateinit var fragmentList:FragmentContainerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentEmailList,fragmentEmailList)
//            .commit()
        fragmentList = findViewById(R.id.fragmentEmailList)
        val fragmentDetail:FragmentContainerView? = findViewById(R.id.fragmentEmailDetail)
        println(fragmentDetail?.isVisible)
        println(fragmentList.isVisible)

    }

}