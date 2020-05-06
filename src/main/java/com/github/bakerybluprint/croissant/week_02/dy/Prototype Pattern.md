# ProtoType Pattern

### 프르토타입 패턴이란?
- 생산 비용이 높은 인스턴스를 복사를 통해서 쉽게 생성할 수 있도록 하는 패턴
- 생산비용이 높은 인스턴스란?
	- 종류가 너무 많아서 클래스로 정리되지 않는 경우
	- 클래스로부터 인스턴스 생성이 어려운 경우

### UML
<img width="412" alt="스크린샷 2020-05-06 오후 10 27 54" src="https://user-images.githubusercontent.com/38370976/81227488-7a684700-9027-11ea-9fbf-96b427076f40.png">

### 예제

요구사항
- 일러스트레이터와 같은 그림그리기 툴을 개발중입니다. 어떤 모양을 그릴 수 있도록 하고 복사 붙여넣기 기능을 구현해주세요.

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



 
