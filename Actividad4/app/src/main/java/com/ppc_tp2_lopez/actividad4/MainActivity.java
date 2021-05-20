package com.ppc_tp2_lopez.actividad4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnCamara;
    ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamara = findViewById(R.id.btnCamara);
        imgFoto = findViewById(R.id.imgFoto);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });
    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);    // Indicamos que se va a usar el componente de la camara.
        if(intent.resolveActivity(getPackageManager()) != null){        // Verificamos que esté instalado el paquete de la camara en el dispositivo.
            startActivityForResult(intent, 1);              // Iniciamos la camara y aguardamos el resultado. El numero 1 es para identificar el requerimiento que pertenece a la camara (en caso que se retornen varios resultados).
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // Al obtener un resultado de una actividad se recibe el código del requerimiento, el código del resultado que indica como salio la operación y el intent con los datos del resultado.
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {              // Verificamos que el código del requerimiento sea el de la camara y que la operación fue satisfactoria.
            Bundle parametros = data.getExtras();                       
            Bitmap foto = (Bitmap) parametros.get("data");
            imgFoto.setImageBitmap(foto);
        }
    }
}