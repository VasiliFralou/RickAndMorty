package by.vfdev.rickandmorty.LocalModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vfdev.rickandmorty.RemoteModel.Character

@Dao
interface CharacterDao {

    @Insert
    suspend fun insertCharacters(characters: MutableList<Character>)

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): MutableList<Character>
}