package com.example.kino_v1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Popular(navController: NavController){
    Box() {
        val pageCountt = 6
        val pagerState = rememberPagerState()

        HorizontalPager(
            pageCount = pageCountt, state = pagerState,  pageSpacing = 0.dp
        ) { page ->
            // Our page content
            when(page){
                0->{
                    ImageFilms("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/one_big_.png?alt=media&token=5e29d8ea-29d9-4682-a950-e389a5467759", "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/one_mini.jpg?alt=media&token=d7bb0c22-952f-498e-8370-18e1139c7157", "7.7", "ДЖОН УИК-4", "22:50")
                }
                1->{
                    ImageFilms("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/five_big.png?alt=media&token=ac53cdf7-c32b-46d3-8f33-2775a5694217", "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/five_mini.jpg?alt=media&token=48f93fa8-728b-4b43-9028-07d456133705", "6.9", "ТРИ МУШКЕТЕРА: Д`ДАРТАНЬЯН", "18:30")
                }
                2-> {
                    ImageFilms("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/for_big.png?alt=media&token=b362ac08-979a-45b5-9df1-a18e9fabbb4b", "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/for_mini.jpg?alt=media&token=234faf27-71a2-4fe4-81b0-ad6bdc63f333", "6.6", "НА СОЛНЦЕ, ВДОЛЬ РЯДОВ КУКУРУЗЫ ", "14:40")
                }
                3-> {
                    ImageFilms("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/free_big.png?alt=media&token=3d8eed88-a12d-4369-82e5-df9c4b2ae8a0", "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/free_mini.jpg?alt=media&token=69408ec8-3d06-4284-b6e6-96280fc3eb59", "6.4", "МОЕ ПРЕКРАСНОЕ НЕСЧАСТЬЕ", "16:25")

                }
                4-> {
                    ImageFilms("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/six_big.png?alt=media&token=4e81ece4-16d5-4860-a3b0-44703a266fab", "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/six_mini.jpg?alt=media&token=99f42cc3-94f6-4c1f-929a-8cafff8e4071", "6.9", "КОТЫ ЭРМИТАЖА", "12:35")
                }
                5-> {
                    ImageFilms("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/two_big.png?alt=media&token=3e849b92-fe54-4bf2-b2f4-3b36fd1ccafc", "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/two_mini.jpg?alt=media&token=857ed6b6-5e78-4f58-80de-0b20acbb10b7", "6.6", "ВЫЗОВ", "11:50")
                }
                
                
            }
        }
        Row(
            Modifier
                .height(20.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCountt) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color(0xFFFA3E5B) else Color(
                    0xFF868686
                )
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 0.dp)
                .size(400.dp, 90.dp)
                .background(color = Color(0x39000000))
        ) {
            Text(
                text = "КИНО", fontSize = 28.sp, fontWeight = FontWeight.Bold,
                color = Color.White, modifier = Modifier.padding(top = 40.dp, start = 10.dp)
            )
        }
    }
}
@Composable
fun ImageFilms(film_big: String, film_mini: String, imbs: String, name_films: String, time_films: String){
    Box(Modifier.clickable {  }) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(film_big)
                .crossfade(true)
                .build(),
            contentDescription = "", modifier = Modifier.size(460.dp, 900.dp), contentScale = ContentScale.Crop

        )
//        AsyncImage(model = film_big, contentDescription ="" ,
//            modifier = Modifier.size(460.dp, 900.dp), contentScale = ContentScale.Crop)
        Box(Modifier.padding(start = 20.dp, top = 410.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(film_mini)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp, 150.dp)
            )
//            AsyncImage(
//               model = film_mini,
//                contentDescription = "",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.size(100.dp, 150.dp)
//            )
            Column(modifier = Modifier.padding(top = 50.dp, start = 20.dp)) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(50.dp)) {
                    Icon(painter = painterResource(id = R.drawable.baseline_play_circle_24), contentDescription = "",
                    tint = Color(0xA9E6D5D5),  modifier = Modifier.size(50.dp)
                    )
                }
            }
            Column(modifier = Modifier
                .size(40.dp, 23.dp)
                .background(color = Color(0xFF6B43BD))) {
                Text(text = imbs, fontSize = 15.sp, color = Color.White,
                modifier = Modifier.padding(start = 7.dp,
                top = 1.dp))

            }
        }
        val gradientColors = listOf(Color(0x0), Color(0xB5000000))
        val gradient = Brush.linearGradient(
            colors = gradientColors,
            start = Offset(0f, -10f),
            end = Offset(0f, 230f)
        )
        Column(modifier = Modifier
            .padding(top = 565.dp)
            .size(540.dp, 180.dp)
            .background(gradient)) {
            Text(text = name_films, fontSize = 21.sp, color = Color.White,
                fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp, start = 20.dp))
            Text(text = "Формула Кино Аура", color = Color.White
                , modifier = Modifier.padding(top = 5.dp, start = 20.dp), fontSize = 18.sp)
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
                .size(90.dp, 40.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF6B43BD)), shape = (CircleShape)) {
                Text(text = time_films, color = Color.White, fontSize = 16.sp)
            }
        }
    }
}