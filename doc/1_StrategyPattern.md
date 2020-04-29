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


## 2. Adapter Pattern
### 설명
- 이미 주어진 알고리즘을 어댑터를 통해 원하는 기능으로 변경하는 것
- 처음에 설계했던 인터페이스와 새롭게 사용하려는 라이브러리와 다를 때 어뎁터 패턴을 이용해 기능을 알맞게 변경

### 

```java
// * 사용하려는 인터페이스
public interface Adapter {
    //두배
    public Double twiceOf(Float num);
    //절반
    public Double halfOf(Float num);
}


// *이미 존재하는 기능
public class Math {
    //두배 
    public static double twoTime(double num){return num*2;}
    //절반
    public static double half(double num){ return num/2;}
}


// * 구현체
public class AdapterImpl implements Adapter {
    @Override
    public Double twiceOf(Float num) {
	return Math.doubled(num.doubleValue());
    }

    @Override
    public Double halfOf(Float num) {
        return Math.half(num);
    }
}
```

## 3. Template Method Pattern

### 설명
- 알고리즘의 구조를 메소드에 정의하고 하위클래스에서 구조변경없이 알고리즘만 재정의해서 사용하는 패턴
- 구현하는 알고리즘이 일정한 프로세스가 있고, 알고리즘이 변경가능성이 있을 경우 사용

### 단계
- 알고리즘을 **여러 단계**로 나눈다.
- 나눠진 알고리즘의 단계를 **메소드로 선언**한다.
- 알고리즘을 수행할 **템플릿 메소드**를 만든다.
- 하위 클래스에서 **나눠진 메소드를 구현**한다.

### 예제코드 확인

```java
//Abstract class
public abstract class AbstGameConnectHelper {
  protected abstract String doSecurity(String string);
  protected abstract boolean authentication(String id, String password);
  protected abstract int authorization(String userName);
  protected abstract String conection(String info);

  //템플릿 메소드
  public String requestConnection(String encodedInfo) {
    //보안 과정 -> 암호화 된 문자열을 디코드(복호화) 한다.
    String decodedInfo = doSecurity(encodedInfo);

    //인증 과정
    String id = "aaa";
    String password = "bbb";
    if(!authentication(id, password)) {
      throw new Error("아이디 암호 불일치");
    }

    //권한 과정
    String userName = "mesung";
    int i = authorization(userName);
    switch (i) {
      case 0: //게임 매니저
        break;
      case 1: //유료 회원
        break;
      case 2: //무료 회원
        break;
      case 3: //권한 없음
        break;
      default://기타 상황
    }

    //접속 과정
    return conection(decodedInfo);
  }
}

//Concrete Class
public class DefaultGameConnectHelper extends AbstGameConnectHelper{
  @Override
  protected String doSecurity(String string) {
    System.out.println("디코드");
    return string;
  }

  @Override
  protected boolean authentication(String id, String password) {
    System.out.println("아이디/암호 확인 과정");
    return true;
  }

  @Override
  protected int authorization(String userName) {
    System.out.println("권한 확인");
    return 0;
  }

  @Override
  protected String conection(String info) {
    System.out.println("마지막 접속 단계");
    return info;
  }
}

//Main
public static void main(String [] args) {
  AbstGameConnectHelper helper = new DefaultGameConnectHelper();
  helper.requestConnection("아이디 암호 등 접속 정보");
}
```




