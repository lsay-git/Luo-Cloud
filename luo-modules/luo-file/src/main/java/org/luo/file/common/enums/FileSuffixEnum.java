package org.luo.file.common.enums;

/**
 * @Date 16:57 2021/6/5
 * @Description {
 *  文件后缀枚举
 * }
 * @Author lsay
 **/
public enum FileSuffixEnum {
    /**
     * 图片
     */
    IMG_JPG(".jpg",".JPG"),
    IMG_PNG(".png",".PNG"),
    IMG_GIF(".gif",".GIF")
    ;

    private final String lower;
    private final String upper;

    FileSuffixEnum(String lower, String upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public String getLower() {
        return lower;
    }

    public String getUpper() {
        return upper;
    }
}
