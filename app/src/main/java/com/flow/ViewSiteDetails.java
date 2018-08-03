package com.flow;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
public class ViewSiteDetails extends AppCompatActivity {
    ProgressBar progressBar1,progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_site_details);
        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
        progressBar1.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        String value = getIntent().getExtras().getString("site");
        ImageView detailImage = (ImageView) findViewById(R.id.detail_image);
        TextView detailTextView = (TextView) findViewById(R.id.detail_title);
        switch (value){
            case "makka" :
                detailImage.setImageDrawable(getDrawable(R.drawable.makkah));
                detailTextView.setText("Makkah");
                break;
            case "madinah" :
                detailImage.setImageDrawable(getDrawable(R.drawable.medinah));
                detailTextView.setText("Medinah");
                break;
            case "mina" :
                detailImage.setImageDrawable(getDrawable(R.drawable.tants));
                detailTextView.setText("Mina");
                break;
            case "arafat" :
                detailImage.setImageDrawable(getDrawable(R.drawable.arafat));
                detailTextView.setText("Arafat");
                break;
            case "muzdalifah" :
                detailImage.setImageDrawable(getDrawable(R.drawable.muzdalifah));
                detailTextView.setText("Muzdalifah");
                break;
            case "jamratstoning" :
                detailImage.setImageDrawable(getDrawable(R.drawable.jamarat));
                detailTextView.setText("Jamarat");
                break;
        }
    }
}
