package com.example.instagramuiclone

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// houses the total profile screen ! more of the scaffold
@Composable
fun ProfileScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        // Top bar section
        TopBarSection(name = "iamifeanyichukwu")
    }
}


/* implementing the top bar section
    contains the back button, profile name, notification button and the more button
 */
@Composable
fun TopBarSection(
    name: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        // the back button
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        ) // end back button
        
        // the user's name
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis
        ) // end user's name
        
        // the notification button
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notification",
            modifier = Modifier.size(24.dp)
        ) // ends notification
        
        // start menu more 
        Icon(
            painter = painterResource(id = R.drawable.ic_down_menu),
            contentDescription = "More",
            modifier = Modifier.size(20.dp)
        )
    }
}



@Composable
@Preview(showBackground = true)
fun SecondPreview(){
    ProfileScreen()
}