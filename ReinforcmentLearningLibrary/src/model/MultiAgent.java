package model;

import java.util.Arrays;
import java.util.Set;

/**
 * MultiAgent is class which determines object of Reinforcement Learning.
 * MultiAgent contains of one or more subAgents.
 * <p>
 * MultiAgent has:
 * <ul>
 * <li><i>set of States</i>: determines in which states MultiAgent can be during
 * learning. Consists from states in which each subAgent can be.
 * <li><i>set of Actions</i>: determines what actions MultiAgent can do during
 * learning.Consists from actions which can be done by each subAgent.
 * </ul>
 *
 * @author Olha_Babenko
 */
public class MultiAgent {

    private String nameOfMultiAgent;
    private Set<SubAgent> subAgentsList;

    /**
     * Class constructor specifying MultiAgent which must be learned.
     * Initialization is doing by given a name to MultiAgent without specifying
     * its set of Actions or States.
     *
     * @param nameOfMultiAgent name of multi agent that must be learned
     */
    public MultiAgent(String nameOfMultiAgent) {
        this.nameOfMultiAgent = nameOfMultiAgent;
    }

    /**
     *
     * @return name Of MultiAgent
     */
    public String getNameOfMultiAgent() {
        return nameOfMultiAgent;
    }

    /**
     * Renaming MultiAgent which must be learned
     *
     * @param nameOfMultiAgent new name of MultiAgent
     */
    public void renameMultiAgent(String nameOfMultiAgent) {
        this.nameOfMultiAgent = nameOfMultiAgent;
    }

    /**
     * Adding {@link SubAgent}s into set of SubAgents which constitute
     * MultiAgent and specify its set of States and Actions.
     *
     * @param subAgents {@link SubAgent}s to add into set of SubAgents
     */
    public void addAllSubAgents(SubAgent... subAgents) {
        this.subAgentsList.addAll(Arrays.asList(subAgents));
    }

    /**
     *
     * @return list of subAgents which constitute MultiAgent
     */
    public Set<SubAgent> getSubAgentsList() {
        return subAgentsList;
    }

    //TO BE DONE
    private void initializeStatesSetOfMultiAgent() {
    }

    //TO BE DONE
    private void initializeActionsSetOfMultiAgent() {
    }

}
