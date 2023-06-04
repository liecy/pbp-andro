package id.ac.unri.platformandrorahmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText nama, email, uname, pass, passRepeat, date, tanggalLahir;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        nama = findViewById(R.id.fullname);
        tanggalLahir = findViewById(R.id.birthdate);
        email = findViewById(R.id.email);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.password);
        passRepeat = findViewById(R.id.passwordrepeat);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str_pass = pass.getText().toString();
                    String str_passRepeat = passRepeat.getText().toString();

                    if (str_pass.equals(str_passRepeat)){
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.putExtra("nama", nama.getText().toString().trim());
                        intent.putExtra("lahir", tanggalLahir.getText().toString().trim());
                        intent.putExtra("email", email.getText().toString().trim());
                        intent.putExtra("uname", uname.getText().toString().trim());
                        intent.putExtra("pass", pass.getText().toString().trim());
                        intent.putExtra("password", pass.getText().toString().trim());

                        startActivity(intent);
                        finish();

                    }else{
                        Toast.makeText(RegisterActivity.this, "password tidak sama...", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception a){

                }



            }
        });

        //Input Tanggal Lahir Menggunakan Format DD/MM/YYYY
        date = (EditText)findViewById(R.id.birthdate);
        date.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]", "");
                    String cleanC = current.replaceAll("[^\\d.]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        if(mon > 12) mon = 12;
                        cal.set(Calendar.MONTH, mon-1);

                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    date.setText(current);
                    date.setSelection(sel < current.length() ? sel : current.length());
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}

        });
    }
}