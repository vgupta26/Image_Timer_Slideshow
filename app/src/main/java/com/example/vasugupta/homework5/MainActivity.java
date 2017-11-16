package com.example.vasugupta.homework5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.progress;
import static android.R.attr.settingsActivity;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    TextView seekval;
    SeekBar seekBar;
    Button strbtn;
    int progressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.skbar);
        seekval = (TextView) findViewById(R.id.slidesec);
        strbtn = (Button) findViewById(R.id.startb);
        Seekbarprogress();}

    public void Seekbarprogress() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar S1, int progress, boolean fromUser) {
                seekval.setText(valueOf(progress));
                progressValue = progress; }
            @Override
            public void onStartTrackingTouch(SeekBar S1) {}
            @Override
            public void onStopTrackingTouch(SeekBar S1) {
                Toast.makeText(getApplicationContext(), seekBar.getProgress() + "  Secs", Toast.LENGTH_SHORT).show();
                addListeneronbutton(); }});}
    public void addListeneronbutton() {
        strbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        Main2Activity.class);
                intent.putExtra("vasu", String.valueOf(progressValue));
                startActivity(intent);
            }});}}

