package com.example.tablesandfun;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public void generate(int number){
        int j;
        ListView listView=findViewById(R.id.listview);;
        Toast.makeText(MainActivity.this, "Table of "+number, Toast.LENGTH_SHORT).show();
        ArrayList<String> arrayList=new ArrayList<String>();
        for(j=1;j<=10;j++)
        {
            String m=Integer.toString((number*j));
            arrayList.add(j +" X "+ number+" = "+ (m));

        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar seekBar=findViewById(R.id.seekbar);
        seekBar.setMin(1);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        generate(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                generate(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}