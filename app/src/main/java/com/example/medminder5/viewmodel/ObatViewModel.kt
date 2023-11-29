package com.example.medminder5.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medminder5.model.Obat
import com.example.medminder5.model.ObatDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Date

class ObatViewModel(private val obatDao: ObatDao) : ViewModel() {

    private val _obatList = MutableStateFlow<List<Obat>>(emptyList())
    val obatList: StateFlow<List<Obat>> = _obatList


    private lateinit var selectedObat: Obat

    init {
        viewModelScope.launch {
            obatDao.getAllObat()
                .collect { obats ->
                    _obatList.value = obats
                    Log.d("woe", "halos")
                }
        }

    }


    fun getObatCheckByObatId(obatId: String): Obat {
        return obatList.value.first { it.obatId == obatId }
    }

    fun setSelectedObat(obat: Obat) {
        selectedObat = obat
    }

    fun insertObat(obat: Obat) {
        viewModelScope.launch {
            obatDao.insertObat(obat)
        }
    }

    fun getObatById(obatId: String): Obat {
        return obatDao.getObatById(obatId)

    }

    fun getSelectedObat(): Obat {
        return selectedObat
    }

    fun updateObat(obat: Obat) {
        viewModelScope.launch {
            obatDao.updateObat(obat)
        }
    }

    fun deleteObat(obat: Obat) {
        viewModelScope.launch {
            obatDao.deleteObat(obat)
        }
    }

//    fun checkObat(obat: Obat) {
//        viewModelScope.launch {
//            obat.isCheck = true
//            obatDao.updateObat(obat)
//
//            val currentList = _obatList.value.toMutableList()
//            val index = currentList.indexOfFirst { it.obatId == obat.obatId }
//
//            if (index != -1) {
//                currentList[index] = obat.copy()
//                _obatList.value = currentList
//            }
//        }
//    }
//
//    fun unCheckHabit(obat: Obat) {
//        viewModelScope.launch {
//            obat.isCheck = false
//            obatDao.updateObat(obat)
//        }
//    }



}
