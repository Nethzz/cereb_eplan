package com.campusiq.cereb_eplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText et_name,et_designation,et_username,et_password,et_email,et_phone;
    Button btnRegister,btncancel;
//    private static final String url="http://10.0.1.7:8888/cerebtech/cereb_emp_reg.php";
private static final String url="http://10.0.1.5:8888/Cereb_eplan/insert.php";
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        et_name=findViewById(R.id.editText);
        et_designation=findViewById(R.id.editText4);
        et_username=findViewById(R.id.editText5);
        et_password=findViewById(R.id.editText7);
        et_phone=findViewById(R.id.editText8);
        et_email=findViewById(R.id.editText9);
        btnRegister=findViewById(R.id.buttonReg);
        btncancel=findViewById(R.id.buttonCan);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "Registration Succesfully", Toast.LENGTH_SHORT).show();



                user=new User();

                user.setName(et_name.getText().toString());
                user.setDesignation(et_designation.getText().toString());
                user.setEmail(et_email.getText().toString());
                user.setPhone(et_phone.getText().toString());
                user.setUsername(et_username.getText().toString());
                user.setPass(et_password.getText().toString());


                Map<String,String> params=new HashMap<>();


                params.put("name",user.getName());
                params.put("designation",user.getDesignation());
                params.put("email",user.getEmail());
                params.put("phone",user.getPhone());
               // params.put("phone",String.valueOf(user.getPhone()));
                params.put("username",user.getUsername());
                params.put("password",user.getPass());

                JSONObject jsonObject=new JSONObject(params);

                JsonObjectRequest jsonObjectRequset=new JsonObjectRequest(Request.Method.POST,url,jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        et_name.setText("");
                        et_designation.setText("");
                        et_email.setText("");
                        et_phone.setText("");
                        et_username.setText("");
                        et_password.setText("");
                        try {
                            String op=response.getString("message");
                            if (op.equals("success"))
                            {
                                Toast.makeText(RegisterActivity.this,"success",Toast.LENGTH_LONG).show();

                            }
                            else
                            {
                                Toast.makeText(RegisterActivity.this,"failure",Toast.LENGTH_LONG).show();

                            }

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(RegisterActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map <String,String> headers = new HashMap<>();
                        headers.put("Content-Type","application/json;charset=UTF-8");
                        return headers;
                    }

                    @Override
                    public String getPostBodyContentType() {
                        return "application/json;charset=UTF-8";
                    }
                };
                Volley.newRequestQueue(RegisterActivity.this).add(jsonObjectRequset);

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Registration Canceled", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
