package com.example.covid19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showIndonesia()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun showIndonesia(){
        ApiService.instance.getData().enqueue(object : Callback<ArrayList<CovidModel>>{
            override fun onFailure(call: Call<ArrayList<CovidModel>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ArrayList<CovidModel>>,
                response: Response<ArrayList<CovidModel>>
            ) {
                val CovidModel = response.body()?.get(0)
                val positive = CovidModel?.positif
                val recover = CovidModel?.sembuh
                val death = CovidModel?.meninggal

                totalInfected.text = positive
                totalRecovered.text = recover
                totalDeath.text = death
            }

        })
    }
}