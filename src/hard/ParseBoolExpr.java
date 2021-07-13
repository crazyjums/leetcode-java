package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParseBoolExpr {

    public static boolean parseBoolExpr(String expr) {
        Deque<String> stackOprator = new ArrayDeque<>();
        Deque<String> stackOprand = new ArrayDeque<>();
        String[] strings = expr.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String tem = strings[i];
            if (tem.equals("T") || tem.equals("F") || tem.equals("(")) {
                stackOprand.addLast(tem);
            } else if (tem.equals("||") || tem.equals("&&") || tem.equals("!")) {
                stackOprator.addLast(tem);
            } else if (tem.equals(")")) {
                int trueCount = 0;
                int falseCount = 0;

                while (!stackOprand.isEmpty()) {
                    String pop = stackOprand.pollLast();
                    if (pop.equals("T")) {
                        trueCount ++;
                    } else if (pop.equals("F")) {
                        falseCount ++;
                    } else if (tem.equals("(")) {
                        break;
                    }
                }

                String operator = stackOprator.pollLast();
                if (operator.equals("||")) {
                    stackOprand.addLast(falseCount > 0 ? "F" : "T");
                } else if (operator.equals("&&")) {
                    stackOprand.addLast(trueCount > 0 ? "T" : "F");
                } else if (operator.equals("!")) {
                    stackOprand.addLast(trueCount > 0 ? "F" : "T");
                }

            }
        }


        return stackOprand.peekLast().equals("T") ? true : false;
    }

    public static void main(String[] args) {
        String s = "! F";
        System.out.println(parseBoolExpr(s));
    }
}
