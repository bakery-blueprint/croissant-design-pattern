# 1. Strategy Pattern

### 설명
- 여러 알고리즘을 하나의 **추상적인 접근점(인터페이스)** 을 만들어 접근점에서 **서로 교환가능**하도록 하는 패턴.
- 동일한 기능에 대한 선언을 가진 인터페이스를 다양한 클래스로 구현하고 각각의 구현들을 변경하면서 사용할 수 있도록 함.

### 인터페이스
- 기능에 대한 **선언과 구현 분리** 
- 기능 구현 시에 기능 **구현에 대한 통로**
- 유연한 프로그램은 객체간의 의존성을 줄이기 위해서 인터페이스를 사용하며 서로 대화를 나눌 때에 인터페이스를 사용
-  인터페이스가 아니라 상속을 사용할 경우에는 결합도가 높아짐! 
```java
//기능에 대한 선언
interface AInterface {
  void functionA();
} 

//선언 후 구체적인 구현이 어떤지 클래스를 통해서 만들 수 있다.
class AImplements implements AInterface {
  public void functionA(){
    //구현
    System.out.println("AAA");
  }
}

public static void main(String[] args) {
	
  AInterface aInterface = new AImplements();
  
  // 통로
  aInterface.functionA(); 
}
```

### 델리게이트
- 구현을 **위임하는 것**
- 특정 객체의 기능을 사용하기 위해 다른 객체의 기능을 호출하는것으로 AObj는 functionA를 호출함으로서 AObj는 AInterface를 구현한 구현클래스에 구현을 위임
```java
public class AObj {

    AInterface aInterface;

    public AObj(AInterface aInterface) {
        this.aInterface = aInterface;
    }

    public void funcAA() {
    	//위임 
        aInterface.funcA();
        aInterface.funcA();
    }
}


//Main
public static void main(String []) {
  AObj aObj = new AObj(aInterface);
  aObj.funcAA();
}
```

### UML
<img width="553" alt="스크린샷 2020-04-30 오전 9 04 01" src="https://user-images.githubusercontent.com/38370976/80658689-c3694a00-8ac1-11ea-97ea-4c5f29b7bf99.png">

- Strategy
인터페이스나 추상 클래스로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시
- StrategyA, StrategyB, StrategyC
스트래티지 패턴에서 명시한 알고리즘을 실제로 구현한 클래스
- Client
스트래티지 패턴을 이용하는 역할을 수행한다.
필요에 따라 동적으로 구체적인 전략을 바꿀 수 있도록 메서드 제공

### 예제 코드
- 중심이 되는 캐릭터라는 객체
- 캐릭터는 무기(접근점)를 소지
- 무기에는 칼, 검 두가지가 있음
- 무기에는 공격이라는 기능이 있고 기 기능은 추상화 되어 있고 하위 객체에서 구현

```java

//GameCharacter.java
public class GameCharacter {
    //접근점
    private Weapon weapon;

    public void attact() {
    	if (weapon == null) {
		System.out.println("맨손공격");
	} else {
		weapon.doAttact();  // 델리게이트
	}
    }

    //교환가능
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

//Weapon.java
public interface Weapon {	//접근점
    public int doAttact();	//기능
}


//Sword.java
public class Sword implements Weapon {
    public int doAttact() {
        System.out.println("검 공격");
	return 0;
    }
}

//Knife.java
public class Knife implements Weapon {

    public int doAttact() {
        System.out.println("칼 공격");
	return 0;
    }
}

//main.java
public class Main {

    public static void main(String[] args) {
		
        GameCharacter character = new GameCharacter();
	
	// 교환하여 사용
        character.setWeapon(new Sword());
	character.attact();
		
	character.setWeapon(new Ax());
	character.attact();
		
	character.setWeapon(new Knife());
	character.attact();
    }	
}

```

## 장점
- 객체의 실시간 알고리즘의 변경시에 유용하다.
- Strategy Interface를 구현해서 신규 알고리즘을 추가하기가 용이하다. 
- 추후에 알고리즘이 변경시에도 클라이언트와 독립적으로 해당 알고리즘만 변경되면 된다.





