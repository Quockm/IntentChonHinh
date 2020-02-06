package com.example.intentchonhinhanh26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AnimalsActivity extends AppCompatActivity {

    TableLayout mTableLayout;
    String[] arrayNamesAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        init();
        mapview();
        drawTableImage();
    }

    private void init() {
        arrayNamesAnimal = getResources().getStringArray(R.array.arrayNamesAnimal);
        Collections.shuffle(Arrays.asList(arrayNamesAnimal));
    }

    private void drawTableImage() {
        int socot = 3;
        int sodong = 6;
        int index = 0;
        for (int i = 0 ; i < sodong ; i++){
            TableRow tableRow = new TableRow(AnimalsActivity.this);
            for (int y = 0 ; y < socot ; y++){
                final ImageView imageView = new ImageView(AnimalsActivity.this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(360,360);
                imageView.setLayoutParams(layoutParams);
                final int valueHinhChon = getResources().getIdentifier(
                        arrayNamesAnimal[index++],
                        "drawable",
                        getPackageName());
                imageView.setImageResource(valueHinhChon);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(AnimalsActivity.this, valueHinhChon+"",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.putExtra("idhinh",Integer.parseInt(imageView.getTag().toString()));
                        setResult(123, intent);
                        finish();
                    }
                });
                tableRow.addView(imageView);
            }
            mTableLayout.addView(tableRow);
        }

    }

    private void mapview() {
        mTableLayout = findViewById(R.id.tableLayout);
    }
}
