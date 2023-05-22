package com.example.treinopesado.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.treinopesado.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(27, 27, 27))
            .padding(25.dp)
    ) {
        TopBar(image = painterResource(id = R.drawable.img))
        Spacer(modifier = Modifier.padding(12.dp))
        CenterMenu("Kaio Plandel")
        Spacer(modifier = Modifier.padding(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Progresso",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.padding(6.dp))
        ProgressSession()
    }
}

@Composable
fun TopBar(image: Painter, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            Modifier.size(35.dp),
            tint = Color.White
        )
        Image(
            painter = image, contentDescription = "profile", modifier = Modifier
                .size(40.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                ),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProgressSession(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.Transparent
                        ), endY = 900f
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.progress),
                contentDescription = "progress",
                modifier = Modifier.align(Center)
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Center),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Peso atual: 83.5kg", color = Color.White)
                    Text(text = "-4kg", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Cintura: 81.2kg", color = Color.White)
                    Text(text = "-2kg", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Biceps: 41.5kg", color = Color.White)
                    Text(text = "+1", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CenterMenu(name: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "Olá, $name", fontSize = 16.sp, color = Color.Cyan)
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "Bem vindo de volta!",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(25.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.alter),
                contentDescription = null,
                modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent
                            ), endY = 800f
                        )
                    )
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "Proximo Treino",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "Peito e Triceps",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Cyan
                )
                Text(
                    text = "Treino com metodo de oclusão",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Cyan
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Black
                    ),
                    elevation = ButtonDefaults.buttonElevation(8.dp)
                ) {
                    Text(text = "Iniciar Treino", color = Color.White)
                }
            }
        }
    }
}
