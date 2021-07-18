package com.rahul.mynews

import com.google.common.truth.Truth
import com.rahul.mynews.data.TopHeadlineResponse
import org.junit.Test

class FileReaderTest {

    @Test
    fun `should read json file if filename is correct`() {
        val fileContent = FileReader.readTestResourcesFile(JSON_FILE_TOP_HEADLINES_RESPONSE)
        Truth.assertThat(fileContent).isNotEmpty()
    }

    @Test
    fun `should return empty string if filename is incorrect`() {
        val fileContent = FileReader.readTestResourcesFile(INCORRECT_FILE_NAME)
        Truth.assertThat(fileContent).isEmpty()
    }

    @Test
    fun `should return object if filename is correct`() {
        val newsResponse =
            FileReader.parseTestResourceFile<TopHeadlineResponse>(JSON_FILE_TOP_HEADLINES_RESPONSE)
        Truth.assertThat(newsResponse).isNotNull()
    }

    @Test
    fun `should return null if filename is incorrect`() {
        val newsResponse =
            FileReader.parseTestResourceFile<TopHeadlineResponse>(INCORRECT_FILE_NAME)
        Truth.assertThat(newsResponse).isNull()
    }
}