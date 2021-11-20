package com.bcoding.travelappui.ui.screem

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcoding.travelappui.Buddie
import com.bcoding.travelappui.Country
import com.bcoding.travelappui.R
import com.bcoding.travelappui.ui.theme.*
import androidx.compose.foundation.Image as Image

@ExperimentalFoundationApi
@Composable
fun TravelAppScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            SectionTop()
            SectionGridCountry(
                countries = listOf(
                    Country(1, "Japan", R.drawable.japan),
                    Country(1, "Barcelona", R.drawable.barcelona),
                    Country(1, "Greece", R.drawable.greece),
                    Country(1, "Rome", R.drawable.rome),
                )
            )
            SectionTravelBuddies(
                listOf(
                    Buddie(1, "Ashok", 28, "Friend", person1, R.drawable.person1),
                    Buddie(2, "Jack", 20, "Friend", person2, R.drawable.person2),
                    Buddie(3, "Lorena", 28, "Friend", person3, R.drawable.person1),
                    Buddie(4, "Bolivar", 29, "Friend", person4, R.drawable.person2),
                    Buddie(5, "Joseph", 30, "Friend", person5, R.drawable.person1),
                )
            )
        }
    }
}

@Composable
fun SectionTop(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            .fillMaxHeight(fraction = 0.36f)
            .background(bluePrimary)
    ) {
        Column {

            Row() {
                Box {
                    Image(
                        painter = painterResource(R.drawable.ic_hand),
                        contentDescription = "hand",
                        alignment = Alignment.TopStart,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = ParagraphStyle(lineHeight = 40.sp)) {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 40.sp,
                                    )
                                ) {
                                    append("Welcome, \n")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = textYellow,
                                        fontSize = 35.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                ) {
                                    append("Bolivar")
                                }
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 20.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_notification),
                        contentDescription = "Notification",
                        tint = Color.White,
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_menu),
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            }
            SearchInput()
        }

    }
}

@Composable
fun SearchInput() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = grayColor
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .border(width = 1.dp, grayColor, shape = RoundedCornerShape(15.dp)),
            shape = RoundedCornerShape(15.dp),
            placeholder = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.body1.copy(color = grayColor)
                )
            }
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun SectionGridCountry(
    countries: List<Country>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Saved Places",
            color = textGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(countries.size) {
                CountryItem(country = countries[it])
            }
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Box(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(id = country.image),
            contentDescription = country.title
        )
        Text(
            text = country.title,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.CenterStart),
        )
    }
}

@Composable
fun SectionTravelBuddies(buddies: List<Buddie>) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Travel Buddies",
            color = textGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Row {
            AddTravelBuddies()
            Spacer(modifier = Modifier.padding(end = 10.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                items(buddies) { buddie ->
                    TravelBuddiesItems(buddie = buddie)
                }
            }
        }
    }
}

@Composable
fun TravelBuddiesItems(buddie: Buddie) {
    Box(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .width(140.dp)
                .height(215.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 11.6.dp,
                        topEnd = 100.dp,
                        bottomStart = 11.6.dp,
                        bottomEnd = 11.6.dp
                    )
                )
                .background(buddie.color)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Name",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )
                Text(
                    text = buddie.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(
                    text = "Age",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )
                Text(
                    text = buddie.age.toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(
                    text = "Status",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )
                Text(
                    text = buddie.status,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }
        }
        Image(
            painter = painterResource(id = buddie.image),
            contentDescription = "Person 1",
            alignment = Alignment.CenterEnd,
            modifier = Modifier
                .width(162.dp)
                .height(215.dp)
        )
    }
}

@Composable
fun AddTravelBuddies() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(Color.White)
            .border(width = 2.dp, color = grayColor, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add_gray),
            contentDescription = "Add buddies",
            tint = grayColor,
            modifier = Modifier.size(30.dp)
        )
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun TravelAppScreenPreview() {
    TravelAppScreen()
}