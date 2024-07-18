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

class EmailAdapter(private val emailList:MutableList<Email>,private val activity: FragmentActivity,private val isDualPane:Boolean?) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        fun bindData(email:CustomEmail,position:Int){
            email.transitionName = "emailListTransitionName$position"
            email.setTitle(emailList[position].title)
            email.setContent(emailList[position].content)
            email.setSubtitle(emailList[position].subtitle)
            email.setDate(emailList[position].date)
            email.setProfileLetter("${emailList[position].title[0]}")
        }

        fun checkIsViewed(email:CustomEmail,position:Int){
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
        }

        fun checkIsStarred(email:CustomEmail,position:Int){
            if(emailList[position].isStarred){
//                println("Email is Stared: ${emailList[position].isStarred}")
                email.getStar().setImageResource(R.drawable.baseline_star_24)
            }
            else{
                email.getStar().setImageResource(R.drawable.baseline_star_outline_24)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_view,parent,false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emailList.size
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {

        holder.itemView.apply {

            val emailDetailFrag = EmailDetailFragment()
            val emailListFrag = EmailListFragment()
            val email = this.findViewById<CustomEmail>(R.id.emailView)
            val star = email.getStar()
            holder.bindData(email,position)
            holder.checkIsViewed(email,position)
            holder.checkIsStarred(email,position)
            this.setOnClickListener{
                emailList[position].isViewed = true
                emailDetailFrag.arguments = Bundle().apply {
                    putString("transitionName","emailListTransitionName$position")
                    putString("title",emailList[position].title)
                    putString("heading",emailList[position].subtitle)
                    putString("content",emailList[position].content)
                    putString("date",emailList[position].date)
                    putBoolean("isStarred",emailList[position].isStarred)
                }
                email.getTitle().typeface = Typeface.DEFAULT
                email.getSubtitle().typeface = Typeface.DEFAULT
                email.getDate().typeface = Typeface.DEFAULT
                if(resources.configuration.screenWidthDp>=700){
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentEmailDetail,emailDetailFrag)
                        .commit()
                }
                else{
                    activity.supportFragmentManager.beginTransaction()
                        .addToBackStack("Detail Fragment")
                        .addSharedElement(email,"emailListTransitionName$position")
                        .replace(R.id.fragmentEmailList,emailDetailFrag)
                        .commit()
                }
            }
            star.setOnClickListener {
                if(emailList[position].isStarred){
                    emailList[position].isStarred = false
                    star.setImageResource(R.drawable.baseline_star_outline_24)
                    Toast.makeText(context,"Message UnStarred",Toast.LENGTH_SHORT).show()
                }
                else{
                    emailList[position].isStarred = true
                    star.setImageResource(R.drawable.baseline_star_24)
                    Toast.makeText(context,"Message Starred",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}