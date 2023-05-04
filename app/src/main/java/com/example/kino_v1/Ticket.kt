package com.example.kino_v1

import android.app.Activity
import android.content.DialogInterface
import android.hardware.biometrics.BiometricManager
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import androidx.core.os.CancellationSignal
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Ticket(navController: NavController){
    TopAppBar(Modifier.size(400.dp, 90.dp), backgroundColor = Color(0xFFFEFEFE)) {
        Text(
            text = "КИНО", fontSize = 28.sp, fontWeight = FontWeight.Bold,
            color = Color.Black, modifier = Modifier.padding(top = 30.dp, start = 5.dp)
        )
        Box(Modifier.padding(start = 230.dp, top = 35.dp)) {
            IconButton(onClick = { navController.navigate("ticket_details") }, modifier = Modifier.size(40.dp)) {
                Icon(painter = painterResource(id = R.drawable.baseline_add_circle_24), contentDescription =" ",
                tint = Color(0xFF6E47B6), modifier = Modifier.size(30.dp)
                )
            }
        }
    }
    Box(Modifier.padding(start = 50.dp, top = 300.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/phone.png?alt=media&token=cacb5645-8145-459b-a0bb-2a0007658c68")
                .crossfade(true)
                .build(),
            contentDescription = "",  modifier = Modifier.size(270.dp)

        )
//        AsyncImage(model = "https://firebasestorage.googleapis.com/v0/b/kino-v1.appspot.com/o/phone.png?alt=media&token=cacb5645-8145-459b-a0bb-2a0007658c68", contentDescription ="" ,
//        modifier = Modifier.size(300.dp))
    }
    Text(text = "Тут будут ваши билеты", modifier = Modifier.padding(start = 60.dp, top = 600.dp),
    fontSize = 23.sp, color = Color(0xFFCCCCD6)
    )

}

