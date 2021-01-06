package QuestionMet;

/**
 * ���ص�����:��n���˺�nյ�ƣ�
 * ��һ���˿����еĵƣ�
 * �ڶ����˰�����2�ı����ĵƵĿ��أ�
 * �������˰�����3�ı����ĵƵĿ��أ��������ƣ���������յ������
 * �ⷨ����������������ż������������������Ϊ��������
 * ����ƽ������������n��ƽ����������
 * Ϊ(int)sqrt(n),��n=16������16=4,����ƽ������1*1,2*2,3*3,4*4����1��4��9��16�ĸ���
 */
public class TurnOnLight {
    int bulbSwitch(int n) {
        if (n == 1)
            return 1;
        int result = 1;
        while (true) {
            if (result * result > n)
                break;
            result++;
        }
        return result - 1;
    }
}
