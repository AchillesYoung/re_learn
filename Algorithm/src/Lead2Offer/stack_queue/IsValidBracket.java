package Lead2Offer.stack_queue;

import java.util.HashMap;
import java.util.Stack;

public class IsValidBracket {

    public boolean isValid(String s){
        // ����֮��Ķ�Ӧ����
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (mappings.containsKey(chars[i])) {
                //˵�����������ˣ�����������
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(chars[i])) {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //({[}(]{)})
    }
}
