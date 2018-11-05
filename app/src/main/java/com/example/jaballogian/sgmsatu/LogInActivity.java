package com.example.jaballogian.sgmsatu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    private Button masukDenganGoogle;
    private EditText masukanEmail, masukanPassword;
    private TextView belumPunyaAkun;

    private ProgressDialog logInProgressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        masukDenganGoogle = (Button) findViewById(R.id.masukDenganGoogleButtonLogInActivity);

        masukanEmail = (EditText) findViewById(R.id.emailEditTextLogInActivity);
        masukanPassword = (EditText) findViewById(R.id.passwordEditTextLogInActivity);

        belumPunyaAkun = (TextView) findViewById(R.id.belumPunyaAkunTextViewLogInActivity);

        logInProgressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        belumPunyaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegisterActivity = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(toRegisterActivity);
                finish();
            }
        });

        masukDenganGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = masukanEmail.getText().toString();
                String password = masukanPassword.getText().toString();

                logInProgressDialog.setTitle("Pengecekan Data");
                logInProgressDialog.setMessage("Mohon menunggu hingga proses selesai");
                logInProgressDialog.setCanceledOnTouchOutside(false);
                logInProgressDialog.show();

                if(email.isEmpty() ||  password.isEmpty()){

                    logInProgressDialog.hide();

                    Toast.makeText(LogInActivity.this, "Tidak boleh ada data yang kosong", Toast.LENGTH_LONG).show();
                }
                else {

                    logInUser(email, password);
                }
            }
        });
    }

    private void logInUser(final String logInEmail, final String logInPassword){

        mAuth.signInWithEmailAndPassword(logInEmail, logInPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    logInProgressDialog.dismiss();

                    Intent toMainActivity = new Intent(LogInActivity.this, MainActivity.class);
                    toMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(toMainActivity);
                    finish();
                }
                else{

                    logInProgressDialog.hide();

                    Toast.makeText(LogInActivity.this, "Mohon maaf, Anda gagal masuk. Mohon coba lagi", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
