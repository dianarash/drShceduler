package com.example.drshceduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class ScheduleActivity extends AppCompatActivity {
    private Button btnAccount, btnSchedule, btnSettings;
    private ScheduleFragment schFr = new ScheduleFragment();
    private AccountFragment accFr = new AccountFragment();
    private TextView txtvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        btnAccount = findViewById(R.id.bntAccount);
        btnSchedule = findViewById(R.id.btnSchedule);
        btnSettings = findViewById(R.id.btnSettings);
        txtvTitle = findViewById(R.id.txtvTitle);

        setNewFragment(schFr);
        btnSchedule.setEnabled(false);
        txtvTitle.setText(getString(R.string.schedule_title));
    }

    public void onClickSchedule(View view){
        setNewFragment(schFr);
        btnSchedule.setEnabled(false);
        btnSettings.setEnabled(true);
        btnAccount.setEnabled(true);
        txtvTitle.setText(getString(R.string.schedule_title));
    }

    @SuppressLint("StringFormatInvalid")
    public void onClickAccount(View view){
        setNewFragment(accFr);
        btnSchedule.setEnabled(true);
        btnSettings.setEnabled(true);
        btnAccount.setEnabled(false);
        txtvTitle.setText(getString(R.string.account_title));
    }

    public void onClickSettings(View view){
        SettingsFragment setFr = new SettingsFragment();
        setNewFragment(setFr);
        btnSchedule.setEnabled(true);
        btnSettings.setEnabled(false);
        btnAccount.setEnabled(true);
        txtvTitle.setText(getString(R.string.settings_title));
    }

    private void setNewFragment(Fragment fr) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fltForFragment, fr);
        ft.addToBackStack(null);
        ft.commit();
    }
}