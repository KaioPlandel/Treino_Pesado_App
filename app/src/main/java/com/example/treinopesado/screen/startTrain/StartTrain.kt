package com.example.treinopesado.screen.startTrain

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.treinopesado.colors.AppColor.backgroundButton
import com.example.treinopesado.colors.AppColor.backgroundTrain
import com.example.treinopesado.model.Exercise
import com.example.treinopesado.model.Train
import com.example.treinopesado.screen.home.HomeViewModel
import java.util.UUID

@Composable
fun StartTrain(id: String?, navController: NavController, viewModel: HomeViewModel) {
    val idString = UUID.fromString(id)
    val train = viewModel.getTrainById(idString)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 3.dp)
            .background(backgroundTrain),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "backIcon",
                tint = Color.White,
                modifier = Modifier
                    .size(35.dp)
                    .padding(start = 3.dp, top = 2.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
        Text(
            text = train.title,
            fontFamily = FontFamily.Monospace,
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        ContainerTrain(train = train)
    }
}

@Composable
fun ContainerTrain(train: Train, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(600.dp)
            .padding(20.dp),
        tonalElevation = 5.dp,
        shadowElevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    modifier.clickable { }
                )
            }
            LazyColumn(modifier = Modifier.padding(15.dp)) {
                items(train.exercises) {
                    CardTrain(it)
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTrain(exercie: Exercise, modifier: Modifier = Modifier) {
    val isChecked = remember { mutableStateOf(false) }
    var peso = remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${exercie.name} ${exercie.session} x ${exercie.peso}",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Checkbox(checked = isChecked.value, onCheckedChange = {
                    isChecked.value = it
                })
            }
            if (isChecked.value) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "${exercie.name}")
                        TextField(
                            value = peso.value,
                            onValueChange = { peso.value = it },
                            singleLine = true,
                            label = { Text(text = "Peso")},
                            modifier = Modifier
                                .height(65.dp)
                                .width(80.dp)
                                .padding(6.dp)
                        )
                        Checkbox(checked = isChecked.value, onCheckedChange = {
                            isChecked.value = it
                        })
                    }
                }
            }
        }
    }
    Divider(modifier = Modifier.padding(2.dp))
}

