package com.rahul.mynews.ui.news.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rahul.mynews.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

@ExperimentalCoroutinesApi
class NewsListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
}