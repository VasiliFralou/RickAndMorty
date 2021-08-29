package by.vfdev.rickandmorty.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.vfdev.rickandmorty.Repository.Repository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class CharacterViewModelFactory @Inject constructor(val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharacterViewModel(repository) as T
    }
}