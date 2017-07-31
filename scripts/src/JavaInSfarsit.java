import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JavaInSfarsit {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.addAll(Arrays.asList("a","b","a","c","d","e","f"));
        System.out.println(s);
    }

}
