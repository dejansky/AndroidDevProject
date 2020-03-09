package com.example.dimpguide.ui.home.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dimpguide.R
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass.
 */
class SignOutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("signOut","Check for user!")
        Log.i("signOut", FirebaseAuth.getInstance().currentUser.toString())

        if (FirebaseAuth.getInstance().currentUser != null){
            FirebaseAuth.getInstance().signOut()
            activity!!.finish()
        }
        else{
            Log.i("signOut","You are not logged in")
            activity!!.finish()
        }


        return null
    }


}
