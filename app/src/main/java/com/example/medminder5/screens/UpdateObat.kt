package com.example.medminder5.screens

import androidx.compose.runtime.Composable
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.medminder5.model.Obat
import com.example.medminder5.viewmodel.ObatViewModel
import java.time.LocalTime
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TimePickerState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.medminder5.R

@Composable
fun UpdateObatFormPage(viewModel: ObatViewModel, navController: NavHostController) {
    var nama by remember { mutableStateOf("") }
    var hari by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var jam by remember { mutableStateOf("") }

    val obatChosen = viewModel.getSelectedObat()

    val context = LocalContext.current
    val successMessage = "Obat berhasil diperbarui"
    val warningMessage = "Obat gagal diperbarui"

    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){


            Box(
                modifier = Modifier
                    .size(60.dp)
//                            .clip(CircleShape)
//                            .background(MaterialTheme.colorScheme.primary)
                    .clickable {
                        navController.navigate("Obat")
                    }
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = "Update Obat",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
//                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF020202),
                    letterSpacing = 0.15.sp,
                )
            )
        }

        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {


            item {
                Text("Nama Obat")
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    label = { Text("") },
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text("Deskripsi")
                OutlinedTextField(
                    value = deskripsi,
                    onValueChange = { deskripsi = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    label = { Text("") },
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text("Hari")
                OutlinedTextField(
                    value = hari,
                    onValueChange = { hari = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    label = { Text("") },
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Jam")
                OutlinedTextField(
                    value = jam,
                    onValueChange = { jam = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    label = { Text("") },
                )
                Spacer(modifier = Modifier.height(16.dp))
            }


            item{
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        onClick = {
                            if (
                                nama.isEmpty() || deskripsi.isEmpty() ||
                                jam.isEmpty() || hari.isEmpty()

                            ) {
                                Toast.makeText(context, warningMessage, Toast.LENGTH_SHORT).show()
                            }
                            else {

                                obatChosen.nama = nama
                                obatChosen.deskripsi = deskripsi
                                obatChosen.jam = jam
                                obatChosen.hari = hari


                                viewModel.updateObat(obatChosen)
                                Toast.makeText(context, successMessage, Toast.LENGTH_SHORT).show()
                                navController.navigate("Beranda")
                            }
                        },
                        modifier = Modifier
                            .padding(0.5.dp)
                            .width(250.dp)
                            .height(55.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3D4EB0), // Change the background color here
                            contentColor = Color.White // Change the text color here
                        ),

                        ) {
                        Text(
                            text = "+ Update Obat",
                            color = Color.White, // Mengatur warna teks menjadi putih
                            fontSize = 16.sp// Mengatur ukuran font teks
                        )
                    }
                }



            }
        }
    }
}

