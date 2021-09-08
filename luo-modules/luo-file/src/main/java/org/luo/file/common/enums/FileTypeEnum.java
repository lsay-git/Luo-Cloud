package org.luo.file.common.enums;

/**
 * @Date 14:01 2021/6/8
 * @Description {
 *   文件类型
 * }
 * @Author lsay
 **/
public enum FileTypeEnum {

    /**
     * 文件类型
     */
    PICTURE(1,"picture","图片"),
    VIDEO(2,"video","视频"),
    OTHER(3,"other","其他")

    ;

    private int type;
    private String code;
    private String name;

    FileTypeEnum(int type, String code, String name) {
        this.type = type;
        this.code = code;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
