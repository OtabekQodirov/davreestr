package com.example.myapplication.domain

import android.content.Context
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.remote.RequestBean
import com.example.myapplication.data.remote.ResponseBean
import com.example.myapplication.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository(context: Context) {
    val retrofit: RetrofitClient = RetrofitClient()
    val database: AppDatabase = AppDatabase.init(context)

    fun searchInfo(cadNumber: String, result: ApiCallback) {
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


    }

    fun getAllDocuments() = database.documentDao().getAll()

    fun getAllECommerce() = database.ecommerceDao().getAll()

}