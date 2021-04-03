package com.project.votify

import adapter.CandidateRecyclerViewAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VotingFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager?=null
    private var candidateList= arrayOf(
        "Class Representative",
        "Spice Representative",
        "President",
        "General Secretory"
    )//Retrived data from firebase(Dummy data for now)
    private var adapter = CandidateRecyclerViewAdapter(candidateList)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bundle = arguments
        if (bundle != null) {
            val pollid: String? = bundle.getString("pollId")
            if (pollid != null) {
                Log.d("Bundle",pollid)
            }
        }
        val view= inflater.inflate(R.layout.fragment_voting, container, false)
        val RecyclerViewId=view.findViewById<RecyclerView>(R.id.CandidateRecyclerView)
        layoutManager= LinearLayoutManager(activity)
        RecyclerViewId.layoutManager=layoutManager
        RecyclerViewId.adapter=adapter
        return view
    }


}