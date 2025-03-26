package com.example.videocompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setContent{
            profile()
        }
    }
    @Preview
    @Composable
    private fun profile() {
        Column(
            Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color= Color(android.graphics.Color.parseColor("#f2f1f6"))),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            ConstraintLayout(
                Modifier
                .height(250.dp)
                .background(color = Color(android.graphics.Color.parseColor("#32357a")))) {
                val (topImg,profile,title,back,pen) = createRefs()

            Image(painterResource(id= R.drawable.arc_3),null,Modifier
                .fillMaxWidth()
                .constrainAs(topImg){
                    bottom.linkTo(parent.bottom)
                })
            Image(painterResource(id= R.drawable.circledphoto),null,Modifier
                .fillMaxWidth()
                .constrainAs(profile){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(topImg.bottom)
                })
            Text(text = "Perfil",
                style= TextStyle(color = Color.White,
                    fontSize = 30.sp),
                modifier = Modifier
                    .constrainAs(title){
                        top.linkTo(parent.top, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Image(painterResource(id= R.drawable.back),null,Modifier
                .constrainAs(back){
                    top.linkTo(parent.top, margin=35.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                })
            Image(painterResource(id= R.drawable.write),null,Modifier
                .constrainAs(pen){
                    top.linkTo(profile.top)
                    start.linkTo(profile.end)
                })
        }
            Text(
                text = "Gustavo Valera",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                color = Color(android.graphics.Color.parseColor("#32357a"))
            )
            Text(
                text = "gustavovalera@gmail.com",
                fontSize = 18.sp,
                color = Color(android.graphics.Color.parseColor("#747679"))
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end=32.dp, top = 32.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_1),null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable{})
                }
                Column(modifier = Modifier
                    .padding(start= 16.dp)
                    .weight(1f)) {
                    Text(text = "Notificacion",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Column(
                    modifier=Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id= R.drawable.arrow),
                        null,
                        Modifier.padding(end=5.dp)
                            .clickable {  })
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end=32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_2),null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable{})
                }
                Column(modifier = Modifier
                    .padding(start= 16.dp)
                    .weight(1f)) {
                    Text(text = "Calendario",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Column(
                    modifier=Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id= R.drawable.arrow),
                        null,
                        Modifier.padding(end=5.dp)
                            .clickable {  })
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end=32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_3),null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable{})
                }
                Column(modifier = Modifier
                    .padding(start= 16.dp)
                    .weight(1f)) {
                    Text(text = "Galeria",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Column(
                    modifier=Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id= R.drawable.arrow),
                        null,
                        Modifier.padding(end=5.dp)
                            .clickable {  })
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end=32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_4),null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable{})
                }
                Column(modifier = Modifier
                    .padding(start= 16.dp)
                    .weight(1f)) {
                    Text(text = "Lista",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Column(
                    modifier=Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id= R.drawable.arrow),
                        null,
                        Modifier.padding(end=5.dp)
                            .clickable {  })
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end=32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_5),null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable{})
                }
                Column(modifier = Modifier
                    .padding(start= 16.dp)
                    .weight(1f)) {
                    Text(text = "Compartir",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Column(
                    modifier=Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id= R.drawable.arrow),
                        null,
                        Modifier.padding(end=5.dp)
                            .clickable {  })
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end=32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_6),null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable{})
                }
                Column(modifier = Modifier
                    .padding(start= 16.dp)
                    .weight(1f)) {
                    Text(text = "Cerrar Sesion",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Column(
                    modifier=Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id= R.drawable.arrow),
                        null,
                        Modifier.padding(end=5.dp)
                            .clickable {  })
                }
            }
        }
    }
}