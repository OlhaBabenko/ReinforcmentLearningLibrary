/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olha_Babenko
 */
public class RunToDelete {

    private static List<Integer> elemList = new ArrayList<>();

    public static void main(String[] args) {
        SubState subSt = new SubState();
        StateParameter stateParameter = new StateParameter("stateParameter", 1, 5, 1);
        StateParameter stateParameter1 = new StateParameter("stateParameter1", 1, 5, 1);

        subSt.addAllStatesParameters(stateParameter, stateParameter1, stateParameter, stateParameter);
        System.out.println(subSt.toString());

//////        StateParameter stPar = new StateParameter("position", 1.01, 4.02, 1.03);
//////        stPar.printStateParameter();
//////        System.out.println(stPar.getParameterValues());
//////
//////        Set<Double> set = new HashSet<>();
//////        set.add(1.0);
//////        set.add(4.0);
//////        set.add(40.0);
//////        StateParameter stPar1 = new StateParameter<>("position", set);
//////        stPar1.printStateParameter();
//////        System.out.println(stPar1.getParameterValues());
//////        Set set1 = new HashSet();
//        set1.addAll(set);
//        Set<Double> set2 = set1;
//        int j = 0;
//        while (j < 8) {
//            elemList.add(j);
//            j++;
//        }
//
//        int N = elemList.size();
//        int M = N;
//        double allCases = Math.pow(N, M);
//
//        Map<Integer, List<Integer>> map = new HashMap<>((int)allCases);
//        // int[] arr = new int[M];
//
//        System.out.println(
//                "N^M = " + allCases);
//
//        int count = 0;
//
//        while (map.size() < allCases) {
//            List<Integer> list = new ArrayList<>();
//            map.put(count, list);
//            count++;
//        }
//
//        count = 0;
//        int steps = 0;
//        int elemIndx = 0;
//        while (map.get(map.size() - 1).isEmpty() || map.get(map.size() - 1).size() < N) {
//            double nextElem = Math.pow(N, (M - 1));
//            map.get(count).add(elemList.get(elemIndx));
//            steps++;
//            if (steps == nextElem) {
//                elemIndx++;
//                if (elemIndx == elemList.size()) {
//                    elemIndx = 0;
//                }
//                steps = 0;
//            }
////                System.out.println("LIST:");
////                list.stream().forEach(s -> System.out.print(s + " "));
////                System.out.print("\n");
//            count++;
//            if (count == allCases) {
//                M--;
//                count = 0;
//                elemIndx = 0;
//            }
//        }
//
//        System.out.println(
//                "size = " + map.size());
//        int i = 0;
//        while (i < allCases) {
//            map.get(i).stream().forEach(s -> System.out.print(s + " "));
//            System.out.print("\n");
//            i++;
//        }
    }
}

//        SubAgent ag = new SubAgent(1, "cart");
//        ag.setAgentStates("a", "b");
//        ag.setAgentActions("UP", "DOWN");
//        ag.printAgentInfo();
//
//        ag.setAgentStates("c", "d");
//        ag.setAgentActions("STOP", "UP");
//        ag.printAgentInfo();
//        System.out.println("");
//        System.out.println(ag.toString());
////////////while (map.size() < allCases) {
////////////            List<Integer> list = new ArrayList<>();
////////////            while (list.size() < N) {
////////////                switch (algorithmCount) {
////////////                    case 0:
////////////                        list.add(elemList.get(elemIndxF));
////////////                        stepsF++;
////////////                        if (stepsF == nextElem) {
////////////                            elemIndxF++;
////////////                            if (elemIndxF == elemList.size()) {
////////////                                elemIndxF = 0;
////////////                            }
////////////                            stepsF = 0;
////////////                        }
////////////                        algorithmCount++;
////////////                        if (list.size() == N) {
////////////                            algorithmCount = 0;
////////////                            break;
////////////                        }
////////////                    case 1:
////////////                        list.add(elemList.get(elemIndxS));
////////////                        elemIndxS++;
////////////                        if (elemIndxS == elemList.size()) {
////////////                            elemIndxS = 0;
////////////                        }
////////////                        algorithmCount++;
////////////                        if (list.size() == N) {
////////////                            algorithmCount = 0;
////////////                            break;
////////////                        }
////////////                    case 2:
////////////                        list.add(elemList.get(elemIndxT));
////////////                        stepsS++;
////////////                        if (stepsS == M) {
////////////                            elemIndxT++;
////////////                            if (elemIndxT == elemList.size()) {
////////////                                elemIndxT = 0;
////////////                            }
////////////                            stepsS = 0;
////////////                        }
////////////                        algorithmCount = 0;
////////////                }
//////////////                System.out.println("LIST:");
//////////////                list.stream().forEach(s -> System.out.print(s + " "));
//////////////                System.out.print("\n");
////////////            }
////        int count = 0;
////        int j = 0;
////        while (j < 7) {
////            elemList.add(j);
////            j++;
////        }
////
////        int N = elemList.size();
////        int M = N;
////        double allCases = Math.pow(N, M);
////
////        Map<Integer, List<Integer>> map = new HashMap<>();
////        // int[] arr = new int[M];
////
////        System.out.println(
////                "N^M = " + allCases);
////
////        while (map.size() < allCases) {
////            List<Integer> list = new ArrayList<>();
////            map.put(count, list);
////            count++;
////        }
////
////        count = 0;
////        int steps = 0;
////        int elemIndx = 0;
////        while (map.get(map.size() - 1).isEmpty() || map.get(map.size() - 1).size() < N) {
////            double nextElem = Math.pow(N, (M - 1));
////            map.get(count).add(elemList.get(elemIndx));
////            steps++;
////            if (steps == nextElem) {
////                elemIndx++;
////                if (elemIndx == elemList.size()) {
////                    elemIndx = 0;
////                }
////                steps = 0;
////            }
//////                System.out.println("LIST:");
//////                list.stream().forEach(s -> System.out.print(s + " "));
//////                System.out.print("\n");
////            count++;
////            if (count == allCases) {
////                M--;
////                count = 0;
////                elemIndx = 0;
////            }
////        }
