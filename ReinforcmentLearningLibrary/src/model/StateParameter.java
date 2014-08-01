package model;

import exceptions.BadIntervalException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StateParameter is final class which describes one of the {@link SubState}'s
 * parameters.
 * <p>
 * This class determines:
 * <ul>
 * <li> name of particular characteristic of state in which {@link SubAgent}
 * could be during Reinforcement Learning
 * <li> boundaries of this characteristic
 * <li> set of single type values which this characteristic can take
 * </ul>
 *
 * @author Olha Babenko
 * @param <E> specifying type of values which parameter can take during
 * Reinforcement Learning
 */
public final class StateParameter<E> {

    private String parameterName;
    private Set<E> parameterValues = new HashSet<>();

    /**
     * Class constructor specifying parameter with unique name and set of the
     * same type values ​that the parameter can take during Reinforcement
     * Learning in accordance with a user-defined range
     *
     *
     * @param parameterName unique name of parameter for its unambiguous
     * identifying in {@link SubState}
     * @param startValue double lower bound of user-defined range of values
     * @param endValue double upper bound of user-defined range of values
     * @param step double distance between neighboring values in range
     * @see #fillParameterValues(java.lang.Double, java.lang.Double,
     * java.lang.Double)
     */
    public StateParameter(String parameterName, double startValue, double endValue, double step) {
        this.parameterName = parameterName;
        fillParameterValues(startValue, endValue, step);
    }

    /**
     * Class constructor specifying parameter with unique name and user-defined
     * set of values ​that the parameter can take during Reinforcement Learning
     *
     * @param parameterName string unique name of parameter for its unambiguous
     * identifying in {@link SubState}
     * @param parameterValues set of user-defined type values ​that the
     * parameter can take during Reinforcement Learning in accordance with a
     * user-defined range
     */
    public StateParameter(String parameterName, Set<E> parameterValues) {
        this.parameterName = parameterName;
        this.parameterValues = parameterValues;
    }

    /**
     * Filling set of values ({@link #parameterValues}) that the parameter can
     * take during Reinforcement Learning in accordance with a user-defined
     * range.
     * <p>
     * <b>Attention:</b> {@link #parameterValues} fill in only when
     * {@link #tryOnBadIntervalException(double, double, double)} do not throw
     * an exception!
     *
     * @param startValue double lower bound of user-defined range of values
     * @param endValue double upper bound of user-defined range of values
     * @param step double distance between neighboring values in user-defined
     * range
     * @see #tryOnBadIntervalException(double, double, double)
     */
    private void fillParameterValues(Double startValue, Double endValue, Double step) {
        //maybe add external/internal intervals

        tryOnBadIntervalException(startValue, endValue, step);

        while (startValue <= endValue) {
            parameterValues.add((E) startValue);
            startValue += step;
        }
    }

    /**
     * Checks boundaries and step between values in user-defined range
     *
     * @param startValue double lower bound of user-defined range of values
     * @param endValue double upper bound of user-defined range of values
     * @param step double distance between neighboring values in range
     */
    private void tryOnBadIntervalException(double startValue, double endValue, double step) {
        try {
            if (startValue < Integer.MIN_VALUE || endValue > Integer.MAX_VALUE) {
                throw new BadIntervalException("Invalid borders of interval!");
            }

            if (endValue <= startValue) {
                throw new BadIntervalException("Start of interval bigger than end of interval!");
            }

            if ((startValue + step) >= endValue) {
                throw new BadIntervalException("Step can not be applied to given interval: start value with step bigger than end of interval!");
            }
        } catch (BadIntervalException ex) {
            Logger.getLogger(StateParameter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Provides user access to the set of values which parameter can take during
     * Reinforcement Learning. The type of values is defined by user when
     * {@link StateParameter} is created
     *
     * @return the set of values which parameter can take during Reinforcement
     * Learning
     */
    public Set<E> getParameterValues() {
        return parameterValues;
    }

    @Override
    public String toString() {
        return "StateParameter:\n Name = " + parameterName + "(for detailed information use printStateParameter().)";
    }

    /**
     * Prints {@link #parameterName} and {@link #parameterValues} of
     * {@link StateParameter}
     */
    public void printStateParameter() {
        System.out.println("StateParameter:\n  Name = " + parameterName);
        System.out.print("  Parameter's values: { ");
        parameterValues.stream().forEach(s -> System.out.print(s + " "));
        System.out.print("}\n");
    }
}
