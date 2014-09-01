package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * SubState is final class which describes states in which {@link SubAgent} can
 * be during Reinforcement Learning. SubState consists of
 * {@link StateParameter}'s which must be defined earlier by user according to
 * {@link SubAgent} structure.
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
public final class SubState {

    private SubAgent ownerAgent;
    private Set<StateParameter> statesParametersSet = new HashSet<>();
    private Map<Integer, StateParameter> stateParametersMap = new HashMap<>();

    /**
     *
     * Class constructor specifying state in which certain agent - owner of
     * SubState - can be during Reinforcement Learning.
     *
     * @param ownerAgent {@link SubAgent} over which the learning process is
     * carried out. It can be only in states defined by {@link StateParameter}'s
     * during Reinforcement Learning.
     * @param statesParameters components of SubState according to
     * {@link SubAgent}'s structure. They determine scope of values that can
     * describes certain SubState during Reinforcement Learning.
     * @see #initializeSubStates(model.StateParameter[])
     */
    public SubState(SubAgent ownerAgent, StateParameter... statesParameters) {
        this.ownerAgent = ownerAgent;
        initializeSubStates(statesParameters);
        initializeStateParametersMap();
    }

    private void initializeSubStates(StateParameter[] statesParameters) {
        if (statesParameters.length != 0) {
            statesParametersSet.addAll(Arrays.asList(statesParameters));
        } else {
            System.out.println("\033[31mWARNING: SubState for agent\"" + ownerAgent + "\" is empty! To initialize this SubState add State's Parameters using addStatesParameter() method!\033[31m");
            System.exit(1);
        }
    }

    //To change!!!!!!!!!!!
    private void initializeStateParametersMap() {
        Iterator iteratorOfStatesParamSet = statesParametersSet.iterator();
        int indexOfStatesParam = 1;
        while (iteratorOfStatesParamSet.hasNext()) {
            stateParametersMap.put(indexOfStatesParam, (StateParameter) iteratorOfStatesParamSet.next());
            indexOfStatesParam++;
        }
    }

    public void addStatesParameter() {

    }

    public void removeStatesParameter() {
    }

    public SubAgent getOwnerAgent() {
        return ownerAgent;
    }

    public void setOwnerAgent(SubAgent ownerAgent) {
        this.ownerAgent = ownerAgent;
    }

    public Map<Integer, StateParameter> getStatesMap() {
        return stateParametersMap;
    }

    public void setStatesMap(Map<Integer, StateParameter> statesMap) {
        this.stateParametersMap = statesMap;
    }
}
