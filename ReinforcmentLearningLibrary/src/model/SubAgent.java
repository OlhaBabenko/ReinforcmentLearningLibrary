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

    private String agentName;
    private SubState setOfStates;
    private SubAction setOfActions;

    /**
     *
     * Class constructor specifying state in which certain agent - owner of
     * SubState - can be during Reinforcement Learning.
     *
     * @param agentName
     */
    public SubAgent(String agentName) {
        this.agentName = agentName;
    }

    public SubAgent(String agentName, SubState statesOfSubAgent, SubAction actionsOfSubAgent) {
        this.agentName = agentName;
        this.setOfStates = statesOfSubAgent;
        this.setOfActions = actionsOfSubAgent;
    }

    public SubAgent(String agentName, StateParameter[] statesParameters, String[] actions) {
        this.agentName = agentName;
        this.setOfStates = new SubState(statesParameters);
        this.setOfActions = new SubAction(actions);
    }

    //EDIT!!!!!!!
    public void printAgentInfo() {
        System.out.println("SubAgent \"" + agentName + "\" :");
//        printStatesList();
//        printActionsList();
    }
//
//    private void printStatesList() {
//        System.out.print("    states: ");
//        statesList.stream().forEach(state -> System.out.print(state + " "));
//    }
//
//    private void printActionsList() {
//        System.out.print("\n    actions: ");
//        actionsList.stream().forEach(action -> System.out.print(action + " "));
//        System.out.print("\n");
//    }

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
