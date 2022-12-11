package com.example.drshceduler;

import static com.example.drshceduler.AuthActivity.dbUser;
import static com.example.drshceduler.AuthActivity.student;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingsFragment extends Fragment {
    private RadioButton rbtnDark, rbtnLight, rbtnLang1, rbtnLang2;
    private RadioGroup rdgrTheme, rdgrLng;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rdgrTheme = view.findViewById(R.id.rdgrTheme);
        rdgrLng = view.findViewById(R.id.rdgrLng);
        rbtnDark = view.findViewById(R.id.rbtnDark);
        rbtnLight = view.findViewById(R.id.rbtnLight);
        rbtnLang1 = view.findViewById(R.id.rbtnLang1);
        rbtnLang2 = view.findViewById(R.id.rbtnLang2);

        //встановлюємо властивості віджетів у відповідності до параметрів із база даних
        rbtnDark.setChecked(student.isThemeDark());
        rbtnLight.setChecked(!student.isThemeDark());
        switch(student.getLanguage()){
            case "en":
                rbtnLang1.setChecked(false);
                rbtnLang2.setChecked(true);
                break;
            default:
                rbtnLang1.setChecked(true);
                rbtnLang2.setChecked(false);
                break;
        }


        rdgrTheme.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //опрацьовуємо подію зміни теми
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbtnDark){
                    dbUser.child(student.getUserID()).child("ThemeDark").setValue(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else {
                    dbUser.child(student.getUserID()).child("ThemeDark").setValue(false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

            }
        });

    }
}