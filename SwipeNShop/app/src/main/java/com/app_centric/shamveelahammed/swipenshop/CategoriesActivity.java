package com.app_centric.shamveelahammed.swipenshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.Random;
import android.content.Context;

public class CategoriesActivity extends AppCompatActivity
{
    public Context context;
    private ImageButton left, right;
    private ImageView showImages;
    private int row = 0, column = 0, index = 0;
    private int lastRow = 0, lastColumn = 0, lastIndex = 0;
    private Random randomGen;
    public int id;
    public String subcat = "", item = "", brand = "";
    //level 0 is choosing category
    //level 1 is choosing subcategory
    //level 2 is choosing item
    //level 3 is buying item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //-------------------------------------------
        left = (ImageButton) findViewById(R.id.left);
        right = (ImageButton) findViewById(R.id.right);
        showImages = (ImageView) findViewById(R.id.showImage);

        randomGen = new Random();

        left.setOnClickListener(new ImageButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                context = showImages.getContext();
                //showImages.setBackgroundResource(R.drawable.electronics_laptop);

                if(MainActivity.getLevel() == 0)
                {
                    while(row == lastRow)
                    {
                        lastRow = row;
                        row = randomGen.nextInt(3);
                    }
                    lastRow = row;
                    id = context.getResources().getIdentifier(MainActivity.getCategory(row),
                            "drawable", context.getPackageName());
                    showImages.setBackgroundResource(id);
                    //MainActivity.incrementLevel();
                } //choose category

                if(MainActivity.getLevel() == 1)
                {
                    while(column == lastColumn)
                    {
                        lastColumn = column;
                        column = randomGen.nextInt(3);
                    }
                    lastColumn = column;
                    subcat = MainActivity.getCategory(row) + "_"
                                    + MainActivity.getSubcategory(column, row);
                    id = context.getResources().getIdentifier(subcat, "drawable",
                                                                    context.getPackageName());
                    showImages.setBackgroundResource(id);
                    //MainActivity.incrementLevel();
                } //choose subcategory

                if(MainActivity.getLevel() == 2)
                {
                    while(index == lastIndex)
                    {
                        lastIndex = index;
                        index = randomGen.nextInt(3) + 1;
                    }
                    lastIndex = index;
                    item = subcat + "_" + Integer.toString(index);
                    id = context.getResources().getIdentifier(item, "drawable",
                            context.getPackageName());
                    showImages.setBackgroundResource(id);
                    brand = item + "_brand";
                    //MainActivity.incrementLevel();
                } //choose item


                //showImages.setImageResource(R.drawable.laptop);
            }
        });

        right.setOnClickListener(new ImageButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity.incrementLevel();
            }//onClick
        });
    } //onCreate
} //CategoriesActivity
