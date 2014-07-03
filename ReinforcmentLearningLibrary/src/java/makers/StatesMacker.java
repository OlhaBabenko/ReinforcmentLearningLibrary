package java.makers;

import java.model.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StatesMacker<T> {

    private int numberOfAgents;
    private List<T> statesList = new LinkedList<>();

    public StatesMacker(int numberOfAgents, T... states) {
        this.numberOfAgents = numberOfAgents;
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
