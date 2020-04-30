# 3. Template Method Pattern

## 설명
- 알고리즘의 구조를 메소드에 정의하고 하위클래스에서 구조변경없이 알고리즘만 재정의해서 사용하는 패턴
- 어떨 때 사용하나? 구현하는 알고리즘이 일정한 프로세스가 있고, 알고리즘이 변경가능성이 있을 경우 사용

## 단계
- 알고리즘을 **여러 단계**로 나눈다.
- 나눠진 알고리즘의 단계를 **메소드로 선언**한다.
- 알고리즘을 수행할 **템플릿 메소드**를 만든다.
- 하위 클래스에서 **나눠진 메소드를 구현**한다.

## UML
<img width="488" alt="스크린샷 2020-04-30 오전 11 59 07" src="https://user-images.githubusercontent.com/38370976/80667412-12bb7480-8ada-11ea-8357-285d3c8f7012.png">
- AbstractClass
1. 템플릿 메서드를 정의하는 클래스
2. 하위 클래스에 공통 알고리즘을 정의하고 하위 클래스에서 구현될 기능을 abstract 메서드로 정의하는 클래스
- ConcreteClass
1. 물려받은 abstract 메서드를 구현하는 클래스
2. 상위 클래스에 구현된 템플릿 메서드의 일반적인 알고리즘에서 하위 클래스에 적합하게 오버라이드하는 클래스


## 예제코드 확인
**요구사항**

- 신작 게임의 접속을 구현해라.
  - requestConnection(String str) : String
- 유저가 게임 접속 시 다음을 고려해야한다.
  - 보안 과정 : 보안 관련 부분을 처리한다.
    - doSecurity(String string) : String
  - 인증 과정 : user name과 password가 일치하는지 확인한다.
    - authentication(String id, String password) : boolean
  - 권한 과정 : 접속자가 유료 회원인지 무료 회원인지 게임 마스터인지 확인한다.
    - authorization(String userName) : int
  - 접속 과정 : 접속자에게 커넥션 정보를 넘겨준다.
    - conection(String info) : String



*요구 사항 설계*

1. 유저가 게임 접속 시 고려해야할 알고리즘을 보안, 인증, 권한, 접속 과정으로 단계화 한다.
2. 각 과정을 추상 메소드로 선언한다.
3. 알고리즘을 수행 할 requestConnection()인 템플릿 메소드를 선언한다.
4. 메소드들을 구현할 Concrete Class를 만든다.

```java
//Abstract class
public abstract class AbstGameConnectHelper {

  //외부에 노출이 되면 안되고, 하위클래스에서 재정의 해야하기 때문에 protected 사용
  protected abstract String doSecurity(String string);
  protected abstract boolean authentication(String id, String password);
  protected abstract int authorization(String userName);
  protected abstract String conection(String info);

  //템플릿 메소드
  public String requestConnection(String encodedInfo) {
    //보안 과정 -> 암호화 된 문자열을 디코드(복호화)
    String decodedInfo = doSecurity(encodedInfo);

    //인증 과정
    String id = "aaa";
    String password = "bbb";
    if(!authentication(id, password)) {
      throw new Error("아이디 암호 불일치");
    }

    //권한 과정
    String userName = "abcd";
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

// Main
// 패키지를 나누어야함!
public static void main(String [] args) {
  AbstGameConnectHelper helper = new DefaultGameConnectHelper();
  helper.requestConnection("아이디 암호 등 접속 정보");
}
```

## 장점
- 전체적인 알고리즘은 상위 클래스에서 구현하면서 다른 부분은 하위 클래스에서 구현할 수 있도록 함으로써 전체적인 알고리즘 코드를 재사용하는 데 유용함.
