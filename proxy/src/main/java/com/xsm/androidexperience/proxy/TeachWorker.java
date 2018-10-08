package com.xsm.androidexperience.proxy;

/**
 * Author: 夏胜明
 * Date: 2018/10/8 0008
 * Email: xiasem@163.com
 * Description:
 */
public class TeachWorker implements Worker {
    @Override
    public void work() {
        System.out.println("i gave a lecture");
    }
}
