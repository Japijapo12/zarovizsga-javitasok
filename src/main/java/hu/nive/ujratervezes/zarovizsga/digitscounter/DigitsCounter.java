package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class DigitsCounter {
    public int getCountOfDigits(String s) {

        Set<Character> chars = new HashSet<>();

        if ( s == null || s.length() == 0) {
            return 0;
        }

        for ( char c : s.toCharArray()) {
            if ( Character.isDigit(c)) {
                chars.add(c);
            }
        }
        return chars.size();


    }
}
