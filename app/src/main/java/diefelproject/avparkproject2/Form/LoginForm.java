package diefelproject.avparkproject2.Form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import diefelproject.avparkproject2.AvparkMainActivity;
import diefelproject.avparkproject2.R;
import diefelproject.avparkproject2.SharedPreference.SessionManager;

/**
 * Created by macbook on 9/12/16.
 */
public class LoginForm extends AppCompatActivity {
    SessionManager session;

    EditText loginemail, loginpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_loginavpark);

        session = new SessionManager(getApplicationContext());

        loginemail = (EditText)findViewById(R.id.loginemail);
        loginpassword = (EditText)findViewById(R.id.loginpassword);
    }

    public void onLoginClick (View v)
    {
        final String etemail = loginemail.getText().toString();
        final String etpassword = loginpassword.getText().toString();

        if (etemail.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Email Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
        }
        else if (etemail.contains(" "))
        {
            Toast.makeText(getApplicationContext(),"Email Tidak Boleh Menggunakan Spasi",Toast.LENGTH_SHORT).show();
        }
        else if (!etemail.contains("@"))
        {
            Toast.makeText(getApplicationContext(),"Email Harus Mengandung @", Toast.LENGTH_SHORT).show();
        }
        else if (etpassword.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Password Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i = new Intent(getApplicationContext(), AvparkMainActivity.class);
            startActivity(i);
            finish();

            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
            session.createLoginSession(etemail,"txtEmail");
        }
    }

    public void onLoginRegisterClick(View v)
    {
        if (v.getId() == R.id.loginregister)
        {
            Intent i = new Intent(getApplicationContext(), RegisterForm.class);
            startActivity(i);
            finish();
        }
    }

    //action buat google account
    public void onLoginGoogleClick(View v)
    {
        if (v.getId() == R.id.logingoogle)
        {
            Toast.makeText(getApplicationContext(),"Login With Google Account", Toast.LENGTH_SHORT).show();
        }
    }


}
