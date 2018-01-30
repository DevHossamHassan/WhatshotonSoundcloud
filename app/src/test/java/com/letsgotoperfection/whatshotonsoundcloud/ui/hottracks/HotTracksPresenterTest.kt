package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import RetrofitProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.RxTestRule
import com.letsgotoperfection.whatshotonsoundcloud.models.FollowersResponse
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import kotlin.test.assertTrue


/**
 * @author hossam.
 */
class HotTracksPresenterTest {
    private lateinit var presenter: HotTracksPresenter
    private val hotTracksFragment: HotTracksListContract.View = mock()
    private lateinit var gson: Gson
    private val retrofitProvider = Mockito.mock(RetrofitProvider::class.java)

    @Rule
    @JvmField
    val rule = MockitoJUnit.rule()!!

    @Rule
    @JvmField
    var testSchedulerRule = RxTestRule()

    @Before
    fun setUp() {
        gson = GsonBuilder().create()
        whenever(retrofitProvider.loadFollowers()).thenReturn(Single.just(getMockedFollowerResponse()))
        presenter = HotTracksPresenter(hotTracksFragment)
    }

    @Test
    fun should_Call_HideProgressBar_AfterLoadingData() {
        presenter.onLoadMore()
        verify(hotTracksFragment, times(1)).hideProgressBar()
    }

    @Test
    fun should_Call_ShowProgressBar_BeforeLoadingData() {
        presenter.onLoadMore()
        verify(hotTracksFragment, times(1)).showProgressBar()
    }

    @Test
    fun should_Call_UpdateData_AfterLoadingData() {
        presenter.onLoadMore()
        verify(hotTracksFragment, times(1)).updateDate()
    }

    @Test
    fun should_Return_HotTracks_WhenCalling_GetExistedTracks() {
        assertTrue((presenter.getExistedTracks().size == HotTracksModel.tracks.size))
    }

    @Test
    fun should_Return_TheSameSizeAs_GetExistedTracks() {
        assertTrue((presenter.getExistedTracks().size == presenter.getTracksListSize()))
    }

    fun getMockedFollowerResponse(): FollowersResponse {
        return gson.fromJson(getJsonString(), FollowersResponse::class.java)
    }

    private fun getJsonString(): String {
        return "{\"collection\":[{\"avatar_url\":\"https://i1.sndcdn.com/avatars-000314061717-zpmbii-large.jpg\",\"id\":193106246,\"kind\":\"user\",\"permalink_url\":\"http://soundcloud.com/stevegatsby\",\"uri\":\"https://api.soundcloud.com/users/193106246\",\"username\":\"Mr. Gatsby\",\"permalink\":\"stevegatsby\",\"last_modified\":\"2017/11/21 08:30:54 +0000\",\"first_name\":\"Dr. Djaco &\",\"last_name\":\"Mr. Gatsby\",\"full_name\":\"Dr. Djaco & Mr. Gatsby\",\"city\":\"\",\"description\":\"\\\".. if you get good music, you’ll become happy; if you get  bad one, you’ll become a philosopher.”\\ncit. Socrates\",\"country\":\"Italy\",\"track_count\":2,\"public_favorites_count\":0,\"followers_count\":1071,\"followings_count\":1208,\"plan\":\"Free\",\"myspace_name\":null,\"discogs_name\":null,\"website_title\":null,\"website\":null,\"reposts_count\":9,\"comments_count\":244,\"online\":false,\"likes_count\":0,\"playlist_count\":1},{\"avatar_url\":\"https://i1.sndcdn.com/avatars-000383288585-qcwwj2-large.jpg\",\"id\":168440564,\"kind\":\"user\",\"permalink_url\":\"http://soundcloud.com/karen-hagen-364866487\",\"uri\":\"https://api.soundcloud.com/users/168440564\",\"username\":\"Karen Hagen\",\"permalink\":\"karen-hagen-364866487\",\"last_modified\":\"2018/01/15 08:13:34 +0000\",\"first_name\":\"Karen\",\"last_name\":\"Hagen\",\"full_name\":\"Karen Hagen\",\"city\":\"Berlin\",\"description\":null,\"country\":\"Germany\",\"track_count\":0,\"public_favorites_count\":0,\"followers_count\":69,\"followings_count\":202,\"plan\":\"Free\",\"myspace_name\":null,\"discogs_name\":null,\"website_title\":null,\"website\":null,\"reposts_count\":13,\"comments_count\":10,\"online\":false,\"likes_count\":0,\"playlist_count\":1}],\"next_href\":\"https://api.soundcloud.com/users/1000/followers?page_size=2&client_id=18zFL6PPbFtf5MqbKEFzGrDWDssKbODa&cursor=1515766117699&sort=desc\"}"
    }


}