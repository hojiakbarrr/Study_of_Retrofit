package com.example.study_of_retrofit.repository

import com.example.study_of_retrofit.api.RetrofitInstance
import com.example.study_of_retrofit.model.Post
import com.example.study_of_retrofit.model.Userss
import com.example.study_of_retrofit.model.UserssItem
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int): Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId)
    }


    suspend fun getUser(): Response<Userss>{
        return RetrofitInstance.api.getUsers()
    }
}