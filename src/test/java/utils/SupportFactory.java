package utils;

import java.util.List;

public class SupportFactory {
    public String listToString(List<String> list) {
        return String.join(", ", list);
    }

    public int getRandomNaturalNumber(int max) {
        return (int) Math.floor(Math.random() * max);
    }
}
