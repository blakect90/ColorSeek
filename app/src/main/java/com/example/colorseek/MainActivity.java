package com.example.colorseek;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SeekBar sb_j_Red;
    SeekBar sb_j_Blue;
    SeekBar sb_j_Green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sb_j_Red = findViewById(R.id.sb_v_Red);
        sb_j_Blue = findViewById(R.id.sb_v_Blue);
        sb_j_Green = findViewById(R.id.sb_v_Green);

        setSeekBarListeners();
        setBackGroundColor();
    }

    public void setSeekBarListeners()
    {
        sb_j_Red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_j_Red.setProgress(progress);
                setBackGroundColor();

                //Log.d("RED", String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sb_j_Blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_j_Blue.setProgress(progress);
//                Log.d("BLUE", String.valueOf(progress));
                setBackGroundColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sb_j_Green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_j_Green.setProgress(progress);
//                Log.d("GREEN", String.valueOf(progress));
                setBackGroundColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void setBackGroundColor()
    {
        int red = sb_j_Red.getProgress();
        int green = sb_j_Green.getProgress();
        int blue = sb_j_Blue.getProgress();

        findViewById(R.id.main).setBackgroundColor(android.graphics.Color.rgb(red, green, blue));
    }
}