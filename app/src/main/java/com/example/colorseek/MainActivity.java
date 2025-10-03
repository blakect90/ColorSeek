package com.example.colorseek;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar sb_j_Red;
    SeekBar sb_j_Blue;
    SeekBar sb_j_Green;
    TextView tv_j_rVal;
    TextView tv_j_gVal;
    TextView tv_j_bVal;
    TextView tv_j_hex;
    TextView lbl_j_header;
    TextView lbl_j_red;
    TextView lbl_j_green;
    TextView lbl_j_blue;
    TextView lbl_j_hex;
    Button btn_j_save;
    ListView lv_j_savedColors;
    ArrayList<ColorInfo> colorList = new ArrayList<>();

    ColorListAdapter clAdapter;

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
//GUI Connections==================================================================================
        sb_j_Red = findViewById(R.id.sb_v_Red);
        sb_j_Blue = findViewById(R.id.sb_v_Blue);
        sb_j_Green = findViewById(R.id.sb_v_Green);

        tv_j_rVal = findViewById(R.id.tv_v_rVal);
        tv_j_gVal = findViewById(R.id.tv_v_gVal);
        tv_j_bVal = findViewById(R.id.tv_v_bVal);
        tv_j_hex = findViewById(R.id.tv_v_hex);

        lbl_j_header = findViewById(R.id.lbl_v_header);
        lbl_j_red = findViewById(R.id.lbl_v_red);
        lbl_j_green = findViewById(R.id.lbl_v_green);
        lbl_j_blue = findViewById(R.id.lbl_v_blue);
        lbl_j_hex = findViewById(R.id.lbl_v_hex);

        btn_j_save = findViewById(R.id.btn_v_save);
        lv_j_savedColors = findViewById(R.id.lv_v_savedColors);

        //Custom Adapter TEST=======================================================================
        //String[] test = {"red", "blue", "green"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,test);
        //lv_j_savedColors.setAdapter(adapter);
        //==========================================================================================

        setSeekBarListeners();
        setBackGroundColor();
        setOnClickListener();
        fillListView();
        setOnItemClickListener();
    }

    //ALL SEEKBAR LISTENERS========================================================================
    public void setSeekBarListeners() {
        sb_j_Red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBackGroundColor();
                tv_j_rVal.setText(String.valueOf(progress));
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

    //==============================================================================================

    public void setOnItemClickListener()
    {
        lv_j_savedColors.setOnItemClickListener((parent, view, position, id) -> {

            ColorInfo selectedColor = colorList.get(position);

            sb_j_Red.setProgress(selectedColor.getRed());
            sb_j_Green.setProgress(selectedColor.getGreen());
            sb_j_Blue.setProgress(selectedColor.getBlue());
        });
    }
    public void setBackGroundColor() {
        int red = sb_j_Red.getProgress();
        int green = sb_j_Green.getProgress();
        int blue = sb_j_Blue.getProgress();

        //Set the background color
        findViewById(R.id.main).setBackgroundColor(android.graphics.Color.rgb(red, green, blue));
        //get luminance to determine text color
        double luminance = calcLuminance(red, green, blue);
        //change text color
        changeTextColor(luminance);
        //set hex code
        setHexCode(red, green, blue);
    }

    public void setHexCode(int r, int g, int b) {
        String rHex = String.format("%02X", r);
        String gHex = String.format("%02X", g);
        String bHex = String.format("%02X", b);
        String hex = "#" + rHex + gHex + bHex;
        tv_j_hex.setText(hex);
    }

    //Calculate relative luminance to approximate the lightness/darkness of background color
    public double calcLuminance(int r, int g, int b) {
        return (0.299 * r) + (0.587 * g) + (0.114 * b);
    }

    //Change text color based on relative luminance value
    public void changeTextColor(double luminance) {
        if (luminance < 128) {
            tv_j_rVal.setTextColor(android.graphics.Color.WHITE);
            tv_j_gVal.setTextColor(android.graphics.Color.WHITE);
            tv_j_bVal.setTextColor(android.graphics.Color.WHITE);
            tv_j_hex.setTextColor(android.graphics.Color.WHITE);
            lbl_j_header.setTextColor(android.graphics.Color.WHITE);
            lbl_j_red.setTextColor(android.graphics.Color.WHITE);
            lbl_j_green.setTextColor(android.graphics.Color.WHITE);
            lbl_j_blue.setTextColor(android.graphics.Color.WHITE);
            lbl_j_hex.setTextColor(android.graphics.Color.WHITE);
        } else {
            tv_j_rVal.setTextColor(android.graphics.Color.BLACK);
            tv_j_gVal.setTextColor(android.graphics.Color.BLACK);
            tv_j_bVal.setTextColor(android.graphics.Color.BLACK);
            tv_j_hex.setTextColor(android.graphics.Color.BLACK);
            lbl_j_header.setTextColor(android.graphics.Color.BLACK);
            lbl_j_red.setTextColor(android.graphics.Color.BLACK);
            lbl_j_green.setTextColor(android.graphics.Color.BLACK);
            lbl_j_blue.setTextColor(android.graphics.Color.BLACK);
            lbl_j_hex.setTextColor(android.graphics.Color.BLACK);
        }
    }

    public void setOnClickListener() {
        btn_j_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveColor();
                resetSeekBars();
                fillListView();
            }

        });
    }

    public void saveColor() {
        ColorInfo colorInfo = new ColorInfo();
        colorInfo.setRed(sb_j_Red.getProgress());
        colorInfo.setGreen(sb_j_Green.getProgress());
        colorInfo.setBlue(sb_j_Blue.getProgress());
        colorInfo.setHex(tv_j_hex.getText().toString());
        colorList.add(colorInfo);

        //+*+*+*+*+*+*+*+*+*+*+**TEST SAVE BUTTON+*+*+*+*+*+*+*+*+*+*+*+
        for (int i = 0; i < colorList.size(); i++) {
            Log.d("COLOR", colorList.get(i).getHex());
            Log.d("COLOR", String.valueOf(colorList.get(i).getRed()));
            Log.d("COLOR", String.valueOf(colorList.get(i).getGreen()));
            Log.d("COLOR", String.valueOf(colorList.get(i).getBlue()));
        }
    }

    public void resetSeekBars() {
        sb_j_Red.setProgress(0);
        sb_j_Green.setProgress(0);
        sb_j_Blue.setProgress(0);
    }

    private void fillListView()
    {
        clAdapter = new ColorListAdapter(this, colorList);
        lv_j_savedColors.setAdapter(clAdapter);
    }
}