package com.example.conquertheexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.conquertheexam.databinding.ActivityMainBinding
import com.example.conquertheexam.offline.ActivityOffline
import com.example.conquertheexam.online.ActivityOnline
import com.example.conquertheexam.online.model.DataTest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var currentUser : FirebaseUser
    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // btn offline
        binding.btnTuLuyen.setOnClickListener {
              val intent = Intent(this, ActivityOffline::class.java)
             startActivity(intent)
        }
        // sign in with google
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this,options)

        // save data in firebase
        dbRef = FirebaseDatabase.getInstance().getReference("test")


        // btn online
        binding.btnTrucTuyen.setOnClickListener {
         val id = dbRef.push().key!!
         val test = DataTest(id,"abc")
            dbRef.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                     if (snapshot.exists()){
                         for(data in snapshot.children){
                                 var dataItem = data.getValue(DataTest::class.java)
                                 if (test.name==dataItem!!.name){
                                     Toast.makeText(this@MainActivity,"Data exists!",Toast.LENGTH_SHORT).show()
                                 }

                         }
                     }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
//          dbRef.child(id).setValue(test)
//              .addOnCompleteListener {
//                  Toast.makeText(this,"add data success!",Toast.LENGTH_SHORT).show()
//              }

//            googleSignInClient.signOut().addOnCompleteListener {
//                val intent = googleSignInClient.signInIntent
//                startActivityForResult(intent,10001)
//            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==10001){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken,null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener {
                    if (task.isSuccessful){
                        val intent = Intent(this, ActivityOnline::class.java)
                        startActivity(intent)
                    } else {
                       Toast.makeText(this,task.exception!!.message,Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }


}