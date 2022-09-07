package com.infoshapers.dynamicconceptscomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.infoshapers.dynamicconceptscomposable.ui.theme.DynamicConceptsComposableTheme

val namesList: ArrayList<String> = arrayListOf("Jhon", "Enchant", "Invoker", "Danna")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingList(names = namesList)
        }
    }
}

@Composable
fun GreetingList(names: List<String>) {
    val changeStateList = remember {
        mutableStateListOf<String>("A", "B")
    }
    val textFieldState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RenderList(changeStateList, {
            changeStateList.add(textFieldState.value)
        }, textFieldState.value, { it ->
            textFieldState.value = it
        })
    }

}

@Composable
fun RenderList(
    nameList: List<String>,
    onButtonCLick: () -> Unit,
    textFieldValue: String,
    onValueChangedTextField: (v: String) -> Unit
) {
    for (name in nameList) {
        Greeting(name = name) // Dynamic Concept , function is not aware about how many elemets
    }
//    val textFieldState = remember { // this is in line set state , now compose concept refers to manage state from single place only
//        mutableStateOf("")
//    }
//    TextField(value = textFieldValue, onValueChange = { it ->
//        textFieldState.value = it
//    })
    TextField(value = textFieldValue, onValueChange = onValueChangedTextField)
    Button(onClick = onButtonCLick) {
        Text(text = "Add New Element ")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.h4)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DynamicConceptsComposableTheme {
        GreetingList(names = namesList)

    }
}