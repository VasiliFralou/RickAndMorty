package by.vfdev.rickandmorty.LocalModel

import androidx.room.Database
import androidx.room.RoomDatabase
import by.vfdev.rickandmorty.RemoteModel.Character

@Database(entities = [Character::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}