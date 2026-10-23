package com.example.week3_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.text.InputType
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

enum class Direction
{
    North, South, East, West
}

fun Test()
{
    val myDir = Direction.North

    if (myDir == Direction.West)
    {
        
    }
}

class MainActivity : AppCompatActivity() {

    private val users = listOf(
        User("daniel@example.com"),
        User("test@example.com"),
        User("admin@example.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.button)

        loginButton.setOnClickListener {
            showLoginPopup()
        }
    }

    private fun showLoginPopup() {
        val emailInput = EditText(this)

        emailInput.hint = "Enter your email"
        emailInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

        AlertDialog.Builder(this)
            .setTitle("Login")
            .setView(emailInput)
            .setPositiveButton("Confirm") { _, _ ->

                val enteredEmail = emailInput.text.toString().trim()

                val foundUser = users.find {it.email.equals(enteredEmail, ignoreCase = true)}

                if (foundUser != null) {
                    Toast.makeText(this,"User found: ${foundUser.email}", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "User not found!",Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}

class User(val email: String)


// struct -> first begin with a data class

/*
 val myInt: Int = 34 // explicit variable
        val myInt2 = 34 // implicit variable

        var myFloat = 123.0f
        val myBool: Boolean = true

        val myStr = "Hello "
        val firstChar = myStr[0]
        val lastChar = myStr[myStr.length - 1]

        val multiline = """
            This is Android
            This is line 2

        """.trimIndent()


        var a: String = "ABC" // var accepts null, val not (For ones that need a value).
        //a = null

        var c: String? = "Hello" // nullable
        c = null
        // using !! makes explicit that some has a value
        //val l: Int = c.length


        val l2 = if (c != null) c.length else 0


        val myList : List<String?> = listOf("Hello", "My Name", "City", "")
        val zerothElem = myList[0]

        for (each in myList)
        {
            each?.let { theValueFoundInEach -> Log.d("TAG", theValueFoundInEach) }
        }

        val numbers: Array<Int> = arrayOf(1,2,3,4)

        val mixedArray: Array<Any?> = arrayOf(1, "Hello", true, null)

        val myMap: HashMap<String, String> = hashMapOf("Vancouver" to "City", "Teacher" to "Role")

        myMap.keys
        myMap.values

        myMap.size

        //if (myMap.contains()) {}

        myMap["Mexico"] = "some value"

        myMap.remove(key = "some value")

        // ++, -- -> increment and decrement
        // =+, -=, *=, /=, %= -> augmented assignment
        // = -> assignment op
        // == -> equality

        val myAge = 20

        if (myAge > 45){}
        else if (myAge < 10){}
        else if (myAge > 3 && myAge < 34 || myAge == 20) {}
        else {}


        when (myAge)
        {
            5 -> Log.d("TAG","It's 5")
        }

        for (i in 0..10)
        {

        }

        // in nested loops to break both loops use break@illop

        val test: Int = Random.nextInt(0, 100)
        val myIntMap = HashMap<Int, Int>()

        for (i in 0..1000000) {
            val test: Int = Random.nextInt(0, 100)

            if (myIntMap.containsKey(test)) {
                myIntMap[test] = myIntMap[test]!! + 1
            } else {
                myIntMap[test] = 1
            }
        }


class User()
{
    var name: String? = null
    lateinit var email: String
    lateinit var id: UUID

    constructor(myMap: HashMap<String, Any>) : this ()
    {
        name = myMap["name"] as? String
        email = myMap["email"] as String
        if (myMap["email"] != null) {email = myMap["email"] as String}
        id = UUID.fromString(myMap["id"] as String)


    }
}

 */