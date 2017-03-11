package com.app_centric.shamveelahammed.swipenshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    public static String[] category;
    public static String[][] subcategory;
    public static int level = 0;
    private ImageButton shopNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //----------------------------------------------------------------------------------------------
        setContentView(R.layout.activity_main);
        //----------------------------------------------------------------------------------------------
        shopNow = (ImageButton) findViewById(R.id.shopNow);

        category = new String[3];
        subcategory = new String[3][3];

        category[0] = "household";
        category[1] = "accessories";
        category[2] = "electronics";

        subcategory[0][0] = "bed";
        subcategory[1][0] = "coffeemaker";
        subcategory[2][0] = "coffeetable";

        subcategory[0][1] = "belts";
        subcategory[1][1] = "handbags";
        subcategory[2][1] = "sunglasses";

        subcategory[0][2] = "laptop";
        subcategory[1][2] = "smartphone";
        subcategory[2][2] = "smartwatch";

        shopNow.setOnClickListener(new ImageButton.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, CategoriesActivity.class));
            }
        }); //pop-up window behaviour when New Game is pressed
    }//onCreate

    public static int getLevel()
    {
        return level;
    }

    public static String getCategory(int i)
    {
        return category[i];
    }

    public static String getSubcategory(int i, int j)
    {
        return subcategory[i][j];
    }

    public static void incrementLevel()
    {
        level++;
    }
}//MainActivity
