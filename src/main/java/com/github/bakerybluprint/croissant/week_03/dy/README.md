# 프로토타입 패턴 2

### 정의 
- 생성관점
- 복사를 통해 새로운 객체 (인스턴스)를 만든다는 개념.

### 사용이유
1. 종류가 너무 많이 클래스로 정리되지 않는 경우
- 취급하는 오브젝트의 종류가 너무 많아, 각각을 별도의 클래스로 만들어 다수의 소스 파일을 작성해야 함
2. 클래스로부터 인스턴스 생성이 어려운 경우
- 생성하고 싶은 인스턴스가 복잡한 작업을 거쳐 만들어지기 때문에, 클래스로부터 만들기가 매우 어려운 경우
3. framework와 생성할 인스턴스를 분리하고 싶은 경우
- 프레임워크를 특정 클래스에 의존하지 않고 만들고 싶은 경우. 클래스 이름을 지정하여 인스턴스를 만드는 것이 아니라, 이미 모형이 되는 인스턴스를 등록해 두고, 그 인스턴스를 복사하여 생성한다.

### 깊은 복사, 얕은 복사
- 깊은 복사 : 인스턴스의 값을 복사하는 것 
- 얕은 복사 : 인스턴스의 주소만 복사하는 것

```java
public class Cat implements Cloneable {

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cat copy() throws CloneNotSupportedException {

		Cat ret = (Cat)this.clone();
		return ret;
	}
}
```

```java
public class main {

	public static void main(String[] args) throws CloneNotSupportedException {

		Cat navi = new Cat();
		navi.setName("navi");

		// 이렇게 복사하면 navi 랑 yo 랑 동일한 주소값 -> 얕은 복사
		Cat yo = navi;
		System.out.println(navi.getName());
		System.out.println(yo.getName());

		// navi가 있는 주소값이 아니라 값을 복사하는 것 -> 깊은 복사
		Cat yo2 = navi.copy();
		System.out.println(navi.getName());
		System.out.println(yo2.getName());

	}
}
```

ex2.
```java

public class Age {
    int year;
    int value;

    public Age(int year, int value) {
        this.year = year;
        this.value = value;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Cat implements Cloneable {

    public String name;
    public Age age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Cat copy() throws CloneNotSupportedException {

        Cat ret = (Cat)this.clone();
        return ret;
    }
}


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Cat navi = new Cat();
        navi.setName("navi");
        navi.setAge(new Age(2018, 2));

        // navi가 있는 주소값이 아니라 값을 복사하는 것 -> 깊은 복사
        Cat yo2 = navi.copy();
        yo2.setName("yo");
        yo2.getAge().setYear(2019);
        yo2.getAge().setValue(1);

        System.out.println(navi.getName());
        System.out.println(navi.getAge().getYear());		// yo의 year인 2019 출력 -> 깊은 복사가 이뤄지지않음.

        System.out.println(yo2.getName());
        System.out.println(yo2.getAge().getYear());		// 2019 출력됨
	
    }
}
```

- 자바에서 제공하는 String, Integer 는 자동으로 깊은복사를 하도록 주소값을 변경하는 기능이 있다고 추측.
- Age Class에서 깊은 복사가 이루어지려면, Cat copy 하는 곳에서 깊은 복사를 하도록함!

```java

public class Cat implements Cloneable {

    public String name;
    public Age age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Cat copy() throws CloneNotSupportedException {

        Cat ret = (Cat)this.clone();
        ret.setAge(new Age(this.age.year, this.age.value)); // 명시적으로 깊은복사가 가능하도록함!
        return ret;
    }
}
```
참고 블로그 : https://jidolstar.tistory.com/430
http://astrod.github.io/design_pattern/2017/04/26/%ED%94%84%EB%A1%9C%ED%86%A0%ED%83%80%EC%9E%85-%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/


 
