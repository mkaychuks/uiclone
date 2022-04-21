package com.example.instagramuiclone

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// houses the total profile screen ! more of the scaffold
@ExperimentalFoundationApi
@Composable
fun ProfileScreen(){
    var selectedTabIndex by remember { mutableStateOf(0)}
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        // Top bar section
        TopBarSection(name = "iamifeanyichukwu")
        // profile section
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighLightSection(highlights = listOf(
            ImageWithText(image = painterResource(id = R.drawable.ifeanyi), "Youtube"),
            ImageWithText(image = painterResource(id = R.drawable.ic_bell), "Discord"),
            ImageWithText(image = painterResource(id = R.drawable.ifeanyi), "Amazon"),
            ImageWithText(image = painterResource(id = R.drawable.ic_bell), "Facebook"),
            ImageWithText(image = painterResource(id = R.drawable.ifeanyi), "Twitter"),
            ImageWithText(image = painterResource(id = R.drawable.ic_bell), "Netflix"),
            ImageWithText(image = painterResource(id = R.drawable.ifeanyi), "Ebay"),
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(image = painterResource(id = R.drawable.ic_grid), text = "Posts"),
                ImageWithText(image = painterResource(id = R.drawable.ic_bell), text = "Reels"),
                ImageWithText(image = painterResource(id = R.drawable.ic_tv), text = "igtv"),
                ImageWithText(image = painterResource(id = R.drawable.ic_second), text = "profile")
            ),
        ){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.ifeanyi),
                    painterResource(id = R.drawable.ifeanyi),
                    painterResource(id = R.drawable.ifeanyi),
                    painterResource(id = R.drawable.ifeanyi),
                    painterResource(id = R.drawable.ifeanyi),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
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

        ProfileDescription(
            displayName = "Achufusi Ifeanyi",
            description = "1 coding experience\n" +
                    "Want me to make your app? send me a DM\n" +
                    "Check out my github repo for more...",
            url = "https://github.com/mkaychuks",
            followedBy = listOf("plcoding", "codinginflow", "wizkid", "SamsonGoddy"),
            otherCount = 21
        )
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
        Text(text = text)
    }
}

// profile description
@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xff3d3d91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if(followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")

                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(index < followedBy.size - 1){
                            append(", ")
                        }
                    }
                    if (otherCount > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

// Button section
@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
){
    val minWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}


// action button
@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if(text != null){
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}


//  highlights section
@Composable
fun HighLightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
){
    LazyRow(
        modifier = modifier
    ){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.padding(end = 10.dp)
            ) {
                RoundImage(image = highlights[it].image, modifier = Modifier.size(70.dp))
                Text(text = highlights[it].text, overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center)
            }
        }
    }
}

// tab layout in compose
@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xff777777)
    
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {

        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}


// post section
@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ){
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        1.dp,
                        color = Color.White
                    )
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
@Preview(showBackground = true)
fun SecondPreview(){
    ProfileScreen()
}