
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

