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
        if (actions.length != 0) {
            actionsOfSubAgent.addAll(Arrays.asList(actions));
        } else {
            System.out.println("\033[31mWARNING: You do not add any action!\033[31m");
            System.exit(1);
        }
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
        if (!actionsOfSubAgent.isEmpty()) {
            actionsOfSubAgent.clear();
            System.out.println("\033[31mWARNING: Actions were changed!\033[0m");
        }
    }

    //TO CHANGE!!!
    @Override
    public String toString() {
        return "SubAction{" + "actionsOfSubAgent=" + actionsOfSubAgent + '}';
    }
}
