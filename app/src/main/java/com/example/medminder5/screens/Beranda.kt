package com.example.medminder5.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medminder5.model.Obat
import com.example.medminder5.viewmodel.ObatViewModel
import android.os.Build
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medminder5.R
import java.text.DateFormat
import java.util.Calendar


@Composable
fun BerandaScreen(viewModel: ObatViewModel, navController: NavController) {
    val obats = viewModel.obatList.collectAsState().value
    viewModel.obatList.collectAsState().value

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        ObatListBeranda(obats, viewModel, navController)


    }

}

@Composable
fun ObatListBeranda(obats: List<Obat>, viewModel: ObatViewModel, navController: NavController) {
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(calendar)
    Column(

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.pinguin),
                contentDescription = "image description",
                modifier = Modifier
                    .size(60.dp)
                    .padding(0.dp, 8.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = "Beranda",
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
        // tanggal
        Spacer(modifier = Modifier.height(35.dp))
        Row {
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFF000000),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .height(32.dp)
                    .padding(5.dp,5.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = dateFormat,

                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
//                    fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.15.sp,
                    )
                )
            }
        }


        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .padding(20.dp,0.dp)
        ){
            items(obats){ obat ->
                Box(
                    modifier = Modifier
                        .padding(20.dp, 20.dp, 20.dp, 0.dp)
                ) {
                    Column {



                        Row(
                            modifier = Modifier.height(40.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pill),
                                contentDescription = "image description",
                                contentScale = ContentScale.None,
                                modifier = Modifier
                                    .width(24.dp)
                                    .height(24.dp)
                                    .weight(1f)
                            )


                            Text(
                                text = obat.nama,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF020202),
                                    letterSpacing = 0.15.sp,
                                ),
                                modifier = Modifier.weight(5f)
                            )


                            var yourCheckedState by remember { mutableStateOf(false) }
                            Checkbox(
                                checked = yourCheckedState,
                                onCheckedChange = { newCheckedState ->
                                    yourCheckedState = newCheckedState},
                                modifier = Modifier
                                    .offset(y = (-10).dp)
                                    .align(Alignment.CenterVertically),
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color.Black,      // Warna checkbox ketika dicentang
                                    uncheckedColor = Color.Black,    // Warna checkbox ketika tidak dicentang
                                    checkmarkColor = Color.White     // Warna centang pada checkbox
                                )
                            )
                        }

                        Text(text = "Deskripsi :",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(600),
                            )
                        )
                        Text(
                            text = obat.deskripsi,
                            style = TextStyle(
                                fontWeight = FontWeight(400),
                            ),
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Jam konsumsi :",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(600),
                            )
                        )
                        Text(
                            text = obat.jam,
                            style = TextStyle(
                                fontWeight = FontWeight(400),
                            ),
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Hari konsumsi :",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(600),
                            )
                        )
                        Text(
                            text = obat.hari,
                            style = TextStyle(
                                fontWeight = FontWeight(400),
                            ),
                        )

                        Spacer(modifier = Modifier.height(8.dp))




                    }
                }

            }
        }

    }

}


