package by.vfdev.rickandmorty.LocalModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vfdev.rickandmorty.RemoteModel.Character
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert
    suspend fun insertCharacters(characters: MutableList<Character>)

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): MutableList<Character>

    @Query("SELECT * FROM characters WHERE name LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Character>>
}