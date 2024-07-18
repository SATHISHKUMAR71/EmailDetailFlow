package com.example.customemaildetailflow

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.transition.TransitionInflater

class EmailDetailFragment : Fragment() {

    private lateinit var title:TextView
    private lateinit var subtitle:TextView
    private lateinit var content:TextView
    private lateinit var date:TextView
    private var isStarred=false
    private var isViewed=false
    private lateinit var starImage:ImageView
    private lateinit var profileView:TextView
    private lateinit var view:View
    private lateinit var scrollView:ScrollView
    private var isStarredDetail = false
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
    ): View {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_email_detail, container, false)
        date = view.findViewById(R.id.date)
        subtitle = view.findViewById(R.id.heading)
        title = view.findViewById(R.id.title)
        content = view.findViewById(R.id.content)
        starImage = view.findViewById(R.id.star)
        view.transitionName = arguments?.getString("transitionName")
        profileView = view.findViewById(R.id.profileView)
        scrollView = view.findViewById(R.id.scrollViewEmailDetail)
        view.visibility = View.INVISIBLE
        var index = 0
        for(i in MainActivity.emails.emailList){
            if(i.title.equals(title)){
                break
            }
            index+=1
        }
        starImage.setOnClickListener {
            if(isStarredDetail){
                isStarredDetail = false
//                MainActivity.emails.emailList[index].isStarred = false
                starImage.setImageResource(R.drawable.baseline_star_outline_24)
                starImage.visibility = View.VISIBLE
            }
            else{
                isStarredDetail = true
//                MainActivity.emails.emailList[index].isStarred = true
                starImage.setImageResource(R.drawable.baseline_star_24)
                starImage.visibility = View.VISIBLE
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    fun putData(title:String,subtitle:String,date:String,content:String,isStarred:Boolean,isViewed:Boolean,transitionName:String){
        view.visibility = View.VISIBLE
        this.date.text = date
        this.subtitle.text = subtitle
        this.content.text = content
        this.title.text = title
        isStarredDetail = isStarred
        if(isStarred){
            starImage.apply {
                setImageResource(R.drawable.baseline_star_24)
                    visibility = View.VISIBLE
            }
        }
        else{
            starImage.apply {
                setImageResource(R.drawable.baseline_star_outline_24)
                    visibility = View.VISIBLE
            }
        }
        profileView.apply {
            text = title[0].toString()
            visibility = View.VISIBLE
        }
        scrollView.scrollTo(0,0)
        view.transitionName = transitionName
    }

}