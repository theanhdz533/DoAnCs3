package com.example.conquertheexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.conquertheexam.databinding.ActivityMainBinding
import com.example.conquertheexam.offline.ActivityOffline
import com.example.conquertheexam.online.ActivityOnline
import com.example.conquertheexam.online.model.DataTest
import com.example.conquertheexam.online.model.DataUser
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
        dbRef = FirebaseDatabase.getInstance().getReference("users")



        // btn online
        binding.btnTrucTuyen.setOnClickListener {

            // window infor login
            googleSignInClient.signOut().addOnCompleteListener {
                val intent = googleSignInClient.signInIntent
                startActivityForResult(intent,10001)
            }

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
                        currentUser = FirebaseAuth.getInstance().currentUser!!
                        val id = dbRef.push().key!!
                        val user = DataUser(id,currentUser.displayName.toString(),currentUser.photoUrl.toString(),currentUser.email.toString())
                        var count : Int = 0
                        dbRef.addValueEventListener(object :ValueEventListener{
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()){
                                    for(data in snapshot.children){
                                        var dataItem = data.getValue(DataUser::class.java)
                                        if (user.email.toString()==dataItem!!.email.toString()){
                                            count++
                                        }

                                    }
                                }
                                if (count==0){
                                    dbRef.child(id).setValue(user)
                                        .addOnCompleteListener {
                                            Toast.makeText(this@MainActivity,"Đăng kí thành công!",Toast.LENGTH_SHORT).show()
                                        }
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                TODO("Not yet implemented")
                            }
                        })
                        val intent = Intent(this, ActivityOnline::class.java)
                        startActivity(intent)
                    } else {
                       Toast.makeText(this,task.exception!!.message,Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }


}