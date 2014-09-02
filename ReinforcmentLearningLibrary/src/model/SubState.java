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
    //ADD CHECK ON STATESPARAMETERS WITH THE SAME NAME
    //ADD toString()

    private Set<StateParameter> statesParametersSet = new HashSet<>();
    private Map<Integer, StateParameter> stateParametersMap = new HashMap<>();

    /**
     *
     * Class constructor specifying state in which certain agent - owner of
     * SubState - can be during Reinforcement Learning.
     *
     * @param statesParameters components of SubState according to
     * {@link SubAgent}'s structure. They determine scope of values that can
     * describes certain SubState during Reinforcement Learning.
     * @see #addAllStatesParameters(model.StateParameter[])
     */
    public SubState(StateParameter... statesParameters) {
        addAllStatesParameters(statesParameters);
        initializeStateParametersMap();
    }

    public void addAllStatesParameters(StateParameter... statesParameters) {
        if (statesParameters.length != 0) {
            statesParametersSet.addAll(Arrays.asList(statesParameters));
        } else {
            System.out.println("\033[31mWARNING: SubState is empty!\033[31m");
        }
    }

    public void removeStatesParametersFromSubState(StateParameter... stateParameters) {
        for (StateParameter stateParameter : stateParameters) {
            if (statesParametersSet.contains(stateParameter)) {
                statesParametersSet.remove(stateParameter);
            }
        }
    }

    public void clearSubState() {
        if (!statesParametersSet.isEmpty()) {
            statesParametersSet.clear();
            System.out.println("\033[31mWARNING: States were changed!\033[0m");
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

    public Map<Integer, StateParameter> getStatesMap() {
        return stateParametersMap;
    }

    public void setStatesMap(Map<Integer, StateParameter> statesMap) {
        this.stateParametersMap = statesMap;
    }

    //TO CHANGE!!!
    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("SubState with statesParameters: { ");
        for (StateParameter stateParam : statesParametersSet) {
            strBuff.append(stateParam.getParameterName()).append(" ; ");
        }
        return strBuff.append(" }").toString();
    }
}
