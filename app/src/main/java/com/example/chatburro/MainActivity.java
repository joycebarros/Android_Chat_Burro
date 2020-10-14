package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edEntradaTexto;
    int LAUNCH_SECOND_ACTIVITY = 1;
    Intent intent;
    String returnString;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = findViewById(R.id.btSend);
        textView = findViewById(R.id.mensagem);
        edEntradaTexto =  findViewById(R.id.entradaTexto);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = edEntradaTexto.getText().toString();
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("KEY_MESSAGE", mensagem);
                startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check that it is the SecondActivity with an OK result
        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) { // Activity.RESULT_OK
                // get String data from Intent
                returnString = data.getStringExtra("KEY_MESSAGE2");
                textView.setText(returnString);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                returnString ="Cancelado";
                textView.setText(returnString.toString());
            }

        }
    }
}
