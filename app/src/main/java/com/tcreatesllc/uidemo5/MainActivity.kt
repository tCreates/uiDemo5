package com.tcreatesllc.uidemo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

val fontFamily = FontFamily(
    Font(R.font.teko_light, FontWeight.Light),
    Font(R.font.teko_regular, FontWeight.Normal),
    Font(R.font.teko_semibold, FontWeight.Bold)
)

val openSans = FontFamily(
    Font(R.font.opensans_regular, FontWeight.Normal),
    Font(R.font.opensans_semibold, FontWeight.Bold)
)

@Composable
fun cardedImage() {
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

@Composable
fun floatingActionButton(drawableInt: Int, mods: Modifier) {
    FloatingActionButton(
        modifier = mods,
        containerColor = Color.White,
        onClick = { },
        shape = RoundedCornerShape(0)
    ) {
        Icon(
            painterResource(id = drawableInt),
            contentDescription = null
        )
    }
}

@Composable
fun roundRect() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        drawRoundRect(
            color = Color.LightGray,
            size = Size(width = size.width, height = size.height),
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx())
        )
    }
}

@Composable
fun verticalLine() {
    Canvas(
        modifier = Modifier
            .width(10.dp)
            .fillMaxHeight()
            .padding(start = 5.dp, end = 5.dp)

    ) {
        drawLine(
            color = Color.White,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 4f,
            cap = StrokeCap.Square,
        )
    }
}


@Composable
fun fabBox() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(250.dp)) {
        floatingActionButton(
            drawableInt = R.drawable.whatsapp_svgrepo_com, mods = Modifier.align(
                Alignment.TopCenter
            )
        )
        floatingActionButton(
            drawableInt = R.drawable.pinterest_svgrepo_com, mods = Modifier.align(
                Alignment.CenterStart
            )
        )
        floatingActionButton(
            drawableInt = R.drawable.gallery_wide_svgrepo_com, mods = Modifier.align(
                Alignment.Center
            )
        )
        floatingActionButton(
            drawableInt = R.drawable.youtube_svgrepo_com, mods = Modifier.align(
                Alignment.CenterEnd
            )
        )
        floatingActionButton(
            drawableInt = R.drawable.chrome_svgrepo_com__1_, mods = Modifier.align(
                Alignment.BottomStart
            )
        )
        floatingActionButton(
            drawableInt = R.drawable.message_4_svgrepo_com, mods = Modifier.align(
                Alignment.BottomCenter
            )
        )
        floatingActionButton(
            drawableInt = R.drawable.call_192_svgrepo_com, mods = Modifier.align(
                Alignment.BottomEnd
            )
        )
    }
}


@Composable
fun boxyColumn() {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.height(600.dp)
    ) {
        items(2) { index ->
            Row(
                modifier = Modifier.padding(
                    top = 30.dp,
                    bottom = 30.dp,
                    start = 5.dp,
                    end = 5.dp
                )
            ) {
                roundRect()
            }
        }
    }
}


@Composable
fun lineColumn() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
        // modifier = Modifier.width(700.dp)
    ) {
        boxyColumn()
        verticalLine()
        boxyColumn()
    }
}


@Composable
fun timeText() {
    Text(
        text = "01\n\n\n\n34",
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 90.sp
    )
}

@Composable
fun rotatedText() {
    Column(modifier = Modifier
        .rotate(90f)
        .height(260.dp)
        .width(250.dp)
        .padding(top = 40.dp)) {
        Text(
            text = "THURSDAY",
            fontFamily = openSans,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
        )
        Text(
            text = "Today is 19th January",
            fontFamily = openSans,
            fontWeight = FontWeight.Bold,
            fontSize = 13.5.sp,
        )
        Text(
            text = "It seems to be haze outside at\nVisakhapatnam. Temperature is 80°F",
            fontFamily = openSans,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UiDemo5Theme {
        //cardedImage()
        // floatingActionButton(R.drawable.ic_launcher_foreground)
        // roundRect()
        //verticalLine()
        //fabBox()
        //boxyColumn()
        // lineColumn()
        //timeText()
        rotatedText()
    }
}