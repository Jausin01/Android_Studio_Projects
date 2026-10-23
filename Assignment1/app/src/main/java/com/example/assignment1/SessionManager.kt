package com.example.assignment1

object SessionManager {
    var currentUser: User? = null
    val isLogged: Boolean
        get() = currentUser != null
}