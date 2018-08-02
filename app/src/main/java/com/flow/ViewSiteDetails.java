package com.flow;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ViewSiteDetails extends AppCompatActivity {
    ProgressBar progressBar1,progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_site_details);

        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);

        progressBar1.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        progressBar2.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
    }
}
