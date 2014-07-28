package model;

import exceptions.BadIntervalException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 *Class describes one of the State's parameter. Contains Set of values which this parameter can take.
 */
//public class StateParameter<T> {
public final class StateParameter {

    //private List<T> parameterValues;
    private String parameterName;
    private Set<Double> parameterValues = new HashSet<>();

    public StateParameter(String parameterName, double startValue, double endValue, double step) {
        this.parameterName = parameterName;
        setParameterValues(startValue, endValue, step);
    }

    public StateParameter(String parameterName, Set<Double> parameterValues) {
        this.parameterValues = parameterValues;
    }

    public Set<Double> getParameterValues() {
        return parameterValues;
    }

    //maybe add external/internal intervals
    void setParameterValues(double startValue, double endValue, double step) {
        tryOnBadIntervalException(startValue, endValue, step);

        while (startValue != endValue) {
            parameterValues.add(startValue);
            startValue += step;
        }
    }

    void tryOnBadIntervalException(double startValue, double endValue, double step) {
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

    @Override
    public String toString() {
        return "StateParameter:\n Name = " + parameterName + "(for detailed information use printStateParameter().)";
    }

    public void printStateParameter() {
        System.out.println("StateParameter:\n Name = " + parameterName);
        parameterValues.stream().forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
    }
}
