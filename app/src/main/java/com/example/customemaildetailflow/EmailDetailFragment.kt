package com.example.customemaildetailflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EmailDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_email_detail, container, false)
        view.findViewById<TextView>(R.id.date).text = arguments?.getString("date")
        view.findViewById<TextView>(R.id.heading).text = arguments?.getString("heading")
        view.findViewById<TextView>(R.id.content).text = arguments?.getString("content")
        view.findViewById<TextView>(R.id.title).text = arguments?.getString("title")
        return view
    }
}