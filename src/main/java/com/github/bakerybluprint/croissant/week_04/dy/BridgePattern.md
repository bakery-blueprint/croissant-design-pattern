# 브릿지 패턴

### 학습목표
> - 브랫지 패턴에 대해서 이해한다.
> - 어뎁터 패턴과 브릿지 패턴을 연결하여 이해한다.
> - 기능부분과 구현부분을 분리한다.

### UML
![KakaoTalk_Photo_2020-05-24-18-14-18](https://user-images.githubusercontent.com/38370976/82750340-7f304780-9dea-11ea-920a-74e2047ad983.png)
- Abstraction : 기능의 구현을 가지고 있는 인터페이스를 멤버변수가지고 그를 통해 기능을 동작.
- RefinedAbstraction : 기능을 재정의
- Implementor :  구현을 위한 interface
- ConcreteImplementor : interface를 구현 부분

### 예제
- 브릿지패턴 사용 전
```java
public class MorseCode {

    public void dot() {
        System.out.println(".");
    }

    public void dash() {
        System.out.println("-");
    }

    public void space() {
        System.out.println(" ");
    }
}

public class PrintMorseCode extends MorseCode {

    public PrintMorseCode g() {
        dash();dash();dot();space();
        return this;
    }
    public PrintMorseCode a() {
        dot(); dash();space();
        return this;
    }
    public PrintMorseCode r() {
        dot();dash();dot();space();
        return this;
    }
    public PrintMorseCode m() {
        dash();dash();space();
        return this;
    }
}
```

- 브랫지 패턴 사용 후
    - 기능과 구현을 분리
    - 구현된것을 쉽게 변경 할 수 있음

```java
   // Implementor
   public interface MorseCodeFunction {
       public void dot();
       public void dash();
       public void space();
   }
   
   //ConcreteImplementor
   public class DefulatMCF implements MorseCodeFunction{
       @Override
       public void dot() {
           System.out.println(".");
       }
       @Override
       public void dash() {
           System.out.println("-");
       }
       @Override
       public void space() {
           System.out.println(" ");
       }
   }

    public class FlashMCF implements MorseCodeFunction{

        @Override
        public void dot() {
            System.out.println("반짝");
        }
    
        @Override
        public void dash() {
            System.out.println("번쩍");
        }
    
        @Override
        public void space() {
            System.out.println(" ");
        }
    }
   ```

```java
// Abstraction
public class MorseCode {

    private MorseCodeFunction function;

    public MorseCode(MorseCodeFunction function) {
        this.function = function;
    }

    // 델리게이트
    public void dot() {
        this.function.dot();
    }

    public void dash() {
        this.function.dash();
    }

    public void space() {
        this.function.space();
    }
}
//RefinedAbstraction
public class PrintMorseCode extends MorseCode {

    public PrintMorseCode(MorseCodeFunction function) {
        super(function);
    }

    public PrintMorseCode g() {
        dash();dash();dot();space();
        return this;
    }
    public PrintMorseCode a() {
        dot(); dash();space();
        return this;
    }
    public PrintMorseCode r() {
        dot();dash();dot();space();
        return this;
    }
    public PrintMorseCode m() {
        dash();dash();space();
        return this;
    }
}

```

```java
public class Main3 {
    public static void main(String[] args) {

        // 기능과 구현을 분리!
        PrintMorseCode code = new PrintMorseCode(new DefulatMCF());
       // PrintMorseCode code = new PrintMorseCode(new DefulatMCF());
        code.g().a().r().a().m();
    }
}
```


