package com.example.dianping.pojo.enums;

/**
 * @author zh
 * @date 2021/7/15 9:49
 */
public enum YesOrNo {
    /**
     * shi
     */
    YES(1, "是"),

    NO(0, "否");
    /**
     * vale
     */
    private Integer value;
    /**
     * description
     */
    private String description;

    YesOrNo(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

}
