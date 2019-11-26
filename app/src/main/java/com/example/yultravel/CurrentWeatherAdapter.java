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

public class CurrentWeatherAdapter extends RecyclerView.Adapter<CurrentWeatherAdapter.CurrentWeatherViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<CurrentWeather> currentWeatherArrayList;
    private Context context;

    static class CurrentWeatherViewHolder extends RecyclerView.ViewHolder{
        CurrentWeatherAdapter adapter;
       TextView currentTemp;
       TextView currentWeather;
       TextView description;
        ImageView imageView;
        CurrentWeatherViewHolder(View itemView, CurrentWeatherAdapter adapter) {
            super(itemView);
            currentTemp =itemView.findViewById(R.id.textViewCurrentTemp);
            currentWeather = itemView.findViewById(R.id.textViewCurrentWeather);
            description = itemView.findViewById(R.id.textViewDescription);
            imageView= itemView.findViewById(R.id.imageViewCurrentWeather);
            this.adapter =adapter;
        }
    }
   CurrentWeatherAdapter(Context context, ArrayList<CurrentWeather> weatherArrayList) {
        mInflater = LayoutInflater.from(context);
        this.context =context;
        this.currentWeatherArrayList = weatherArrayList;
    }
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @NonNull
    @Override
    public CurrentWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.currentweather_item,viewGroup,false);
        return new CurrentWeatherViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentWeatherViewHolder currentWeatherViewHolder, int i) {
        currentWeatherViewHolder.currentTemp.setText( currentWeatherArrayList.get(i).getCurrentTemp());
        currentWeatherViewHolder.currentWeather.setText(currentWeatherArrayList.get(i).getWeatherCondition());
        currentWeatherViewHolder.description.setText(currentWeatherArrayList.get(i).getDescription());
         Picasso.with(context)
                .load(currentWeatherArrayList.get(i).getCurrentImgUrl())
                .resize(6000,4000)
                .into(currentWeatherViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return currentWeatherArrayList.size();
    }


}
