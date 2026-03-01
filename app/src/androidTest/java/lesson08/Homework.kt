package lesson08

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.textview.MaterialTextView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen: KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val items = KRecyclerView (
        builder = {withId(R.id.feed_view)},
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::CustomizeItem)
            itemType(::DayItem)
            itemType(::TopReadItem)
            itemType(::NewsItem)
        }
    )

}

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val icon = KImageView (matcher) {
        withIndex(0){
            isInstanceOf(AppCompatImageView::class.java)
        }
    }

    val text = KTextView (matcher) {
        withText("Search Wikipedia")
    }

    val voiceIcon = KImageView (matcher) {
        withId(R.id.voice_search_button)
    }
}

class CustomizeItem(matcher: Matcher<View>): KRecyclerItem<CustomizeItem>(matcher) {

    val image = KImageView (matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val text = KTextView (matcher) {
        withId(R.id.view_announcement_text)
    }

    val customizwButton = KButton (matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val button = KButton (matcher) {
        withId(R.id.view_announcement_action_negative)
    }

}

class DayItem(matcher: Matcher<View>): KRecyclerItem<DayItem>(matcher) {

    val text = KTextView (matcher) {
        withId(R.id.day_header_text)
        isInstanceOf(MaterialTextView::class.java)
    }

}

class TopReadItem (matcher: Matcher<View>): KRecyclerItem<TopReadItem>(matcher) {

    val headerMenu = KImageView (matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val headerTitle = KTextView (matcher) {
        withId(R.id.view_card_header_title)
    }

    val moreLink = KTextView (matcher) {
        withId(R.id.footerActionButton)
    }

    val items = KRecyclerView (
        parent = matcher,
        builder = {withId(R.id.view_list_card_list)},
        itemTypeBuilder = {
            itemType(::TopReadRecycler)
        }
    )

}

class TopReadRecycler (matcher: Matcher<View>): KRecyclerItem<TopReadRecycler>(matcher) {

    val number = KTextView (matcher) {
        withId(R.id.numberView)
    }

    val header = KTextView (matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val subtitle = KTextView (matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val graph = KView (matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val pageviews = KView (matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }

    val image = KImageView (matcher) {
        withId(R.id.view_list_card_item_image)
    }

}

class NewsItem(matcher: Matcher<View>): KRecyclerItem<NewsItem>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
        isInstanceOf(MaterialTextView::class.java)
    }

    val icon = KImageView (matcher) {
        withId(R.id.view_list_card_header_menu)
        isInstanceOf(AppCompatImageView::class.java)
        isDisplayed()
    }

    val items = KRecyclerView (
        parent = matcher,
        builder = {withId(R.id.view_list_card_list)},
        itemTypeBuilder = {
            itemType(::NewsRecycler)
        }
    )

}

class NewsRecycler(matcher: Matcher<View>): KRecyclerItem<NewsRecycler>(matcher) {

    val text = KTextView (matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }

    val image = KImageView (matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }

}