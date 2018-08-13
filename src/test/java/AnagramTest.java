import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnagramTest {
    static int makeAnagram(String first, String second) {
        if (first.length() > second.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }

        Map<String, Integer> firstMap = createCountMapSortedByChar(first);
        int gap = second.length() - first.length();

        for(int start = 0; start < gap; ++start) {
            if (firstMap.equals(second.substring(start, first.length() - 1))) {
                return 5;
            }
        }

        return 0;
    }

    @Test
    public void equalsMap() {
        Map<String, Integer> m1 = createCountMapSortedByChar("abcd");
        Map<String, Integer> m2 = createCountMapSortedByChar("dabc");

        assertTrue(m1.equals(m2));
    }

    private static Map<String, Integer> createCountMapSortedByChar(String first) {
        Map<String, Integer> map = new TreeMap<>();
        first.chars()
                .mapToObj(operand -> Character.getName(operand))
                .forEach(value -> {
                    if (map.containsKey(value)) {
                        map.put(value, map.get(value) + 1);
                    } else {
                        map.put(value, 0);
                    }
                });

        return map;
    }

    @Test
    public void name() {
//        assertEquals(4, makeAnagram("abc", "cde"));
        assertEquals(30, makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}
