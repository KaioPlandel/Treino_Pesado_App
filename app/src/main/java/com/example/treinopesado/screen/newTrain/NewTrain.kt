package com.example.treinopesado.screen.newTrain

import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.treinopesado.colors.AppColor
import com.example.treinopesado.model.Exercise
import com.example.treinopesado.model.Train
import com.example.treinopesado.screen.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTrain(navController: NavController, viewModel: HomeViewModel) {

    val nameTrain = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.backgroundTrain)
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Informações do treino",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            value = nameTrain.value, onValueChange = { nameTrain.value = it },
            singleLine = true,
            label = { Text(text = "Nome") },
            keyboardActions = KeyboardActions(onDone = {
                nameTrain.value = ""
            }),
            maxLines = 1,
            textStyle = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp)),
            colors = TextFieldDefaults.textFieldColors(containerColor = AppColor.backgroundButton)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        CardAddExericise(viewModel, nameTrain.value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardAddExericise(viewModel: HomeViewModel, nameTrain: String, modifier: Modifier = Modifier) {

    val nameExercise = remember {
        mutableStateOf("")
    }
    val serie = remember {
        mutableStateOf("0")
    }

    val repetition = remember {
        mutableStateOf("0")
    }

    val exercises = remember {
        mutableStateListOf<Exercise>()
    }
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Cyan,
                            Color.Black,
                            Color.Transparent
                        ), endY = 800f
                    )
                )
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Adicionar exercicio",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.padding(5.dp))
                TextField(
                    value = nameExercise.value, onValueChange = { nameExercise.value = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardOptions.Default.capitalization),
                    label = { Text(text = "Nome do execicio") },
                    keyboardActions = KeyboardActions(onDone = {
                        nameExercise.value = ""
                    }),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.textFieldColors(containerColor = AppColor.backgroundButton)
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextFieldCustomWithButtons(serie)
                    TextFieldCustomWithButtons(repetition)
                }
                Spacer(modifier = Modifier.padding(8.dp))
                ButtonAddExercise(nameExercise, serie, repetition, exercises)
                Spacer(modifier = Modifier.padding(8.dp))
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(exercises) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = it.name, color = Color.White)
                            Text(text = "${it.session} x ${it.repetition}", color = Color.White)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(6.dp))
        if (exercises.isNotEmpty()) {
            Button(
                onClick = {
                    val train = Train(title = nameTrain, description = "", exercises = exercises)
                    viewModel.addNewTrain(train)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            ) {
                Text(
                    text = "SALVAR TREINO",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun ButtonAddExercise(
    nameExercise: MutableState<String>,
    serie: MutableState<String>,
    repetition: MutableState<String>,
    exercises: SnapshotStateList<Exercise>
) {
    Button(
        onClick = {
            val lExercise = Exercise(
                nameExercise.value,
                0,
                serie.value.toInt(),
                repetition.value.toInt(),
                "",
                0f
            )
            exercises.add(lExercise)
            serie.value = "0"
            repetition.value = "0"
            nameExercise.value = ""

        }, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp)
    ) {
        Text(text = "ADICIONAR EXERCÍCIO")
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TextFieldCustomWithButtons(serie: MutableState<String>) {
    Row {
        TextField(
            value = serie.value, onValueChange = { serie.value = it },
            singleLine = true,
            enabled = false,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "serie") },
            textStyle = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .width(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(containerColor = AppColor.backgroundButton)
        )

        ButtonMoreOrLess(clickMore = {
            serie.value = (serie.value.toInt() + 1).toString()
        }, clickLess = {
            val number = (serie.value.toInt() - 1)
            serie.value = if (number < 0) "0" else number.toString()
        })

    }
}

@Composable
fun ButtonMoreOrLess(
    modifier: Modifier = Modifier,
    clickMore: () -> Unit,
    clickLess: () -> Unit
) {
    Column(
        modifier = modifier.padding(start = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black)
                .clickable { clickMore() }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "null",
                tint = Color.White,
                modifier = Modifier.padding(2.dp)
            )
        }
        Spacer(modifier = Modifier.padding(3.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black)
                .clickable { clickLess() }
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "null",
                tint = Color.White,
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}