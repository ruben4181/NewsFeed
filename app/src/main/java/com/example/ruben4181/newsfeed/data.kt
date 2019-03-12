package com.example.ruben4181.newsfeed


import java.util.*

data class Noticia(val titulo : String, val abst : String, val URL : String)
data class Evento(val titulo : String, val abst : String, val date : Date, val time : String, val place : String, val URL : String)