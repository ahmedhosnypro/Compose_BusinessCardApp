package com.businesscardapp

import android.graphics.Insets
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.businesscardapp.ui.theme.BusinessCardAppTheme

val galanoGrotesqueFontFamily = FontFamily(
    Font(R.font.galano_grotesque_thin, FontWeight.Thin),
    Font(R.font.galano_grotesque_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.galano_grotesque_light, FontWeight.Light),
    Font(R.font.galano_grotesque_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.galano_grotesque, FontWeight.Normal),
    Font(R.font.galano_grotesque_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.galano_grotesque_medium, FontWeight.Medium),
    Font(R.font.galano_grotesque_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.galano_grotesque_semi_bold, FontWeight.Bold),
    Font(R.font.galano_grotesque_semi_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.galano_grotesque_bold, FontWeight.Bold),
    Font(R.font.galano_grotesque_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.galano_grotesque_black, FontWeight.Black),
    Font(R.font.galano_grotesque_black_italic, FontWeight.Black, FontStyle.Italic),
)

val backgroundColor = Color(0xFFD2E8D4)
val transparentBlack = Color(0xd9000000)
val darkGreen = Color(0xFF006D3B)
val darkBlue = Color(0xFF073042)
val lightGreen = Color(0xFF30DC80)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidLogo()
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            Modifier.fillMaxHeight(0.7f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AndroidLogo()
            AboutMe(name = "Ahmed Hosny", aboutMe = "Android Developer Extraordinaire")
        }
        ContactList()
    }
}

@Composable
fun AndroidLogo() {
    Column(
        modifier = Modifier
            .background(darkBlue)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.android),
            contentDescription = stringResource(R.string.android_logo),
            tint = Color(0xFF30DC80)
        )
        Text(
            text = stringResource(R.string.android),
            fontFamily = galanoGrotesqueFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 21.sp,
            color = Color.White
        )
    }
}

@Composable
fun AboutMe(
    name: String,
    aboutMe: String
) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = name,
            fontFamily = FontFamily.SansSerif,
            color = transparentBlack,
            fontSize = 48.sp,
            fontWeight = FontWeight.Light,
        )

        Text(
            text = aboutMe,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = darkGreen,
        )
    }
}

@Composable
fun ContactList() {
    Column(
        Modifier
            .wrapContentWidth(),
        verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top)
    ) {
        ContactItem(
            icon = painterResource(id = R.drawable.phone),
            iconDescription = stringResource(R.string.phone_number),
            info = stringResource(R.string.fake_phone_number),
        )
        ContactItem(
            icon = painterResource(id = R.drawable.social),
            iconDescription = stringResource(R.string.social),
            info = stringResource(R.string.ahmedhosnydev),
        )
        ContactItem(
            icon = painterResource(id = R.drawable.mail),
            iconDescription = stringResource(R.string.mail),
            info = stringResource(R.string.ahmedhosnydev_gmail_com),
        )
    }
}

@Composable
fun ContactItem(
    icon: Painter,
    iconDescription: String,
    info: String,
    iconColor: Color = darkGreen,
    textColor: Color = transparentBlack,
) {
    Row(
        Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = iconDescription,
            tint = iconColor,
        )

        Text(
            info,
            color = textColor
        )
    }
}