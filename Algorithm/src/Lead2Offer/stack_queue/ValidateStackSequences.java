package Lead2Offer.stack_queue;

import java.util.Stack;

/**

 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 输出：true
 解释：我们可以按以下顺序执行：
 push(1), push(2), push(3), push(4), pop() -> 4,
 push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
public class ValidateStackSequences {
    /**
     * 两个栈，一个pushed，一个poped，每次push前都和poped栈底的比较，如果 相等pop出来pushed里面的,pushed++
     */


    public static boolean validateSequences(int [] arr, int [] help){

        Stack<Integer> pushed = new Stack<>();
        int point =0;
        for(int i =0; i<arr.length;i++){
            pushed.push(arr[i]);
            if(arr[i]==help[point]&&point<arr.length){
                pushed.pop();
                point++;
            }
        }
        while (!pushed.isEmpty()){
            if(help[point]!=pushed.pop()){
                return false;
            }
            point++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(12/10);
        System.out.println(validateSequences(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}));
    }
}
