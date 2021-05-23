import java.util.*;
import java.util.stream.Collectors;

public class StreamUtils {
    /**
     * @param strings: the input collection of <code>String</code>s.
     * @return a collection of those <code>String</code>s in the input collection
     *              that start with a capital letter.
     */
    public static Collection<String> capitalized(Collection<String> strings) {
        try {
            if (strings.isEmpty())
                throw new IllegalArgumentException("The inputted Collection is empty.");
            return strings.stream()
                    .filter(e -> (e != null && e.length() != 0 && Character.isUpperCase(e.charAt(0))))
                    .collect(Collectors.toList());
        }
        catch(IndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Find and return the longest <code>String</code> in a given collection of <code>String</code>s.
     *
     * @param strings: the given collection of <code>String</code>s.
     * @param from_start: a <code>boolean</code> flag that decides how ties are broken.
    If <code>true</code>, then the element encountered earlier in
     * the iteration is returned, otherwise the later element is returned.
     * @return the longest <code>String</code> in the given collection,
     * where ties are broken based on <code>from_start</code>.
     */
    public static String longest(Collection<String> strings, boolean from_start) {
        try {
            if (strings.isEmpty())
                throw new IllegalArgumentException("The inputted Collection is empty.");
            return strings.stream()
                    .reduce("", (x, y) -> x.length() == y.length() ?
                            from_start ? x : y
                            : x.length() < y.length() ? y : x);
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Find and return the least element from a collection of given elements that are comparable.
     *
     * @param items: the given collection of elements
     * @param from_start: a <code>boolean</code> flag that decides how ties are broken.
     * If <code>true</code>, the element encountered earlier in the
     * iteration is returned, otherwise the later element is returned.
     * @param <T>: the type parameter of the collection (i.e., the items are all of type T).
     * @return the least element in <code>items</code>, where ties are
     * broken based on <code>from_start</code>.
     */
    public static <T extends Comparable<T>> T least(Collection<T> items, boolean from_start) {
        try {
            if (items.isEmpty()) {
                throw new IllegalArgumentException("Inputted Collection is empty.");
            }
            return items.stream().min((o1, o2) -> o1.compareTo(o2) == 0 ?
                    from_start ? -1 : 1
                    : o1.compareTo(o2))
                    .get();
        }
        catch(NoSuchElementException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Flattens a map to a stream of <code>String</code>s, where each element in the list
     * is formatted as "key -> value" (i.e., each key-value pair is converted to a string
     * with this format).
     *
     * @param aMap the specified input map.
     * @param <K> the type parameter of keys in <code>aMap</code>.
     * @param <V> the type parameter of values in <code>aMap</code>.
     * @return the flattened list representation of <code>aMap</code>.
     */
    public static <K, V> List<String> flatten(Map<K, V> aMap) {
        try {
            if (aMap.isEmpty())
                throw new IllegalArgumentException("Inputted Map is empty.");
            return aMap.keySet().stream()
                    .map(k -> k + " -> " + aMap.get(k))
                    .collect(Collectors.toList());
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
