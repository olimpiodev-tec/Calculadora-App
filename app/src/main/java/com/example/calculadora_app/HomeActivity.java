package com.example.calculadora_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonAdicao = findViewById(R.id.buttonAdicao);
        buttonAdicao.setOnClickListener(this);

        Button buttonSubtracao = findViewById(R.id.buttonSubtracao);
        buttonSubtracao.setOnClickListener(this);

        Button buttonMultiplicacao = findViewById(R.id.buttonMultiplicacao);
        buttonMultiplicacao.setOnClickListener(this);

        Button buttonDivisao = findViewById(R.id.buttonDivisao);
        buttonDivisao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent telaCalcula = new Intent(this, CalculaActivity.class);

        if (v.getId() == R.id.buttonAdicao) {
            telaCalcula.putExtra("parametro", "Somar números");
        } else if (v.getId() == R.id.buttonSubtracao) {
            telaCalcula.putExtra("parametro", "Subtrair números");
        } else if (v.getId() == R.id.buttonMultiplicacao) {
            telaCalcula.putExtra("parametro", "Multiplicar números");
        } else if (v.getId() == R.id.buttonDivisao) {
            telaCalcula.putExtra("parametro", "Dividir números");
        }

        startActivity(telaCalcula);
    }
}