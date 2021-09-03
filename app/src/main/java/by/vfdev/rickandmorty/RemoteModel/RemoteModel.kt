package by.vfdev.rickandmorty.RemoteModel

import android.util.Log
import java.lang.Exception
import javax.inject.Inject

class RemoteModel @Inject constructor() {

    val apiService = ApiService.create()

    suspend fun getRemoteData(): MutableList<Character> {
        return try {
            val characters: MutableList<Character> = apiService.getCharacters().results
            characters
        } catch (e: Exception) {
            mutableListOf()
        }
    }
}