package com.example.lackofvision;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText inputFirstName, inputLastName, inputPassword, inputemail, inputAge, inputphone_no, inputUsername;
    RadioGroup gender;
    Button buttonRegister;
    String phonenumber;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputphone_no = findViewById(R.id.phone);
        inputUsername = findViewById(R.id.uname_txt);
        inputFirstName = findViewById(R.id.fname_txt);
        inputLastName=findViewById(R.id.lname_txt);
        inputAge=findViewById(R.id.age_txt);
        gender=findViewById(R.id.gender);
        inputemail = findViewById(R.id.email_txt);
        inputPassword = findViewById(R.id.password_txt);


        // linklogin = findViewById(R.id.lnkLogin);

        buttonRegister = findViewById(R.id.btnregister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int selectedId = gender.getCheckedRadioButtonId();
                radioButton = findViewById(selectedId);


                if (inputUsername.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                }else if (inputFirstName.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter first name", Toast.LENGTH_SHORT).show();
                }else if (inputLastName.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter Last name", Toast.LENGTH_SHORT).show();
                }else if (inputemail.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                }else if (selectedId == -1) {
                    Toast.makeText(RegisterActivity.this, "Enter gender", Toast.LENGTH_SHORT).show();
                }else if (inputAge.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter Age", Toast.LENGTH_SHORT).show();
                }else if (inputPassword.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                } else {


                    //we take here the value of phone number
                    phonenumber=getIntent().getStringExtra("mobile");
                    inputphone_no.setText(phonenumber);


                    //validate email

                    String emailToText = inputemail.getText().toString();

                    if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()){


                        HashMap<String, String> params = new HashMap<>();
                        params.put("phone_no",inputphone_no.getText().toString() );
                        params.put("User_name", inputUsername.getText().toString());
                        params.put("Gender", radioButton.getText().toString());
                        params.put("first_name", inputFirstName.getText().toString());
                        params.put("last_name", inputLastName.getText().toString());
                        params.put("age", inputAge.getText().toString());
                        params.put("email", inputemail.getText().toString());
                        params.put("u_password", inputPassword.getText().toString());
                        register(params);

                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Enter valid Email address !",Toast.LENGTH_SHORT).show();
                    }


                }

            }

        });

    }



    private void register(HashMap<String, String> params) {

        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Registering...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        NetworkService networkService = NetworkClient.getClient().create(NetworkService.class);
        Call<RegistrationResponseModel> registerCall = networkService.register(params);
        registerCall.enqueue(new Callback<RegistrationResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponseModel> call, @NonNull Response<RegistrationResponseModel> response) {
                RegistrationResponseModel responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {
                        Toast.makeText(RegisterActivity.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,userhome.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationResponseModel> call, @NonNull Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

}