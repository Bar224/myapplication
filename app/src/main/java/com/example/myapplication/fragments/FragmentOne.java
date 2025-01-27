package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.activitys.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Button buttonFromFrag1To3;




    public FragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
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
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Button butttonReg = view.findViewById(R.id.buttonFromFrag1To2);
        Button butttonLog = view.findViewById(R.id.buttonFromFrag1To3);
        EditText editPasswordLog =view.findViewById(R.id.editTextTextPasswordLog) ;
        EditText editEmailAddressLog=view.findViewById(R.id.editTextTextEmailAddressLog);



        butttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentTwo);
            }
        });

        butttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmailAddressLog.getText().toString();
                String password = editPasswordLog.getText().toString();

                if (password.isEmpty()) {
                    editPasswordLog.setError("Password is required");
                }
                else if (email.isEmpty()){
                    editEmailAddressLog.setError("Email is required");
                }

                else if (password.length() < 6) {
                        editPasswordLog.setError("Password must be at least 6 characters long");
                }

                else {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.login(view);
                }

            }
        });

        return view;
    }

}

