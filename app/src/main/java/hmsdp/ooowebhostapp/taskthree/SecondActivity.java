package hmsdp.ooowebhostapp.taskthree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textview, secondTextview, thirdTetxView, fourthTextview, fifthTexview, eName, eSlackID, eEmail, eTracks, price;
    String stringAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //finding views by id

        textview = findViewById(R.id.textView);
        secondTextview = findViewById(R.id.textView2);
        thirdTetxView = findViewById(R.id.textView3);
        fourthTextview = findViewById(R.id.textView4);
        fifthTexview = findViewById(R.id.textView5);

        eName = findViewById(R.id.name);
        eSlackID = findViewById(R.id.slackId);
        eEmail = findViewById(R.id.emailAddress);
        eTracks = findViewById(R.id.tracks);

        price = findViewById(R.id.totalPrice);



        //getting text from the first activity
        stringAgain = getIntent().getExtras().getString("value");
        textview.setText(stringAgain);

        stringAgain = getIntent().getExtras().getString("value2");
        secondTextview.setText(stringAgain);

        stringAgain = getIntent().getExtras().getString("value3");
        thirdTetxView.setText(stringAgain);

        stringAgain = getIntent().getExtras().getString("value4");
        fourthTextview.setText(stringAgain);

        stringAgain = getIntent().getExtras().getString("value5");
        fifthTexview.setText(stringAgain);

        stringAgain = getIntent().getExtras().getString("value6");
        price.setText(stringAgain);


       ImageButton buttonShare = findViewById(R.id.button_share);
       buttonShare.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               shareData();
           }
       });

    }


    //method to share data to email
    private void shareData(){
         String subject = eName.getText().toString();
         String subject2 = eSlackID.getText().toString();
         String subject3 = eEmail.getText().toString();
         String subject4 = eTracks.getText().toString();



        String message = textview.getText().toString();
        String message2 = secondTextview.getText().toString();
        String message3 = thirdTetxView.getText().toString();
        String message4 = fourthTextview.getText().toString();
        String message5 = fifthTexview.getText().toString();
        String message6 = price.getText().toString();


         Intent intent =  new Intent(Intent.ACTION_SEND);
         intent.putExtra(Intent.EXTRA_SUBJECT, subject + "\n" + subject2 + "\n" + subject3 + "\n" + subject4);
         intent.putExtra(Intent.EXTRA_TEXT, message +"\n" + message2 +"\n" + message3 +"\n" + message4 +"\n" + message5 + "\n" + message6);


         intent.setType("message/rfc822");
         startActivity(Intent.createChooser(intent, "choose a email client"));
    }
}
