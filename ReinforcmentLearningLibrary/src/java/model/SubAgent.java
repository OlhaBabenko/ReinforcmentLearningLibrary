package java.model;

import java.model.printer.SubAgentPrinter;
import java.util.*;

public class SubAgent<T1, T2> {

    private int agentId;
    private List<T1> statesList = new ArrayList<>();
    private List<T2> actionsList = new ArrayList<>();

    public SubAgent(int agentId) {
        this.agentId = agentId;
    }

    public int getAgentId() {
        return agentId;
    }

    public List<T1> getAgentStatesList() {
        return statesList;
    }

    public void setAgentStates(T1... states) {
        this.statesList.addAll(Arrays.asList(states));
    }

    public List<T2> getAgentActionsList() {
        return actionsList;
    }

    public void setAgentActions(T2... actions) {
        this.actionsList.addAll(Arrays.asList(actions));
    }

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
        if (!Objects.equals(this.actionsList, other.actionsList)) {
            return false;
        }
        return true;
    }

}
