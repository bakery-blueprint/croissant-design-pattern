# 1주차 

## 1. Strategy Pattern
### 설명
클라이언트 객체에서 서로 교환 가능한 다른 구현들을 의존성없이 변경 가능하도록 하는 패턴
### 인터페이스
- 객체에 대한 **선언과 기능을 분리**
```java
//기능에 대한 선언
interface AInterface {
  void functionA();
} 
```
- 기능 구현 시에 기능 **구현에 대한 통로**
```java
//선언 후 구체적인 구현이 어떤지 클래스를 통해서 만들 수 있다.
class AImplements implements AInterface {
  public void functionA(){
    //구현
  }
}

public static void main(String[] args) {
	
  AInterface aInterface = new AImplements();

  // aInterface가 어떻게 동작 할지는 런타임에서 결정된다.
  aInterface.functionA();
}
```



