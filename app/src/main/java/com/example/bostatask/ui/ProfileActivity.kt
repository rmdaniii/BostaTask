package com.example.bostatask.ui

import AlbumsAdapter
import AlbumsViewModel
import UserProfileViewModel
import UsersViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.bostatask.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity(){

    private lateinit var userName: TextView
    private lateinit var address: TextView
    private lateinit var recyclerView: RecyclerView

    private val userViewModel: UsersViewModel by viewModels()
    private val albumsViewModel: AlbumsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize variables
        userName = findViewById(R.id.userName_tv)
        address = findViewById(R.id.userAddress_tv)
        recyclerView = findViewById(R.id.albums_recycler)

        lifecycleScope.launch {
            // Observe LiveData and update UI
            userViewModel.users.collect{
                // Update the user's name and address on the UI
                userName.text = user.name
                address.text = user.userAddress.toString()
            }
        }



        lifecycleScope.launch {

            albumsViewModel.albums.collect{
                // Update the list of albums in a RecyclerView
                val adapter = AlbumsAdapter()
                recyclerView.adapter = adapter

                adapter.setOnItemClickListener { album ->
                    // Handle album item click and navigate to AlbumDetailsActivity
                    val intent = Intent(this, AlbumDetailsActivity::class.java)
                    intent.putExtra("albumId", album.id)
                    startActivity(intent)
                }
            }
        }



    }


    }

}