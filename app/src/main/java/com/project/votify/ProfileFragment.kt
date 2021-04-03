package com.project.votify

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.profile_fragment, container, false)
        val editProfile = view.findViewById<Button>(R.id.editProfile)
        editProfile.setOnClickListener(){
            val intent= Intent(activity,EditProfile::class.java)
            startActivity(intent)
        }

        val sign_out = view.findViewById<Button>(R.id.student_sign_out)
        sign_out.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(activity, "Logged Out!", Toast.LENGTH_LONG).show()
            startActivity(Intent(activity, SignInActivity::class.java))
            activity?.finish()
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        if(FirebaseAuth.getInstance().currentUser == null){
            startActivity(Intent(activity, SignInActivity::class.java))
            activity?.finish()
        }
    }
}