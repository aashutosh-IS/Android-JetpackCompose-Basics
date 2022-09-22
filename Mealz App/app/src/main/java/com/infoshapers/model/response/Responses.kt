package com.infoshapers.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(
     val categories: List<MealResponse>,
    //we have same name as of server so no need to deserialize if diff name need to serialize.
)

data class MealResponse(
    @SerializedName("idCategory")  val id: String,
    @SerializedName("strCategory")  val name: String,
    @SerializedName("strCategoryDescription")  val description: String,
    @SerializedName("strCategoryThumb")  val imageUrl: String,
)

// Gson deserialization : JSON -> Classes