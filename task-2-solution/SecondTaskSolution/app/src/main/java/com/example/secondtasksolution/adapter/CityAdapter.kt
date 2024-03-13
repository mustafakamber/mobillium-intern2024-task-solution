package com.example.secondtasksolution.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondtasksolution.databinding.RecyclerCityRowBinding
import com.example.secondtasksolution.model.City

class CityAdapter(val cityList: MutableList<City>, val onItemSelected: (City) -> Unit) :
    RecyclerView.Adapter<CityAdapter.ListHolder>() {

    class ListHolder(val binding: RecyclerCityRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {

        val listAdapterBinding = RecyclerCityRowBinding
            .inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )

        return ListHolder(listAdapterBinding)
    }

    override fun getItemCount(): Int {

        return cityList.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) = with(holder.binding) {

        listRowCityText.text = cityList[position].cityName
        listRowWeatherImage.setImageResource(cityList[position].cityWeatherImage!!.toInt())
        listRowWeatherText.text = cityList[position].cityWeatherName
        listRowTemperatureText.text = cityList[position].cityTemperature.toString()
        listRowTemperatureRangeText.text =
            cityList[position].cityTemperatureMin.toString() + "° - " + cityList[position].cityTemperatureMax.toString() + "°"

        holder.itemView.setOnClickListener {
            onItemSelected(cityList[position])
        }
    }

}