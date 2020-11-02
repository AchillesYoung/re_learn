package Adapter;

/**
 * TODO
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220;
    public PowerAdapter(AC220 ac220){ this.ac220 = ac220; }
    /**
     * 调用我输出5v的
     */
    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        //变压器...流程处理成5v
        int adapterOutput = adapterInput/44;
        System.out.println("使用 PowerAdapter 输入 AC:"+adapterInput+"V"+"输出DC:"+adapterOutput+"V");
        return adapterOutput;
    }
}

//表示 5V 直流电的标准
interface DC5 {
    int outputDC5V();
}

/**
 * 输出220v，现在想让适配器转化220v为5v的
 */
class AC220 {
    public int outputAC220V() {
        System.out.println("输出交流电" + "220" + "V");
        return 220;
    }
}
