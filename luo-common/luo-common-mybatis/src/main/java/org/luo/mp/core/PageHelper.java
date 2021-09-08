package org.luo.mp.core;

import java.util.List;

/**
 * @Date 14:47 2021/7/5
 * @Description {
 *   自定义分页
 * }
 * @Author lsay
 **/
public class PageHelper {

    private int size;
    private int current;

    public int getSize() {
        return size == 0 ? 10 : size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current == 0 ? 1 : current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

}
