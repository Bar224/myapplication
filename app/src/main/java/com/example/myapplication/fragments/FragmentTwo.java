package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.activitys.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTwo extends Fragment {

    Button buttonReg;
    TextView textViewEmail, textViewPass1, textViewPass2, textViewPhone;

    String email, pass1, pass2, phone;

    EditText editTextEmailAddress, editTextTextPassword1, editTextTextPassword2, editTextPhone;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String emailExample;

    public FragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTwo newInstance(String param1, String param2) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    // Example registration function
    //private void registerUser(String email, String password, String phone) {
        // Handle registration logic
        //Toast.makeText(getContext(), "Registration successful", Toast.LENGTH_SHORT).show();
 //   }


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
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        editTextEmailAddress = view.findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword1 = view.findViewById(R.id.editTextTextPassword1);
        editTextTextPassword2 = view.findViewById(R.id.editTextTextPassword2);
        editTextPhone = view.findViewById(R.id.editTextPhone);


        buttonReg = view.findViewById(R.id.buttonReg);

        // Set onClickListener for the registration button
        buttonReg.setOnClickListener(v -> {
            email = editTextEmailAddress.getText().toString().trim();
            pass1 = editTextTextPassword1.getText().toString();
            pass2 = editTextTextPassword2.getText().toString();
            phone = editTextPhone.getText().toString().trim();

            // Validate inputs
            if (email.isEmpty()) {
                editTextEmailAddress.setError("Email is required");
            }

            else if (pass1.isEmpty() || pass2.isEmpty()) {
                editTextTextPassword1.setError("Password is required");
                editTextTextPassword2.setError("Password is required");
            }

            else if (pass1.length() < 6) {
                editTextTextPassword1.setError("Password must be at least 6 characters long");
            }

            else if (!pass1.equals(pass2)) {
                editTextTextPassword2.setError("Passwords do not match");
            }

            else if (phone.isEmpty() || phone.length() != 10 || !phone.matches("\\d+")) {
                editTextPhone.setError("Invalid phone number");
            }

            else {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.register(view,email,pass2, phone);
            }

        });
        return view;
    }
}

