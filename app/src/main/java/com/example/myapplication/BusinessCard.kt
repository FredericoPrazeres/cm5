package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.navigation.Screens

@Composable
fun BusinessCallingCardDemo(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color.White, Color.Blue))),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BusinessCallingCardExample(navController)
    }
}

@Composable
fun BusinessCallingCard(
    navController: NavController,
    name: String,
    email: String,
    backgroundColor: Color = Color.White,
    phone: String
) {

    Button(
        onClick = { navController.navigate(Screens.Roll.route) },
        modifier= Modifier.padding(12.dp)
    ) {
        Text(stringResource(R.string.back))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 64.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .border(
                        width = 4.dp,
                        color = Color(0xFF3345b3),
                        shape = CircleShape
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color(0xFF3345b3),
                ),
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Aluno",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color(0xFF3345b3)
                ),
                modifier = Modifier.padding(4.dp)
            )

            Spacer(modifier = Modifier.weight(5f))

            Divider(
                color = Color(0xFF3345b3),
                thickness = 2.dp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Text(
                text = "✉ Email: $email",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF3345b3)

                ),
                modifier = Modifier.padding(4.dp)
            )

            Divider(
                color = Color(0xFF3345b3),
                thickness = 2.dp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Text(
                text = "✆ Telemóvel: $phone", color = Color(0xFF3345b3), fontSize = 14.sp,
                modifier = Modifier.padding(4.dp)
            )

            Divider(
                color = Color(0xFF3345b3),
                thickness = 2.dp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )




            Spacer(modifier = Modifier.weight(0.75f))

            Image(
                painter = painterResource(id = R.drawable.transferir),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(40.dp).scale(2.5F),
                contentScale = ContentScale.Crop
            )


        }
    }
}

@Composable
fun BusinessCallingCardExample(navController: NavController) {
    BusinessCallingCard(
        navController=navController,
        email = "fc56269@alunos.fc.ul.pt",
        phone = "916230428",
        name = "Frederico Prazeres",
        backgroundColor = Color.White
    )
}
