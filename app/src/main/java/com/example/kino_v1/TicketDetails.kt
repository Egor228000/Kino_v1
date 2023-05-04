package com.example.kino_v1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController

@Composable
fun TicketDetails(navController: NavController){
    var on by remember {
        mutableStateOf(false)
    }
    var bilet by rememberSaveable {
        mutableStateOf("")
    }
    var pochta by rememberSaveable {
        mutableStateOf("")
    }

    if (bilet.length == 6 && pochta.length == 15){
        on = true
    }
    var offonn by rememberSaveable {
        mutableStateOf(true)
    }
    Column() {
        TopAppBar(Modifier.size(400.dp, 90.dp), backgroundColor = Color(0xFFFEFEFE)) {
            Box(Modifier.padding(start = 0.dp, top = 35.dp)) {
                IconButton(onClick = { navController.popBackStack() }, modifier = Modifier.size(40.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_close_24),
                        contentDescription = " ", tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            Text(
                text = "Добавление билета",
                fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 30.dp, start = 35.dp)
            )
        }
    }
    Column(
        Modifier
            .padding(top = 93.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFF9F9F9))
        ) {
        Text(text = "Введите номер билета и почту",
        modifier = Modifier.padding(start = 50.dp, top = 30.dp),
        fontSize = 18.sp)

        TextField(value = bilet,
            onValueChange = {bilet = it},
            colors = TextFieldDefaults.
            textFieldColors(backgroundColor = Color(0xFFF9F9F9),
           focusedLabelColor = Color(0xFF0F8F85) ,
                focusedIndicatorColor = Color(0xFF0F8F85)
            ), label = {Text(text = "Билет ID")},
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .size(320.dp, 50.dp)
        ,  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = pochta, onValueChange = {pochta = it},
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color(0xFFF9F9F9),
                focusedLabelColor = Color(0xFF0F8F85) , focusedIndicatorColor = Color(0xFF0F8F85)
            ), label = {Text(text = "Почта держателя")}, modifier = Modifier
                .padding(start = 20.dp, top = 40.dp)
                .size(320.dp, 50.dp)
        )


        Row {
            Checkbox(checked = offonn, onCheckedChange = {offonn = it},
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFF6E47B6)))

            Text(text = "Принять билет",
                color = Color(0xFF878787),
            modifier = Modifier.padding(top = 24.dp),
                fontSize = 15.sp)

            Icon(painter = painterResource(id = R.drawable.baseline_error_24), contentDescription = "" ,
            tint = Color(0xFF787878), modifier = Modifier.padding(top = 22.dp, start = 10.dp)
            )

        }
        Button(onClick = { /*TODO*/ }, enabled = on,
            modifier = Modifier
                .padding(start = 120.dp, top = 20.dp)
                .size(130.dp, 60.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6E47B6)), shape = RoundedCornerShape(25)
        ) {
            Text(text = "ДОБАВИТЬ", color = Color.White)
        }
        

    }
    if (!offonn){
        Dialog(onDismissRequest = { offonn = true }) {
            Card(Modifier.size(300.dp, 200.dp)) {
                Column() {
                    Text(text = "Принять билет от друга", fontSize = 18.sp,
                        fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 50.dp, top =30.dp))
                    Text(text = "Теперь можно принимать билеты если знаешь билет ID и почту держателя:)",
                         modifier = Modifier.padding(start = 50.dp, top = 15.dp), fontSize = 16.sp)
                    Button(onClick = {  offonn = true },  modifier = Modifier
                        .padding(start = 170.dp, top = 10.dp)
                        .size(110.dp, 50.dp), shape = RoundedCornerShape(20),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6E47B6))
                    ) {
                        Text(text = "ПОНЯТНО", color = Color.White)
                    }
                }
            }

    
            
        }
    }

}