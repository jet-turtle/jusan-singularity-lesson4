package kz.rusmen.lesson4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.rusmen.lesson4.ui.theme.Lesson4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lesson4Theme {
                PostsPageScreen()
            }
        }
    }
}

val tahomaFontFamily = FontFamily(
    Font(R.font.tahoma_regular, FontWeight(400)),
    Font(R.font.tahoma_bold, FontWeight(700))
)

@Composable
fun PostsPageScreen() {
    val viewModel = viewModel(modelClass = PostViewModel::class.java)
    val state by viewModel.state

    PostsPageContent(
        state = state
    )
}

@Composable
fun PostsPageContent(
    state: PostState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        items(state.numbers) {number ->
            Posts(
                title = "${state.title} ${number + 1}",
                content = state.content
            )
        }
    }
}

@Composable
fun Posts(title: String, content: String, modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .heightIn(max = 180.dp)
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
                color = colorResource(R.color.text_02),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
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
        PostsPageScreen()
    }
}