package com.murdock.unitconverter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UnitRecyclerAdapter extends RecyclerView.Adapter<UnitRecyclerAdapter.MyViewHolder> {

    Context context;
    int [] convertList;

    public UnitRecyclerAdapter(Context context, int[] convertList) {
        this.context = context;
        this.convertList = convertList;
    }

    @NonNull
    @Override
    public UnitRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.convert, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitRecyclerAdapter.MyViewHolder holder, int position) {
        holder.imgConvert.setImageResource(convertList[position]);
    }

    @Override
    public int getItemCount() {
        return convertList.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgConvert;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgConvert = itemView.findViewById(R.id.imgConvert);

            imgConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(convertList[getAdapterPosition()] == R.drawable.ctof)
                    {
                        Unit unit = new Unit("Celsius", "Fahrenheit");
                        Intent intent = new Intent(context, UnitConvertActivity.class);
                        intent.putExtra("unit", unit);
                        context.startActivity(intent);
                    }
                    else if(convertList[getAdapterPosition()] == R.drawable.ctok)
                    {
                        Unit unit = new Unit("Celsius", "Kelvin");
                        Intent intent = new Intent(context, UnitConvertActivity.class);
                        intent.putExtra("unit", unit);
                        context.startActivity(intent);
                    }
                    else if(convertList[getAdapterPosition()] == R.drawable.ftoc)
                    {
                        Unit unit = new Unit("Fahrenheit", "Celsius");
                        Intent intent = new Intent(context, UnitConvertActivity.class);
                        intent.putExtra("unit", unit);
                        context.startActivity(intent);
                    }
                    else if(convertList[getAdapterPosition()] == R.drawable.ftok)
                    {
                        Unit unit = new Unit("Fahrenheit", "Kelvin");
                        Intent intent = new Intent(context, UnitConvertActivity.class);
                        intent.putExtra("unit", unit);
                        context.startActivity(intent);
                    }
                    else if(convertList[getAdapterPosition()] == R.drawable.ktoc)
                    {
                        Unit unit = new Unit("Kelvin", "Celsius");
                        Intent intent = new Intent(context, UnitConvertActivity.class);
                        intent.putExtra("unit", unit);
                        context.startActivity(intent);
                    }
                    else
                    {
                        Unit unit = new Unit("Kelvin", "Fahrenheit");
                        Intent intent = new Intent(context, UnitConvertActivity.class);
                        intent.putExtra("unit", unit);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
