package com.example.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



    public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {


        private ArrayList<DataModel> dataSet;
        private ArrayList<DataModel> filteredDataSet;

        public CustomeAdapter(ArrayList<DataModel> dataSet) {
            this.dataSet = dataSet;
            this.filteredDataSet = new ArrayList<>(dataSet);  // התחלה עם הנתונים המקוריים
        }

        public void getFilter(String query) {
            ArrayList<DataModel> filteredList = new ArrayList<>();

            if (query.isEmpty()) {
                filteredList.addAll(dataSet);
            } else {
                for (DataModel item : dataSet) {
                    if (item.getName().toLowerCase().startsWith(query.toLowerCase())) {
                        filteredList.add(item);
                    }
                }
            }

            updateData(filteredList);
        }


        public ArrayList<DataModel> getSelectedItems() {
            ArrayList<DataModel> selectedItems = new ArrayList<>();
            for (DataModel item : dataSet) {
                if (item.getCount() > 0) {
                    selectedItems.add(item);
                }
            }
            return selectedItems;
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView textViewName;
            ImageView imageView;
            TextView  textViewCount;

            Button buttonPlus, buttonMinus;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.imageView);
                textViewName = itemView.findViewById(R.id.textViewProd);
                textViewCount = itemView.findViewById(R.id.textViewCount);
                imageView = itemView.findViewById(R.id.imageView);
                buttonPlus = itemView.findViewById(R.id.buttonPlus);
                buttonMinus = itemView.findViewById(R.id.buttonMin);
            }
        }

        @NonNull
        @Override
        public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddrow, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {


            DataModel item = filteredDataSet.get(position);
            holder.itemView.setBackgroundColor(Color.parseColor("#00FFFF80"));

            // הצגת שם הפריט
            holder.textViewName.setText(item.getName());
            holder.imageView.setImageResource(item.getImage());

            // כמות הפריט
            int itemCount = myData.itemCounts[item.getId()];
            holder.textViewCount.setText(String.valueOf(itemCount));

            // לחצן הפחתה
            holder.buttonMinus.setOnClickListener(v -> {
                if (myData.itemCounts[item.getId()] > 0) {
                    myData.itemCounts[item.getId()]--;
                    holder.textViewCount.setText(String.valueOf(myData.itemCounts[item.getId()]));
                }
            });

            // לחצן הוספה
            holder.buttonPlus.setOnClickListener(v -> {
                myData.itemCounts[item.getId()]++;
                holder.textViewCount.setText(String.valueOf(myData.itemCounts[item.getId()]));
            });

            // פעולה בלחיצה
            holder.itemView.setOnClickListener(view -> {
                String itemName = item.getName();
                String priceD = item.getPriced();
                Toast.makeText(view.getContext(), itemName + " Price: " + priceD, Toast.LENGTH_SHORT).show();
            });



        }

        @Override
        public int getItemCount() {
            return filteredDataSet.size();
        }

        public void updateData(ArrayList<DataModel> newDataset) {
            this.filteredDataSet = newDataset;  // מעדכן את הרשימה המסוננת
            notifyDataSetChanged();  // מעדכן את ה-RecyclerView
        }


    }




