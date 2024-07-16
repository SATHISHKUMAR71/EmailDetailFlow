package com.example.customemaildetailflow

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emailList:MutableList<Email>,private val activity: FragmentActivity) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_view,parent,false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emailList.size
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        var i=0
        holder.itemView.apply {
            val email = this.findViewById<CustomEmail>(R.id.emailView)
            val star = email.getStar()
            email.setTitle(emailList[position].title)
            email.setContent(emailList[position].content)
            email.setSubtitle(emailList[position].subtitle)
            email.setDate(emailList[position].date)
            email.setProfileLetter("${emailList[position].title[0]}")
            if(emailList[position].isViewed){
                email.getTitle().typeface = Typeface.DEFAULT
                email.getSubtitle().typeface = Typeface.DEFAULT
                email.getDate().typeface = Typeface.DEFAULT
            }
            else{
                email.getTitle().typeface = Typeface.DEFAULT_BOLD
                email.getSubtitle().typeface = Typeface.DEFAULT_BOLD
                email.getDate().typeface = Typeface.DEFAULT_BOLD
            }
            if(emailList[position].isStarred){
                star.setImageResource(R.drawable.baseline_star_24)
            }
            else{
                star.setImageResource(R.drawable.baseline_star_outline_24)
            }
            this.setOnClickListener{
                emailList[position].isViewed = true
                val emailFragment = EmailDetailFragment()
                emailFragment.arguments = Bundle().apply {
                    putString("title",emailList[position].title)
                    putString("heading",emailList[position].subtitle)
                    putString("content",emailList[position].content)
                    putString("date",emailList[position].date)
                    putBoolean("isStarred",emailList[position].isStarred)
                }

                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView,emailFragment)
                    .addToBackStack("Detail View")
                    .commit()
                email.getTitle().typeface = Typeface.DEFAULT
                email.getSubtitle().typeface = Typeface.DEFAULT
                email.getDate().typeface = Typeface.DEFAULT
            }
            star.setOnClickListener {
                i+=1
                if(i%2 == 1){
                    emailList[position].isStarred = true
                    Toast.makeText(context,"Message Starred",Toast.LENGTH_SHORT).show()
                    star.setImageResource(R.drawable.baseline_star_24)
                }
                else{
                    emailList[position].isStarred = false
                    Toast.makeText(context,"Message Unstarred",Toast.LENGTH_SHORT).show()
                    star.setImageResource(R.drawable.baseline_star_outline_24)
                }
            }
        }
    }

}