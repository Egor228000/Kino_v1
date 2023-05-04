package com.example.kino_v1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Kino(navController: NavController){
    TopAppBar(Modifier.size(400.dp, 90.dp), backgroundColor = Color(0xFF19082C)) {
        Text(
            text = "КИНО", fontSize = 28.sp, fontWeight = FontWeight.Bold,
            color = Color.White, modifier = Modifier.padding(top = 30.dp, start = 5.dp)
        )
        Box(Modifier.padding(start = 230.dp, top = 35.dp)) {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(40.dp)) {
                Icon(painter = painterResource(id = R.drawable.baseline_map_24), contentDescription =" ",
                    tint = Color.White, modifier = Modifier.size(30.dp)
                )
            }
        }
    }


    Column(Modifier.padding(top = 90.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/ggggg.png?alt=media&token=4c538885-cba2-43bd-830b-5f2c856299fc")
                .crossfade(true)
                .build(),
            contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier
                .size(400.dp, 600.dp)

        )
//        AsyncImage(model = "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/ggggg.png?alt=media&token=4c538885-cba2-43bd-830b-5f2c856299fc", contentDescription = "",
//        contentScale = ContentScale.Crop, modifier = Modifier
//                .size(400.dp, 600.dp))
    }

}
