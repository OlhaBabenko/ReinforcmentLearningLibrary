package model;

import java.util.Scanner;

/**
 * Class provides excluding of changes in agent's states or actions without your
 * agreement
 *
 * @author Olha_Babenko
 */
public class SafeMode {

    static boolean askForMakingChangesInStatesOrActions(String listToChange) {
        System.out.println(listToChange + " were already defined! Do you realy want to change them?");

        Scanner answer = new Scanner(System.in);
        boolean needNext = true;
        boolean toChange = false;

        while (needNext) {
            if (answer.hasNext()) {
                boolean[] checkAnsw = checkAnswer(answer.next());
                needNext = checkAnsw[0];
                toChange = checkAnsw[1];
            }
        }
        return toChange;
    }

    static boolean[] checkAnswer(String answer) {
        boolean toChangeList = false;
        boolean needNext = true;
        if (null != answer) {
            switch (answer) {
                case "y":
                case "Y":
                    needNext = false;
                    toChangeList = true;
                case "n":
                case "N":
                    needNext = false;
                default:
                    System.out.println("Please, enter 'Y' or 'N': ");
            }
        }
        return new boolean[]{needNext, toChangeList};
    }
}
