package com.rag.passwordchecker

import android.R.attr.value
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rag.passwordchecker.ui.theme.PasswordCheckerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasswordCheckerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PasswordScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun PasswordScreen(modifier: Modifier){
    var text by remember { mutableStateOf("") }
    var checker = PasswordChecker()
    val strenght = checker.checkStrength(text)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = {text=it},
            label ={ Text("Enter your Password")},
            placeholder = {Text("Enter a Strong Password")},
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone ={
                    println("Password stored ")
                }
            ),
            trailingIcon = {
                IconButton(onClick = {
                    println("icon clicked : $text")
                }) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Submit"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Strenght : $strenght")

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PasswordCheckerTheme {
        Greeting("Android")
    }
}