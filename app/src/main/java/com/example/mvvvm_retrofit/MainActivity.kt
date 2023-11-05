package com.example.mvvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesApi = RetrofitBuilder.getInstance().create(QuoteInterface::class.java)

//        NOTE: Long running task should be done on background tasks

        GlobalScope.launch {
            val result = quotesApi.getQuotes(1)

            if(result.isSuccessful){
                val quotes = result.body()?.results
                quotes?.forEach {
                    println(it)
                }
                Log.d("MainActivity", "onCreate: $quotes")

            }
            else{
                println(result.errorBody())
            }

        }



    }
}