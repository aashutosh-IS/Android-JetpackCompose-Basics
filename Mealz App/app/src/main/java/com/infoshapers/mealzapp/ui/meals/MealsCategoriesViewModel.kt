package com.infoshapers.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.infoshapers.model.MealsRepository
import com.infoshapers.model.response.MealResponse
import com.infoshapers.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals {
            successCallback(it)
        }

    }
}