package sg.edu.rp.c346.id18004536.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class ViewMovies extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDesc;
    ImageView ivRating;
    TextView tvMoreDesc;
    RatingBar ratingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movies);

        tvTitle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);
        ivRating = findViewById(R.id.ivRating);
        tvMoreDesc = findViewById(R.id.tvMoreDesc);
        ratingBar = findViewById(R.id.ratingBar);


        Intent intentReceived = getIntent();
        String takentitle = intentReceived.getStringExtra("title");
        String takenrated = intentReceived.getStringExtra("rated");
        int takenyear = intentReceived.getIntExtra("year", 0);
        String takengenre = intentReceived.getStringExtra("genre");
        String takendesc = intentReceived.getStringExtra("desc");
        String takenwatchon = intentReceived.getStringExtra("watchedon");
        String takentheatre = intentReceived.getStringExtra("theatre");
        int takenrating = intentReceived.getIntExtra("rating", 0);

        tvTitle.setText(takentitle);
        tvDesc.setText(takenyear+" "+takengenre);
        tvMoreDesc.setText(takendesc+"\n\n"+"Watch on: "+takenwatchon+ "\n"+"In theatre: "+takentheatre);
        ratingBar.setRating(takenrating);

        if(takenrated.equalsIgnoreCase("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if(takenrated.equalsIgnoreCase("g")){
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if(takenrated.equalsIgnoreCase("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if(takenrated.equalsIgnoreCase("nc16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if(takenrated.equalsIgnoreCase("m18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else if(takenrated.equalsIgnoreCase("r21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }
    }
}
