package com.example.medminder5

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Beranda : BottomBarScreen(
        route = "beranda",
        title = "Beranda",
        icon = Icons.Default.Home
    )

    object Obat : BottomBarScreen(
        route = "obat",
        title = "Obat",
        icon = Icons.Default.Person
    )

    object Riwayat : BottomBarScreen(
        route = "riwayat",
        title = "Riwayat",
        icon = Icons.Default.Settings
    )
}