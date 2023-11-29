package com.example.medminder5.model
import java.text.SimpleDateFormat
import java.util.*

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Entity(tableName = "obat")
data class Obat(
    @PrimaryKey
    val obatId: String = UUID.randomUUID().toString(),
    var nama: String,
    var deskripsi: String,
    var jam: String,
    var hari: String,
)

@Entity(tableName = "riwayat")
data class Riwayat(
    @PrimaryKey
    val obatId: String = UUID.randomUUID().toString(),
    val nama: String,
    val waktu: String = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(Date())
)

@Dao
interface ObatDao {
    @Insert
    suspend fun insertObat(obat: Obat)

    @Query("SELECT * FROM obat")
    fun getAllObat(): Flow<List<Obat>>

    @Update
    suspend fun updateObat(obat: Obat)

    @Delete
    suspend fun deleteObat(obat: Obat)

    @Query("SELECT * FROM obat WHERE obatId = :obatId")
    fun getObatById(obatId: String): Obat
}
