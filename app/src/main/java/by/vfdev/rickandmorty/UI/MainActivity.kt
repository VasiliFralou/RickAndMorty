package by.vfdev.rickandmorty.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.vfdev.rickandmorty.R
import by.vfdev.rickandmorty.ViewModel.CharacterViewModel
import by.vfdev.rickandmorty.ViewModel.CharacterViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var viewModel: CharacterViewModel

    @Inject lateinit var factory: CharacterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.navHost)

        viewModel = ViewModelProvider(this, factory).get(CharacterViewModel::class.java)
    }
}