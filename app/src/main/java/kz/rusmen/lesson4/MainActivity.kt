package kz.rusmen.lesson4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.rusmen.lesson4.ui.theme.Lesson4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lesson4Theme {
                PostsPage()
            }
        }
    }
}

val tahomaFontFamily = FontFamily(
    Font(R.font.tahoma_regular, FontWeight(400)),
    Font(R.font.tahoma_bold, FontWeight(700))
)

@Composable
fun PostsPage(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        items(5) {
            Posts(
                title = "Post Title",
                content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean arcu arcu, tristique in orci sed, volutpat auctor risus. Donec convallis maximus auctor. Etiam id dui at libero porttitor mollis vel eget lacus. Nullam molestie magna at eros pretium, a elementum libero lobortis. Cras eu consectetur mi. Proin iaculis, ex vitae malesuada vehicula, erat sem aliquam leo, ac porttitor mauris turpis eu mi. Suspendisse sed est pretium, malesuada diam et, vehicula ligula. Duis consequat in purus et tincidunt. Donec odio velit, dapibus a elit a, feugiat tempor neque. Donec convallis, tellus eu vestibulum porta, mauris metus imperdiet orci, sit amet viverra leo orci sed purus. Nunc pretium quam ut vehicula pellentesque."
            )
        }
    }
}

@Composable
fun Posts(title: String, content: String, modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Column(
            modifier = modifier
                .height(165.dp)
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontFamily = tahomaFontFamily,
                fontWeight = FontWeight(700),
                fontSize = 18.sp,
                lineHeight = 21.73.sp,
                color = colorResource(R.color.text_01)
            )
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = content,
                fontFamily = tahomaFontFamily,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                lineHeight = 19.31.sp,
                color = colorResource(R.color.text_02)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Lesson4Preview() {
    Lesson4Theme {
        PostsPage()
    }
}