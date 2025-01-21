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

    LinearLayout llStudy,llDepartment,llSpecialExam,llMCQ,llLiveExam,llLiveExamScore,llGroupExam,llJobSyllabus;
    TextView textViewNotice;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // Initialize TextView and LinearLayout

        textViewNotice = view.findViewById(R.id.txtView_Notice);

        llStudy = view.findViewById(R.id.StudyCardView_Id);
        llDepartment = view.findViewById(R.id.DepartmentCardView_Id);
        llSpecialExam = view.findViewById(R.id.SpecialExamCardView_Id);
        llMCQ = view.findViewById(R.id.MCQCardView_Id);
        llLiveExam = view.findViewById(R.id.LiveExamCardView_Id);
        llLiveExamScore = view.findViewById(R.id.LiveExamScoreCardView_Id);
        llGroupExam = view.findViewById(R.id.GroupExamCardView_Id);
        llJobSyllabus = view.findViewById(R.id.JobSyllabusCardView_Id);




//Intent All Pages ........

        llStudy.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),StudyActivity.class);
            startActivity(intent);
        });
        llDepartment.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),DepartmentActivity.class);
            startActivity(intent);
        });
        llSpecialExam.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),SpecialExamActivity.class);
            startActivity(intent);
        });
        llMCQ.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),MCQActivity.class);
            startActivity(intent);
        });
        llLiveExam.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),LiveExamActivity.class);
            startActivity(intent);
        });
        llLiveExamScore.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),LiveExamScoreActivity.class);
            startActivity(intent);
        });
        llGroupExam.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),GroupExamActivity.class);
            startActivity(intent);
        });
        llJobSyllabus.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),JobSyllabusActivity.class);
            startActivity(intent);
        });





        // Enable focus programmatically
        textViewNotice.setSelected(true);

        return view;
    }
}
