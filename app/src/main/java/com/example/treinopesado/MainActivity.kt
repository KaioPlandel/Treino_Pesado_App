package com.example.treinopesado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.treinopesado.screen.home.HomeScreen
import com.example.treinopesado.ui.theme.TreinoPesadoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreinoPesadoTheme {
                Scaffold(bottomBar = {
                    Card(
                        modifier = Modifier
                            .height(58.dp),
                        shape = RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp),
                        colors = CardDefaults.cardColors(Color.Black),
                        elevation = CardDefaults.cardElevation(5.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home",
                                tint = Color.Cyan
                            )
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Home",
                                tint = Color.Cyan
                            )
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Home",
                                tint = Color.Cyan
                            )
                        }
                    }
                }) {
                    it.calculateBottomPadding()
                    HomeScreen()
                }
            }
        }
    }
}
