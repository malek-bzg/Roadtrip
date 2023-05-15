package com.anypli.roadtriip.data.retrofit
import com.google.firebase.firestore.auth.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("yourendpoint/{param}")
    fun getData(@Path("param") param : String?) : Call<User>

}