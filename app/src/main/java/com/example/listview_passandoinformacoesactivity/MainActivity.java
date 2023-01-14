package com.example.listview_passandoinformacoesactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campNome, campSobrenome, campIdade, campEmail;
    private Button btnCadastrar;
    private ListView listView;
    ArrayList<User> listaUsuario;
    ArrayAdapter<User> adapter;
    Intent intent;
    int posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campNome = findViewById(R.id.edit_nome);
        campSobrenome = findViewById(R.id.edit_sobrenome);
        campIdade = findViewById(R.id.edit_idade);
        campEmail = findViewById(R.id.edit_email);

        btnCadastrar = findViewById(R.id.btnCadastro);

        listView = findViewById(R.id.listView);

        listaUsuario = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listaUsuario
        );
        listView.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = campNome.getText().toString();
                String sobrenome = campSobrenome.getText().toString();
                int idade = Integer.parseInt(campIdade.getText().toString());
                String email = campEmail.getText().toString();


                if (!nome.isEmpty()) {
                    if (!sobrenome.isEmpty()) {
                        if (!campIdade.getText().toString().isEmpty()) {
                            if (!email.isEmpty()) {

                                User user = new User(nome, sobrenome, idade, email);
                                listaUsuario.add(user);
                                adapter.notifyDataSetChanged();

                                limpar();

                            } else {
                                Toast.makeText(getApplicationContext(), "Preencher e-mail", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Preencher idade", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Preencher sobrenome", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Preencher nome", Toast.LENGTH_SHORT).show();
                }

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(MainActivity.this, ConfiguracaoActivity.class);
                intent.putExtra("nome", listaUsuario.get(i).getNome());
                intent.putExtra("sobrenome", listaUsuario.get(i).getSobrenome());
                intent.putExtra("idade", listaUsuario.get(i).getIdade());
                intent.putExtra("email", listaUsuario.get(i).getEmail());
                intent.putExtra("id", listaUsuario.get(i).getId());
                startActivityForResult(intent, 1);
                posicao = i;
                Toast.makeText(getApplicationContext(), listaUsuario.get(i).getNome(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void limpar() {
        campNome.setText("");
        campSobrenome.setText("");
        campIdade.setText("");
        campEmail.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 1 && data != null){

            String name = data.getExtras().getString("renomeadoNome");
            String sobrenome = data.getExtras().getString("renomeadoSobrenome");
            String idade = data.getExtras().getString("renomeadoIdade");
            String email = data.getExtras().getString("renomeadoEmail");

            int numIdade = Integer.parseInt(idade);

            User user = new User(name,sobrenome,numIdade, email );
            user.setId(data.getExtras().getInt("id"));

            listaUsuario.set(posicao, user);
            adapter.notifyDataSetChanged();
        }
    }
}