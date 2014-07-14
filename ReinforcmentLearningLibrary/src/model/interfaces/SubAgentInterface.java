package model.interfaces;

import java.util.List;

/**
 *
 * @author Olha_Babenko
 * @param <T1>
 * @param <T2>
 */
public interface SubAgentInterface<T1, T2> {

    /*
    @param states States in wich agent can be during learning
    @return statesList List of states in wich agent could be during learning
     */
    public void setAgentStates(T1... states);

    public void changeAgentStates(T1... states);

    public void setAgentActions(T2... actions);

    public void changeAgentActions(T2... actions);

    public void printAgentInfo();

    //getters for fields
    public int getAgentId();

    public List<T1> getAgentStatesList();

    public List<T2> getAgentActionsList();
}
