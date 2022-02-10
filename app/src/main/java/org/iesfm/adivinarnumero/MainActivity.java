package org.iesfm.adivinarnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int numeroIntentos;
    private int numeroAciertos;
    private EditText etNumeroIntrodcucido;
    private int numeroAleatorio;
    private Button btnRetry;

    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        etNumeroIntrodcucido = (EditText) findViewById(R.id.etuNumeroIntroducido);
        Random random = new Random();
        numeroAleatorio = random.nextInt(100) + 1;

        pref = getSharedPreferences(getString(R.string.pref_name_file), Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putInt(getString(R.string.pref_numero), numeroAleatorio);
        editor.commit();
        btnRetry = (Button) findViewById(R.id.btnVolverAJugar);
        btnRetry.setVisibility(View.GONE);
    }

    public void validarNumero(View v) {
        int numeroIntroducido = Integer.parseInt(etNumeroIntrodcucido.getText().toString());
        if (pref.getInt(getString(R.string.pref_numero), numeroAleatorio) == numeroIntroducido) {
            Toast.makeText(this, getString(R.string.mensaje_acierto), Toast.LENGTH_SHORT).show();
            numeroAciertos++;
            btnRetry.setVisibility(View.VISIBLE);
        } else if (pref.getInt(getString(R.string.pref_numero), numeroAleatorio) > numeroIntroducido) {
            Toast.makeText(this, getString(R.string.mensaje_mayor), Toast.LENGTH_SHORT).show();
            numeroIntentos++;
        } else {
            Toast.makeText(this, getString(R.string.mensaje_menor), Toast.LENGTH_SHORT).show();
            numeroIntentos++;
        }
        editor.putInt(getString(R.string.pref_aciertos), numeroAciertos);
        editor.putInt(getString(R.string.pref_errores), numeroIntentos);
        editor.commit();
        etNumeroIntrodcucido.setText("");
    }

    public void volverAJugar(View v) {
        Random random = new Random();
        numeroAleatorio = random.nextInt(100) + 1;
        editor.putInt(getString(R.string.pref_numero), numeroAleatorio);
        editor.commit();
        btnRetry.setVisibility(View.GONE);
    }
}


























