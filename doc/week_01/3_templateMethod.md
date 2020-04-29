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




