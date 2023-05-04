package com.example.kino_v1

import android.app.AlertDialog
import android.text.style.EasyEditSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Films(navController: NavController){
    Column() {
        Column(
            modifier = Modifier
                .padding(top = 0.dp)
                .size(400.dp, 90.dp)
                .background(color = Color(0xFF19082C))
        ) {
            Text(
                text = "КИНО", fontSize = 28.sp, fontWeight = FontWeight.Bold,
                color = Color.White, modifier = Modifier.padding(top = 40.dp, start = 10.dp)
            )
        }
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 0.dp, start = 10.dp)) {
            Text(text = "Сейчас в кино", fontSize = 18.sp, color = Color(0xFF767676))
            Spacer(modifier = Modifier.padding(top = 30.dp))
            MiniCard("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/five_mini.jpg?alt=media&token=48f93fa8-728b-4b43-9028-07d456133705", "6.9", "Три мушкетера: Д`Артаньян", "БОЕВИК, ИСТОРИЧЕСКИЙ, ПРИКЛЮЧЕНИЕ", "От Лувра до Букингемкого дворца, от трущоб Парижа до осады Ла-Рошели... В корол...",
                navController)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            MiniCard("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/one_mini.jpg?alt=media&token=d7bb0c22-952f-498e-8370-18e1139c7157", "7.7", "Джон Уик-4", "БОЕВИК, ТРИЛЛЕР, КРИМИНАЛЬНЫЙ", "Джон Уик (Киану Ривз)\n" +
                    "находит способ победить\n" +
                    "Правление кланов. Но преж …", navController)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            MiniCard("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/two_mini.jpg?alt=media&token=857ed6b6-5e78-4f58-80de-0b20acbb10b7", "6.7", "Вызов", "ДРАМА", "Торакальный хирург Женя за\n" +
                    "месяц должна подготовиться\n" +
                    "к космическому полету и от …", navController)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            MiniCard("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/free_mini.jpg?alt=media&token=69408ec8-3d06-4284-b6e6-96280fc3eb59", "6.4", "Мое прекрасное несчастье", "КОМЕДИЯ, МЕЛОДРАМА", "Эбби - загадочная и\n" +
                    "недоступная первокурсница,\n" +
                    "желающая сбежать от свое …", navController)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            MiniCard("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/for_mini.jpg?alt=media&token=234faf27-71a2-4fe4-81b0-ad6bdc63f333", "6.8", "На солнце вдоль рядов кукурузы", "ДРАМА", "История о небе, несбыточной\n" +
                    "НА СОЛНЦЕ,\n" +
                    "мечте и подвиге, поразивше …", navController)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            MiniCard("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/six_mini.jpg?alt=media&token=99f42cc3-94f6-4c1f-929a-8cafff8e4071", "6.9", "Коты Эрмитажа", "МУЛЬТФИЛЬМ,\n" +
                    "ПРИКЛЮЧЕНИЕ, КОМЕДИЯ", "Юный кот по имени Винсент\n" +
                    "в компании мыши Мориса\n" +
                    "спасается от наводнения в стамбуле…", navController)
            Spacer(modifier = Modifier.padding(top = 10.dp))
        }
    }
}

@Composable
fun MiniCard(film_mini: String, imgs: String, name_films: String, janr: String, edit: String, navController: NavController){
    Row(Modifier.clickable(onClick = {navController.navigate("films_details")})) {
        Box() {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(film_mini)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp, 150.dp)

            )
            Column(modifier = Modifier.padding(top = 50.dp, start = 20.dp)) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(50.dp)) {
                    Icon(painter = painterResource(id = R.drawable.baseline_play_circle_24), contentDescription = "",
                        tint = Color(0x8DE6D5D5),  modifier = Modifier.size(50.dp)
                    )
                }
            }
            Column(modifier = Modifier
                .size(40.dp, 23.dp)
                .background(color = Color(0xFF6B43BD))) {
                Text(text = imgs, fontSize = 15.sp, color = Color.White,
                    modifier = Modifier.padding(start = 7.dp,
                        top = 1.dp))
            }
        }
        Column(
            Modifier
                .size(240.dp, 135.dp)
                .padding(start = 10.dp)) {
            Text(text = name_films, fontSize = 17.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(text = janr, fontSize = 16.sp, color = Color(0xFFCACBCF))
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(text = edit, fontSize = 16.sp)
        }

    }

}