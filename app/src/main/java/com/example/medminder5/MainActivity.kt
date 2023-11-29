package com.example.medminder5

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.medminder5.model.ObatDatabase.Companion.getDatabase
import com.example.medminder5.viewmodel.ObatViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class MainActivity : ComponentActivity() {
    private val obatViewModel by viewModels<ObatViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val db = getDatabase(applicationContext)
                    return ObatViewModel(db.obatDao()) as T
                }

            }
        }
//        factoryProducer = {
//            object : ViewModelProvider.Factory {
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    val db = getDatabase(applicationContext)
//                    return HabitViewModel(db.habitDao(), db.habitEvent()) as T
//                }
//            }
//        }
    )

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel = obatViewModel)
        }
    }
}

