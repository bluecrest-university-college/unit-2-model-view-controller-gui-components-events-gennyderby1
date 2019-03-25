package com.genevive.diet_app;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Food> meals = new ArrayList<>();
    GridLayout gridLayout;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);



        meals.add(new Food("Rice", 5));
        meals.add(new Food("Beans", 10));
        meals.add(new Food("Chicken", 15));
        meals.add(new Food("Soup", 2));

        createLayout(this);

    }

    void createLayout(Context context){

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x / 3;

        gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(4);

        Log.d("food size", meals.get(0).name);
        gridLayout.setMinimumHeight(20);
        gridLayout.setMinimumWidth(20);


        for(int row = 0; row < meals.size(); row++){

            TextView name = new TextView(context);
            name.setTextSize(20);
            TextView calories = new TextView(context);
            calories.setTextSize(20);
            EditText input = new EditText(context);

            Log.d("Row height", Integer.toString(w));

            name.setText(meals.get(row).getName());
            calories.setText( Integer.toString(meals.get(row).getCalories()));
            input.setText("0");

            gridLayout.addView(name, w, 200);
            gridLayout.addView(calories, w, 200);
            gridLayout.addView(input, w, 200);
        }


//        amount.setText("Total Amount");
//
//        btn.setText("Calculate");
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculate();
//            }
//        });
//
//
//        gridLayout.addView(amount, w * 2, 200);
//        gridLayout.addView(btn, w , 200);

        linearLayout = findViewById(R.id.layout);
        linearLayout.addView(gridLayout);
        setContentView(gridLayout);
    }

    void calculate(){

    }
}
