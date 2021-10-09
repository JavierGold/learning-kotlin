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
        val superhero = bundle.getParcelable<Superhero>("superhero") !!


        binding.heroName.text = superhero.name
        binding.alterEgoText.text=superhero.alterEgo
        binding.bioText.text=superhero.bio
        binding.ratingBar.rating=superhero.power

    }
}