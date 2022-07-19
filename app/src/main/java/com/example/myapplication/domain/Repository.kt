package com.example.myapplication.domain

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.remote.RequestBean
import com.example.myapplication.data.remote.ResponseBean
import com.example.myapplication.data.remote.RetrofitClient
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository(context: Context) {
    val retrofit: RetrofitClient = RetrofitClient()
    val database: AppDatabase = AppDatabase.init(context)

    fun searchInfo(cadNumber: String, result: ApiCallback) {

        val str1 = """
            {
                "address": "г. Ташкент, Яккасарайский, Дамарик МФЙ, Кичик Бешегоч кучаси, 3а, 3б-уй",
                "area": 7000,
                "area_bino": 803,
                "area_jilaya": 22.5,
                "ban_info": "105-000625 - 2018-11-23",
                "cad_number": "10:05:02:02:04:0037",
                "code": 99,
                "cost": "0",
                "count_subjects": 1,
                "date": "",
                "district_id": 1726287,
                "has_ban": "1",
                "number": "",
                "object_type": "3",
                "region_id": 1726,
                "subjects": ["4239565cb4b4935be0b944ec1d1639d4", "4239565cb4b4935be0b944ec1"]
            }
        """

        val responseV1 = Gson().fromJson(str1, ResponseBean::class.java)


        Handler(Looper.myLooper()!!).postDelayed({ result.onSuccess(responseV1) }, 2_000)


        /*
        val request = RequestBean(cad_num = cadNumber)
        val call = retrofit.api.getCadInfo(request)

        call.enqueue(object : Callback<ResponseBean> {
            override fun onResponse(call: Call<ResponseBean>, response: Response<ResponseBean>) {

                if (response.isSuccessful) {
                    response.body()?.let {
                        result.onSuccess(it)
                        return
                    }
                }

                result.onFailure("Fail")
            }

            override fun onFailure(call: Call<ResponseBean>, t: Throwable) {
                result.onFailure(t.message ?: "")
            }

        })

        */
    }

    fun getAllDocuments() = database.documentDao().getAll()

    fun getAllECommerce() = database.ecommerceDao().getAll()

}