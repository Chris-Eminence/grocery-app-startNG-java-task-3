package hmsdp.ooowebhostapp.taskthree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstEditText, firstQuantity, secondEditText, secondQuantity, thirdEditText, thirdQuantity, fourthEditText, fourthQuantity, fifthEditText, fifthQuantity;
    String stringValue;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstEditText = findViewById(R.id.firstItem);
        secondEditText = findViewById(R.id.secondItem);
        thirdEditText = findViewById(R.id.thirdItem);
        fourthEditText = findViewById(R.id.fourthItem);
        fifthEditText = findViewById(R.id.fifthItem);


        firstQuantity = findViewById(R.id.firstItemQuantity);
        secondQuantity = findViewById(R.id.secondItemQuantity);
        thirdQuantity = findViewById(R.id.thirdItemQuantity);
        fourthQuantity = findViewById(R.id.fourthItemQuantity);
        fifthQuantity = findViewById(R.id.fifthItemQuantity);
        result = findViewById(R.id.calculatePrice);


    }

    public void proceed(View view) {

        int firstNumber = Integer.parseInt(firstQuantity.getText().toString());
        int secondNumber = Integer.parseInt(secondQuantity.getText().toString());
        int thirdNumber = Integer.parseInt(thirdQuantity.getText().toString());
        int fourthNumber = Integer.parseInt(fourthQuantity.getText().toString());
        int fifthNumber = Integer.parseInt(fifthQuantity.getText().toString());

        int calculation = firstNumber * 100 + secondNumber * 100 + thirdNumber * 100 + fourthNumber * 100 + fifthNumber * 100;
        result.setText("Total amount of goods: " + (calculation));



        Intent intent = new Intent(this, SecondActivity.class);
        stringValue = firstEditText.getText().toString();
        intent.putExtra("value", stringValue);

        stringValue = secondEditText.getText().toString();
        intent.putExtra("value2", stringValue);

        stringValue = thirdEditText.getText().toString();
        intent.putExtra("value3", stringValue);

        stringValue = fourthEditText.getText().toString();
        intent.putExtra("value4", stringValue);

        stringValue = fifthEditText.getText().toString();
        intent.putExtra("value5", stringValue);

        stringValue = result.getText().toString();
        intent.putExtra("value6", stringValue);


        startActivity(intent);
    }
}
