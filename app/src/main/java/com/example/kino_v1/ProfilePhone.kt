package com.example.kino_v1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfilePhone(navController: NavController) {
    Column() {
        TopAppBar(
            Modifier.size(400.dp, 90.dp), backgroundColor = Color(0xFFFEFEFE),
            elevation = 0.dp
        ) {
            Box(Modifier.padding(start = 0.dp, top = 35.dp)) {
                TextButton(onClick = { navController.popBackStack() }) {
                    Text(text = "Назад", fontSize = 15.sp, color = Color(0xFF644AA9))
                }
            }
            Text(
                text = "КИНО",
                fontSize = 28.sp, fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 30.dp, start = 65.dp)
            )
            Box(Modifier.padding(start = 50.dp, top = 35.dp)) {
                TextButton(onClick = { navController.navigate("profile") }) {
                    Text(text = "Закрыть", fontSize = 15.sp, color = Color(0xFF644AA9))
                }
            }
        }
    }
    Column(Modifier.padding(top = 420.dp, start = 20.dp)) {
        var phone by rememberSaveable {
            mutableStateOf("")
        }


        Text(text = "По номеру телефона", color = Color(0xFF6F6F6F))
        OutlinedTextField(value = phone, onValueChange = { phone = it },
            modifier = Modifier
                .padding(top = 10.dp, start = 0.dp)
                .size(320.dp, 50.dp), placeholder = { Text(text = "+7 (000) 000-00-00") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone,
            ),
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        if (phone.length == 11){
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(15),
                modifier = Modifier.
                size(320.dp, 45.dp),colors =  ButtonDefaults.buttonColors(Color(0xFF644AA9)) ) {
                Text(text = "Получить код",  fontSize = 17.sp, color = Color.White)
            }
        }

    }
}