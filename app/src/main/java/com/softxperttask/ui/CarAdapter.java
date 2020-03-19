package com.softxperttask.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softxperttask.R;
import com.softxperttask.data.models.Car;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    List<Car> cars;

    void notifyChange(List<Car> cars) {
        this.cars = cars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        Car car = cars.get(position);

        Picasso.get().load(car.imageUrl).into(holder.ivCar);

        holder.tvBrand.setText(car.brand);

        holder.tvStatus.setText(car.isUsed? "Used" : "New");

        holder.tvYear.setText(car.constructionYear);

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}

class CarViewHolder extends RecyclerView.ViewHolder {

    ImageView ivCar;
    TextView tvBrand;
    TextView tvStatus;
    TextView tvYear;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCar = (ImageView) itemView.findViewById(R.id.iv_car);
            tvBrand = (TextView) itemView.findViewById(R.id.tv_brand);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_status);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
        }
}

