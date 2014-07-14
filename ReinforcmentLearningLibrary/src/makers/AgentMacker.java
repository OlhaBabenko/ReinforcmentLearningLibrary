package makers;

import java.util.*;

public class AgentMacker<T1, T2> {

    private int numberOfAgents;
    private Map<Integer, List<T1>> statesMap = new HashMap<>();
    private Map<Integer, List<T2>> actionsMap = new HashMap<>();

    private AgentMacker(int numberOfAgents) {
        this.numberOfAgents = numberOfAgents;

    }

    public static AgentMacker createIndividualAgent() {
        return new AgentMacker(1);
    }

    public static AgentMacker createMultiAgent(int numberOfAgents) {
        return new AgentMacker(numberOfAgents);
    }

}
