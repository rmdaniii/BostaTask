package com.example.bostatask.ui

import AlbumDetailsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bostatask.R
import com.example.bostatask.adapter.PhotosAdapter

class AlbumDetailsActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var photosRecyclerView: RecyclerView
    private val photoViewModel: AlbumDetailsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        val albumId = intent.getIntExtra("albumId", -1)

        // Observe LiveData and update UI
        photoViewModel.photos.observe(this, Observer { photos ->
            // Initialize and set up the adapter
            val photosAdapter = PhotosAdapter(photos)
            photosRecyclerView.layoutManager = GridLayoutManager(this, 3) // Adjust grid layout as needed
            photosRecyclerView.adapter = photosAdapter

            searchEditText.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val query = s.toString()
                    photosAdapter.filter(query)
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // Not needed
                }

                override fun afterTextChanged(s: Editable?) {
                    // Not needed
                }
            })
        })

    }
}