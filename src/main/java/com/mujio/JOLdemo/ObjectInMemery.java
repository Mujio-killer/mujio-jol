package com.mujio.JOLdemo;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @Description: ObjectInMemery 利用jol查看对象在内存中的状态
 * @Author: GZY
 * @Date: 2020/4/22 0022
 */

public class ObjectInMemery {
    public static void main(String[] args) {

        Object o = new Object();
        o.hashCode();
        print(o);


        A a = new A();
//        print(a);

        B b = new B();
//        print(b);


        C c = new C();
        c.a = new int[10];
//        print(c.a);


        D d = new D();
        d.D = "as";
//        print(d);


        E e = new E();
        e.a = new A();
//        print(e);
        do {
            int i = 1;
        }while (true);
    }

    public static void print(Object o) {
        // 对象内存信息
        System.out.println("对象内存信息 :" + ClassLayout.parseInstance(o).toPrintable());

        // 查看对象外部信息：包括引用的对象
        System.out.println("查看对象外部信息：包括引用的对象" + GraphLayout.parseInstance(o).toPrintable());

        // 查看对象所占空间大小
        System.out.println("查看对象所占空间大小" + GraphLayout.parseInstance(o).totalSize());
    }
}


/**
 * @Description: A 定义一个空对象
 * @Author: GZY
 * @Date: 2020/4/22 0022
 */
class A {

}



/**
* @Description: B 只包含一个基本数据类型的对象
* @Author: GZY
* @Date: 2020/4/22 0022
*/
class B {
//    boolean aBoolean;
//    byte aByte; //这两项都是1字节
//    short aShort;
//    char aChar; //2字节
//    int a;
//    float aFloat; //4字节
//    long aLong;
    double aDouble;// 8字节
}


/**
* @Description: C 包含数组的类，以int数组为例
* @Author: GZY
* @Date: 2020/4/22 0022
*/
class C {
    int[] a;
}


/**
* @Description: D 包含String类型等简单引用类型
* @Author: GZY
* @Date: 2020/4/22 0022
*/
class D {
    String D;
}


/**
* @Description: E 包含自定义类
* @Author: GZY
* @Date: 2020/4/22 0022
*/
class E {
    A a;
}