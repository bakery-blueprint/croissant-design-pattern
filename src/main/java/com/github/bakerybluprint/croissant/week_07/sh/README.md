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
<img src="https://upload.wikimedia.org/wikipedia/commons/8/8d/Observer.svg" title="uml" alt="observer-patten-uml"></img>  


**구조**  
>Subject에 여러 Observer를 등록(Attach)해 두고, Notify를 하게 되면 루프를 돌면서 각 Observer를 Update하는 패턴이다.  
* Subject와 Observer가 느슨한 결합을 갖는 것이 중요하다.  
* Observer 등록 순서 등에 특정 로직이 의존하지 않도록 한다.  

<hr>

#### Java에 내장된 Observer, Observable
    
**Observer**
>* Observer는 Subject에 생긴 변화를 감시한다.
>* 여러 Observer가 Subject에 등록될 수 있다.
>* Observer는 상태를 갖지 않아도 된다.
>   * 예제에서는 Observer가 update를 통해 값을 전달받고 저장하지만, 굳이 필요가 없는 경우에는 상태를 저장하지 않아도 된다.
>* Observer의 행위가 Subject에 영향을 주는 경우
>   * 만약 Observer의 행위가 Subject에 영향을 주는 로직이 있다면, 무한 루프가 발생할 수 있으므로 주의할 필요가 있다.
>       1. Subject가 notify를 호출한다.
>       2. Observer의 update가 호출된다.
>       3. Observer::update 실행도중 Subject에 영향을 준다.
>       4. Goto 1

```java
public interface Observer {
    void update(Observable o, Object arg);
}
```

**Observable (Subject)**
>* Subject는 Observer들이 감시하고 있는 대상
>* Observer들이 변화를 감지할 수 있는 하는 상태를 갖고 있다.
>* 자신의 상태가 달라지면 Observer들에게 통보한다.
```java
public class Observable {
    private boolean changed = false;    //변화감지
    private Vector<Observer> obs;       //Observer를 등록하는 Vector

    public Observable() { obs = new Vector<>(); }   //생성되면서 할당

    //Observer 등록
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    //Observer 제거
    public synchronized void deleteObserver(Observer o) { 
        obs.removeElement(o); 
    }

    //**Subject 변경 시 Observer들에게 noti - 1) Pull 방식**
    public void notifyObservers() {
        notifyObservers(null);
    }

    //**Subject 변경 시 Observer들에게 noti - 2) Push 방식**
    public void notifyObservers(Object arg) {
        Object[] arrLocal;

        synchronized (this) {
            //Subject가 변경되지 않았으면 return
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }

        //Subject의 변경을 등록된 Observer들에게 noti
        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }
    
    //Observer 제거
    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    //**Subject의 변화**
    protected synchronized void setChanged() {
        changed = true;
    }

    protected synchronized void clearChanged() {
        changed = false;
    }

    public synchronized boolean hasChanged() {
        return changed;
    }

    public synchronized int countObservers() {
        return obs.size();
    }
}
```
<hr>

#### Observer Pattern 강의1  

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

#### Observer Pattern 강의2.
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

#### Observer Pattern 강의3.
```java

```
```java

```
<hr>  

#### Head First Design Pattern Example
날씨 정보를 각각의 디스플레이(Observer)가 구독하는 구조

**1. Observer와 Subject의 인터페이스**  
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
**2. Subject의 구현체**
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
**3. Display 인터페이스**
```java
public interface DisplayElement {
    public void display();
}
```
**4. Observer 구현체**
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
**5. main 메소드**
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

#### Observer들에게 Noti하는 방식 (Polling 방식 vs Push 방식)
1. Polling 방식  
    > 위의 소스에서 구현된 형식으로 Subject 객체는 데이터 값이 변경되었다는 사실만을 통보(그 외 나머지 역할을 Observer 객체에게 위임)  
     Observer 객체가 변경된 데이터 값을 받아가는 형식으로 데이터 값이 변경되었다는 통보와 실제 변경된 데이터 값을 가져오는 동작이 구분되어 효율이 떨어질 수 있으나, Update() 멤버함수를 항상 동일한 인터페이스 형태로 사용할 수 있다는 장점이 있다.
