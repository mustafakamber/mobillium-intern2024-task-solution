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

        cityList[position].run {
            listRowCityText.text = cityName
            listRowWeatherImage.setImageResource(weatherImage)
            listRowWeatherText.text = weatherName
            listRowTemperatureText.text = temperature.toString()
            listRowTemperatureRangeText.text =
                temperatureMin.toString() + "° - " + temperatureMax.toString() + "°"
        }
        holder.itemView.setOnClickListener {
            onItemSelected(cityList[position])
        }
    }

}