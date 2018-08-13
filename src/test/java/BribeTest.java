import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BribeTest {
    static String minimumBribes(int[] q) {
        int bribe = 0;
        int index = q.length - 1;

        while(index >= 0) {
            int exactValue = (index + 1);

            if (q[index] != exactValue) {
                int exactValueIndex = findIndexWhereValueIs(q, exactValue);
                if (exactValueIndex < 0) {
                    return tooChaotic();
                }

                if (!verifySequence(q, exactValueIndex, index)) {
                    return tooChaotic();
                }

                bribe += (index - exactValueIndex);
                index = exactValueIndex - 1;
            }
        }

        return String.valueOf(bribe);
    }

    static String tooChaotic() {
        return "Too Chaotic";
    }

    static int findIndexWhereValueIs(int[] q, int value) {
        for(int i = 0;i < q.length; ++i) {
            if (q[i] == value) {
                return i;
            }
        }

        return -1;
    }

    static boolean verifySequence(int[] q, int begin, int end) {
        int gap = end - begin;
        int next = q[begin] - gap;
        begin += 1;

        while(begin <= end) {
           if (next != q[begin]) {
              return false;
           }
           next += 1;
           begin += 1;
        }

        return true;
    }

    @Test
    public void testVerifySequence() {
       int[] q = {1,2,5,3,4};
       assertTrue(verifySequence(q, 2, 4));
       int[] q2 = {1};
       assertTrue("요소가 1개이고 1이면 시퀀스가 맞지", verifySequence(q2, 0, 0));
    }

    @Test
    public void testFindIndexWhereValueIs() {
        int[] q = {1,2,3,4,5};
        assertEquals(findIndexWhereValueIs(q, 1), 0);
        assertEquals(findIndexWhereValueIs(q, 19), -1);
        assertEquals(findIndexWhereValueIs(q, -20), -1);
    }

    @Test
    public void testMinimumBribes() {
        int[] q = {2, 1, 5, 3, 4};
        assertEquals("3", minimumBribes(q));
        int[] q1 = {2, 5, 1, 3, 4};
        assertEquals("Too Chaotic", minimumBribes(q1));
        int[] q2 = {1, 2, 5, 3, 7, 8, 6, 4};
        assertEquals("8", minimumBribes(q2));
    }

    @Test
    @Ignore
    public void name2() {
        int[] q = {2, 1, 3, 4, 5};
        assertEquals(minimumBribes(q), "1");
    }
}
