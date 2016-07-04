package com.bubble.test;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Singleton {
    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static Singleton singleton = new Singleton();

    //单例模式
    public static Singleton getSingleton() {
        return singleton;
    }

    //单例模式测试
    public static void main(String[] args) {
        Singleton.getSingleton();
    }
}