2. Push 방식
    > Subject 객체가 Observer 객체에게 데이터 값이 변경되었다는 사실을 통보하면서 변경된 데이터 값을 동시에 전달하는 방식.  
    Subject가 Notify() 멤버 함수 내에서 Update() 멤버함수를 호출할 때 변경된 데이터 값을 인자로 전달하는 형태 효율적이나 Update 멤버함수의 인터페이스가 항상 동일하지 않아 사용에 불편할 수 있다.
<hr>

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

<hr>

#### Observer Pattern 장단점 및 활용

**1. 장점**
>* Subject 와 Observer 가 서로 독립적으로 변경될 수 있어 두 클래스를 각각 독립적으로 재사용할 수 있다.
>* Subject 객체는 Observer 객체들을 리스트로 관리하게 되는데, 이때 Observer 객체의 자료형은 Observer 클래스의 하위 클래스면 상관없다. 즉 Subject 클래스와 Observer 클래스간의 결합도가 낮다.
>* Subject 객체는 변경된 사실이 있으면 모든 Observer 객체들에게 이 사실을 알린다. 이는 Subject 객체가 Observer 객체들을 특별히 구분하지 않는다는 것을 의미하며, 이러한 이유로 Observer 객체의 입장에서는 Subject 객체에게 자기 자신을 등록하거나 삭제하는 것이 자유롭다.  

**2. 단점**  
>* Observer 객체들은 Subject 객체의 정보를 서로서로 변경 시킬 수 있는데, 이로 인해 때로 동일한 변경 작업이 서로 다른 Observer 객체에 의해 반복 수행되는 사태가 벌어질 수 있다.  
이유는 Subject 객체와 Observer 객체가 데이터 값이 변경되었다는 사실만 주고 받기 때문이다.  
그렇기 때문에 어떤 데이터 값이 어떻게 변경되었는지를 명시적으로 교환해 주지 않는 이상 동일한 변경 작업이 서로 다른 Observer 객체에 의해 반복 수행되는 것을 막을 방법은 없다.

**3. 활용**
>* 한 객체에 대한 변경이 다른 객체들에게도 영향을 미치는 상황에서 얼마나 많은 객체가 영향을 받는지를 일일히 관리하고 싶지 않을 때  
>* 하나의 객체가 다른 객체에게 변경 사항을 알려주어야 하는데, 구체적으로 어떤 객체들에게 통보를 해야 할 지 알지 못할 때 유용하다. 이 같은 상황에서 변경이 일어난 객체가 어떤 객체들에게 변경사항을 통보해야 하는지 안다는 것은 객체들간의 결합도가 높아짐을 의미하므로 피하는 것이 좋다.

<hr>

#### 과제
> Observer Pattern을 이용한 출판사(신문사) + 구독자 예제

1. 신문사가 사업을 시작하고 신문을 찍어내기 시작
2. 독자가 특정 신문사/잡지사에 구독 신청을 하면 매번 새로운 신문/잡지가 나올 때마다 배달을 받을 수 있습니다.  
계속 구독자로 남아있는 이상 계속해서 신문/잡지를 받을 수 있습니다.
3. 신문을 더 이상 보고 싶지 않으면 구독 해지 신청을 합니다.  
그러면 더 이상 신문이 오지 않습니다.
4. 신문사가 계속 영업을 하는 이상 여러 개인 독자, 호텔, 항공사 및 기타 회사 등에서 꾸준히 구독 및 해지를 하게 됩니다.

```java
//Subject
public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notify();
}
```
```java
//Observer
public interface Observer {
    void update();  //신문사가 갖고있는 String(신문) 변경 내용 update
}
```
```java
public class Practice {
    public static void main(String[] args){
        //new 신문사
        //new 구독자 + 신문사에 구독 (register)
        //신문사 신문 발행
        //구독자 새로운 신문
        //구독자 해지
        //신문사 신문 발행
        //해지된 구독자 제외 나머지 구독자 새로운 신문
    }
}
```