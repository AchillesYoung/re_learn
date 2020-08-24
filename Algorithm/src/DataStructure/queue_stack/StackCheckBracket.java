package DataStructure.queue_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 待优化
 */
public class StackCheckBracket {


    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');map.put('{', '}');map.put('[', ']');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        if (!map.containsKey(chars[0])) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            //空的时候直接压进去然后跳过去这轮
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            //不是空了，那要判断2种情况，
            //先判断是key放进去还是value
            //是key可以直接放进去，不管之前怎么样，后面如果消不掉可以判断isEmpty 返回false
            //是value就要判断peek出来的值是不是跟他闭合(是不是key）,如果是value也闭合，就false，闭合的话消掉pop出来
            if (map.containsKey(chars[i])) {
                stack.push(chars[i]);
            } else if (map.get(stack.peek()).equals(chars[i])) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        String str ="()[]{}";
        String str = "{[(])}";

        System.out.println(isValid(str));

    }
}
