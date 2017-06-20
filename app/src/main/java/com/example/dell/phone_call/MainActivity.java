package com.example.dell.phone_call;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       final EditText editText1=(EditText)findViewById(R.id.editText1);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);

        //Performing action on button click
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                String number= editText1.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
            //    String shareBody = editText1.getText().toString();
                String shareSub = "Your subject here";
            //    String sAux = "\nLet me recommend you this application\n\n";
                String sAux ="https://play.google.com/store/apps/details?id=Orion.Soft \n\n";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,sAux);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));

            }
        });
    }
}
