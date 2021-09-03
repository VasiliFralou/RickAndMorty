package by.vfdev.rickandmorty.Repository

import by.vfdev.rickandmorty.LocalModel.LocalModel
import by.vfdev.rickandmorty.RemoteModel.Character
import by.vfdev.rickandmorty.RemoteModel.RemoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(val remoteModel: RemoteModel,
                                     val localModel: LocalModel) {

    suspend fun getData() : MutableList<Character> {
        var charactersList = localModel.getAllCharacters()
        return if (charactersList.isEmpty()) {
            charactersList = remoteModel.getRemoteData()
            localModel.insertCharacters(charactersList)
            charactersList
        } else {
            charactersList
        }
    }

    suspend fun saveData(charactersList: MutableList<Character>) {
        localModel.insertCharacters(charactersList)
    }

    suspend fun searchDatabase(searchQuery: String): Flow<List<Character>> {
        return localModel.searchDatabase(searchQuery)
    }
}