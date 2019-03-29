package com.example.ruben4181.newsfeed


import java.util.*

data class Noticia(val titulo : String, val abst : String, val URL : String)
data class Evento(val titulo : String, val abst : String, val date : Date, val time : String, val place : String, val URL : String)
data class Horario(val dia : String, val inicio : String, val fin : String, val lugar : String)
data class Subject(val nombre: String, val profesores : ArrayList<String>, val horarios : ArrayList<Horario>)