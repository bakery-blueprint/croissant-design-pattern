# 4주차 

#  추상 팩토리 메서드 패턴이란?

관련 있는 객체의 생성을 가상화한다.

- 생성 부분의 가상화 
- 관련 있는 객체의 가상화

------

## 실습



![img](https://k.kakaocdn.net/dn/FPQbt/btqEcHIvI6j/9hGGa4iWlbhpYbMjkNNkuK/img.png)



 

인스턴스의 생성 부분을 추상화, 같은 책임을 갖는 부분을 추상화(역할) 하는 것이 특징이다.

###  인스턴스 생성 부분 추상화

```java
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:31 오후
 */
public interface BikeFactory {
 
    public Body createBody();
    public Wheel createWheel();
}
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:37 오후
 */
public class GtBikeFactory implements BikeFactory {
    @Override
    public Body createBody() {
        return new GtBody();
    }
 
    @Override
    public Wheel createWheel() {
        return new GtWheel();
    }
}
```

인스턴스 생성 부분을 추상화하여 하위 구현 클래스에서 인스턴스를 생성한다.

------

### 역할의 추상화

```java
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:28 오후
 */
public interface Body {
}
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:37 오후
 */
public class GtBody implements Body {
}
```

------

### 실행

```java
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:33 오후
 */
public class Main {
    public static void main(String[] args) {
        BikeFactory factory = new GtBikeFactory();
 
        System.out.println(factory.createBody().getClass());
        System.out.println(factory.createWheel().getClass());
    }
}
```



![img](https://k.kakaocdn.net/dn/3gKXb/btqEbaEUUyq/vQ0HLB6mETGdFcPaSVfoq1/img.png)

------



# 브릿지 패턴에 대해서

> 이번 포스팅에서는 브릿지 패턴에 대해서 이미 학습하였다는 전제로 브리지 패턴과 연관된 패턴들의 차이에 대해서 중점적으로 포스팅할 예정이다. 만약 브릿지 패턴에 대한 소스를 원하는 방문자들을 위해 코드 링크를 달아두었으니 참고하시길!

 

브릿지 패턴과 을 학습할 때 정말 헷갈리는 부분이 있었다. 바로 **전략 패턴, 어댑터 패턴**과의 차이였다.

별다른 차이가 없어 보이는데 왜 다른 개념으로 나누어놨을까라는 의문이 들었다.

일단은 브릿지 패턴을 살펴보기 이전에 해당 개념에 대한 차이를 명확하게 한 뒤에 본론으로 들어가 보는 것으로 하자!

 

### 브릿지 패턴 VS 어댑터 패턴

쉽게 육안으로 볼 수 있는 차이는 어댑터 패턴은 Interface를 **두 개를** 두고 브릿지 패턴은 Interface를 **한 개만** 두는 것이다.

즉 어댑터는 호환되지 않는 두 개의 인터페이스가 함께 작동하며 브릿지 패턴은 두 개의 클래스를 분리하여 추상화와 구현을 분리시켜놓았다.



![img](https://k.kakaocdn.net/dn/bl287d/btqEcGCZcD7/WBHvYNQKgNMfsnZs2GQ6hk/img.png)![img](https://k.kakaocdn.net/dn/buEx4P/btqEdxk1slV/znU2p7hHU2t7plsdRgYXPk/img.png)

왼쪽은 어댑터 패턴 오른쪽은 브릿지 패턴



또한 GOF에 따르면 어댑터 패턴은 **설계가 끝난 이후**에 사용하는 개념이다. 즉 어떠한 클래스의 인터페이스가 다른 클래스에서는 기대와는 다른 내용으로 구성되어진다면 어댑터 Interface를 하나 두어서 이격을 맞추는 것이다. 반면에 브릿지 패턴은 **설계 중** 추상과 구현을 제대로 분리시켜 설계가 변경되어도 이미 구현된 내용에는 영향이 없도록 하게 되는 것이 목적이다.

 

> 결론적으로 어댑터 패턴은 어떤 코드에 맞게끔 기존의 코드를 쓰기 위해 사용되고 브릿지 패턴은 확정성을 미리 고려하여 작성하는 기법이다.

 

### 브릿지 패턴 VS 전략 패턴

이 둘의 패턴도 골 때리게 거의 비슷하다.

하지만 **의도**가 다르다.

 

브릿지 패턴은 구현 부와 추상화 부분의 계층을 분리시켜서 계층 간의 결합도를 낮추는 패턴이고

전략 패턴은 계층 간의 결합도는 신경 쓰지 않고 빈번히 변경 되거나 다양한 방법이 존재할 경우 추상화하여 변경 가능하도록 하는 패턴이다.

 



![img](https://k.kakaocdn.net/dn/EWQGL/btqEeo2ghI9/iaAW10C9r8eT9kKshMCppk/img.png)브릿지 패턴과 전략 패턴의 차이

