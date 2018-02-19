package com.campusiq.cereb_eplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eusername,epassword;
    Button btnlogin;
    TextView txtpass,txtregister;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eusername=findViewById(R.id.editText2);
        epassword=findViewById(R.id.editText3);
        btnlogin=findViewById(R.id.button);
        txtpass=findViewById(R.id.textView);
        txtregister=findViewById(R.id.textView2);



        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {




                if(eusername.getText().toString().equals("admin") && epassword.getText().toString().equals("admin"))
                {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                    intent=new Intent(MainActivity.this,AdminActivity.class);
                    startActivity(intent);

                }


                else
                {
                    Toast.makeText(getApplicationContext(), "please enter correct username and password",Toast.LENGTH_SHORT).show();
                }




            }
        });




        txtpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_EMAIL , new String[]{"recipient@example.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });



        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });



    }
    }

