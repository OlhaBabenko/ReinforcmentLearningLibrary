/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Olha_Babenko
 */
public class RunToDelete {

    public static void main(String[] args) {
        SubAgent ag = new SubAgent(1, "cart");
        ag.setAgentStates("a", "b");
        ag.setAgentActions("UP", "DOWN");
        ag.printAgentInfo();

        ag.setAgentStates("c", "d");
        ag.setAgentActions("STOP", "UP");
        ag.printAgentInfo();
        System.out.println("");
        System.out.println(ag.toString());
    }
}
