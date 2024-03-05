package com.tcreatesllc.uidemo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tcreatesllc.uidemo5.ui.theme.UiDemo5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiDemo5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Composable
fun cardedImage(){
    val rainbowColorsBrush = remember {
        Brush.verticalGradient(
            listOf(
                Color(0xFFF50A5C),
                Color(0xFFFFFFFF),
            )
        )
    }
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.cat_avif),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .border(
                BorderStroke(borderWidth, rainbowColorsBrush),
                RoundedCornerShape(16.dp)
            )
            .padding(borderWidth)
            .clip(RoundedCornerShape(12.dp))
    )
}


@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    UiDemo5Theme {
        cardedImage()
    }
}