import org.junit.Test;

import java.util.*;

public class StringArrayTest {

    @Test
    public void firstNotDuplicatedChar() {
        String str = "total";
        List<String> list = new ArrayList<>();

        for(int i = 0;i < str.length(); ++i) {
            list.add(String.valueOf(str.charAt(i)));
        }

        Map<String, Integer> map = new HashMap<>();

        list.stream().forEach(s -> {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
                return;
            }

            map.put(s, 0);
        });

        Optional<String> first = list.stream()
                .filter(s -> map.get(s) == 0)
                .findFirst();

        first.ifPresent(s -> System.out.println(s + " is first not duplicated"));
    }
}
