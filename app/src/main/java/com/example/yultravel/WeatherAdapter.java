package com.example.yultravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Weather> weatherArrayList;
    private Context context;

    public static class WeatherViewHolder extends RecyclerView.ViewHolder{
        WeatherAdapter adapter;
        TextView temperature;
        TextView date;
         ImageView imageView;
        WeatherViewHolder(View itemView, WeatherAdapter adapter) {
            super(itemView);
            temperature = itemView.findViewById(R.id.textViewTemp);
            date = itemView.findViewById(R.id.textViewTime);
            imageView= itemView.findViewById(R.id.imageViewWeather);
            this.adapter =adapter;
        }
    }
    WeatherAdapter(Context context, ArrayList<Weather> weatherArrayList) {
        mInflater = LayoutInflater.from(context);
        this.context =context;
        this.weatherArrayList = weatherArrayList;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.weather_item,viewGroup,false);
        return new WeatherViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder weatherViewHolder, int i) {
        weatherViewHolder.temperature.setText( weatherArrayList.get(i).getTemperature());
        weatherViewHolder.date.setText(weatherArrayList.get(i).getDate());
        Picasso.with(context)
                .load(weatherArrayList.get(i).getImageUrl())
                .resize(6000,4000)
                .into(weatherViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return weatherArrayList.size();
    }


}
