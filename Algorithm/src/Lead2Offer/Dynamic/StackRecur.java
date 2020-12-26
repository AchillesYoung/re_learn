package Lead2Offer.Dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackRecur {
    public static int FListRecur(int n){
        if(n == 0 || n == 1){
            return n;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for(int i = 2; i<= n; i++){
            list.add(list.get(i-2)+list.get(i-1));
        }
        return list.get(n);
    }

    public static int FRecur(int n){
        if(n == 0 || n == 1){
//            f(1)
            return n;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//f(3)
        stack.push(1);//f(3) 2
        for(int i = 2; i<=n; ++i){
            int tmp1 = stack.pop();
            int tmp2 = stack.pop();
            stack.push(tmp1);
            stack.push(tmp1 + tmp2);
        }
        return stack.peek();
    }


    public static void main(String[] args) {
//        int [] arr = new int[]{}
        //0,1,1,2,3,5,8,13,21,34
        System.out.println(FListRecur(9));
    }


}
