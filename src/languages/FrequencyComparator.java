package languages;

import java.util.Comparator;
import java.util.Map;

public class FrequencyComparator implements Comparator<Character> {
    private Map<Character, Double> frequencyMap;

    @Override
    public int compare(Character c1, Character c2) {
        double f1 = frequencyMap.get(c1);
        double f2 = frequencyMap.get(c2);
        if (f1 == f2) {
            return 0;
        } else if (f1 > f2) {
            return -1;
        } else {
            return 1;
        }
    }

    public FrequencyComparator(Map<Character, Double> frequencyMap) {
        this.frequencyMap = frequencyMap;
    }
}
