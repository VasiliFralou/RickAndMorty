package by.vfdev.rickandmorty.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.vfdev.rickandmorty.RemoteModel.Character
import by.vfdev.rickandmorty.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel (val repository: Repository) : ViewModel() {

    val scope = CoroutineScope(Dispatchers.IO)

    val charactersLive: MutableLiveData<MutableList<Character>> by lazy {
        MutableLiveData<MutableList<Character>>()
    }

    var characterList: Character? = null

    fun getData() {
        scope.launch {
            val data = repository.getData()
            charactersLive.postValue(data)
        }
    }

    fun saveData() {
        scope.launch {
            repository.saveData(charactersLive.value!!)
        }
    }
}