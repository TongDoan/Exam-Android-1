package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity
        extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener
        {
    Button btnAdd;
    TextView txName, txSdt;
    RadioButton Nam, Nu;
    String s,ct;
            boolean first = true;
            String[] city = { "Quên Quán","Bắc Ninh", "Nam Định",
            "Bắc Giang", "Ninh Bình",
            "Quảng Ninh", "HCM" };

    ListView l;
    boolean c = true;
    ArrayList<String> listPerson = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listPerson.add("Nguyễn Văn An - Nam - 0984839843 - Hà Nội");
        btnAdd = findViewById(R.id.button);
        txName = findViewById(R.id.editTextTextPersonName);
        txSdt = findViewById(R.id.editTextPhone);
        Nam = findViewById(R.id.radioButton);
        Nu = findViewById(R.id.radioButton2);

        Nam.setOnCheckedChangeListener(listener);
        Nu.setOnCheckedChangeListener(listener);
        btnAdd.setOnClickListener((v) ->{
            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        } );

        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                city
        );
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spin.setAdapter(ad);

        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                listPerson);
        l.setAdapter(arr);
    btnAdd.setOnClickListener((v)->{
        if(check()){
            listPerson.add(txName.getText().toString()+ " - "  + s  + " - " + txSdt.getText().toString()+ " - " +ct);
            l.setAdapter(arr);
        }
    });
    }
    boolean check(){
        if(txName.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txSdt.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Vui lòng nhập số điện thoại!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(c){
            Toast.makeText(MainActivity.this, "Vui lòng chọn giới tính!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(ct == city[0]){
            Toast.makeText(MainActivity.this, "Vui lòng nhập quê quán!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                c = false;
                s = compoundButton.getText().toString();
            }
        }
    };

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                    ct = city[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        }