package com.example.conquertheexam.online

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.conquertheexam.MainActivity
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityOnlineBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ActivityOnline : AppCompatActivity() {
    private lateinit var currentUser : FirebaseUser

    private lateinit var binding: ActivityOnlineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online)
        binding = ActivityOnlineBinding.inflate(layoutInflater)
//        binding.nav.itemIconTintList = null
        setContentView(binding.root)
        currentUser = FirebaseAuth.getInstance().currentUser!!
//        binding.button.setOnClickListener {
//            FirebaseAuth.getInstance().signOut()
//            val i  = Intent(this, MainActivity::class.java)
//            startActivity(i)
//            Toast.makeText(this,currentUser.email, Toast.LENGTH_SHORT).show()
//
//
//        }


    }
    // display menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.open_menu,menu)
        return true
    }
    // event click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (binding.nav.isVisible == true){
            when(item.itemId){
                R.id.open_menu -> binding.nav.visibility = View.GONE
            }
        }
        else {
            when(item.itemId){
                R.id.open_menu -> binding.nav.visibility = View.VISIBLE

            }
        }
        return super.onOptionsItemSelected(item)
    }
}