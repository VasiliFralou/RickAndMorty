package by.vfdev.rickandmorty.RemoteModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class Character (
    val info: Info,
    val results: List<Results>)

data class Info (
    val count: Int,
    val pages: Int)

data class Results (
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String)

data class Origin (
    val name: String)

data class Location (
    val name: String)