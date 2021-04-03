package com.project.votify

import adapter.RecyclerViewAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PollsFragment() : Fragment(), RecyclerViewAdapter.onPollItemClickListener {
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var pollsList= arrayOf("Class Representative","Spice Representative","President","General Secretory")//Retrived data from firebase(Dummy data for now)
    private var adapter = RecyclerViewAdapter(pollsList,this)// Pass Retrived data to Recycler view for display

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.polls_fragment, container, false)
        val RecyclerViewId=view.findViewById<RecyclerView>(R.id.RecyclerViewId)
        layoutManager= LinearLayoutManager(activity)
        RecyclerViewId.layoutManager=layoutManager
        RecyclerViewId.adapter=adapter
        return view
    }

    override fun onItemClick(position: Int) {
        var bundle= Bundle()
        bundle.putString("pollId","sdsdsdsdsd") //We have to pass poll id
        var fragment=VotingFragment()
        fragment.arguments=bundle
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment_container,fragment)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }

}