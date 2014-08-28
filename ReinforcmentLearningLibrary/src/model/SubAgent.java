package model;

import java.util.*;

/**
 * SubAgent is class which describes agent as the part of MultiAgent which must
 * be learned. SubAgent has a list of states in which it can be during
 * Reinforcement Learning and a list of actions which it can do during
 * Reinforcement Learning. SubState consists of {@link StateParameter}'s which
 * must be defined earlier by user according to {@link SubAgent} structure.
 * <p>
 * This class determines:
 * <ul>
 * <li> {@link StateParameter}'s from which states of {@link SubAgent} consist.
 * <li> stateParameterMap which describes possible states of {@link SubAgent}
 * during Reinforcement Learning
 * </ul>
 *
 * @author Olha Babenko
 */
public abstract class SubAgent {

    private int agentId;
    private String agentName;
    private List<T1> statesList = new ArrayList<>();
    private List<T2> actionsList = new ArrayList<>();
    private Map<Integer, T1> statesMap = new HashMap<>();

    /**
     *
     * Class constructor specifying state in which certain agent - owner of
     * SubState - can be during Reinforcement Learning.
     *
     * @param agentId
     * @param agentName
     */
    public SubAgent(int agentId, String agentName) {
        this.agentId = agentId;
        this.agentName = agentName;
    }

    public SubAgent(int agentId, String agentName, List<T1> statesList, List<T2> actionsList) {
        this.agentId = agentId;
        this.statesList = statesList;
        this.actionsList = actionsList;
        initializeStatesMap();
    }

    public int getAgentId() {
        return agentId;
    }

    public List<T1> getAgentStatesList() {
        return statesList;
    }

    public List<T2> getAgentActionsList() {
        return actionsList;
    }

    /*
     @param states states in wich agent can be
     */
    public void setAgentStates(T1... states) {
        clearStatesList();
        statesList.addAll(Arrays.asList(states));
        initializeStatesMap();
    }

    private void clearStatesList() {
        if (!statesList.isEmpty()) {
            statesList.clear();
            System.out.println("\033[31mWARNING: States for agent \"" + agentName + "\" were changed!\033[0m");
        }
    }

    public void setAgentActions(T2... actions) {
        clearActionsList();
        actionsList.addAll(Arrays.asList(actions));
    }

    private void clearActionsList() {
        if (!actionsList.isEmpty()) {
            actionsList.clear();
            System.out.println("\033[31mWARNING: Actions for agent \"" + agentName + "\" were changed!\033[0m");
        }
    }

    public void printAgentInfo() {
        printAgentIDAndName();
        printStatesList();
        printActionsList();
    }

    private void printAgentIDAndName() {
        System.out.println("SubAgent #" + agentId + " - \"" + agentName + "\" :");
    }

    private void printStatesList() {
        System.out.print("    states: ");
        statesList.stream().forEach(state -> System.out.print(state + " "));
    }

    private void printActionsList() {
        System.out.print("\n    actions: ");
        actionsList.stream().forEach(action -> System.out.print(action + " "));
        System.out.print("\n");
    }

    private void initializeStatesMap() {

    }
//
//    @Override
//    public String toString() {
//        return "SubAgent #" + agentId + " - \"" + agentName + "\"\n(for detail info use printAgentInfo() method)";
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 53 * hash + this.agentId;
//        hash = 53 * hash + Objects.hashCode(this.statesList);
//        hash = 53 * hash + Objects.hashCode(this.actionsList);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final SubAgent<?, ?> other = (SubAgent<?, ?>) obj;
//        if (this.agentId != other.agentId) {
//            return false;
//        }
//        if (!Objects.equals(this.statesList, other.statesList)) {
//            return false;
//        }
//        return Objects.equals(this.actionsList, other.actionsList);
//    }
}
