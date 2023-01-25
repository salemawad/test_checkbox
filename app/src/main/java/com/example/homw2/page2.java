package com.example.homw2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class page2 extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;
    private CheckBox checkBox;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        builder = new AlertDialog.Builder(this);
        radioGroup = findViewById(R.id.rade);
        button = findViewById(R.id.bnn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton.getText().equals("غزة")) {
                    Toast.makeText(page2.this, "غزة", Toast.LENGTH_SHORT).show();
                } else if (radioButton.getText().equals("القدس")) {
                    Toast.makeText(page2.this, "القدس", Toast.LENGTH_SHORT).show();
                } else if (radioButton.getText().equals("خان يونس")) {
                    Toast.makeText(page2.this, "خان يونس", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opchin, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_share) {
            Intent intent = new Intent(page2.this, MainActivity.class);
            startActivity(intent);


        } else if (item.getItemId() == R.id.item_intent) {
            Intent intent = new Intent(page2.this, page2.class);
            startActivity(intent);

        } else {
            builder.setMessage("رسالة تاكيد").setTitle("تسجيل خروج");
            builder.setMessage("هل انت متأكد من الخروج").setCancelable(false).setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    finishAffinity();

                }
            }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();


                }
            });
            AlertDialog dialog = builder.create();
            dialog.setTitle("تسجيل خروج");
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}

