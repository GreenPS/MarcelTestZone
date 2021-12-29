package com.example.greenps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.greenps.databinding.ActivityPerfilBinding
import com.google.firebase.auth.FirebaseAuth

class Perfil : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_perfil)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val email = bundle?.getString("email")

        binding.username.text = email
        binding.textViewCorreo2.text = email

        val backMenu = supportActionBar
        if(backMenu != null){
            backMenu.title = "Perfil"
        }
        backMenu!!.setDisplayHomeAsUpEnabled(true)

        binding.logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
            val intento = Intent(this, AuthActivity::class.java)
            startActivity(intento)
        }
    }
}