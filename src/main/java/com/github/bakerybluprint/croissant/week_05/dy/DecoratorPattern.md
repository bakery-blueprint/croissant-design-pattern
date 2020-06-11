# 데코레이터 패턴
> 학습목표 : 동적으로 책임 추가가 필요할 때 데코레이터 패턴을 사용할 수 있다.

### 데코레이터 패턴이란?
- 기본 기능에 추가해야하는 기능이 많은 경우 추가 기능 Decorator 클래스로 정의 한 후 필요한 객체를 조합하여 추가기능 조합을 설계
- 객체의 결합을 통해 기능을 유연하게 확장할 수 있는 패턴

### UML
<img width="522" alt="스크린샷 2020-05-31 오후 4 40 29" src="https://user-images.githubusercontent.com/38370976/83347120-937dc280-a35d-11ea-8904-dea123730233.png">

- Component : 기본 기능을 뜻하는 ConcreteComponent와 추가 기능을 뜻하는 Decorator의 공통 기능을 정의하는 인터페이스
              즉, 클라이언트는 Component를 통해 실제 객체를 사용함
- ConcreateComponent : 기본기능을 구현하는 클래스
- Decorator : 추가 기능을 구현하기 위한 공통 클래스
- ConcreteDecorator : Decorator의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻함


### 예제 
 
> 에스프레소, 물, 스팀밀크, 헤이즐럿시럽, 초콜릿 시럽, 카라멜시럽 
- 모두 조합해야 하는 경우 각 조합별로 클래스를 만들어주어야함!
- 문제점 : 다양한 기능의 조합을 고려한 경우 상속을 통한 기능확장은 각 기능별로 클래스가 추가되어야 한다는 문제점이 있다. ex. EspressoAndSteamMilk.class
- 해결책 : 각 추가 기능별로 개별적인 클래스를 설계하고 기능을 조합할 때 각 클래스의 객체 조합을 이용
 
 ```java
//Component
public interface IBeverage {
	
	/**
	 * 총 가격
	 */
	int getTotalPrice();
}
```

```java
// ConcreateComponent : 기본 기능을 구현한 클래스
public class Base implements IBeverage {

	@Override
	public int getTotalPrice() {
		return 0;
	}

}
```
- 기본기능 : 총 가격이 0원을 기본으로 함  

```java
// Decorator : 추가 기능을 구현하기 위한 공통 클래스
abstract public class AbstAdding implements IBeverage {
	
	private IBeverage base;
	
	public AbstAdding(IBeverage base) {
		this.base = base;
	}
	
	@Override
	public int getTotalPrice() {
		return base.getTotalPrice();
	}
	
	protected IBeverage getBase() {
		return base;
	}
}
```

```java
//ConcreteDecorator : Decorator의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻함
public class Espresso extends AbstAdding {

	static protected int espressoCount = 0;
	
	public Espresso(IBeverage base) {
		super(base);
	}
	
	@Override
	public int getTotalPrice() {
		return super.getTotalPrice() + 100;
	}
}

public class Milk extends AbstAdding {

	public Milk(IBeverage base) {
		super(base);
	}
	
	@Override
	public int getTotalPrice() {
		return super.getTotalPrice() + 50;
	}
	
}
```

```java
public class Main {

	public static void main(String[] args) {

		// base
		IBeverage beverage = new Milk(new Espresso(new Base()));

		System.out.println("음료 가격 : " + beverage.getTotalPrice());
	}
}
```
<img width="660" alt="스크린샷 2020-06-11 오후 6 12 42" src="https://user-images.githubusercontent.com/38370976/84367445-357b9580-ac0f-11ea-8d83-a41727ad3a18.png">

- 제일 바깥쪽 데코레이터인 Milk의 getTotalPrice 호출하고 다시 Milk에서는 Espresso의 getTotalPrice 호출, Espresso에서는 Base의 getTotalPrice 를 호출
- Base의 0원 리턴, Espresso의 100원 리턴, Milk에서 50원 리턴하여 총 150원 리턴!

>- 객체에 대한 접근이 모두 IBeverage를 통해 이루어진다. 
>- 즉 어떤 기능을 추가하느냐에 관계없이 Client 클래스는 동일한 IBeverage를 통해 일관성 있는 방식으로 정보를 표시
>- 이렇게 Decorator 패턴을 이용하면 추가 기능 조합별로 별도의 클래스를 구현하는 대신 각 추가 기능에 해당하는 클래스의 객체를 조합해 추가 기능의 조합을 구현할 수 있게 된다.
>이 설계는 추가 기능의 수가 많을수록 효과가 크다.
>- 데코레이터 패턴을 사용하면 자잘한 객체들이 매우 많이 추가될 수 있고, 데코레이터를 너무 많이 사용하면 코드가 필요 이상으로 복잡해 질 수 도 있다
                   
#### 데코레이터 패턴의 대표적인 예로는 자바 API의 파일 I/O       

<img width="715" alt="스크린샷 2020-05-31 오후 5 57 33" src="https://user-images.githubusercontent.com/38370976/83348508-4f43ef80-a368-11ea-9644-d70b35297202.png">

- java.io에 있는 InputStream, Reader, OutputStream, Writer 등은 모두 Decorator 패턴으로 구성

```java
// FileInputStream을 만들고 BufferdInputStream, LineNumberInputStream로 감싼다
InputStream in = new LineNumberInputStream(
                        new BufferdInputStream(
                            new FileInputStream("test.txt")
                        )
                    );
 
                
// 버퍼링 + 파일에서 읽기
Reader reader = new BufferedReader(
    new FileReader("test.txt")
);

// 라인 넘버 + 버퍼링 + 파일에서 읽기
Reader reader = new LineNumberReader(
    new BufferedReader(
        new FileReader("test.txt")
    )
);
```