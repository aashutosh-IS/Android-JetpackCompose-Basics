package com.infoshapers.profile_card

data class UserProfileDataClass constructor(
    val name: String,
    val status: Boolean,
    val drawableId: Int
)

val UserProfileList= arrayListOf(
    UserProfileDataClass("Jhon Doe",true,R.drawable.aashutosh),
    UserProfileDataClass("Jhon Green",false,R.drawable.ic_launcher_background),
)