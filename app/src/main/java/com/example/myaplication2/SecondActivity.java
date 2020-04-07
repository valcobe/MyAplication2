package com.example.myaplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secundary_activity);
        String message = readParameters();
        controler(message);
    }

    private String readParameters() {
        Bundle data = this.getIntent().getExtras();
        int numRep = data.getInt(getString(R.string.rep));
        String message = data.getString(getString(R.string.mss));

        String concatMess = message;
        for (int i = 1; i < numRep; i++) {
            concatMess = concatMess.concat(message);
        }

        TextView byeText = findViewById(R.id.textViewBye);
        byeText.setText(concatMess);

        return concatMess;
    }

    private void controler(String mess) {
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new Changer(mess));
        button.requestFocus();
    }

    private class Changer implements View.OnClickListener {
        String message;

        public Changer(String message) {
            this.message = message;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra(getString(R.string.messageKey), this.message);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
