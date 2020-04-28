# 1주차 

## 1. Strategy Pattern
### 설명
- 클라이언트 객체에서 서로 교환 가능한 다른 구현들을 의존성없이 변경 가능하도록 하는 패턴
- 동일한 기능에 대한 선언을 가진 인터페이스를 다양한 클래스로 구현하고 각각의 구현들을 변경하면서 사용할 수 있도록 하는 패턴
### 인터페이스
- 객체에 대한 **선언과 기능을 분리**
- 기능 구현 시에 기능 **구현에 대한 통로**
```java
//기능에 대한 선언
interface AInterface {
  void functionA();
} 
```
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
### 델리게이트
- 구현을 **위임하는 것**
- A 클래스는 사실상 구현한 것이 없고 B 클래스의 구현을 동작을 하는 것
```java
class A {
    void functionA() {
        B b = new B();
        b.functionB();
    }
}

class B {
    void functionB() { /*구현*/}
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






