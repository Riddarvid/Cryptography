package ciphers;

import java.util.Comparator;

public class SolutionComparatorBest implements Comparator<MonoSolution> {
    @Override
    public int compare(MonoSolution s1, MonoSolution s2) {
        return Double.compare(s1.getError(), s2.getError());
    }
}
