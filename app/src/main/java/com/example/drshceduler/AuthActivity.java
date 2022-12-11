package com.example.drshceduler;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AuthActivity extends AppCompatActivity {
    private EditText username, password;
    private FirebaseAuth mAuth;
    private DatabaseReference dbTemp;
    private DatabaseReference dbSchedule;
    public static DatabaseReference dbUser;
    public static User student;
    public static List<Subject> subjectList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        username = findViewById(R.id.edtxtUsername);
        password = findViewById(R.id.edtxtPassword);

        mAuth = FirebaseAuth.getInstance();
        dbUser = FirebaseDatabase.getInstance().getReference().child("User");
        subjectList = new ArrayList<>();
    }

    public void onClickLogin(View view) {
        //перевіряємо чи користувач ввів логін і пароль
        if(!TextUtils.isEmpty(username.getText()) && !TextUtils.isEmpty(password.getText())){
            mAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Log.d(TAG, String.valueOf(user));
                                readStudentData(user);
//                                addToSchedule();
                                startSelectData(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                username.setText("");
                                password.setText("");
                                Toast.makeText(getApplicationContext(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else{
            Toast.makeText(getApplicationContext(), "Empty Username or Password",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void startSelectData(FirebaseUser user){
        Intent intent = new Intent(this, DataActivity.class);
        //передаємо в наступну activity ID і E-Mail
        intent.putExtra("student", user.getUid());
        intent.putExtra("email", user.getEmail());
        startActivity(intent);
    }

    private void readStudentData(FirebaseUser user){
        String uId = user.getUid();
        dbUser.child(uId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    student = dataSnapshot.getValue(User.class);
                    student.setEmail(user.getEmail());
                    student.setUserID(uId);
                    Log.d("Create student:", String.valueOf(dataSnapshot.getValue()));
                    if(student.isThemeDark()){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addToSchedule() {
        dbTemp = FirebaseDatabase.getInstance().getReference().child("/Schedule/ІП-19-2(1)");
        String sub;
        for (int i = 14; i < 21; i++) {
            sub = "Subject" + i;
            dbTemp.child(sub).child("Cabinet").setValue("C");
            dbTemp.child(sub).child("Subject").setValue("S");
            dbTemp.child(sub).child("Type").setValue("Lecture");
            dbTemp.child(sub).child("Teacher").setValue("T");
            dbTemp.child(sub).child("Day").setValue("Tue");
            dbTemp.child(sub).child("Week").setValue("All");
            dbTemp.child(sub).child("Link").setValue("L");
            dbTemp.child(sub).child("Time").setValue(": - :");
        }
    }
}