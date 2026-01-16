package lab5.zad3;


import java.util.*;

public class ListTask9 {
    public static <T> List<T> symmetricDiff(List<T> l1, List<T> l2) {
        Set<T> set = new HashSet<>(l1);
        for (T x : l2)
            if (!set.add(x)) set.remove(x);
        return new ArrayList<>(set);
    }
}
