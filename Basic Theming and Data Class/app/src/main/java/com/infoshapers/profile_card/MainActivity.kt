package com.infoshapers.profile_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infoshapers.profile_card.ui.theme.MyTheme
import com.infoshapers.profile_card.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme() {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(userProfileList: List<UserProfileDataClass> = UserProfileList) {
    Scaffold(topBar = {
        AppBar()
    }) {
        androidx.compose.material.Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column {
                for (user in userProfileList) {
                    ProfileCard(user)

                }
            }

        }
    }

}

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Home, contentDescription = "asd",
                Modifier.padding(horizontal = 8.dp)
            )
        },
        title = {
            Text(text = "Messaging Users")
        },
    )

}

@Composable
fun ProfileCard(userProfileDataClass: UserProfileDataClass) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top), elevation = 8.dp,
        backgroundColor = Color.White

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfileDataClass.drawableId, userProfileDataClass.status)
            ProfileContent(userProfileDataClass.name, userProfileDataClass.status)

        }
    }
}

@Composable
fun ProfilePicture(drawableId: Int, status: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (status)
                MaterialTheme.colors.lightGreen
            else
                Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = "Content Description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop,
        )
    }

}

@Composable
fun ProfileContent(name: String, status: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(name, style = MaterialTheme.typography.h5)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
            Text(
                text = if (status)
                    "Active now"
                else "Offline",
                style = MaterialTheme.typography.body2
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        MainScreen()

    }
}