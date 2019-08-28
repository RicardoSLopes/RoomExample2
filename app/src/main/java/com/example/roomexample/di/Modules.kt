package com.example.roomexample.di
import androidx.room.Room
import com.example.roomexample.MainViewModel
import com.example.roomexample.WordListAdapter
import com.example.roomexample.dao.WordRoomDatabase
import com.example.roomexample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val repositoryModule = module {
    single {
        WordRepository(get())
    }
}
val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single {
        get<WordRoomDatabase>().wordDao()
    }
}
val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
}

val uiModule = module {
    factory { WordListAdapter(get()) }
}
