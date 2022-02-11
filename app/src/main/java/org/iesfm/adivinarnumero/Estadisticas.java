package org.iesfm.adivinarnumero;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.Format;

public class Estadisticas extends AppCompatActivity {

    private TextView tvAciertos;
    private TextView tvIntentos;
    private TextView tvPorcentajeAciertos;
    private TextView tvMediaIntentos;

    private Integer aciertos;
    private Integer intentos;

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

        tvAciertos.setText(aciertos.toString());
        tvIntentos.setText(intentos.toString());

        DecimalFormat format = new DecimalFormat("#.00");


        Double media = (Double.valueOf(intentos) / Double.valueOf(aciertos));
        Double porcentaje = (Double.valueOf(aciertos) * 100 / Double.valueOf(intentos));

        tvMediaIntentos.setText(format.format(media));
        tvPorcentajeAciertos.setText(format.format(porcentaje) + "%");

    }
}