package com.kartik.ridepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kartik.ridepal.ui.theme.RidePalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RidePalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RidePal()
                }
            }
        }
    }
}

@Composable
fun RidePal() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = R.drawable.ridepal_app_bar),
            contentDescription = "app bar",
            modifier = Modifier
                .align(Alignment.TopCenter)
        )
    }
    Column {
        ProfileElement()
    }
}

@Composable
fun ProfileElement() {
    var total by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row{
            Text(text = "Counter: $total")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { total += 10 }) {
                Text(text = "+10")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { total += 50 }) {
                Text(text = "+50")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { total -= 50 }) {
                Text(text = "-50")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { total = 0 }) {
                Text(text = "reset")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RidePalPreview() {
    RidePalTheme {
        RidePal()
    }
}