package model;

import java.util.Arrays;
import java.util.Set;

/**
 * SubAction is final class which describes actions that can de done by
 * {@link SubAgent} during Reinforcement Learning.
 *
 * @author Olha_Babenko
 */
public final class SubAction {

    private Set<String> actionsOfSubAgent;

    public SubAction(String... actions) {
        this.actionsOfSubAgent.addAll(Arrays.asList(actions));
    }

    /**
     *
     * @return set of actions in which {@link SubAgent} can be during
     * Reinforcement Learning
     */
    public Set<String> getActionsOfSubAgent() {
        return actionsOfSubAgent;
    }

    /**
     * Adding actions into set of actions in which {@link SubAgent} can be
     * during Reinforcement Learning
     *
     * @param actions
     */
    public void addAllActions(String... actions) {
        this.actionsOfSubAgent.addAll(Arrays.asList(actions));
    }

    /**
     * Removing actions from set of actions of {@link SubAgent}
     *
     * @param actions
     */
    public void removeActionsFromActionsSet(String... actions) {
        for (String action : actions) {
            if (actionsOfSubAgent.contains(action)) {
                actionsOfSubAgent.remove(action);
            }
        }
    }

    /**
     * Clearing all actions that are in set of actions which {@link SubAgent}
     * can do during Reinforcement Learning.
     */
    public void clearActions() {
        actionsOfSubAgent.clear();
    }

}
