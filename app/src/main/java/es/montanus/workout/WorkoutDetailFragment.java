package es.montanus.workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {
    private static final String WORKOUT_ID = "workoutId";
    private long workoutId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
            setWorkoutId(savedInstanceState.getLong(WORKOUT_ID));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Workout workout = Workout.workouts[(int)workoutId];
            TextView title = view.findViewById(R.id.textTitle);
            title.setText(workout.getName());
            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong(WORKOUT_ID, workoutId);
    }

    public void setWorkoutId(long id) {
        this.workoutId = id;
    }
}
