package com.example.customemaildetailflow

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.transition.TransitionInflater

class EmailDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.enter_transition)
        sharedElementReturnTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.exit_transition)
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
        view.transitionName = arguments?.getString("transitionName")
        println("Detail transitionName:${arguments?.getString("transitionName")}")
//        Toast.makeText(context,arguments?.getString("transitionName"),Toast.LENGTH_SHORT).show()
        return view
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        parentFragmentManager.beginTransaction()
            .remove(this)
            .commit()
    }

}