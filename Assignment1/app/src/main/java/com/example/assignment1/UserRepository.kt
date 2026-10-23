package com.example.assignment1

import android.content.Context
import org.json.JSONArray

object UserRepository {
    private var users: List<User> = emptyList()

    fun load(context: Context) {
        val json = context.resources.openRawResource(R.raw.users)
            .bufferedReader()
            .use { it.readText() }

        val array = JSONArray(json)
        val list = mutableListOf<User>()
        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            list.add(User(obj.getString("username"), obj.getString("password")))
        }
        users = list
    }

    fun login(username: String, password: String): User? {
        return users.firstOrNull { it.username == username && it.password == password }
    }
}