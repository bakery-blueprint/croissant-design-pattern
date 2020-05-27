# 추상 팩토리 패턴

### 학습목표
> - 관련있는 객체의 생성을 가상화 할 수 있다.

### UML
![KakaoTalk_Photo_2020-05-24-17-15-16](https://user-images.githubusercontent.com/38370976/82749177-53a95f00-9de2-11ea-954c-449f55ae6a85.png)
 
### 예제
```java

// BikeFactory.java
public interface BikeFactory {

    public Body createBody();
    public Wheel createWheel();
}
// Body.java
public interface Body {}

// Wheel.java
public interface Wheel {}

```
```java

//SamFactory.java
public class SamFactory implements BikeFactory {
    @Override
    public Body createBody() {
        return new SamBody();
    }

    @Override
    public Wheel createWheel() {
        return new SamWheel();
    }
}

//SamBody.java
public class SamBody implements Body {}

//SamWheel.java
public class SamWheel implements Wheel {}
```

```java
public class Main {
    public static void main(String[] args) {

        // 자전거를 만드는 공장이 필요하고 공장마다 만들어줘야하는 자전거 부품, 만드는 방식이 다를때 팩토리 패턴 사용
        BikeFactory factory = new SamFactory();
        Body body = factory.createBody();
        Wheel wheel = factory.createWheel();
    }
}
```

```java
public interface GuiFactory {
    public Button createButton();
    public TextArea createTextArea();
}

public interface Button {
    public void click();
}

public interface TextArea {
    public String getText();
}
```

```java

// 원래라면 library로 제공되어야함
public class MacGuiFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("macButton");
    }
}

public class MacTextArea implements TextArea {
    @Override
    public String getText() {
        return "MacTextarea";
    }
}
```

```java
public class FactoryInstance {

    public static GuiFactory getGuiFactory() {

        if (getOsCode() == 0) {
            return new MacGuiFactory();
        } else if (getOsCode() == 1) {
            return new WindowGuiFactory();
        } else if (getOsCode() == 2) {
            return new LinuxGuiFactory();
        }
        return null;
    }

    public static int getOsCode() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            return 0;
        } else if (System.getProperty("os.name").equals("Window")) {
            return 1;
        } else if (System.getProperty("os.name").equals("Linux")) {
            return 2;
        } else {
            return 3;
        }
    }
}
```

```java
public class Main {
    public static void main(String[] args) {

        GuiFactory factory = FactoryInstance.getGuiFactory();

        Button button = factory.createButton();
        TextArea textArea = factory.createTextArea();
        button.click();
        System.out.println(textArea);
        
    }
}
```
