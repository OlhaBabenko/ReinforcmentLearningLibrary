package model;

import model.interfaces.SubAgentInterface;
import model.printer.SubAgentPrinter;
import java.util.*;

public class SubAgent<T1, T2> implements SubAgentInterface<T1, T2> {

    private int agentId;
    private String agentName;
    private List<T1> statesList = new ArrayList<>();
    private List<T2> actionsList = new ArrayList<>();

//    public SubAgent(int agentId) {
//        this.agentId = agentId;
//    }
    public SubAgent(int agentId, String agentName) {
        this.agentId = agentId;
        this.agentName = agentName;
    }

    public SubAgent(int agentId, String agentName, List<T1> statesList, List<T2> actionsList) {
        this.agentId = agentId;
        this.statesList = statesList;
        this.actionsList = actionsList;
    }

    @Override
    public int getAgentId() {
        return agentId;
    }

    @Override
    public List<T1> getAgentStatesList() {
        return statesList;
    }

    @Override
    public List<T2> getAgentActionsList() {
        return actionsList;
    }

    
    /*
    @param states states in wich can agent can be
    */
    @Override
    public void setAgentStates(T1... states) {
        if (!statesList.isEmpty()) {
            this.statesList.clear();
            System.out.println("States were changed!");
        }
        this.statesList.addAll(Arrays.asList(states));
    }

    @Override
    public void changeAgentActions(T2... actions) {
        this.actionsList.clear();
        this.actionsList.addAll(Arrays.asList(actions));
    }

    @Override
    public void setAgentActions(T2... actions) {
        if (!actionsList.isEmpty()) {
            if (safeMode) {
                changeAgentActionsInSafeMode(actions);
            } else {
                changeAgentActions(actions);
                System.out.println("Actions were changed!");
            }
        } else {
            this.actionsList.addAll(Arrays.asList(actions));
        }
    }

    private void changeAgentActionsInSafeMode(T2[] actions) {
        if (SafeMode.askForMakingChangesInStatesOrActions("Actions")) {
            changeAgentActions(actions);
            System.out.println("Actions were changed!");
        }
    }

    private void changeAgentStatesInSafeMode(T1[] states) {
        if (SafeMode.askForMakingChangesInStatesOrActions("States")) {
            changeAgentStates(states);
            System.out.println("States were changed!");
        }
    }

    @Override
    public void printAgentInfo() {
        SubAgentPrinter subAgentPrinter = new SubAgentPrinter(agentId, statesList, actionsList);
        subAgentPrinter.printAgentInfo();
    }

    @Override
    public String toString() {
        SubAgentPrinter.printAgentID(agentId);
        return "(for detail info use printAgentInfo() method)";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.agentId;
        hash = 53 * hash + Objects.hashCode(this.statesList);
        hash = 53 * hash + Objects.hashCode(this.actionsList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubAgent<?, ?> other = (SubAgent<?, ?>) obj;
        if (this.agentId != other.agentId) {
            return false;
        }
        if (!Objects.equals(this.statesList, other.statesList)) {
            return false;
        }
        return Objects.equals(this.actionsList, other.actionsList);
    }

    public boolean isSafeMode() {
        return safeMode;
    }

    public void setSafeMode(boolean safeMode) {
        this.safeMode = safeMode;
    }
}

//    private void askForMakingChangesInActions(T2... actions) {
//        System.out.println("Actions were already defined! Do you realy want to change them?");
//
//        Scanner answer = new Scanner(System.in);
//        boolean needNext = true;
//
//        while (needNext) {
//            if (answer.hasNext()) {
//                needNext = checkAnswer(answer.next(), actions);
//            }
//        }
//    }
//    private void askForMakingChangesInStates(T1... states) {
//        System.out.println("States were already defined! Do you realy want to change them?");
//
//        Scanner answer = new Scanner(System.in);
//        boolean needNext = true;
//
//        while (needNext) {
//            if (answer.hasNext()) {
//                needNext = checkAnswer(answer.next(), states);
//            }
//        }
//    }
//
//    private boolean checkAnswer(String answer, T1... states) {
//        if (null != answer) {
//            switch (answer) {
//                case "y":
//                case "Y":
//                    changeAgentStates(states);
//                    return false;
//                case "n":
//                case "N":
//                    return false;
//                default:
//                    System.out.println("Please, enter 'Y' or 'N': ");
//            }
//        }
//        return true;
//    }
//
//    private void askForMakingChangesInActions(T2... actions) {
//        System.out.println("Actions were already defined! Do you realy want to change them?");
//
//        Scanner answer = new Scanner(System.in);
//        boolean needNext = true;
//
//        while (needNext) {
//            if (answer.hasNext()) {
//                needNext = checkAnswer(answer.next(), actions);
//            }
//        }
//    }
