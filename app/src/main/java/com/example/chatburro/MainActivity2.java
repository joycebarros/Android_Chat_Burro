package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText edEntradaTexto2;
    private String mensagem2;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button botao2 = findViewById(R.id.btReply);
        edEntradaTexto2 = findViewById(R.id.entradaTexto2);
        textView = findViewById(R.id.mensagem2);

        String mensagem = getIntent().getStringExtra("KEY_MESSAGE");
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();

        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagemDevolvida = edEntradaTexto2.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("KEY_MESSAGE2", mensagemDevolvida);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        });

    }
}