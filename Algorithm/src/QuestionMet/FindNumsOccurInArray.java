package QuestionMet;

public class FindNumsOccurInArray {

    public int solution(int[] arr) {
        int count = 0;
        int num = arr[0];
        for (int j = 0; j < arr.length; j++) {
            //System.out.println(a[j]);
            if (arr[j] == num) count++;
            else if (count > 0) count--;
            else num = arr[j];
        }
        return num;
    }
}
