package com.ppc_tp2_lopez.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    Button btnOk, btnCancel;
    TextView txtIngresarTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);

        txtIngresarTexto = findViewById(R.id.txtIngresarTexto);

        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datos = txtIngresarTexto.getText().toString();

                Bundle parmetros = new Bundle();
                parmetros.putString("datos", datos);

                Intent intent = new Intent(OtraActivity.this, MainActivity.class);
                intent.putExtras(parmetros);
                startActivity(intent);
            }
        });

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}