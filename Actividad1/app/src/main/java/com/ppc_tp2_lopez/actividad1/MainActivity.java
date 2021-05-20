package com.ppc_tp2_lopez.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMostrarTexto;
    Button btnCambiarTexto;
    String texto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMostrarTexto = findViewById(R.id.txtMostrarTexto);

        btnCambiarTexto = findViewById(R.id.btnCambiarTexto);
        btnCambiarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtraActivity.class);
                startActivity(intent);
            }
        });

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String datos = parametros.getString("datos");
            texto = datos;
            txtMostrarTexto.setText(texto);
        }
    }
}