package java.model;

import java.util.*;

public class Agent<T1, T2> {

    private int numberOfAgents;
    private Map<Integer, List<T1>> statesMap = new HashMap<>();
    private Map<Integer, List<T2>> actionsMap = new HashMap<>();

    private Agent(int numberOfAgents) {
        this.numberOfAgents = numberOfAgents;

    }

    public Agent createIndividualAgent() {
        return new Agent(1);
    }

    public Agent createMultiAgent(int numberOfAgents) {
        return new Agent(numberOfAgents);
    }

}
