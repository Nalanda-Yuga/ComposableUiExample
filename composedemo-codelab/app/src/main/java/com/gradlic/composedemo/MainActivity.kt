package com.gradlic.composedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.gradlic.composedemo.ui.ComposeDemoTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                Column{
                    Greeting("ANDROID")
                    Divider(color = Color.Black)
                    MyScreenContent()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    ComposeDemoTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp),
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.surface
    )
}

@Composable
fun MyScreenContent(){
    val counterState = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()){
        Column(modifier = Modifier.weight(1f)){
            Greeting("Android")
            Divider(color = Color.Black)
            Greeting(name = "there")
            Divider(color = Color.Black)
            //Divider(color = Color.Transparent, thickness = 32.dp)
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit){
    //val count = remember { mutableStateOf(0) }

    Button(
        onClick = { updateCount(count+1) },
        backgroundColor = if (count>5) Color.Green else Color.White
        ) {
        Text("I have been clicked $count times")
    }
}

@Preview(showBackground = true, name = "TextViewPreview")
@Composable
fun DefaultPreview() {
    MyApp{
        Column{
            Greeting(name = "ANDROID")
            Divider(color = Color.Black)
            MyScreenContent()
        }
    }
}

