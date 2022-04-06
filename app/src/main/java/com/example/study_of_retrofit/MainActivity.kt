package com.example.study_of_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.study_of_retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {

            Log.d("Response", "response.body().toString()")
            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
            viewModel.getUser()
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
//                Log.d("Response", response.body()?.email .toString())
//                Log.d("Response", response.body()?.id.toString())
                    textView.text = response.body()!!.title
                    Log.d("Response", response.body().toString())
                } else {
                    Log.d("Response", response.errorBody().toString())
                    textView.text = response.code().toString()

//        https://www.google.com/search?q=%D0%BC%D0%B5%D1%82%D0%B0%D0%B2%D1%81%D0%B5%D0%BB%D0%B5%D0%BD%D0%BD%D0%B0%D1%8F+%D0%B2%D0%BE%D0%B9%D1%82%D0%B8&rlz=1C1GCEA_enKG971KG971&sxsrf=APq-WBvU97L7cj0xGDH95-A8mcuMaSBI-Q:1644855016448&source=lnms&sa=X&ved=2ahUKEwij6Ni3yv_1AhUFzYsKHVwPCUYQ_AUoAHoECAEQAg&biw=1745&bih=852&dpr=1.1
                }
            })
        }


//        button.setOnClickListener {
//            val myNumber :String = number_editText.text.toString()
//            viewModel.getCustomPosts(Integer.parseInt(myNumber))
////           viewModel.getPost()
//            viewModel.myCustomPosts .observe(this, Observer { response ->
//                if (response.isSuccessful){
//                    textView.text = response.body().toString()
//                    response.body()?.forEach {
//                        Log.d("Response",it.userId.toString())
//                        Log.d("Response",it.id.toString())
//                        Log.d("Response",it.title)
//                        Log.d("Response",it.body)
//                        Log.d("Response","--------------------------------------------------------")
//                    }
//                }else{
//                    textView.text = response.code().toString()
//                }
//            })
//
//        }


    }
}