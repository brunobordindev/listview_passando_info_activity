package com.example.listview_passandoinformacoesactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ConfiguracaoActivity extends AppCompatActivity {

    private TextInputEditText campNome, campSobrenome, campIdade, campEmail;
    private Button btnSalvar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        campNome = findViewById(R.id.config_nome);
        campSobrenome = findViewById(R.id.config_sobrenome);
        campIdade = findViewById(R.id.config_idade);
        campEmail = findViewById(R.id.config_email);
        btnSalvar = findViewById(R.id.btnSalvar);

        intent = getIntent();

        String idade = Integer.toString(intent.getExtras().getInt("idade"));

        campNome.setText(intent.getExtras().getString("nome"));
        campSobrenome.setText(intent.getExtras().getString("sobrenome"));
        campIdade.setText(idade);
        campEmail.setText(intent.getExtras().getString("email"));

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("renomeadoNome", campNome.getText().toString());
                intent.putExtra("renomeadoSobrenome", campSobrenome.getText().toString());
                intent.putExtra("renomeadoIdade", campIdade.getText().toString());
                intent.putExtra("renomeadoEmail", campEmail.getText().toString());
                setResult(1, intent);
                finish();
            }
        });
    }
}