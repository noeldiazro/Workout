package es.montanus.workout;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorkoutTest {
    private static final String NAME = "Name";
    private static final String DESCRIPTION = "Description";

    private Workout workout;

    @Before
    public void createWorkout() {
        workout = new Workout(NAME, DESCRIPTION);
    }

    @Test
    public void nameEqualsGiven() {
        assertEquals(NAME, workout.getName());
    }

    @Test
    public void descriptionEqualsGiven() {
        assertEquals(DESCRIPTION, workout.getDescription());
    }

    @Test
    public void toStringReturnsName() {
        assertEquals(NAME, workout.toString());
    }
}