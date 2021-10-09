package com.example.registro_superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registro_superheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val superheroName = bundle.getString("superhero_name") ?: ""
        val alterEgo = bundle.getString("alter_Ego") ?: ""
        val bio = bundle.getString("bio") ?: ""
        val power = bundle.getFloat("power")

        binding.heroName.text = superheroName
        binding.alterEgoText.text=alterEgo
        binding.bioText.text=bio
        binding.ratingBar.rating=power

    }
}