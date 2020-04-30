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


## 예제코드 확인
<img width="564" alt="스크린샷 2020-04-30 오후 12 02 09" src="https://user-images.githubusercontent.com/38370976/80667604-96756100-8ada-11ea-97ad-8a73a7badba1.png">
- 보안, 인증, 권한, 접속 => 구현하려는 알고리즘이 일정한 프로세스가 있음


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


###추가된 요구사항
밤 10시 이후에 접속 제한
=> 알고리즘이 변경가능성이 있을 경우 사용

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
      case 1:
        throw new Error("셧다운");
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
    //밤 열시 이후 확인하는 로직 추가 
    return 0;
  }

  @Override
  protected String conection(String info) {
    System.out.println("마지막 접속 단계");
    return info;
  }
}

```
