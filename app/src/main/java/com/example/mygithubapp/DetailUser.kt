package com.example.mygithubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvUsername: TextView = findViewById(R.id.tv_detail_name)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val imgAvatar: ImageView = findViewById(R.id.img_detail_photo)
        val tvFollower: TextView = findViewById(R.id.tv_detail_follower)
        val tvFollowing: TextView = findViewById(R.id.tv_detail_following)
        val tvRepository: TextView = findViewById(R.id.tv_detail_repository)
        val tvCompany: TextView = findViewById(R.id.tv_detail_company)
        val tvOLocation: TextView = findViewById(R.id.tv_detail_location)

        val data = intent.getParcelableExtra<User>("Data")
        imgAvatar.setImageResource(data?.avatar!!)
        tvUsername.text = data?.username
        tvName.text = data?.name
        tvCompany.text = data?.company
        tvOLocation.text = data?.location
        tvFollower.text = data?.follower
        tvFollowing.text = data?.following
        tvRepository.text = data?.repository

        val actionbar = supportActionBar
        actionbar!!.title= data.username
    }
}


