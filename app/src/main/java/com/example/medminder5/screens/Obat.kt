package com.example.medminder5.screens



import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medminder5.R
import com.example.medminder5.model.Obat
import com.example.medminder5.viewmodel.ObatViewModel

@Composable
fun ObatScreen(viewModel: ObatViewModel, navController: NavController) {
    val obats = viewModel.obatList.collectAsState().value
    viewModel.obatList.collectAsState().value

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        ObatList(obats, viewModel, navController)
        Button(
            onClick = {
                navController.navigate("CreateObat")
            },
            modifier = Modifier
                .padding(0.5.dp)
                .width(250.dp)
                .height(55.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3D4EB0), // Change the background color here
                contentColor = Color.White // Change the text color here
            )
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Tambah Obat",
                    // Button
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 1.25.sp,
                    )
                )
            }
        }

    }
}

@Composable
fun ObatList(obats: List<Obat>, viewModel: ObatViewModel, navController: NavController) {
    val context = LocalContext.current
    val successMessage = "Obat berhasil dihapus"
    val warningMessage = "Obat gagal dihapus"
    Column (
    ){
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
                text = "Daftar Obat",
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
    }
    LazyColumn(
        modifier = Modifier.height(600.dp)
    ){
        items(obats) { obat ->
            Column (
                modifier = Modifier.fillMaxSize()
            ){


                Box(
                    modifier = Modifier
                        .padding(20.dp, 20.dp, 20.dp, 0.dp)
                ){
                    Column {

                        Row(
                            modifier = Modifier.height(40.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ){
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
                                modifier = Modifier.weight(3f)
                            )


                            Box(
                                modifier = Modifier
                                    .size(80.dp)
//                            .clip(CircleShape)
//                            .background(MaterialTheme.colorScheme.primary)
                                    .clickable {
                                        viewModel.setSelectedObat(obat)
                                        navController.navigate("UpdateObat")
                                    }
                                    .padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.edit),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }


                            Box(
                                modifier = Modifier
                                    .size(80.dp)
                                    .clickable {
                                        viewModel.deleteObat(obat)
                                        Toast
                                            .makeText(context, successMessage, Toast.LENGTH_SHORT)
                                            .show()
                                        navController.navigate("Obat")
                                    }
                                    .padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.delete),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }


                        }



                    }
                }

            }


        }
    }



}

//@Preview(showBackground = true)
//@Composable
//fun previewObat() {
//    Surface {
//        ObatScreen()
//    }
//}

