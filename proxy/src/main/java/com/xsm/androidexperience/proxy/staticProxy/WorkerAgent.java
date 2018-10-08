package com.xsm.androidexperience.proxy.staticProxy;

import com.xsm.androidexperience.proxy.Worker;

/**
 * Author: 夏胜明
 * Date: 2018/10/8 0008
 * Email: xiasem@163.com
 * Description:
 */
public class WorkerAgent implements Worker {
    private Worker worker;

    public WorkerAgent(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void work() {
        System.out.println("start work");
        worker.work();
        System.out.println("end work");
    }
}
