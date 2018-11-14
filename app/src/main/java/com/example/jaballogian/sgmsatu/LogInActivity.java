package com.example.jaballogian.sgmsatu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LogInActivity extends AppCompatActivity {

    private Button logInBIasa;
    private EditText masukanEmail, masukanPassword;
    private TextView belumPunyaAkun;

    private SignInButton masukDenganGoogle;

    private ProgressDialog logInProgressDialog;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private static final int RC_SIGN_IN = 1;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        logInBIasa = (Button) findViewById(R.id.logInButtonLogInActivity);

        masukDenganGoogle = (SignInButton) findViewById(R.id.masukDenganGoogleButtonLogInActivity);

        masukanEmail = (EditText) findViewById(R.id.emailEditTextLogInActivity);
        masukanPassword = (EditText) findViewById(R.id.passwordEditTextLogInActivity);

        belumPunyaAkun = (TextView) findViewById(R.id.belumPunyaAkunTextViewLogInActivity);

        logInProgressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(LogInActivity.this, MainActivity.class));
                }
            }
        };

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                        Toast.makeText(LogInActivity.this, "Maaf ada kesalahan", Toast.LENGTH_LONG).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        masukDenganGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn();
            }
        });

        belumPunyaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegisterActivity = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(toRegisterActivity);
                finish();
            }
        });

        logInBIasa.setOnClickListener(new View.OnClickListener() {
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

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(LogInActivity.this, "Sign In dengan Google gagal", Toast.LENGTH_LONG).show();
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Toast.makeText(LogInActivity.this, "Selamat Datang", Toast.LENGTH_LONG).show();
                        }
                        else {

                            Toast.makeText(LogInActivity.this, "Authentication failed", Toast.LENGTH_LONG).show();
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
