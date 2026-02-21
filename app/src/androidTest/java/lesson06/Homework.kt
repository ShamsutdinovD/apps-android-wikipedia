package lesson06

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val textSettings = KTextView {
    withId(R.id.textSettingsCategory)
}

val textSize = KTextView {
    withId(R.id.text_size_percent)
}

val buttonDecreaseText = KButton {
    withId(R.id.buttonDecreaseTextSize)
}

val buttonIncreaseText = KButton {
    withId(R.id.buttonIncreaseTextSize)
}

val sizeSeekBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
}

val buttonSansSerif = KButton {
    withId(R.id.button_font_family_sans_serif)
}

val buttonSerif = KButton {
    withId(R.id.button_font_family_serif)
}

val compateImage = KImageView {
    withParent {
        R.id.readingFocusModeContainer
    }
    isInstanceOf(AppCompatImageView::class.java)
}

val modeSwitch = KCheckBox {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
}

val focusModeDescription = KTextView {
    withId(R.id.theme_chooser_reading_focus_mode_description)
}

val textTheme = KTextView{
    containsText("Theme")
}

val lightThemeButton = KTextView {
    withId(R.id.button_theme_light)
}

val sepiaThemeButton = KTextView {
    withId(R.id.button_theme_sepia)
}

val darkThemeButton = KTextView {
    withId(R.id.button_theme_dark)
}

val blackThemeButton = KTextView {
    withId(R.id.button_theme_black)
}

val matchSystemThemeSwitch = KCheckBox {
    withId(R.id.theme_chooser_match_system_theme_switch)
}

val imageDimmingSwitch = KCheckBox {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}