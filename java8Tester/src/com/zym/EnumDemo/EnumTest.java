package com.zym.EnumDemo;

/**
 * @author wangliang
 * @date 2019/3/14 0014
 */
public enum EnumTest {
    RED("1","red"),
    BLUE("2","blue"),
    YELLOW("3","yellow"),
    BLACK("4","black"),
    PINK("5","pink"),
    ;
    private final String code;
    private final String name;

    EnumTest(String code,String name) {
        this.code=code;
        this.name=name;
    }

    public static EnumTest getByCode(String code){
        if(null == code){
            return null;
        }
        for (EnumTest temp:EnumTest.values()) {
            if(code.equals(temp.getCode())){
                return temp;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
