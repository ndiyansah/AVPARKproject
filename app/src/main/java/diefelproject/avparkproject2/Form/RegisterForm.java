package diefelproject.avparkproject2.Form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import diefelproject.avparkproject2.R;
import diefelproject.avparkproject2.SharedPreference.AlertDialogManager;

/**
 * Created by macbook on 9/12/16.
 */
public class RegisterForm extends AppCompatActivity {
    AlertDialogManager alert;

    TextView result_gender;
    EditText registeremail, registerpassword, registerconfirmpassword, registerhp;
    Button registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_registeravpark);

        registeremail = (EditText) findViewById(R.id.registeremail);
        registerpassword = (EditText) findViewById(R.id.registerpassword);
        registerconfirmpassword = (EditText) findViewById(R.id.registerconfirmPassword);
        registerhp = (EditText) findViewById(R.id.registerhp);
        result_gender = (TextView) findViewById(R.id.selectedGender);
        registerbutton = (Button) findViewById(R.id.registerbutton);
    }

    public void onRegisterClick(View v) {
        final String etemail = registeremail.getText().toString();
        final String etpass = registerpassword.getText().toString();
        final String etcpass = registerconfirmpassword.getText().toString();
        final String rbgender = result_gender.getText().toString();
        final String ethp = registerhp.getText().toString();

        if (etemail.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Email Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this,"Register Failed ...","Email Tidak Boleh Kosong",false);
        } else if (etemail.contains(" ")) {
            Toast.makeText(getApplicationContext(), "Email Tidak Boleh Menggunakan Spasi", Toast.LENGTH_SHORT).show();
        } else if (!etemail.contains("@")) {
            Toast.makeText(getApplicationContext(), "Email Wajib Mengandung @", Toast.LENGTH_SHORT).show();
        } else if (!etemail.contains(".")) {
            Toast.makeText(getApplicationContext(), "Email Wajib Mengandung . ", Toast.LENGTH_SHORT).show();
        } else if (etemail.length() < 8) {
            Toast.makeText(getApplicationContext(), "Email Minimal Terdiri Dari 8 Karakter", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Email Minimal Terdiri Dari 8 Karakter", false);
        } else if (etpass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Password Harus Di Isi", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Password Harus Di Isi", false);
        } else if (etpass.length() < 5) {
            Toast.makeText(getApplicationContext(), "Password Minimal Terdiri Dari 5 Karakter", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Password Minimal Terdiri Dari 5 Karakter", false);
        } else if (etcpass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Confirm Password Harus Di Isi", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Confirm Password Harus Di Isi", false);
        } else if (etcpass.length() < 5) {
            Toast.makeText(getApplicationContext(), "Confirm Password Minimal Terdiri Dari 5 Karakter", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Confirm Password Minimal Terdiri Dari 5 Karakter", false);
        } else if (etpass == etcpass) {
            Toast.makeText(getApplicationContext(), "Confirm Password Harus Sama Dengan Password", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Confirm Password Harus Sama Dengan Password", false);
        } else if (ethp.length() < 5) {
            Toast.makeText(getApplicationContext(), "Nomor Telp Minimal Terdiri Dari 5 Karakter", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Nomor Telp Minimal Terdiri Dari 5 Karakter", false);
        } else if (rbgender.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Gender Harus Di Pilih", Toast.LENGTH_SHORT).show();
            //alert.showAlertDialog(RegisterForm.this, "Register Failed..", "Gender Harus Di Pilih", false);
        } else {
            Intent i = new Intent(getApplicationContext(), LoginForm.class);
            startActivity(i);
            finish();

            Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRegisterLoginClick(View v) {
        if (v.getId() == R.id.registerlogin) {
            Intent i = new Intent(getApplicationContext(), LoginForm.class);
            startActivity(i);
            finish();
        }
    }

    public void onClickGender(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()) {
            case R.id.RBmale:
                if (checked) {
                    result_gender.setText("Male");
                    result_gender.setEnabled(true);
                } else {
                    result_gender.setEnabled(false);
                }
                break;

            case R.id.RBfemale:
                if (checked) {
                    result_gender.setText("Female");
                    result_gender.setEnabled(true);
                } else {
                    result_gender.setEnabled(false);
                }
                break;
        }
    }
}
