# Observer Pattern
> 상태 변화를 감시자에게 통보한다.
<hr>

옵저버 패턴은 객체의 상태 변화를 관찰하는 옵저버를 등록하여  
상태 변화가 있을 때마다 메소드 등을 통해 객체가 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴.  
> 주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다.  
> 발행/구독 모델로 알려져 있기도 하다.  

**대표적인 예로는**  
> 1. 외부에서 발생한 이벤트(ex. 사용자 입력)에 대한 응답, 이벤트 기반 프로그래밍
> 2. 객체의 속성 값 변화에 따른 응답, 이벤트 연쇄의 원인  
* UML 다이어그램  
<img src="https://upload.wikimedia.org/wikipedia/commons/8/8d/Observer.svg" width="450px" height="300px" title="uml" alt="observer-patten-uml"></img>  


**구조**  
>Subject에 여러 Observer를 등록(Attach)해 두고, Notify를 하게 되면 루프를 돌면서 각 Observer를 Update하는 패턴이다.  
* Subject와 Observer가 느슨한 결합을 갖는 것이 중요하다.  
* Observer 등록 순서 등에 특정 로직이 의존하지 않도록 한다.  
    
**Observer**


<hr>
#### 강의1  

```java
public class Button {

    //notify 부분
    public void onClick() {
        //이벤트 처리
        if (onClickListener != null)
            onClickListener.onClick(this);
    }

    //Observer 부분
    public interface OnClickListener {
        //update(Target) 부분
        void onClick(Button button);
    }

    private OnClickListener onClickListener;

    //setObserver(Observer) 부분
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
```
```java
public class Application {
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(new Button.OnClickListener() {  //익명함수
            @Override
            public void onClick(Button button) {
                System.out.println(button + " is clicked.");
            }
        });
        button.onClick();
    }
}
```

#### 강의2.
```java
public class Button extends Observable {
    public void onClick() {
        setChanged();
        notifyObservers();
    }
}
```
```java
//able이라 Interface같지만 구현된 클래스 (주요 메소드 정리)
public class Observable {
    //옵저버 추가
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }
    //notify
    public void notifyObservers(Object arg) {
        Object[] arrLocal;

        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }
    //setChanged
    protected synchronized void setChanged() {
            changed = true;
    }
}
```
```java
public class Application {
    public static void main(String[] args) {
        Button button = new Button();
        button.addObserver(new Observer() { //익명함수로 옵저버 추가
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(o + "is clicked.");
            }
        });
        button.onClick();
    }
}
```

#### 강의3.
```java

```
```java

```
<hr>  

#### Head First Design Pattern Example
날씨 정보를 각각의 디스플레이(Observer)가 구독하는 구조

1_ Observer와 Subject의 인터페이스  
- update 의 파라미터로 subject 가 아닌 값을 전달하고 있음  
```java
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
```
```java
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
```
2_ Subject의 구현체
```java
public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();  // 변경이 발생할 때, 알림을 돌리는 방법 선택
    }
}
```
3_ Display 인터페이스
```java
public interface DisplayElement {
    public void display();
}
```
4_ Observer 구현체
* update 호출시마다 display가 호출되면서 화면이 바뀌도록
* 생성자 파라미터로 받은 Subject에 자기 자신을 등록하기 때문에 main 메소드에서 Subject에 옵저버를 일일이 등록하지 않음.
```java
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private int id;
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData, int id) {
        this.id = id;
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();  // 편의상 여기에 배치
    }

    @Override
    public void display() {
        System.out.println("장비 ID: " + id + ", 현재 기온: " + temperature + "도, 습도: " + humidity + "%");
    }
}
``` 
5_ main 메소드
```java
public class Application {
    public static void main(String[] args) {
        WeatherData weather = new WeatherData();
        CurrentConditionsDisplay current1 = new CurrentConditionsDisplay(weather, 1);
        CurrentConditionsDisplay current2 = new CurrentConditionsDisplay(weather, 2);
        CurrentConditionsDisplay current3 = new CurrentConditionsDisplay(weather, 3);
    
        weather.setMeasurements(30,65, 30.4f);
        weather.setMeasurements(29,64, 30.5f);
        weather.setMeasurements(30,64, 30.6f);
    }
}
```
**실행결과**
```java
//장비 ID: 1, 현재 기온: 30.0도, 습도: 65.0%
//장비 ID: 2, 현재 기온: 30.0도, 습도: 65.0%
//장비 ID: 3, 현재 기온: 30.0도, 습도: 65.0%
//장비 ID: 1, 현재 기온: 29.0도, 습도: 64.0%
//장비 ID: 2, 현재 기온: 29.0도, 습도: 64.0%
//장비 ID: 3, 현재 기온: 29.0도, 습도: 64.0%
//장비 ID: 1, 현재 기온: 30.0도, 습도: 64.0%
//장비 ID: 2, 현재 기온: 30.0도, 습도: 64.0%
//장비 ID: 3, 현재 기온: 30.0도, 습도: 64.0%
```
<hr>

#### Java에 내장된 Observer, Observable


#### Java SE 9 이후 @deprecated 이유?
> Deprecated.  
> This class and the Observer interface have been deprecated. The event model supported by Observer and Observable is quite limited, the order of notifications delivered by Observable is unspecified, and state changes are not in one-for-one correspondence with notifications. For a richer event model, consider using the java.beans package. For reliable and ordered messaging among threads, consider using one of the concurrent data structures in the java.util.concurrent package. For reactive streams style programming, see the Flow API.

* Observer와 Observable이 제공하는 이벤트 모델이 제한적이다.
* Observable의 notify는 순서를 보장할 수 없으며, 상태 변경은 1:1로 일치하지 않는다.
* 더 풍부한 이벤트 모델은 java.beans 패키지가 제공하고 있다.
* 멀티 스레드에서의 신뢰할 수 있고 순서가 보장된 메시징은 java.util.concurrent 패키지의 concurrent 자료 구조들 중 하나를 골라 쓰는 편이 낫다.
* reactive stream 스타일 프로그래밍은 Flow API를 쓰기를 권한다.

**요약하면,**

* Observable이 interface가 아니라 class이다.  
    *  인터페이스에 맞춰 프로그래밍한다는 객체지향 디자인 원칙을 위배한다.
    * 이미 다른 클래스를 상속하는 클래스가 Observable을 상속할 수 없다.
    * 따라서 재사용성에 제약이 생긴다.
* 상속 위주로 작업을 하게 된다.
    * Observable을 사용하려면 서브 클래스를 만들어야 한다.
    * Observable 내부에 protected 메소드가 있어, Observable의 서브클래스를 인스턴스 변수로 사용하는 방법도 써먹을 수가 없다.
    * 상속보다 구성을 사용한다는 디자인 원칙을 위배한다.
* Observable이 java.util에 들어있기 때문에 재구현을 할 수 없다.
