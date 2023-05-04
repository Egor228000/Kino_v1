package com.example.kino_v1

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavController
import com.google.common.io.Files.append
import com.google.firebase.FirebaseException
import java.util.concurrent.TimeUnit

@Composable
fun Profile(navController: NavController, context: Context) {
    Column(Modifier.size(400.dp, 500.dp)) {
        Row(
            Modifier
                .padding(start = 140.dp, top = 70.dp)
                .size(80.dp)
                .clip(RoundedCornerShape(90.dp))
                .background(color = Color(0xFFE8E8E8))) {
            Box(Modifier.padding(start = 20.dp, top = 20.dp)){
                Icon(painter = painterResource(id = R.drawable.baseline_person_24), contentDescription = "",
                    modifier = Modifier.size(40.dp), tint = Color(0xFFA2A2A2)
                )
            }



        }

            Text(text = "АВТОРИЗАЦИЯ", fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 120.dp, top = 20.dp)
                .clickable(onClick = { navController.navigate("profile_details") }),
                color = Color(0xFF644AA9), fontWeight = FontWeight.Bold
            )
        Box(Modifier.padding(start = 20.dp, top = 10.dp)) {
            Text(text = "     После авторизации вы получите доступ к\n" +
                    " вашим билетам и программе лояльности Бонус -" +
                    "сможете копить баллы за покупки и обменивать   " +
                    "их на билеты!", fontSize = 15.sp,
                modifier = Modifier.align(alignment = Alignment.Center),
                color = Color(0xFF888888)
            )
        }
        Box() {
            var on by remember {
                mutableStateOf(false)
            }
            Switch(checked = on, onCheckedChange = {on = it}, modifier = Modifier.padding(start = 290.dp, top = 92.dp),
            colors = SwitchDefaults.colors(Color(0xFF644AA9)))

            Row(
                Modifier
                    .padding(start = 20.dp, top = 40.dp)
                    .clickable(onClick = {})) {
                Icon(painter = painterResource(id = R.drawable.baseline_support_agent_24), contentDescription = "",
                    tint = Color(0xFF644AA9))
                Text(text = "Поддержка", modifier = Modifier.padding(start = 30.dp, top = 2.dp),
                    fontSize = 16.sp)
            }
            Row(Modifier.padding(start = 20.dp, top =100.dp)) {
                Icon(painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription = "",
                    tint = Color(0xFF644AA9))
                Text(text = "Геолокация", modifier = Modifier.padding(start = 30.dp, top = 2.dp),
                    fontSize = 16.sp)



            }
            Row(
                Modifier
                    .padding(start = 20.dp, top = 165.dp)
                    .clickable(onClick = {})) {
                Icon(painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription = "",
                    tint = Color(0xFF644AA9))
                Column() {
                    Text(text = "Ваш город?", modifier = Modifier.padding(start = 30.dp, top = 2.dp),
                        fontSize = 16.sp)
                    Text(text = "Новосибирск", modifier = Modifier.padding(start = 30.dp, top = 0.dp),
                        fontSize = 14.sp)
                }

            }
        }




    }

    Column(
        Modifier
            .padding(top = 500.dp)
            .size(400.dp, 500.dp)
            .background(color = Color(0xFFF2F2F2))) {
        val context = LocalContext.current
        val savedText = remember { mutableStateOf("") }
        val textValue = remember { mutableStateOf(TextFieldValue()) }

        Button(onClick = {
            val inputText = textValue.value.text
            val prefs = context.getSharedPreferences("PREFS_NAME", 0)
            val editor = prefs.edit()
            editor.putString("KEY_TEXT", inputText)
            editor.apply()
            savedText.value = inputText
        }) {
            Text("Save Text")
        }

        Column {
            Text(textValue.value.text)
            Text(savedText.value)
        }

        val prefs = context.getSharedPreferences("PREFS_NAME", 0)
        val myText = prefs.getString("KEY_TEXT", null)
        if (myText != null) {
            savedText.value = myText
        }
    }
    }





