package com.infoshapers.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.infoshapers.mealzapp.ui.theme.MealzAppTheme
import com.infoshapers.model.response.MealResponse

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {

                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel =
        viewModel() //after this instantiated, the vm will get destroyed after the composable is destroyed and wont get instantiated every time composable is rebuild
    val rememberedMeals: MutableState<List<MealResponse>> = remember {
        mutableStateOf(emptyList<MealResponse>())
    }
    viewModel.getMeals {
        val meals = it?.categories
        rememberedMeals.value = meals.orEmpty()
    }
    LazyColumn {
        items(rememberedMeals.value) { meal ->
            Text(text = meal.name)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}