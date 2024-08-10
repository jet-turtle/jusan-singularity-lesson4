package kz.rusmen.lesson4

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class PostState(
    val numbers: Int = 10,
    val title: String = "Post Title",
    val content: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean arcu arcu, tristique in orci sed, volutpat auctor risus. Donec convallis maximus auctor. Etiam id dui at libero porttitor mollis vel eget lacus. Nullam molestie magna at eros pretium, a elementum libero lobortis. Cras eu consectetur mi. Proin iaculis, ex vitae malesuada vehicula, erat sem aliquam leo, ac porttitor mauris turpis eu mi. Suspendisse sed est pretium, malesuada diam et, vehicula ligula. Duis consequat in purus et tincidunt. Donec odio velit, dapibus a elit a, feugiat tempor neque. Donec convallis, tellus eu vestibulum porta, mauris metus imperdiet orci, sit amet viverra leo orci sed purus. Nunc pretium quam ut vehicula pellentesque."
)

class PostViewModel : ViewModel() {
    private val _state = mutableStateOf(PostState())
    val state: State<PostState> = _state
}