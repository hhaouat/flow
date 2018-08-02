package com.flow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView makkah = (CardView)findViewById(R.id.makkah);
        makkah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                startActivity(intent);
            }
        });


        CardView madinah = (CardView)findViewById(R.id.madinah);
        madinah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                startActivity(intent);
            }
        });

        CardView mina = (CardView)findViewById(R.id.mina);
        mina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                startActivity(intent);
            }
        });

        CardView arafat = (CardView)findViewById(R.id.arafat);
        arafat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                startActivity(intent);
            }
        });

        CardView muzdalifah = (CardView)findViewById(R.id.muzdalifah);
        muzdalifah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                startActivity(intent);
            }
        });

        CardView minacamps = (CardView)findViewById(R.id.minacamps);
        minacamps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                startActivity(intent);
            }
        });

        CardView jamrat = (CardView)findViewById(R.id.jamratstoning);
        jamrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
                startActivity(intent);
            }
        });

        CardView slaughter = (CardView)findViewById(R.id.slaughterhouse);
        slaughter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewSiteDetails.class);
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
        /*private double getPercentageByCityName(String cityName){
            double result = 0.0;
            try{
                InputStream in = getResources().getAssets().open("hajjdata0.json");
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String s;
                StringBuilder sb = new StringBuilder();

                while((s=br.readLine())!=null){
                    sb.append(s);
                }

                JSONObject jsonObject = new JSONObject(sb.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("city");

                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject1 = (JSONObject)jsonArray.get(i);
                    if(jsonObject1.getString("name").equals(cityName)){
                        long maxNumPilgrim = jsonObject1.getLong("currentNumPilm");
                        long currentNumPil = jsonObject1.getLong("maxPilm");
                        result = (Double.valueOf(currentNumPil)/Double.valueOf(maxNumPilgrim)) * 100.0;
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
                result = -99.0;
            }

            return result;
        }*/

    }
}
