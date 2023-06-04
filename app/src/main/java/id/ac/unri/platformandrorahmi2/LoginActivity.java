package id.ac.unri.platformandrorahmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText email, pass;
    TextView btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnSignup = findViewById(R.id.btnsignup);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str_nama = getIntent().getExtras().getString("nama");
                    String str_email = getIntent().getExtras().getString("email");
                    String str_lahir = getIntent().getExtras().getString("lahir");

                    String str_uname = getIntent().getExtras().getString("uname");
                    String str_pass = getIntent().getExtras().getString("pass");
                    if (email.getText().toString().equals(str_uname) && pass.getText().toString().equals(str_pass)){
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("email", str_email);
                        intent.putExtra("nama", str_nama);
                        intent.putExtra("lahir", str_lahir);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "wrong username or password...", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "you are not registered yet...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}