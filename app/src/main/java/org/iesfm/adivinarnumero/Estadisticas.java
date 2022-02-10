package org.iesfm.adivinarnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Estadisticas extends AppCompatActivity {

    private TextView tvAciertos;
    private TextView tvIntentos;
    private TextView tvPorcentajeAciertos;
    private TextView tvMediaIntentos;

    private int aciertos;
    private int intentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        init();

    }

    public void init() {
        tvAciertos = (TextView) findViewById(R.id.e_tvAciertos);
        tvIntentos = (TextView) findViewById(R.id.e_tvIntentos);
        tvPorcentajeAciertos = (TextView) findViewById(R.id.e_tvPorcentajeAciertos);
        tvMediaIntentos = (TextView) findViewById(R.id.e_tvMediaIntentos);
        getInfo();
    }

    public void getInfo() {

        aciertos = getIntent().getIntExtra(MainActivity.ACIERTOS, 0);
        intentos = getIntent().getIntExtra(MainActivity.INTENTOS, 0);

        String aciertosStr = String.valueOf(aciertos);
        String intentosStr = String.valueOf(intentos);

        tvAciertos.setText(aciertosStr);
        tvIntentos.setText(intentosStr);
    }
}