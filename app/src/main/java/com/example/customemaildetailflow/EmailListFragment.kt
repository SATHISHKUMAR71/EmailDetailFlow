package com.example.customemaildetailflow

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater

class EmailListFragment : Fragment() {

    val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
    var emailList = viewModel.emails
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("In onCreate")
        println("Saved ${savedInstanceState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        println("OnCreateView")
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_email_list, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.adapter = EmailAdapter(emailList,requireActivity(),arguments?.getBoolean("isDual"))
        rv.layoutManager =LinearLayoutManager(context)
        rv.addItemDecoration(DividerItemDecoration(rv.context, LinearLayoutManager.VERTICAL))
        return view
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}