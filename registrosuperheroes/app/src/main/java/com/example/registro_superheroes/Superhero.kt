package com.example.registro_superheroes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Superhero(val name:String,val alterEgo:String, val bio:String,val power:Float) : Parcelable
