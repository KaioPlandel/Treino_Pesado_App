package com.example.treinopesado.screen.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.treinopesado.R
import com.example.treinopesado.colors.AppColor.backgroundButton
import com.example.treinopesado.colors.AppColor.backgroundTrain
import com.example.treinopesado.model.Train
import com.example.treinopesado.navigation.Screen

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundTrain)
            .padding(25.dp)
    ) {
        TopBar("Kaio Plandel", image = painterResource(id = R.drawable.img))
        Spacer(modifier = Modifier.padding(12.dp))
        CenterMenu(navController, viewModel)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp), color = Color.Black
        )
        ProgressSession()
    }
}

@Composable
fun TopBar(name: String, image: Painter, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Text(text = "Olá, $name", fontSize = 14.sp, color = Color.Cyan)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Bem vindo de volta!",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Image(
            painter = image, contentDescription = "profile", modifier = Modifier
                .size(40.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                ), contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProgressSession(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Progresso", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold
        )
        CustomButton(Icons.Default.Edit) {}
    }
    Spacer(modifier = Modifier.padding(6.dp))
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black, Color.Transparent
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
fun CenterMenu(
    navController: NavController,
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    val listOfTrains = viewModel.trainList.collectAsState().value
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Meus Treinos",
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        CustomButton(Icons.Default.Add) {
            navController.navigate(Screen.NewTrainScreen.route)
        }
    }
    Spacer(modifier = Modifier.padding(3.dp))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.End
    ) {
        items(listOfTrains) {
            CardTrain(navController, it)
        }
    }
}

@Composable
private fun CardTrain(navController: NavController, train: Train, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(290.dp)
            .height(170.dp)
            .padding(end = 8.dp)
            .clip(RoundedCornerShape(20.dp)),
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
                .fillMaxHeight()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black, Color.Transparent,
                            Color.White,
                            Color.Black,
                            Color.Transparent
                        ), endX = 1400f
                    )
                )
                .padding(horizontal = 15.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.padding(6.dp))
            Text(
                text = train.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Cyan
            )
            Text(
                text = train.description,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Cyan
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.StartTrainScreen.withArgrs(train.id.toString()))
                },
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

@Composable
fun CustomButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundButton)
            .padding(3.dp)
            .clickable {
                onButtonClick()
            }
    ) {
        Row {
            Icon(imageVector = icon, contentDescription = "icon")
        }
    }
}

