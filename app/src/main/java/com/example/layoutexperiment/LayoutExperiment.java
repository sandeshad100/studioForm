package com.example.layoutexperiment;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LayoutExperiment extends Activity {

    protected EditText name, phone, password, repassword;
    protected CheckBox cbJava, cbJS;
    protected Button btnRegister;
    protected RadioButton radioMale, radioFemale;
    String selectedGender;

    List<String> selectedFavourite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        name = findViewById(R.id.editName);
        phone = findViewById(R.id.editPhone);
        password = findViewById(R.id.edit_password);
        repassword = findViewById(R.id.edit_confirm_password);

        radioMale = findViewById(R.id.radio_male);
        radioFemale = findViewById(R.id.radio_female);

        cbJava = findViewById(R.id.javaCheckBox);
        cbJS = findViewById(R.id.jsCheckBox);


        btnRegister = findViewById(R.id.btn_register);
        selectedFavourite = new ArrayList<>();

        // Set listeners for checkboxes to manage the array
        cbJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selectedFavourite.add(cbJava.getText().toString());
                } else {
                    selectedFavourite.remove(cbJava.getText().toString());
                }
            }
        });
        cbJS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selectedFavourite.add(cbJS.getText().toString());
                } else {
                    selectedFavourite.remove(cbJS.getText().toString());
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue, phoneValue;
                nameValue = name.getText().toString();
                phoneValue = phone.getText().toString();

                if (radioMale.isChecked()) {
                    selectedGender = radioMale.getText().toString();
                } else if (radioFemale.isChecked()) {
                    selectedGender = radioFemale.getText().toString();
                }

                // Convert the list to a comma-separated string
                String favorites = String.join(", ", selectedFavourite);

//                Toast.makeText(getApplicationContext(), "Name: " + nameValue + "\nPhone: " + phoneValue + "\nGender: " + selectedGender + "\nFavorites: " , Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Favourite:" + favorites, Toast.LENGTH_LONG).show();

            }
        });


    }
}
