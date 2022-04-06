package com.example.study_of_retrofit.api

import com.example.study_of_retrofit.model.Post
import com.example.study_of_retrofit.model.Userss
import com.example.study_of_retrofit.model.UserssItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>


    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>


    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int
    ):Response<List<Post>>


    @GET("/users")
    suspend fun getUsers(): Response<Userss>
}