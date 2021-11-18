package com.bcoding.travelappui.ui.screem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.bcoding.travelappui.Country
import com.bcoding.travelappui.R
import com.bcoding.travelappui.ui.theme.bluePrimary
import com.bcoding.travelappui.ui.theme.grayColor
import com.bcoding.travelappui.ui.theme.textGray
import com.bcoding.travelappui.ui.theme.textYellow
import androidx.compose.foundation.Image as Image

@Composable
fun TravelAppScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            SectionTop()
            SectionGridCountry(countries = listOf())
        }
    }
}

@Composable
fun SectionTop(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            .fillMaxWidth()
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
                                        fontWeight = FontWeight.Bold
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

@Composable
fun SectionGridCountry(
    countries: List<Country>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Text(
            text = "Saved Places",
            color = textGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun CountryItem() {
    Box(modifier = Modifier.background(Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.japan),
            contentDescription = "prueba"
        )
        Text(text = "JAPAN", color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun SectionTravelBuddies() {
}

@Preview
@Composable
fun TravelAppScreenPreview() {
    TravelAppScreen()
}