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
        SubAgent<String, String> ag = new SubAgent<>(1,true);

        ag.setAgentStates("a", "b");
        ag.printAgentInfo();

        ag.setAgentStates("c", "d");
        ag.printAgentInfo();
    }
}
