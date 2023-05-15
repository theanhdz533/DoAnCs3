package com.example.conquertheexam.online

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.conquertheexam.R
import com.example.conquertheexam.databinding.ActivityChatbotBinding
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class ActivityChatbot : AppCompatActivity() {
    lateinit var binding: ActivityChatbotBinding
    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)
        binding = ActivityChatbotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSearch.setOnClickListener {
            binding.txtResult.setText("Loading.......")
            val question = binding.edtEnterQuestions.text.toString()
            getResponse(question){ response->
                runOnUiThread{
                    binding.txtResult.text = "Kết Quả: " + response
                }

            }
        }

    }


    fun getResponse(question: String, callback: (String) -> Unit){
        val apiKey = "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"
        val url = "https://api.openai.com/v1/engines/text-davinci-003/completions"

        val requestBody="""
            {
            "prompt": "$question",
            "max_tokens": 500,
            "temperature": 0
            }
        """.trimIndent()

        val request = Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer $apiKey")
            .post(requestBody.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("error","API failed",e)
            }

            override fun onResponse(call: Call, response: Response) {
                val body=response.body?.string()
                if (body != null) {
                    Log.v("data api",body)
                }
                else{
                    Log.v("data","empty")
                }
                val jsonObject=JSONObject(body)
                val jsonArray:JSONArray=jsonObject.getJSONArray("choices")
                val textResult=jsonArray.getJSONObject(0).getString("text")
                callback(textResult)
            }
        })


    }
}