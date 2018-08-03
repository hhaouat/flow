package com.flow;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.flow.Helper.Helper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView)findViewById(R.id.main_img1);
        img2 = (ImageView)findViewById(R.id.main_img2);
        img3 = (ImageView)findViewById(R.id.main_img3);
        img4 = (ImageView)findViewById(R.id.main_img4);
        img5 = (ImageView)findViewById(R.id.main_img5);
        img6 = (ImageView)findViewById(R.id.main_img6);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.articles_swiperefreshlayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                Random r = new Random();
                try{
                    String filename = "hajjdata"+r.nextInt(3) + ".json";
                    double percentage = 0.0;

                    percentage = getPercentageByCityName(filename,Helper.cityNames.makkah.toString());
                    setImageColoring(percentage,Helper.cityNames.makkah.toString());

                    percentage = getPercentageByCityName(filename,Helper.cityNames.madinah.toString());
                    setImageColoring(percentage,Helper.cityNames.madinah.toString());

                    percentage = getPercentageByCityName(filename,Helper.cityNames.mina.toString());
                    setImageColoring(percentage,Helper.cityNames.mina.toString());

                    percentage = getPercentageByCityName(filename,Helper.cityNames.arafat.toString());
                    setImageColoring(percentage,Helper.cityNames.arafat.toString());

                    percentage = getPercentageByCityName(filename,Helper.cityNames.muzdalifah.toString());
                    setImageColoring(percentage,Helper.cityNames.muzdalifah.toString());

                    percentage = getPercentageByCityName(filename,Helper.cityNames.jamratstoning.toString());
                    setImageColoring(percentage,Helper.cityNames.jamratstoning.toString());

                    //Toast.makeText(MainActivity.this, String.valueOf(percentage), Toast.LENGTH_SHORT).show();

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        //providing the color changes based on the crowd
        /*int count = Helper.cityNames.values().length;
        for(int i=0; i<count; i++){
            //setImageColoring(getPercentageByCityName(Helper.cityNames.values()[i].toString()),Helper.cityNames.values()[i].toString());
        }*/

        CardView makkah = (CardView)findViewById(R.id.makkah);
        makkah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                intent.putExtra("site", "makka");
                startActivity(intent);
            }
        });


        CardView madinah = (CardView)findViewById(R.id.madinah);
        madinah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                intent.putExtra("site", "madinah");
                startActivity(intent);
            }
        });

        CardView mina = (CardView)findViewById(R.id.mina);
        mina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                intent.putExtra("site", "mina");
                startActivity(intent);
            }
        });

        CardView arafat = (CardView)findViewById(R.id.arafat);
        arafat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                intent.putExtra("site", "arafat");
                startActivity(intent);
            }
        });

        CardView muzdalifah = (CardView)findViewById(R.id.muzdalifah);
        muzdalifah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                intent.putExtra("site", "muzdalifah");
                startActivity(intent);
            }
        });

        CardView jamrat = (CardView)findViewById(R.id.jamratstoning);
        jamrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                intent.putExtra("site", "jamratstoning");
                startActivity(intent);
            }
        });

        //JSONObject obj = new JSONObject(sb.toString());
        //Toast.makeText(MainActivity.this, obj.get("Year").toString(), Toast.LENGTH_SHORT).show();
        /*InputStream is = null;
        try {
            is = getResources().getAssets().open("hajjdata1.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s;
        StringBuilder sb = new StringBuilder();
        System.out.println("sb"+ sb);

        try {
            while ((s=br.readLine())!=null){
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //reads the JSON file and gets the values for the corresponding city


    }

    private double getPercentageByCityName(String filename, String cityName){
        double result = 0.0;
        try{
            InputStream in = getResources().getAssets().open(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s;
            StringBuilder sb = new StringBuilder();

            while((s=br.readLine())!=null){
                sb.append(s);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("sites");

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject)jsonArray.get(i);
                if(jsonObject1.getString("name").equals(cityName)){
                    double maxNumPilgrim = jsonObject1.getLong("currentNumPilm");
                    double currentNumPil = jsonObject1.getLong("maxPilm");

                    BigDecimal d1 = new BigDecimal(maxNumPilgrim);
                    BigDecimal d2 = new BigDecimal(currentNumPil);


                    //Toast.makeText(this, String.valueOf(d1.divide(d2,new MathContext(4))), Toast.LENGTH_SHORT).show();
                    result = d1.divide(d2,new MathContext(4)).doubleValue();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            result = -99.0;
        }

        return result;
    }

    private void setImageColoring(double colorValue, String cityName){
        if(colorValue >= 0.6){
            //set red
            if(cityName.equals(Helper.cityNames.makkah.toString())) {
                img1.setImageDrawable(getDrawable(R.drawable.mecca_r));
            }else if(cityName.equals(Helper.cityNames.madinah.toString())){
                img2.setImageDrawable(getDrawable(R.drawable.madina_r));
            }else if(cityName.equals(Helper.cityNames.mina.toString())){
                img3.setImageDrawable(getDrawable(R.drawable.mena_r));
            }else if(cityName.equals(Helper.cityNames.arafat.toString())){
                img4.setImageDrawable(getDrawable(R.drawable.arafa_r));
            }else if(cityName.equals(Helper.cityNames.muzdalifah.toString())){
                img5.setImageDrawable(getDrawable(R.drawable.muzdalifah_r));
            }else if(cityName.equals(Helper.cityNames.jamratstoning.toString())){
                img6.setImageDrawable(getDrawable(R.drawable.jamarat_r));
            }
        }else if(colorValue >= 0.45){
            //set yellow
            if(cityName.equals(Helper.cityNames.makkah.toString())) {
                img1.setImageDrawable(getDrawable(R.drawable.mecca_y));
            }else if(cityName.equals(Helper.cityNames.madinah.toString())){
                img2.setImageDrawable(getDrawable(R.drawable.madina_y));
            }else if(cityName.equals(Helper.cityNames.mina.toString())){
                img3.setImageDrawable(getDrawable(R.drawable.mena_y));
            }else if(cityName.equals(Helper.cityNames.arafat.toString())){
                img4.setImageDrawable(getDrawable(R.drawable.arafa_y));
            }else if(cityName.equals(Helper.cityNames.muzdalifah.toString())){
                img5.setImageDrawable(getDrawable(R.drawable.muzdalifah_y));
            }else if(cityName.equals(Helper.cityNames.jamratstoning.toString())){
                img6.setImageDrawable(getDrawable(R.drawable.jamarat_y));
            }
        }else{
            //set green
            if(cityName.equals(Helper.cityNames.makkah.toString())) {
                img1.setImageDrawable(getDrawable(R.drawable.mecca_g));
            }else if(cityName.equals(Helper.cityNames.madinah.toString())){
                img2.setImageDrawable(getDrawable(R.drawable.madina_g));
            }else if(cityName.equals(Helper.cityNames.mina.toString())){
                img3.setImageDrawable(getDrawable(R.drawable.mena_g));
            }else if(cityName.equals(Helper.cityNames.arafat.toString())){
                img4.setImageDrawable(getDrawable(R.drawable.arafa_g));
            }else if(cityName.equals(Helper.cityNames.muzdalifah.toString())){
                img5.setImageDrawable(getDrawable(R.drawable.muzdalifah_g));
            }else if(cityName.equals(Helper.cityNames.jamratstoning.toString())){
                img6.setImageDrawable(getDrawable(R.drawable.jamarat_g));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_menu_item1:
                startActivity(new Intent(MainActivity.this,DonateActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
