package DataStructure.String;


/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/12/20-10:06 AM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public enum TxStsEnum {
    /**
    *
    */
    INIT("0","Initial"),
    SUCCESS("1","Success"),
    PENDING("2","Pending"),
    FAIL("3","Failure"),
    ;

    TxStsEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private String value;
    private String desc;

    public void setValue(String value) {
        this.value = value;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static TxStsEnum getByValue(String value) {
        for (TxStsEnum type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
