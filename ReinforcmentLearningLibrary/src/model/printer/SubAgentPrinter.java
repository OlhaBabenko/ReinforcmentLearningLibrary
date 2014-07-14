package model.printer;

import java.util.*;

public final class SubAgentPrinter<T1, T2> {

    private int agentId;
    private List<T1> statesList = new ArrayList<>();
    private List<T2> actionsList = new ArrayList<>();

    public SubAgentPrinter(int agentId, List<T1> statesList, List<T2> actionsList) {
        this.agentId = agentId;
        this.statesList = statesList;
        this.actionsList = actionsList;
    }

    public void printAgentInfo() {
        printAgentID(agentId);
        printStatesList(statesList);
        printActionsList(actionsList);
    }

    public static void printAgentID(int agentId) {
        System.out.println("SubAgent #" + agentId + ":");
    }

    private void printStatesList(List<T1> statesList) {
        System.out.print("    states: ");
        statesList.stream().forEach(state -> System.out.print(state + " "));
    }

    private void printActionsList(List<T2> actionsList) {
        System.out.print("\n    actions: ");
        actionsList.stream().forEach(action -> System.out.print(action + " "));
        System.out.print("\n");
    }
}
