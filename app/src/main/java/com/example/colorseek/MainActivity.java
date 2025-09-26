package com.example.colorseek;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SeekBar sb_j_Red;
    SeekBar sb_j_Blue;
    SeekBar sb_j_Green;
    TextView tv_j_rVal;
    TextView tv_j_gVal;
    TextView tv_j_bVal;
    TextView tv_j_hex;
    TextView lbl_v_header;
    TextView lbl_v_red;
    TextView lbl_v_green;
    TextView lbl_v_blue;
    TextView lbl_v_hex;

//    ListView lv_j_savedColors;

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

        tv_j_rVal = findViewById(R.id.tv_v_rVal);
        tv_j_gVal = findViewById(R.id.tv_v_gVal);
        tv_j_bVal = findViewById(R.id.tv_v_bVal);
        tv_j_hex = findViewById(R.id.tv_v_hex);

        lbl_v_header = findViewById(R.id.lbl_v_header);
        lbl_v_red = findViewById(R.id.lbl_v_red);
        lbl_v_green = findViewById(R.id.lbl_v_green);
        lbl_v_blue = findViewById(R.id.lbl_v_blue);
        lbl_v_hex = findViewById(R.id.lbl_v_hex);

//        lv_j_savedColors = findViewById(R.id.lv_v_savedColors);

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
                tv_j_rVal.setText(String.valueOf(progress));
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
                tv_j_bVal.setText(String.valueOf(progress));
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
                tv_j_gVal.setText(String.valueOf(progress));
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
        changeTextColor(red, green, blue);
    }

    public void changeTextColor(int r, int g, int b)
    {
        int red = r;
        int green = g;
        int blue = b;

        double luminance = (0.299 * red) + (0.587 * green) + (0.114 * blue);

        if (luminance < 128)
        {
            tv_j_rVal.setTextColor(android.graphics.Color.WHITE);
            tv_j_gVal.setTextColor(android.graphics.Color.WHITE);
            tv_j_bVal.setTextColor(android.graphics.Color.WHITE);
            tv_j_hex.setTextColor(android.graphics.Color.WHITE);
            lbl_v_header.setTextColor(android.graphics.Color.WHITE);
            lbl_v_red.setTextColor(android.graphics.Color.WHITE);
            lbl_v_green.setTextColor(android.graphics.Color.WHITE);
            lbl_v_blue.setTextColor(android.graphics.Color.WHITE);
            lbl_v_hex.setTextColor(android.graphics.Color.WHITE);
        }
        else
        {
            tv_j_rVal.setTextColor(android.graphics.Color.BLACK);
            tv_j_gVal.setTextColor(android.graphics.Color.BLACK);
            tv_j_bVal.setTextColor(android.graphics.Color.BLACK);
            tv_j_hex.setTextColor(android.graphics.Color.BLACK);
            lbl_v_header.setTextColor(android.graphics.Color.BLACK);
            lbl_v_red.setTextColor(android.graphics.Color.BLACK);
            lbl_v_green.setTextColor(android.graphics.Color.BLACK);
            lbl_v_blue.setTextColor(android.graphics.Color.BLACK);
            lbl_v_hex.setTextColor(android.graphics.Color.BLACK);
        }

    }
}