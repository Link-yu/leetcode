package main.juc;

/**
 * Created on 2017/7/17.
 * Title: Simple
 * Description: Example
 * Copyright: Copyright(c) 2016
 * Company: 杭州公共交通云科技有限公司
 *
 * @author 维斯
 */
public class TestVolatile {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
//        Thread.sleep(3000);
        while(true) {
            //synchronized保证共享数据及时更新
            synchronized (td) {
                if (td.isFlag()) {
                    System.out.println("---------------");
                    break;
                }
            }
        }
        //因为这是两个独立的线程，共享数据线程间相互不可见，main线程无法获取到td线程里的变量
    }
}

class ThreadDemo implements Runnable {
    //volatile 实时刷新数据到主内存
    //相较于 synchronized 是一种轻量级的同于策略
    // 1. volatile 不具备“互斥性” 2. 不具备“原子性”

    private volatile boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("flag = " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
