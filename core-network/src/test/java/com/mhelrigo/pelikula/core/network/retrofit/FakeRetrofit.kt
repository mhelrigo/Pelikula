package com.mhelrigo.pelikula.core.network.retrofit

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object FakeRetrofit {
    fun fakeServer(mockWebServer: MockWebServer) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(mockWebServer.url("/"))
        .build()

    val fakeResponse = MockResponse().addHeader("Content-Type", "application/json; charset=utf-8")
}