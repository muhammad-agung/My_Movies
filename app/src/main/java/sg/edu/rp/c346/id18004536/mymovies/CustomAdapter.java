package sg.edu.rp.c346.id18004536.mymovies;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object\\//layout inflater shows XML file
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvDesc = rowView.findViewById(R.id.tvDesc);
        ImageView ivRating = rowView.findViewById(R.id.ivRating);

        // Obtain the Android Version information based on the position
        Movie currentItem = movieList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentItem.getTitle());
        if(currentItem.getTitle().equals(2020)){
            //tvTitle.setTextColor();
        }
        tvDesc.setText(currentItem.getYear()+ " " + currentItem.getGenre());
        if(currentItem.getRated().equalsIgnoreCase("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if(currentItem.getRated().equalsIgnoreCase("g")){
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if(currentItem.getRated().equalsIgnoreCase("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if(currentItem.getRated().equalsIgnoreCase("nc16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if(currentItem.getRated().equalsIgnoreCase("m18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else if(currentItem.getRated().equalsIgnoreCase("r21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
