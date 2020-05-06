# 2주차  

------

# Singleton Pattern



## 싱글턴 패턴이란?

인스턴스를 오직 하나만 생성할 수 있는 클래스를 뜻함.



**장점**

- 고정된 메모리 영역을 얻으면서 한 번의 new로 인스턴스를 공유하기 때문에 메모리 낭비를 방지할 수 있다.
- 두 번째 사용부터는 객체 로딩 시간이 줄어들어 성능이 좋아진다.

**단점** 

- 싱글턴 인스턴스가 너무 많은 일을 하면 인스턴스의 간의 결합도가 높아진다. (OCP의 원칙에 위배 )
- 디버깅이 어려움이 있다.
- 테스트 코드의 작성의 어려움이 있다.

[https://whatisthenext.tistory.com/m/36](https://whatisthenext.tistory.com/m/36)

------

## 실습



### Version 01

```java
public class SystemSpeaker {
    private static SystemSpeaker instance;
    private int volume;

    private SystemSpeaker() {

    }

    public static SystemSpeaker getInstance() {
        if (instance == null) {
            instance = new SystemSpeaker();
        }
        return instance;
    }

    public int getVolume() {
        return volume;
   }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
```



### Version 02

```java
public class SystemSpeaker {
    private final static SystemSpeaker INSTANCE = new SystemSpeaker();

    private SystemSpeaker() {}

    public SystemSpeaker getInstance() {

        return INSTANCE;
    }
}
```



> 위의 두가지 방법은 과연 완벽한 방법일까?



아니다.

생성자가 private 접근자를 가지고 있다고 해도 접근자를 public 하게 바꿔주기만하면 인스턴스를 생성할 수 있기 때문이다.



그렇다면 최대한 방어적으로 인스턴스의 생성을 제약하는 방법은 무엇일까?

**enum**을 사용하면 된다.

###### <u>이펙티브 자바 (Joshua Bloch 지음) - 아이템 3. private 생성자나 열거 타입으로 싱글턴임을 보증하라</u>

[https://woowabros.github.io/tools/2017/07/10/java-enum-uses.html](https://woowabros.github.io/tools/2017/07/10/java-enum-uses.html)

### Version 03

```java
public enum  SystemSpeaker {
    INSTANCE();

    SystemSpeaker() {

    }

    public static SystemSpeaker getInstance() {
        return INSTANCE;
    }

    public void innerMethod() {
        System.out.println("inner Singleton");
    }
}
```

------

다시 한번 생각해보면 왜 이렇게 리플렉션 방어에 치중하는 것일까?

목적은 인스턴스를 안전하게 하나만 생성하는 것일텐대 말이다.

리플렉션이 private 생성자를 뚫을지언정 또 다른 여러가지 방어적인 코딩으로 제어할 수 있다.



예를 들자명 아래와 같은 방식으로 가능하다.

````java
private Singleton() {
  if (true)
    throw  new UnsupportedOperationException();
}
````



### Version 04 가장 많이 쓰이는 LazyHolder 방식 (Lazy Initialization)

그렇다면 가장 많이 쓰이는 방식은 아래와 같은 방식이다.

```java
public class Singleton {
    private Singleton() {

    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
```



이 방식은 클래스 내부에 static 내부 클래스를 두어서 클래스 로딩 시점에 JVM에게 인스턴스 생성을 맡겨 버리는 방법이다.



해당 방법은 클래스 초기화 시점에는 Thread-Safe를 보장하기 때문에  굳이 volatile 이나 synchronized 키워드를 사용하지 않아도되며

성능까지 보장하는 가장 널리 사용되는 싱글턴 방식이다.

[https://medium.com/@joongwon/multi-thread-%ED%99%98%EA%B2%BD%EC%97%90%EC%84%9C%EC%9D%98-%EC%98%AC%EB%B0%94%EB%A5%B8-singleton-578d9511fd42](https://medium.com/@joongwon/multi-thread-환경에서의-올바른-singleton-578d9511fd42)

------

# FactoryMethod Pattern



상속을 통해 기능을 확장하게 하는 패턴(탬플릿 메서드 패턴과 구조 유사)

슈퍼클래스의 코드에 서브클래스에서 구현할 메서드를 호출할떄 필요한 타입의 오브젝트를 가져와 사용

팩토리 메서드 패턴에는 템플릿 메서드 패턴이 사용된다.



> **쉽게 말하자면 객체를 만들어내는 부분을 서브클래스에 위임하는 패턴**
>
> 객체를 만들어내는 공장을 만드는 패턴

------

## 실습



### 요구사항

게임과 아이템과 아이템 생성을 구현
\- 아이템을 생성하기 전에 DB에서 아이템 정보를 요청
\- 아이템을 생성 후 아이템 복제 등의 불법을 방지하기 위해 DB에 아이템 생성 정보를 남긴다.

아이템을 생성하는 주체는 ItemCreator이다.

아이템은 item이라는 interface로 선언한다.
\- item은 use 메서드를 기본적으로 가지고 있다.

현재 아이템의 종류는 체력 회복 물약, 마력 회복 물약이 존재한다.



1. item 인터페이스 생성 - use() 메서드 

```java
public interface Item {
    public void use();
}
```



2. ItemCreator 추상 클래스 생성 - **템플릿 메서드 패턴**

```java
public abstract class ItemCreator {

    public Item create() {
        Item item;

        //Step01
        requestItemInfo();
        //Step02
        item = createItem();
        //Step03
        createItemLog();

        return item;
    }

    //아이템을 생성하기 전에 데이터 베이스에서 아이템 정보를 요청합니다.
    abstract protected void requestItemInfo();
    //아이템을 생성 후 아이템 복제 등의 불법을 방지하기 위해 데이터 베이스에 아이템 생성
    abstract protected void createItemLog();
    //아이템을 생성하는 알고리즘
    abstract protected Item createItem();

}
```

3. 구현 클래스 생성 

1) 위의 포션을 사용하기 위한 Creator가 필요 - ItemCreator 추상 클래스를 상속해서 구현

```java
public class HpPotion implements Item {
    @Override
    public void use() {
        System.out.println("체력 회복!");
    }
}
```



2) 이전에 생성하였던 item 인터페이스를 implements 하는 구체 클래스를 작성한다. - 요구사항의 체력 회복 물약, 마력 회복 물약

```java
public class HpCreator extends ItemCreator {
    @Override
    protected void requestItemInfo() {
        System.out.println("데이터 베이스에서 체력 회복 물약의 터정보를 가져옵니다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("체력 회복 물약을 새로 생성 했습니다."+new Date());
    }

    @Override
    protected Item createItem() {

        return new HpPotion();
    }
}
```



4. Main 함수 생성

```java
public class Main {
    public static void main(String[] args) {
        Item item;
        ItemCreator itemCreator;

        itemCreator = new HpCreator();
        item = itemCreator.create();
        item.use();

        itemCreator = new MpCreator();
        item = itemCreator.create();
        item.use();

    }
}
```

[https://jwdeveloper.tistory.com/27](https://jwdeveloper.tistory.com/27)

[https://github.com/mike6321/Spring/tree/master/1%EC%9E%A5%20%EC%98%A4%ED%94%84%EC%A0%9D%ED%8A%B8%EC%99%80%20%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84/%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%20%ED%8C%A8%ED%84%B4%26%ED%8C%A9%ED%86%A0%EB%A6%AC%EB%A9%94%EC%84%9C%EB%93%9C%20%ED%8C%A8%ED%84%B4](https://github.com/mike6321/Spring/tree/master/1%EC%9E%A5%20%EC%98%A4%ED%94%84%EC%A0%9D%ED%8A%B8%EC%99%80%20%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84/%ED%85%9C%ED%94%8C%EB%A6%BF%EB%A9%94%EC%84%9C%EB%93%9C%20%ED%8C%A8%ED%84%B4%26%ED%8C%A9%ED%86%A0%EB%A6%AC%EB%A9%94%EC%84%9C%EB%93%9C%20%ED%8C%A8%ED%84%B4)

------

# Prototype Pattern



생산 비용이 높은 인스턴스를 복사를 함으로써 쉽게 생성할 수 있도록 도와주는 패턴

<u>이펙티브 자바 (Joshua Bloch 지음) - 아이템 13. clone 재정의는 주의해서 진행하라</u>

------

## 실습



### 요구사항

일러스트레이터와 같이 그림 그리기 툴을 개발 중이다.

어떤 모양을 그릴 수 있도록 하고 복사 붙여 넣기 기능을 구현해보자

```java
public class Shape implements Cloneable{

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

```

```java
public class Circle extends Shape{

    private int x;
    private int y;
    private int r;


    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    public Circle copy() throws CloneNotSupportedException {

        Circle clone = (Circle) clone();
        clone.x = x + 1;
        clone.y = y + 1;


        return clone;
    }
}
```

```java
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle1 = new Circle(1,1,3);
        Circle circle2 = circle1.copy();

        System.out.println(circle1.toString());
        System.out.println(circle2.toString());

    }
}
```

