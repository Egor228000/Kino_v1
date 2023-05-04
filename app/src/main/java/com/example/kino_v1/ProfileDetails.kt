package com.example.kino_v1

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.checkerframework.checker.optional.qual.Present

@Composable
fun ProfileDetails(navController: NavController){
    Column() {
        TopAppBar(Modifier.size(400.dp, 90.dp), backgroundColor = Color(0xFFFEFEFE),
        elevation = 0.dp) {
            Text(
                text = "КИНО",
                fontSize = 28.sp, fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 30.dp, start = 135.dp)
            )
            Box(Modifier.padding(start =50.dp, top = 35.dp)) {
                TextButton(onClick = { navController.popBackStack()}) {
                    Text(text = "Закрыть", fontSize = 15.sp, color = Color(0xFF644AA9))
                }
            }
        }
    }
    Column(Modifier.padding(top = 360.dp, start = 20.dp)) {
        Text(text = "Войти", color = Color(0xFF6F6F6F))
        Button(onClick = {navController.navigate("profile_phone") }, shape = RoundedCornerShape(15), modifier = Modifier.
        padding(top = 10.dp, start = 0.dp).
        size(320.dp, 45.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF644AA9))) {
            Text(text = "По номеру телефона", fontSize = 17.sp, color = Color.White)
        }
        OutlinedButton(onClick = { navController.navigate("profile_email") }, shape = RoundedCornerShape(15),
             modifier = Modifier.
            padding(top = 20.dp, start = 0.dp).
            size(320.dp, 45.dp).border(2.dp, color = Color(0xFF644AA9), shape = RoundedCornerShape(15))) {
            Text(text = "По email", fontSize = 17.sp, color = Color(0xFF644AA9))
        }
        TextButton(onClick = { navController.navigate("profile_registr")},
        modifier = Modifier.padding(start = 70.dp, top = 240.dp)) {
            Text(text = "Зарегистрироваться", fontSize = 15.sp, color = Color(0xFF644AA9),
            )
        }
    }
}
