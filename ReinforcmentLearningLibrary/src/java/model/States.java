package java.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class States<T> {

    private int numberOfAgents;
    private List<T> statesList = new LinkedList<>();

    public States(T... states) {

        initializeStates(states);
    }

    private void initializeStates(T... states) {
        if (states.length != 0) {
            statesList.addAll(Arrays.asList(states));
        } else {
            System.out.println("No states to initialize!");
            System.exit(1);
        }
    }

    private void createStatesMap() {
        List states = new LinkedList();
    }
}
