package com.example.registro_superheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registro_superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener{
            val superheroName = binding.superheroNameEdit.text.toString()
            val alterEgo=binding.alterEgoEdit.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power=binding.powerBar.rating

            val hero =Superhero(superheroName,alterEgo,bio,power)

            openDetailActivity(hero)
        }
    }

    private fun openDetailActivity(superhero:Superhero){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("superhero",superhero)

        startActivity(intent)
    }
}