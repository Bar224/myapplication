package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.myapplication.CustomeAdapter;
import com.example.myapplication.DataModel;
//import com.example.myapplication.myData;
import com.example.myapplication.myData;
import com.example.myapplication.R;
import com.example.myapplication.activitys.MainActivity;
import com.google.firebase.auth.FirebaseAuth;


import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTh#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTh extends Fragment {


    private ArrayList<DataModel> dataSet;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomeAdapter adapter;
    private SearchView searchView;
    private Button buttonOrder;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTh() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTh.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTh newInstance(String param1, String param2) {
        FragmentTh fragment = new FragmentTh();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =  inflater.inflate(R.layout.fragment_th, container, false);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getData(view);


        dataSet = new ArrayList<>();
        recyclerView = view.findViewById(R.id.resView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Populate the dataset
        for (int i = 0; i < myData.nameArray.length ; i++ ) {
            dataSet.add(new DataModel(
                    myData.nameArray[i],
                    myData.priceDescription[i],
                    myData.drawableArray[i],
                    myData.id_[i],
                    myData.itemCounts[i]
                    //myData.price[i]
            ));
        }

        adapter = new CustomeAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (adapter != null) {
                    adapter.getFilter(newText);
                }
                return true;
            }
        });

//        buttonOrder.setOnClickListener(v -> {
//            ArrayList<DataModel> selectedItems = adapter.getSelectedItems();
//            if (!selectedItems.isEmpty()) {
//                StringBuilder orderDetails = new StringBuilder();
//                StringBuilder order = new StringBuilder();
//                orderDetails.append("Order Date and Time: ").append(getCurrentDateTime()).append("\n");
//
//                for (DataModel item : selectedItems) {
//                    order.append("Product: ").append(item.getName())
//                            .append(", Quantity: ").append(item.getCount()).append("\n");
//                }
//
//                Log.d("Order", order.toString());
//                Toast.makeText(getContext(), "Order placed successfully!", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(getContext(), "No items selected.", Toast.LENGTH_SHORT).show();
//            }
//        });


       return  view;

    }

//    private String getCurrentDateTime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        return sdf.format(new Date());
//    }
}