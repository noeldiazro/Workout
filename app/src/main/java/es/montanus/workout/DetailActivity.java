package es.montanus.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment fragment =
                (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        fragment.setWorkoutId(1);
    }
}
