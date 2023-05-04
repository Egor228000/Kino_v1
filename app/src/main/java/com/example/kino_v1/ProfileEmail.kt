package com.example.kino_v1

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.OutlinedButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileEmail(navController: NavController) {
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

    Column(Modifier.padding(top = 360.dp, start = 20.dp)) {
        var email by remember {
            mutableStateOf("")
        }
        var kkk by rememberSaveable {
            mutableStateOf(false)
        }
        var password by remember {
            mutableStateOf("")
        }
        var size by remember {
            mutableStateOf(false)
        }
        if (email == "krasnov@gmail.com" && password == "12345") {
            kkk = true
        }
        Text(text = "По email", color = Color(0xFF6F6F6F))
        OutlinedTextField(value = email, onValueChange = { email = it },
            modifier = Modifier
                .padding(top = 10.dp, start = 0.dp)
                .size(320.dp, 50.dp), placeholder = { Text(text = "email@example.com") })
        OutlinedTextField(value = password, onValueChange = { password = it },
            modifier = Modifier
                .padding(top = 10.dp, start = 0.dp)
                .size(320.dp, 50.dp), placeholder = { Text(text = "Пароль") },
            trailingIcon = {
                IconToggleButton(checked = size, onCheckedChange = { size = it }) {
                    if (size) {
                        IconButton(onClick = { size = false }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                                contentDescription = "",
                                tint = Color(0xFF644AA9)
                            )
                        }
                    } else {
                        IconButton(onClick = { size = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                                contentDescription = "",
                                tint = Color(0xFF644AA9)
                            )
                        }
                    }

                }
            })

        TextButton(
            onClick = { },
            modifier = Modifier.padding(start = 160.dp, top = 5.dp)
        ) {
            Text(
                text = "Не помню пароль", fontSize = 15.sp, color = Color(0xFF644AA9),
            )
        }
        Button(
            onClick = { }, shape = RoundedCornerShape(15), modifier = Modifier
                .padding(top = 20.dp, start = 0.dp)
                .size(320.dp, 45.dp), colors = ButtonDefaults.buttonColors(Color(0xFF644AA9)),
            enabled = kkk
        ) {
            Text(text = "Войти", fontSize = 16.sp, color = Color.White)
        }
    }

}


