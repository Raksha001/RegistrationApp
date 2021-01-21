package com.example.registrationapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    Spinner sp1;
    ArrayList arrayList1;
    ArrayAdapter arrayAdapter1;
    Button submit,signin;
    EditText name,roll,mobile,dob,blood;
    TextView yr,dept;
    RadioGroup gender;
    String s,ss,s2;
    CheckBox tc;
    MediaPlayer m;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = findViewById(R.id.spinner);
        sp1 = findViewById(R.id.spinner2);
        submit = findViewById(R.id.submit);
        name = findViewById(R.id.editTextTextPersonName);
        roll = findViewById(R.id.editTextTextPersonName2);
        mobile = findViewById(R.id.editTextTextPersonName3);
        dob = findViewById(R.id.editTextTextPersonName4);
        blood = findViewById(R.id.editTextTextPersonName5);
        yr = findViewById(R.id.textView);
        dept = findViewById(R.id.textView1);
        gender = findViewById(R.id.radio);
        tc = findViewById(R.id.checkBox);
        signin = findViewById(R.id.button3);
        m = MediaPlayer.create(MainActivity.this,R.raw.alert);


        arrayList = new ArrayList();
        arrayList1 = new ArrayList();

        arrayList.add("SELECT YEAR");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList1.add("SELECT DEPARTMENT");
        arrayList1.add("IT");
        arrayList1.add("EEE");
        arrayList1.add("ECE");
        arrayList1.add("CSE");
        arrayList1.add("MECH");

        arrayAdapter =
                new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1, arrayList);
        sp.setAdapter(arrayAdapter);
        arrayAdapter1 =
                new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1, arrayList1);
        sp1.setAdapter(arrayAdapter1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = gender.getCheckedRadioButtonId();
                switch (i){

                    case R.id.radioButton2:
                        ss="female";
                        break;

                    case R.id.radioButton:
                        ss="male";
                        break;
                }

                boolean st = tc.isChecked();
                if (st){
                    String yr = sp.getSelectedItem().toString();
                    String dept = sp1.getSelectedItem().toString();

                    s="NAME:"+ "\t" + name.getText().toString() + "\n" + "ROLL NUM:"+ "\t"+roll.getText().toString()  +"\n"+ "PHONE NUM:"+ "\t"+ mobile.getText().toString() + "\n" + "YEAR:"+ "\t"+yr +"\n" +"DOB:"+ "\t"+dob.getText().toString() +"\n"+ "DEPT:"+ "\t"+ dept + "\n"+ "BLOOD GROUP:"+ "\t"+ blood.getText().toString()  + "\n" + "GENDER:"+ "\t"+ ss;
                    s2 = mobile.getText().toString();
                    Intent an = new Intent(MainActivity.this,DataDisplay.class);
                    an.putExtra("abc",s);
                    an.putExtra("key",s2);
                    startActivity(an);
                    Toast.makeText(MainActivity.this, "Information Submitted!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Agree Terms and Condition!" , Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(MainActivity.this)//for alert message
                            .setTitle("Alert!")
                            .setMessage("Agree Terms and Condition!")
                            .setPositiveButton("Okayyy!", null)
                            .setNegativeButton("No",null)
                            .setNeutralButton("LOL",null)
                            .show();
                    m.start();
                }
            }
        });

    }

    public void dat(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                dob.setText(i + "/" + i1 + "/" + i2);
                dob.setEnabled(false);
            }
        }, 2021, 0, 26);
        datePickerDialog.show();
    }

    public void sign(View view) {
        Intent an = new Intent(MainActivity.this,LoginPg.class);
        startActivity(an);
    }
}