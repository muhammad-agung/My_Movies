package sg.edu.rp.c346.id18004536.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movie> alMovieList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvMovies = findViewById(R.id.listViewMovies);
        alMovieList = new ArrayList<>();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(2014,10,15);
        c2.set(2015,4,15);

        Movie item1 =new Movie("The Avengers",2012,"pg13","Action | Sci-Fi",c1,
                "Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles" +
                " a team of superheroes to save the planet from Loki and his army.\tA crop-dusting plane with a fear of" +
                " heights lives his dream of competing in a famous around-the-world aerial race.",5);

        Movie item2 =new Movie("Planes",2020,"pg","Animation | Comedy",c1,
                "Cathay - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of " +
                "competing in a famous around-the-world aerial race.",3);


        alMovieList.add(item1);
        alMovieList.add(item2);

        customAdapter = new CustomAdapter(this, R.layout.row, alMovieList);

        lvMovies.setAdapter(customAdapter);



        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movieSelected = alMovieList.get(position);

                String title = movieSelected.getTitle();
                String rated = movieSelected.getRated();
                int year = movieSelected.getYear();
                String genre = movieSelected.getGenre();
                String desc = movieSelected.getDescription();
                Calendar watchedon = movieSelected.getWatched_on();
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                String cal = format1.format(watchedon.getTime());
                String theatre = movieSelected.getIn_theatre();
                int rating = movieSelected.getRating();

                Intent intent = new Intent(MainActivity.this, ViewMovies.class);



                intent.putExtra("title", title);
                intent.putExtra("rated", rated);
                intent.putExtra("year", year);
                intent.putExtra("genre", genre);
                intent.putExtra("desc", desc);
                intent.putExtra("watchedon", cal);
                intent.putExtra("theatre", theatre);
                intent.putExtra("rating", rating);


                startActivity(intent);
            }
        });


    }
}
