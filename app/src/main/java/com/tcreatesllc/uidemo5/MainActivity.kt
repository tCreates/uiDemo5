package com.tcreatesllc.uidemo5

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
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
import androidx.core.view.WindowCompat
import com.tcreatesllc.uidemo5.ui.theme.UiDemo5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        //Hide the status bars

        WindowCompat.setDecorFitsSystemWindows(window, true)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        } else {
            window.insetsController?.apply {
                hide(WindowInsets.Type.systemBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        setContent {
            UiDemo5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainLayout()

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
fun cardedImage(mods: Modifier) {
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
        modifier = mods
            .fillMaxWidth()
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
        modifier = mods.size(40.dp),
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
            .size(40.dp)
    ) {
        drawRoundRect(
            color = Color.LightGray,
            size = Size(width = size.width, height = size.height),
            cornerRadius = CornerRadius(x = 5.dp.toPx(), y = 5.dp.toPx())
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
            color = Color.Gray,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 4f,
            cap = StrokeCap.Square,
        )
    }
}


@Composable
fun fabBox(mods: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = mods.size(170.dp)) {
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
        modifier = Modifier.height(300.dp)
    ) {
        items(2) { index ->
            Row(
                modifier = Modifier.padding(
                    top = 20.dp,
                    bottom = 20.dp,
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
fun lineColumn(mods: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = mods
    ) {
        boxyColumn()
        verticalLine()
        boxyColumn()
    }
}


@Composable
fun timeText(mods: Modifier) {
    Text(
        text = "01\n\n\n\n\n\n34",
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 160.sp,
        modifier = mods.padding(start = 30.dp),
        color = Color(0xFF1e2a36)
    )
}

@Composable
fun rotatedText(mods: Modifier) {
    Column(
        modifier = mods
            .rotate(90f)
            .height(300.dp)
            .width(250.dp)
            .padding(top = 80.dp)
    ) {
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
            text = "It seems to be haze outside at Visakhapatnam. Temperature is 80°F",
            fontFamily = openSans,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
        )
    }
}

@Composable
fun mainLayout() {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Blue),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.LightGray)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, bottom = 70.dp)
                ) {
                    timeText(Modifier.align(Alignment.TopStart))
                    rotatedText(Modifier.align(Alignment.BottomStart))
                }
            }


            Column(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color(0xFF1e2a36))
                    .padding(top = 20.dp, bottom = 20.dp, end = 10.dp, start = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    cardedImage(Modifier.align(Alignment.TopCenter))
                    lineColumn(
                        Modifier
                            .align(Alignment.Center)
                            .padding(top = 120.dp, bottom = 190.dp)
                    )
                    fabBox(Modifier.align(Alignment.BottomCenter))
                }
            }

        }
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
        //rotatedText()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            mainLayout()
        }

    }
}