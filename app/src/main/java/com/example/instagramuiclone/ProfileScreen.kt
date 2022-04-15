package com.example.instagramuiclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
        // profile section
        ProfileSection()
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

// Profile section
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.fillMaxWidth()) {
        /* Row that houses the profile image and the followers, following
            and total number of posts
         */
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(image = painterResource(id = R.drawable.ifeanyi), modifier = Modifier
                .size(100.dp)
                .weight(3f)) // image

            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        } // row end
    } // column end
}


// circular image
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )
}


// stat section
@Composable
fun StatSection(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStats(numberText = "601", text = "Posts")
        ProfileStats(numberText = "10M", text = "Followers")
        ProfileStats(numberText = "1", text = "Following")
    }
}



// profile stat
@Composable
fun ProfileStats(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, )
    }
}



@Composable
@Preview(showBackground = true)
fun SecondPreview(){
    ProfileScreen()
}