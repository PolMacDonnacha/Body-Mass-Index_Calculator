package s00189392.mail.itsligo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class BMI_Result extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        double bmi = getIntent().getDoubleExtra("BMI",-1);

        TextView Result, Message;
        ConstraintLayout background;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i__result);
        background = findViewById(R.id.appBackground);
        background.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        Result = findViewById(R.id.ResultCategory);
        Message = findViewById(R.id.BMIresult);
        if (bmi != -1)
        {
            DecimalFormat myFormat = new DecimalFormat("0.0");
            String BMI = myFormat.format(bmi);
            String bmiUnderweight = "Your BMI is " + BMI + ", you are in the underweight range.";
            String bmiHealthy = "Your BMI is " + BMI + ", you are in the healthy weight range.";
            String bmiOverweight = "Your BMI is " + BMI + ", you are in the overweight range.";
            if (bmi < 18.5)
            {
                Result.setText("Underweight");
                Message.setText(bmiUnderweight);
                background.setBackgroundColor(Color.parseColor("#FF0B40C6"));
            }
            if (bmi >= 18.5 && bmi <= 24.9)
            {
                Result.setText("Healthy");
                Message.setText(bmiHealthy);
                background.setBackgroundColor(Color.parseColor("#FF3DCD15"));
            }
            if (bmi >= 25)
            {
                Result.setText("Overweight");
                Message.setText(bmiOverweight);
                background.setBackgroundColor(Color.parseColor("#FFB10606"));
            }
        }
    }
    public void Finish(View view)
    {
        Intent MainActivity = new Intent(view.getContext(),MainActivity.class);
        startActivity(MainActivity);
    }
}