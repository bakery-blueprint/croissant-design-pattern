# 빌더 패턴 

### 정의 
- 사전적의미 : 건축업자, 시공자, 건조자, 건설자
- 복잡한 단계를 거쳐야 생성되는 객체의 구현을 서브 클래스에게 넘겨주는 패턴

### UML
![KakaoTalk_Photo_2020-05-17-20-39-24](https://user-images.githubusercontent.com/38370976/82143413-c95f7900-987e-11ea-8c73-d7f8ab0376e6.png)
- Director 가 Builder를 가지고 build 하는 패턴.


### 예제
- 예제 코드 상에서 
    - Director : ComputerFactory
    - AbstractBuilder : BluePrint 
    - ConcreateBuilder : LgGramBluePrint

```java
public class Computer {

    private String cpu;
    private String ram;
    private String storage;

    public Computer(String cpu, String ram, String storage) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}
```

```java

// Builder 역할
public abstract class BluePrint {
    abstract public void setCpu();
    abstract public void setRam();
    abstract public void setStorage();

    public abstract Computer getComputer();
}

//상속
public class LgGramBluePrint extends BluePrint {

    private Computer computer;

    public LgGramBluePrint() {
        computer = new Computer("default", "default", "default");
    }
    @Override
    public void setCpu() {
        computer.setCpu("i7");
    }

    @Override
    public void setRam() {
        computer.setRam("8g");
    }

    @Override
    public void setStorage() {
        computer.setStorage("256g ssd");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
```

```java
//Director 역할!
public class ComputerFactory {

    private BluePrint bluePrint;

    public void setBluePrint(BluePrint blueprint) {
        this.bluePrint = blueprint;
    }

    public void make() {
        bluePrint.setCpu();
        bluePrint.setRam();
        bluePrint.setStorage();
    }

    public Computer getComputer() {
        return bluePrint.getComputer();
    }
}
```


```java
public class Main {
    public static void main(String[] args) {

        // 생성하는 것을 main class에서 하면 복잡해짐!
        // 생성하는 것을 다른 곳에서 하도록 하면 더욱 코드가 깔끔함
        // Computer computer = new Computer("i7", "16g", "256g ssd");
        // System.out.println(computer.toString());

        // 컴퓨터를 만드는 Facoty Class를 하나 만든다!
        // factory class 에서 객체생성하는 것을 넘겨줌으로서 간단하게 구현
        ComputerFactory factory = new ComputerFactory();
        factory.setBluePrint(new LgGramBluePrint());
        factory.make();
        Computer computer = factory.getComputer();
        System.out.println(computer.toString());
    }
}
```

## 빌더패턴 2
- 많은 변수를 가진 객체의 생성을 가독성 높도록 코딩할 수 있다.
- 많은 인자를 가진 객체 생성을 다른 객체의 도움으로 생성하는 패턴.

```java
public class Main {

    public static void main(String[] args) {

        //  cpu, ram, storagem 순서인데 인자 순서를 잘못 넣을 수 있음!
        // Computer computer = new Computer("256 ssd", "i7", "8g");

        // 인자가 많은 경우 실수를 줄이기 위해  체이닝
        // 가독성이 높아짐!
        Computer computer = ComputerBuilder
                .start()
                .setCpu("i7")
                .setRam("8g")
                .setStorage("256 ssd")
                .build();

        System.out.print(computer.toString());
    }
}

public class ComputerBuilder {

    private Computer computer;

    private ComputerBuilder() {
        computer = new Computer("default", "default", "default");
    }

    public static ComputerBuilder start() {
        return new ComputerBuilder();
    }

    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder setRam(String ram) {
        computer.setRam(ram);
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    public Computer build() {
        return this.computer;
    }
}
```



 
