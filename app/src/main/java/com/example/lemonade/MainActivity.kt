package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFC8E6C9), shape = RoundedCornerShape(24.dp))
                            .padding(30.dp)
                            .clickable {
                                    currentStep = 2
                            }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.pantalla1_2),
                            modifier = Modifier.size(150.dp)
                        )
                    }

                    Text(text = stringResource(R.string.pantalla1_1))
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
            2 ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFC8E6C9), shape = RoundedCornerShape(24.dp))
                            .padding(30.dp)
                            .clickable {
                                val n = Random.nextInt(1, 11)
                                if (n == 3) {
                                    currentStep = 3
                                }
                            }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = stringResource(R.string.pantalla2_2),
                            modifier = Modifier.size(150.dp)
                        )
                    }

                    Text(text = stringResource(R.string.pantalla2_1))
                    Spacer(modifier = Modifier.height(32.dp))


        }
            3 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFC8E6C9), shape = RoundedCornerShape(24.dp))
                            .padding(304.dp)
                            .clickable {
                                    currentStep = 4
                            }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = stringResource(R.string.pantalla3_2),
                            modifier = Modifier.size(150.dp)
                        )
                    }

                    Text(text = stringResource(R.string.pantalla3_1))
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
            4 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFC8E6C9), shape = RoundedCornerShape(24.dp))
                            .padding(30.dp)
                            .padding()
                            .clickable {
                                currentStep = 1
                            }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = stringResource(R.string.pantalla4_2),
                            modifier = Modifier.size(150.dp)
                        )
                    }

                    Text(text = stringResource(R.string.pantalla4_1))
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}