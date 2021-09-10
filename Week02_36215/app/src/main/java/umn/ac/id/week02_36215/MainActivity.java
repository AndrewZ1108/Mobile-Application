package umn.ac.id.week02_36215;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText text1, text2;
    Button tambah, kurang, kali, bagi;
    TextView textjumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(EditText) findViewById(R.id.editText1);
        text2=(EditText) findViewById(R.id.editText2);
        textjumlah=(TextView) findViewById(R.id.jumlah);
        tambah=(Button) findViewById(R.id.Tambah);
        kurang=(Button) findViewById(R.id.Kurang);
        kali=(Button) findViewById(R.id.Kali);
        bagi=(Button) findViewById(R.id.Bagi);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, hasil;
                bil1=Double.valueOf(text1.getText().toString().trim());
                bil2=Double.valueOf(text2.getText().toString().trim());
                hasil=bil1+bil2;
                String hasil1=String.valueOf(hasil);
                textjumlah.setText(hasil1);
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, hasil;
                bil1=Double.valueOf(text1.getText().toString().trim());
                bil2=Double.valueOf(text2.getText().toString().trim());
                hasil=bil1-bil2;
                String hasil1=String.valueOf(hasil);
                textjumlah.setText(hasil1);
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, hasil;
                bil1=Double.valueOf(text1.getText().toString().trim());
                bil2=Double.valueOf(text2.getText().toString().trim());
                hasil=bil1*bil2;
                String hasil1=String.valueOf(hasil);
                textjumlah.setText(hasil1);
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bil1, bil2, hasil;
                bil1=Double.valueOf(text1.getText().toString().trim());
                bil2=Double.valueOf(text2.getText().toString().trim());
                hasil=bil1/bil2;
                String hasil1=String.valueOf(hasil);
                textjumlah.setText(hasil1);
            }
        });
    }
}