package com.example.jaballogian.sgmsatu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private Button buatAkun;
    private CheckBox persetujuan;
    private EditText masukanNamaLengkap, masukanNoTelpon, masukanEmail, masukanProvinsi, masukanKabupatenKota, masukanAlamat, masukanUsername, masukanPassword, masukanUlangiPassword;
    private RadioButton radioButtonJenisKelamin, radioButtonOpsiAkun;
    private RadioGroup radioGroupJenisKelamin, radioGroupOpsiAkun;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private ProgressDialog pembuatanProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buatAkun = (Button) findViewById(R.id.buatAkunButtonRegisterActivity);

        persetujuan = (CheckBox) findViewById(R.id.persetujuanCheckBoxRegisterActivity);

        masukanNamaLengkap = (EditText) findViewById(R.id.namaLengkapEditTextRegisterActivity);
        masukanNoTelpon = (EditText) findViewById(R.id.noTelponEditTextRegisterActivity);
        masukanEmail = (EditText) findViewById(R.id.emailEditTextRegisterActivity);
        masukanProvinsi = (EditText) findViewById(R.id.provinsiEditTextRegisterActivity);
        masukanKabupatenKota = (EditText) findViewById(R.id.kabupatenKotaEditTextRegisterActivity);
        masukanAlamat = (EditText) findViewById(R.id.alamatEditTextRegisterActivity);
        masukanUsername = (EditText) findViewById(R.id.usernameEditTextRegisterActivity);
        masukanPassword = (EditText) findViewById(R.id.passwordEditTextRegisterActivity);
        masukanUlangiPassword = (EditText) findViewById(R.id.ulangiPasswordEditTextRegisterActivity);

        radioGroupJenisKelamin = (RadioGroup) findViewById(R.id.jenisKelaminRadioGroupRegisterActivity);

        radioGroupOpsiAkun = (RadioGroup) findViewById(R.id.opsiAkunRadioGroupRegisterAcitvity);

        mAuth = FirebaseAuth.getInstance();

        pembuatanProgressDialog = new ProgressDialog(this);

        buatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //convert all editText to String
                String namaLengkap = masukanNamaLengkap.getText().toString();
                String noTelpon = masukanNoTelpon.getText().toString();
                String email = masukanEmail.getText().toString();
                String provinsi = masukanProvinsi.getText().toString();
                String kabupatenKota = masukanKabupatenKota.getText().toString();
                String alamat = masukanAlamat.getText().toString();
                String username = masukanUsername.getText().toString();
                String password = masukanPassword.getText().toString();
                String ulangiPassword = masukanUlangiPassword.getText().toString();

                int radioJenisKelamin = radioGroupJenisKelamin.getCheckedRadioButtonId();
                radioButtonJenisKelamin = (RadioButton) findViewById(radioJenisKelamin);
                String jenisKelamin = (String) radioButtonJenisKelamin.getText();

                int radioOpsiUser = radioGroupOpsiAkun.getCheckedRadioButtonId();
                radioButtonOpsiAkun = (RadioButton) findViewById(radioOpsiUser);
                String opsiUser = (String) radioButtonOpsiAkun.getText();

                //check the checkbox
                if(persetujuan.isChecked()){

                    //check all of the fields
                    if(namaLengkap.isEmpty() || noTelpon.isEmpty() || email.isEmpty() || provinsi.isEmpty() || kabupatenKota.isEmpty() || alamat.isEmpty() || username.isEmpty() ||
                            password.isEmpty() || ulangiPassword.isEmpty() || radioGroupJenisKelamin.getCheckedRadioButtonId() == -1 || radioGroupOpsiAkun.getCheckedRadioButtonId() == -1){

                        Toast.makeText(RegisterActivity.this, "Tidak boleh ada data yang kosong",Toast.LENGTH_LONG).show();
                    }
                    else {

                        //check the password and confirmation
                        if(password.equals(ulangiPassword)){

                            //process the registration
                            registerUser(namaLengkap, noTelpon, email, provinsi, kabupatenKota, alamat, username, password, ulangiPassword, jenisKelamin, opsiUser);

                            pembuatanProgressDialog.setTitle("Pendaftaran Sedang Diproses");
                            pembuatanProgressDialog.setMessage("Mohon menunggu hingga pendaftaran selesai");
                            pembuatanProgressDialog.setCanceledOnTouchOutside(false);
                            pembuatanProgressDialog.show();
                        }
                        else {

                            Toast.makeText(RegisterActivity.this, "Password dan Konfirmasi Password harus sama", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else{

                    Toast.makeText(RegisterActivity.this, "Anda harus menyetujui persyaratan", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void registerUser(final String namaLengkap, final String noTelpon, final String email, final String provinsi, final String kabupatenKota, final String alamat, final String username,
                              final String password, final String ulangiPassword, final String jenisKelamin, final String opsiUser) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    //save data to database
                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    String uID = currentUser.getUid();

                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uID);

                    HashMap<String, String> identitasUser = new HashMap<>();
                    identitasUser.put("Nama Lengkap", namaLengkap);
                    identitasUser.put("No Telpon", noTelpon);
                    identitasUser.put("Email", email);
                    identitasUser.put("Provinsi", provinsi);
                    identitasUser.put("Kabupaten Kota", kabupatenKota);
                    identitasUser.put("Alamat", alamat);
                    identitasUser.put("Username", username);
                    identitasUser.put("Password", password);
                    identitasUser.put("Ulangi Password", ulangiPassword);
                    identitasUser.put("Jenis Kelamin", jenisKelamin);
                    identitasUser.put("Opsi User", opsiUser);
                    identitasUser.put("Point", "100");

                    mDatabase.setValue(identitasUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){

                                pembuatanProgressDialog.dismiss();

                                Intent toMainActivity = new Intent(RegisterActivity.this, MainActivity.class);
                                toMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(toMainActivity);
                                finish();
                            }

                        }
                    });
                }
                else {

                    pembuatanProgressDialog.hide();

                    Toast.makeText(RegisterActivity.this, "Maaf ada masalah pada proses registrasi, mohon coba lagi" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
