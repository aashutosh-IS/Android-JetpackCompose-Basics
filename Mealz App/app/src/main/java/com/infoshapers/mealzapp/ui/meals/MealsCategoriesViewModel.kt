package com.infoshapers.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.infoshapers.model.MealsRepository
import com.infoshapers.model.response.MealResponse
import com.infoshapers.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    suspend  fun getMeals():List<MealResponse> {
        return repository.getMeals().categories
    }
}