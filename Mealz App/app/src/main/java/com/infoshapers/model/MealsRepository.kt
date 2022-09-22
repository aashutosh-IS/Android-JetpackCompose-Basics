package com.infoshapers.model

import com.infoshapers.model.api.MealsWebService
import com.infoshapers.model.response.MealResponse
import com.infoshapers.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {

        //return  webService.getMeals().execute().body()
        //execute will bloc the thread and execute in main thread and will crash since it wont allow to run on main thread

        return webService.getMeals().enqueue(object : Callback<MealsCategoriesResponse> {
            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>,
            ) {
                if(response.isSuccessful){
                    successCallback(response.body())
                }

            }
            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                TODO("Do it later")
            }
        })
    }
}