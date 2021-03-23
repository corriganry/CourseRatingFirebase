package edu.lewisu.cs.example.courserating;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CourseRatingAdapter extends FirebaseRecyclerAdapter<CourseRating, CourseRatingAdapter.RatingHolder> {
    public CourseRatingAdapter(@NonNull FirebaseRecyclerOptions<CourseRating> options, Context context) {
        super(options);

    }


    @NonNull
    @Override
    public RatingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.context = context;
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new RatingHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull RatingHolder holder, int position, @NonNull CourseRating model) {
        holder.courseNameTextView.setText(model.getCourseName());
        holder.instructorTextView.setText(model.getInstructorName());
        int rating = model.getRating();
        String ratingString = context.getResources().getQuantityString(R.plurals.star_rating, rating);
        holder.courseRatingTextView.setText(ratingString);
    }


    class RatingHolder extends RecyclerView.ViewHolder{
        private final TextView courseNameTextView;
        private final TextView courseRatingTextView;
        private final TextView instructorTextView;

        RatingHolder(View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            courseRatingTextView = itemView.findViewById(R.id.courseRatingTextView);
            instructorTextView = itemView.findViewById(R.id.courseInstructorTextView);

        }
    }


    private Context context;


}
