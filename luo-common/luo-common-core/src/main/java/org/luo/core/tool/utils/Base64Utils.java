package org.luo.core.tool.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Date 10:32 2021/5/10
 * @Description {
 *
 * }
 * @Author lsay
 **/
public class Base64Utils {

    private final static Base64.Encoder encoder = Base64.getEncoder();
    private final static Base64.Decoder decoder = Base64.getDecoder();

    /**
     * 编码
     * @param s
     * @return
     */
    public static String encoder(String s){
        return encoder.encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String decoder(String s){
        return new String(decoder.decode(s),StandardCharsets.UTF_8);
    }

}
