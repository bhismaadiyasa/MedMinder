package com.example.medminder5.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medminder5.R


@Composable
fun RiwayatScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
                text = "Riwayat",
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

        Box(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
        ){
            Column {
                // tanggal
                Box (
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(71.dp)
                        .height(32.dp)
                        .padding(top = 5.dp, bottom = 3.dp),
                    contentAlignment = Alignment.Center
                ){

                    Text(
                        text = "22 Nov",

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

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.height(40.dp)
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
                        text = "CDR",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(3f)
                    )

                    Text(
                        text = "08.00 AM",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(1.75f)
                    )
                }

                Row(
                    modifier = Modifier.height(40.dp)
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
                        text = "Panadol",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(3f)
                    )

                    Text(
                        text = "09.00 AM",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(1.75f)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
        ){
            Column {
                // tanggal
                Box (
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(71.dp)
                        .height(32.dp)
                        .padding(top = 5.dp, bottom = 3.dp),
                    contentAlignment = Alignment.Center
                ){

                    Text(
                        text = "24 Nov",

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

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.height(40.dp)
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
                        text = "CDR",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(3f)
                    )

                    Text(
                        text = "08.00 AM",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(1.75f)
                    )
                }

                Row(
                    modifier = Modifier.height(40.dp)
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
                        text = "Ibuprofen",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(3f)
                    )

                    Text(
                        text = "12.00 PM",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(1.75f)
                    )
                }

                Row(
                    modifier = Modifier.height(40.dp)
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
                        text = "Panadol",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(3f)
                    )

                    Text(
                        text = "12.00 PM",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF020202),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier.weight(1.75f)
                    )
                }
            }




        }
    }



}

@Preview(showBackground = true)
@Composable
fun preview() {
    Surface {
        RiwayatScreen()
    }
}


