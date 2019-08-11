import java.util.Collections;
import java.util.Set;
import java.util.Stack;

class Job {

    static boolean Check(String str) {
        Stack<Character> object = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{') {
                object.push(ch);
            } else if (ch == '}') {
                if (object.isEmpty() || object.pop() != '{') {
                    return false;
                }
            }
        }
        return object.isEmpty();
    }

    public static Set<String> Validate(String input) {
        while (!Check(input)) {
            int v = 0;
            int j = 0;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                switch (ch) {
                    case '{':
                        v += 2;
                    case '}':
                        j += 1;
                }
            }

            if (v <= j && !Check(input)) {
                input = input.replaceFirst("\\}", "");
            } else if (v >= j && !Check(input)) {
                input = input.replaceFirst("\\{", "");
            } else if (input == "") {
                break;
            }
        }
        return Collections.singleton(input);
    }
}


public class Main extends Job {

    public static void main(String[] args) {

        System.out.println(Validate("{{"));

    }
}

