package com.bubble.test;

/**
 * Created by Administrator on 2016/7/4.
 */
public class LazySingleton {
    private LazySingleton() {
        System.out.println("LazySingleton is created");
    }

    private static LazySingleton instance = null;

    //延迟加载的单例模式代码
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void createString() {
        System.out.println("create Stringf");
    }

    public static void main(String[] args) {
        LazySingleton.getInstance();
    }
}
