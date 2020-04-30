
# 2. Adapter Pattern
## 설명
- 이미 주어진 알고리즘을 어댑터를 통해 원하는 기능으로 변경하는 것
- 처음에 설계했던 인터페이스와 새롭게 사용하려는 라이브러리와 다를 때 어뎁터 패턴을 이용해 기능을 알맞게 변경

## UML 기본적인 구조
<img width="578" alt="스크린샷 2020-04-30 오전 9 20 58" src="https://user-images.githubusercontent.com/38370976/80659448-fad8f600-8ac3-11ea-8ae3-11557808b42d.png">
이미 주어진 Adaptee라는 알고리즘을 Adapter라는 기능을 통해 원하는 기능으로 변경하는 것


## 코드구현
### 요구사항
- 두수에 대한 다음 연산을 수행하는 객체를 만들어라
 수의 두배의 수를 반환 : twiceOf(Float) : Float
 수의 반(1/2)을 반환 :  halfOf(Float) : Float
- 구현 객체의 기능은 'Adapter'
- Math 클래스에서 두 배와 절반을 구하는 함수는 이미 구현되어 있음

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

