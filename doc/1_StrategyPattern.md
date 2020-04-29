# 1. Strategy Pattern
### 설명
- 여러 알고리즘을 하나의 추상적인 접근점(인터페이스)을 만들어 접근점에서 서로 교환가능하도록 하는 패턴.
- 동일한 기능에 대한 선언을 가진 인터페이스를 다양한 클래스로 구현하고 각각의 구현들을 변경하면서 사용할 수 있도록 함.
### 인터페이스
- 사전적의미 : 키보드나 디스플레이 따위처럼 사람과 컴퓨터를 연결하는 장치
- 기능에 대한 **선언과 구현 분리** 
- 기능 구현 시에 기능 **구현에 대한 통로**
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
- 특정 객체의 기능을 사용하기 위해 다른 객체의 기능을 호출하는것.
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



### 예제 코드
- 중심이 되는 캐릭터라는 객체
- 캐릭터는 무기를 소지
- 무기에는 공격이라는 기능이 있고 기 기능은 추상화 되어 있고 하위 객체에서 구현

```java

//GameCharacter.java
public class GameCharacter {

    private Weapon weapon;

    public int attact() {
        return weapon.doAttact();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

//Weapon.java
public interface Weapon {
    public int doAttact();
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
		
        character.setWeapon(new Sword());
	character.attact();
		
	character.setWeapon(new Ax());
	character.attact();
		
	character.setWeapon(new Knife());
	character.attact();
    }	
}

```




