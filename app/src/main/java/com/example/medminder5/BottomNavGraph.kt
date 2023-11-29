package com.example.medminder5

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medminder5.screens.BerandaScreen
import com.example.medminder5.screens.CreateObatFormPage
import com.example.medminder5.screens.ObatScreen
import com.example.medminder5.screens.RiwayatScreen
import com.example.medminder5.screens.UpdateObatFormPage
import com.example.medminder5.viewmodel.ObatViewModel

@Composable
fun BottomNavGraph(navController: NavHostController, viewModel: ObatViewModel) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Beranda.route
    ) {
        composable(route = BottomBarScreen.Beranda.route) {
            BerandaScreen(viewModel, navController)
        }
        composable(route = BottomBarScreen.Obat.route) {
            ObatScreen(viewModel, navController)
        }
        composable(route = BottomBarScreen.Riwayat.route) {
            RiwayatScreen()
        }
        composable(route = "Beranda") {
            BerandaScreen(viewModel, navController)
        }
        composable(route = "Obat") {
            ObatScreen(viewModel, navController)
        }
        composable(route = "Riwayat") {
            RiwayatScreen()
        }
        composable(route = "CreateObat") {
            CreateObatFormPage(viewModel, navController)
        }
        composable(route = "UpdateObat") {
            UpdateObatFormPage(viewModel, navController)
        }
    }
}