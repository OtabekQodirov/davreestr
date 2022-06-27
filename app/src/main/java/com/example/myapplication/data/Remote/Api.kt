package com.example.myapplication.data.Remote

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @POST("page/getinfo")
    fun getCadInfo(@Body info: RequestBean): Call<ResponseBean>

    /*
    * /2021/12/23
    * .....info/2022/12/13 - path param
    *
    * info ? date=2022-12-13 & time=12:00 & theme=sport,food
    * info ? page=3 & perPage=15 & theme=sport, food          - query param
    *
    *
    *
    * */

}
