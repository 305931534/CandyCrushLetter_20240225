package com.hsbc.candycrushletter;


/**
 * using a simple factory pattern for the solution
 */
public class SolutionFactory {
    public static String solution(String str, String stage) {
        BaseStrategy strategy;
        if (stage == "Stage1") {
            strategy = new RemoveStrategy();
        } else {
            strategy = new ReplaceStrategy();
        }
        return strategy.removeDuplicates(str);
    }
}
