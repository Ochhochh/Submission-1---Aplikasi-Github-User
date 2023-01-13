package com.example.mygithubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser : RecyclerView
    private val list = ArrayList<User>()

    private val listUser : ArrayList<User>
    get() {
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataRepository = resources.getStringArray(R.array.repository)
        val  listUser = ArrayList<User>()
        for (i in dataUsername.indices){
                val user = User(dataAvatar.getResourceId(i, -1), dataUsername[i], dataName[i], dataRepository[i], dataLocation[i], dataCompany[i], dataFollower[i], dataFollowing[i])
        listUser.add(user)
        }
        return listUser
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecycleList()
    }

    private fun showRecycleList(){
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        val moveToDetail = Intent(this@MainActivity, DetailUser::class.java)
        moveToDetail.putExtra("Data", user)
        startActivity(moveToDetail)
    }


}