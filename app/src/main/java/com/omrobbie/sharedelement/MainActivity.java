package com.omrobbie.sharedelement;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CardView cardView = (CardView) findViewById(R.id.cardView);
        final ImageView info_image = (ImageView) findViewById(R.id.info_image);
        final TextView info_title = (TextView) findViewById(R.id.info_title);
        final TextView info_desc = (TextView) findViewById(R.id.info_desc);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                // cek apakah minimum sdk dari device di atas lolipop (API 21)
                // ini diperlukan untuk mengaktifkan content transition
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    Pair<View, String> p1 = Pair.create((View) info_image, "image");
                    Pair<View, String> p2 = Pair.create((View) info_title, "title");
                    Pair<View, String> p3 = Pair.create((View) info_desc, "desc");

                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat
                            .makeSceneTransitionAnimation(MainActivity.this, p1, p2, p3);
                    startActivity(intent, activityOptionsCompat.toBundle());
                } else startActivity(intent);
            }
        });
    }
}
