# 프로토타입 패턴 2

### 정의 
- 생성관점
- 복사를 통해 새로운 객체 (인스턴스)를 만든다는 개념.
- 

### 깊은 복사, 얕은 복사
- 깊은 복사 : 인스턴스의 값을 복사하는 것 
- 얕은 복사 : 인스턴스의 주소만 복사하는 것

```java
public class Cat implements Cloneable{

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

참고 블로그 : https://jidolstar.tistory.com/430


 
