package com.example.bai6_callapi2.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bai6_callapi2.DI.ExerciseApplication
import com.example.bai6_callapi2.R
import com.example.bai6_callapi2.viewmodel.UserViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
   lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//        userViewModel.fetchUsers()

        (application as ExerciseApplication).appComponent.inject(this)


        userViewModel.fetchUsers()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        userViewModel.users.observe(this, Observer { users ->
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = UserAdapter(users)
        })
    }
}