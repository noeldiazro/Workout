package es.montanus.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        if (includeDetails())
            showDetails(id);
        else
            startDetailActivity(id);
    }

    private boolean includeDetails() {
        return findViewById(R.id.fragment_container) != null;
    }

    private void showDetails(long id) {
        final WorkoutDetailFragment fragment = new WorkoutDetailFragment();
        fragment.setWorkoutId(id);

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment).
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                addToBackStack(null);
        transaction.commit();
    }

    private void startDetailActivity(long id) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.ID, id);
        startActivity(intent);
    }
}
