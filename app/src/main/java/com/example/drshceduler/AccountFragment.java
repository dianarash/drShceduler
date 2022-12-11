package com.example.drshceduler;

import static com.example.drshceduler.AuthActivity.student;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AccountFragment extends Fragment {
    private TextView txtvFullName, txtvStudentID, txtvFaculty, txtvSpeciality, txtvTerm,
            txtvGroup, txtvFoS, txtvToS, txtvEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtvFullName = view.findViewById(R.id.txtvFullName);
        txtvStudentID = view.findViewById(R.id.txtvStudentID);
        txtvFaculty = view.findViewById(R.id.txtvFaculty);
        txtvSpeciality = view.findViewById(R.id.txtvSpeciality);
        txtvGroup = view.findViewById(R.id.txtvGroup);
        txtvTerm = view.findViewById(R.id.txtvTerm);
        txtvFoS = view.findViewById(R.id.txtvFoS);
        txtvToS = view.findViewById(R.id.txtvToS);
        txtvEmail = view.findViewById(R.id.txtvEmail);
        txtvFullName.setText(student.getFullName());
        txtvStudentID.setText(student.getStudentID());
        txtvFaculty.setText(student.getFaculty());
        txtvSpeciality.setText(student.getSpecialty());
        txtvGroup.setText(student.getGroup());
        txtvTerm.setText(student.getTerm());
        txtvFoS.setText(student.getFormOfEducation());
        txtvToS.setText(student.getTermOfEducation());
        txtvEmail.setText(student.getEmail());
    }
}