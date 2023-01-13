package com.example.mygithubapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar : Int,
    var username : String,
    var name : String,
    var repository : String,
    var location : String,
    var company : String,
    var follower : String,
    var following : String
) : Parcelable
