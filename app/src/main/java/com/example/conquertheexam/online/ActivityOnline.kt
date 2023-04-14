package com.example.conquertheexam.online

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.conquertheexam.MainActivity
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityOnlineBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ActivityOnline : AppCompatActivity() {
    private lateinit var currentUser : FirebaseUser

    private lateinit var binding: ActivityOnlineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online)
        binding = ActivityOnlineBinding.inflate(layoutInflater)
        binding.nav.itemIconTintList = null
        setContentView(binding.root)
        currentUser = FirebaseAuth.getInstance().currentUser!!

      binding.nav.setNavigationItemSelectedListener {
          when(it.itemId){
              R.id.addNewExam -> Toast.makeText(this,"giig",Toast.LENGTH_SHORT).show()
              R.id.chatBot ->{
                  val intent = Intent(this,ActivityChatbot::class.java)
                  startActivity(intent)
              }
              R.id.signOut -> {
                  FirebaseAuth.getInstance().signOut()
                  val i  = Intent(this, MainActivity::class.java)
                  startActivity(i)
              }

          }
          true
      }
        // get data from nav header
        val nav = findViewById<NavigationView>(R.id.nav)
        val headerNav = nav.getHeaderView(0)
        val clientName = headerNav.findViewById<TextView>(R.id.txtName)
        val avatar = headerNav.findViewById<ImageView>(R.id.avatar)

         // set data for user
         clientName.setText(currentUser.displayName.toString())
         Glide.with(this)
             .load(currentUser.photoUrl.toString())
             .into(avatar)

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