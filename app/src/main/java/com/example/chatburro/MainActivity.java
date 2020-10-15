package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private static final String TAG_KEY_MESSAGE = MainActivity.class.getSimpleName();
    private static final String TAG_PREFERENCES = MainActivity.class.getSimpleName();
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = this.getSharedPreferences(TAG_PREFERENCES, Context.MODE_PRIVATE);

        Button botao = findViewById(R.id.btSend);
        textView = findViewById(R.id.mensagem);
        edEntradaTexto =  findViewById(R.id.entradaTexto);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = edEntradaTexto.getText().toString();
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("KEY_MESSAGE", mensagem);

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(TAG_KEY_MESSAGE, mensagem);
                editor.apply();

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

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String value = sharedPref.getString(TAG_KEY_MESSAGE, "Sem valor");
        textView.setText(value);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
