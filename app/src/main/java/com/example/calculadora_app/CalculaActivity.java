package com.example.calculadora_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculaActivity extends AppCompatActivity implements View.OnClickListener {

    private String parametro = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcula);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(this);

        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonCalcular.setOnClickListener(this);

        TextView textViewTitulo = findViewById(R.id.textViewTitulo);

        Intent telaHome = getIntent();
        this.parametro = telaHome.getStringExtra("parametro");
        textViewTitulo.setText(this.parametro);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonVoltar) {
            finish();
        } else if (v.getId() == R.id.buttonCalcular) {
            EditText editTextPrimeiroNumero = findViewById(R.id.editTextPrimeiroNumero);
            EditText editTextSegundoNumero = findViewById(R.id.editTextSegundoNumero);

            int n1 = Integer.parseInt(editTextPrimeiroNumero.getText().toString());
            int n2 = Integer.parseInt(editTextSegundoNumero.getText().toString());
            int resultado = 0;

            switch (parametro) {
                case "Somar números":
                    resultado = n1 + n2;
                    break;
                case "Subtrair números":
                    resultado = n1 - n2;
                    break;
                case "Multiplicar números":
                    resultado = n1 * n2;
                    break;
                case "Dividir números" :
                    resultado = n1 / n2;
                    break;
                default:
                    break;
            }

            Toast.makeText(this, "O resultado da operação é " + resultado, Toast.LENGTH_LONG).show();
        }
    }
}