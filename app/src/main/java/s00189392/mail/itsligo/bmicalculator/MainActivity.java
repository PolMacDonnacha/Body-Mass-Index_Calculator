package s00189392.mail.itsligo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {
    EditText heightBox = null;
    EditText weightBox = null;
    double height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightBox = findViewById(R.id.editTextHeight);
        weightBox = findViewById(R.id.editTextWeight);
    }

    public void Calculate(View view) {
        Double heightcm = 0.0;
        Double weight = 0.0;
        Log.i("Value of Height: ", "Value of height before parse++" + heightBox.getText().toString() + "++");// I added "+" to show if there was a value passed
        Log.i("Value of Weight: ", "Value of weight before parse++" + weightBox.getText().toString() + "++");
        boolean weightok = false;
        boolean heightok = false;
        double calculation = 0;
        Intent ResultsPage = new Intent(view.getContext(), BMI_Result.class);
        heightok = tryParseDouble(heightBox.getText().toString());
        weightok = tryParseDouble(weightBox.getText().toString());
        if (weightok && heightok) {
            heightcm = Double.parseDouble(heightBox.getText().toString().trim());
            weight = Double.parseDouble(weightBox.getText().toString().trim());
            Log.i("ValuesParsed", "Weight and height Parsed Successfully ");
            if (weight < 20 || heightcm < 80 || weight > 200 || heightcm > 300) {
                Log.i("Values Under Parameters", "Values did not meet Parameters");
                Toast.makeText(getApplicationContext(),
                        "Incorrect value, please try again.\nMinimum Weight: 20kg\nMaximum Weight: 200kg" +
                                "\nMinimum Height: 80cm\nMaximum Height: 300cm", Toast.LENGTH_LONG).show();
            }






            else if (weight > 20 && weight < 200 || heightcm > 80 && heightcm < 300) {
                Log.i("Values Met Parameters", "Values did meet Parameters");
                height = heightcm / 100;
                calculation = weight / (height * height);
                ResultsPage.putExtra("BMI", calculation);
                startActivity(ResultsPage);
            }







        } else if (!weightok || !heightok) {
            Log.i("Element Missing Value", "Height or Weight input was empty");
            Toast.makeText(getApplicationContext(),
                    "Please enter your height and weight", Toast.LENGTH_LONG).show();
        }
    }

    public void ResetInput(View view) {
        heightBox.setText("");
        weightBox.setText("");
    }

    boolean tryParseDouble(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}