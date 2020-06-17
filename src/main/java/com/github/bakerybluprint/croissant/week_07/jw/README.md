# 7주차 

 

## 책임 사슬 패턴이란 무엇이고 언제 쓰는가?

어떤 요청이 해당 요청을 담당하는 책임을 가진 객체에게 들어오면 해당 객체가 요청을 처리하는 것이 일반적인 과정이지만 링크드 리스트와 같이 해당 요청을 처리하지 못하는 객체라면 다음 객체에게 해당 요청을 넘기고 요청을 받은 객체 조차 처리할 수 없다면 다음 객체로 넘기는 방식의 패턴을 의미한다.

- 이는 처리하는 객체 간의 결합도를 느슨하게 하기 위해서 사용된다.



![img](https://k.kakaocdn.net/dn/qCG36/btqEw10gjnk/FZGUp4Go26kYytpLY8zqFk/img.png)



------

## 실습

간단한 + , - 계산을 하는 계산기를 구현해보자!

 

Handler - Calculator

추상 클래스로 되어있으며 추상 메서드가 눈에 띈다.

해당 클래스를 구현하는 클래스에게 해당 요청을 처리할 수 있는지와 실질적인 구현을 위임한다.

 

```java
public abstract class Calulator {
	
	private Calulator nextCalculator;
 
	public void setNextCalculator(Calulator calulator) {
		this.nextCalculator = calulator; 
	}
	
	public boolean process(Request request) {
		if (operator(request)){
			return true;
		}else {
			if (nextCalculator != null) {
				return nextCalculator.process(request);
			}
		}
		return false;
	}
	
	abstract protected boolean operator(Request request);		
		
}
```

ConcreteHandler1

```java
public class PlusCalulator extends Calulator {
 
	@Override
	protected boolean operator(Request request) {
		// TODO Auto-generated method stub
		if(request.getOperator().equals("+")) {
			int a = request.getA();
			int b = request.getB();
			
			System.out.println(a + "+"+b + "= " +(a+b));
		}
		
		return false;
	}
}
```

ConcreteHandler2

```java
public class SubCalulator extends Calulator {
 
	@Override
	protected boolean operator(Request request) {
		// TODO Auto-generated method stub
		if(request.getOperator().equals("-")) {
			int a = request.getA();
			int b = request.getB();
			
			System.out.println(a + "+" +b+ "= " +(a-b));
		}
		
		return false;
	}
}
```

요청 - Request

```java
public class Request {
	private int a,b;
	private String operator;
	
	
	public Request(int a, int b, String operator) {
		super();
		this.a = a;
		this.b = b;
		this.operator = operator;
	}
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}	
}
```

Main

```java
public class Main {
	public static void main(String[] args) {
		Calulator plus = new PlusCalulator();
		Calulator sub = new SubCalulator();
		
		
		plus.setNextCalculator(sub);
		
		Request request1 = new Request(1,2,"+");
		Request request2 = new Request(10,2,"-");
		
		plus.process(request1);
		plus.process(request2);
	}
}
```

------

### References

https://sexycoder.tistory.com/105