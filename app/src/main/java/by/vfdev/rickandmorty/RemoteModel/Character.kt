package by.vfdev.rickandmorty.RemoteModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class Character (
    val info: Info,
    val results: Results)

data class Info (
    val count: Int,
    val pages: Int)

data class Results (
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String)

data class Origin (
    val name: String)

data class Location (
    val name: String)