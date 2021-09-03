package by.vfdev.rickandmorty.LocalModel

import android.content.Context
import androidx.room.Room
import by.vfdev.rickandmorty.RemoteModel.Character
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalModel @Inject constructor(@ApplicationContext context: Context) {

    private val database: CharacterDatabase = Room.databaseBuilder(
        context,
        CharacterDatabase::class.java, "character_db"
    ).build()

    suspend fun insertCharacters(characters: MutableList<Character>) {
        database.characterDao().insertCharacters(characters)
    }

    suspend fun getAllCharacters() : MutableList<Character> {
        return database.characterDao().getAllCharacters()
    }

   fun searchDatabase(searchQuery: String): Flow<List<Character>> {
        return database.characterDao().searchDatabase(searchQuery)
    }
}