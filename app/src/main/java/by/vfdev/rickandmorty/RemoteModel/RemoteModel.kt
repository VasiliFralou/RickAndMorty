package by.vfdev.rickandmorty.RemoteModel

import java.lang.Exception
import javax.inject.Inject

class RemoteModel @Inject constructor() {

    val apiService = ApiService.create()

    suspend fun getRemoteData(): MutableList<Character> {
        return try {
            val characters = apiService.getCharacters()
            characters
        } catch (e: Exception) {
            mutableListOf()
        }
    }
}