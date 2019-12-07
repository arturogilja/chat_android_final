package com.example.proyectochat

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private var instance: RetrofitClient? = null
        private var retrofit: Retrofit? = null
        private val url = "http://157.230.145.29:9090/"
        fun getInstance(): RetrofitClient {
            if (instance == null) {
                instance = RetrofitClient()
            }
            return instance as RetrofitClient
        }

        fun createRetrofit(): Retrofit? {
            retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }

    }
    fun <S> createService(ServiceClass: Class<S>): S {
        return if (retrofit == null) {
            createRetrofit()!!.create(ServiceClass)
        } else {
            retrofit!!.create(ServiceClass)
        }
    }
}