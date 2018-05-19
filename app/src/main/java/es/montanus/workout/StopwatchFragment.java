package es.montanus.workout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StopwatchFragment extends Fragment {

    private StopwatchPresenter presenter;
    private View layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        initStartButton();
        presenter = new StopwatchPresenter(this);
        return layout;
    }

    private void initStartButton() {
        final Button startButton = (Button) layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.start();
            }
        });
    }

    public void setTime(String time) {
        final TextView timeView = (TextView) layout.findViewById(R.id.time_view);
        timeView.setText(time);
    }

    public void display(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
