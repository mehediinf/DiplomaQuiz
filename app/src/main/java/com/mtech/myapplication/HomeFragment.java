package com.mtech.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    LinearLayout llQuiz;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // Initialize TextView
        TextView textViewNotice = view.findViewById(R.id.txtView_Notice);
        llQuiz = view.findViewById(R.id.LL_Quiz);


        llQuiz.setOnClickListener(view1 -> {


            Intent intent = new Intent(getActivity(),SingleQuizActivity.class);
            startActivity(intent);




        });





        // Enable focus programmatically
        textViewNotice.setSelected(true);

        return view;
    }
}
