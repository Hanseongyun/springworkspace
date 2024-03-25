package com.seongyun.basic.service;

public interface Basicservice {
    // interface의 메서드는 반드시 public abstract 제어자 이어야 함
    // public abstract String getHello();              /* 인터페이스는 메서드의 선언부만 존재 */

    // public abstract 제어자는 생략해도 됨
    String getHello();
    String getApple();
}
