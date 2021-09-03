package by.vfdev.rickandmorty.RemoteModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class Character (
    val gender: String,
    @PrimaryKey val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String)

data class CharacterCallBack(
    @SerializedName("results")
    var results: MutableList<Character>
)