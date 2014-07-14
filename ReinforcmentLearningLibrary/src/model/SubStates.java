package model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubStates<T> {

    private int stateID;
    private List<T> statesList = new LinkedList<>();

    public SubStates(T... states) {
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

    }
}
