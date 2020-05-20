# 3주차 

 

## 프로토타입 패턴이란?

생산 비용이 높은 인스턴스를 복사를 함으로써 쉽게 생성할 수 있도록 도와주는 패턴 

------

## 실습

일러스트레이터와 같이 그림 그리기 툴을 개발 중이다.

어떤 모양을 그릴 수 있도록 하고 복사 붙여 넣기 기능을 구현해보자

```
public class Shape implements Cloneable{
 
    private String id;
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Circle extends Shape{
 
    private int x;
    private int y;
    private int r;
 
 
    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
 
    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
 
    public Circle copy() throws CloneNotSupportedException {
 
        Circle clone = (Circle) clone();
        clone.x = x + 1;
        clone.y = y + 1;
 
 
        return clone;
    }
}
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle1 = new Circle(1,1,3);
        Circle circle2 = circle1.copy();
 
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
        
    }
}
```

Object 클래스의 clone을 재정의 하는 클래스를 생성하여 (Shape)

해당 클래스를 상속 받음으로써 객체에 대한 복사를 가능하게 한다. 



## 빌더 패턴이란? 

복잡한 단계가 필요한 인스턴스 생성을 빌더 패턴을 통해서 구현할 수 있다.

------

## 실습 (1)

> 서브 클래스에게 넘겨서 인스턴스를 생성

### 기본 Structure



![img](https://k.kakaocdn.net/dn/cMVf32/btqD0NQQOLo/H9dgzKiCgozYKUgKPkgFc0/img.png)



 

### Factory 생성 

- 구현할 클래스에 대한 추상 클래스 정보를 가지고 있다.
- 전달받은 인스턴스 (구현할 클래스)에 따라서 해당 클래스의 구현 로직에 맞게 값을 주입한다.

아래 코드에서는 추상 클래스 정보는 BluePrint 

해당 추상 클래스를 구현하는 하위 클래스를 아규먼트로 전달받아서 값을 주입한다.

```
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:06 오후
 */
public class ComputerFactory {
 
    private BluePrint bluePrint;
 
    public void setBlueprint(BluePrint blueprint) {
        this.bluePrint = blueprint;
    }
 
    public void make() {
        bluePrint.setRam();
        bluePrint.setCpu();
        bluePrint.setStorate();
    }
 
    public Computer getComputer() {
        return bluePrint.getComputer();
    }
}
```

------

 

 

### 추상 클래스 생성 : 추상 메서드 생성

```
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:03 오후
 */
public abstract class BluePrint {
    abstract void setCpu();
    abstract void setRam();
    abstract void setStorate();
    abstract Computer getComputer();
}
```

### 구현 클래스 생성

- 구현 클래스의 리턴 값은 Computer이다.
- Computer 클래스는 구현 클래스에 대한 정보를 포함하고 있다.

```
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:05 오후
 */
public class LgGramBlueprint extends BluePrint{
 
    private String cpu;
    private String ram;
    private String storage;
 
    @Override
    public void setCpu() {
        this.cpu = "i7";
    }
 
    @Override
    public void setRam() {
        this.ram = "8g";
    }
 
    @Override
    public void setStorate() {
        this.storage = "256G SSD";
    }
 
    @Override
    public Computer getComputer() {
        return new Computer(cpu,ram,storage);
    }
}
```

### DTO 생성

 

```
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:25 오후
 */
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

 



![img](https://k.kakaocdn.net/dn/b1zybR/btqD4T2myjz/lGRkCA9hSXyTJlG8OgGDSK/img.png)실행 결과



------

## 실습 (2)

> 많은 인자를 가진 객체의 생성을 다른 객체의 도움으로 생성하는 패턴

 

코드의 특징은 아래와 같이 **Chaining 구조**로 이루어져 있다.

```
public class Main {
    public static void main(String[] args) {
        Computer computer = ComputerBuilder
                                .start()
                                .setCpu("i7")
                                .setRam("8g")
                                .setStorage("256G SSD")
                                .build();
 
        System.out.println(computer.toString());
    }
}
```

 

### Builder 클래스 작성

```
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:44 오후
 */
public class ComputerBuilder {
    private final Computer computer;
 
    private ComputerBuilder() {
        computer = new Computer("default","default","default");
    }
 
 
    public static ComputerBuilder start() {
        return new ComputerBuilder();
    }
 
 
    public ComputerBuilder setCpu(String cpu) {
 
        computer.setCpu(cpu);
 
        return this;
    }
 
    public ComputerBuilder setRam(String ram) {
        computer.setCpu(ram);
        
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

### 실습 (3) - Computer 클래스 없애고 내부 static 클래스로 해결

```
/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:44 오후
 */
public class ComputerBuilder {
 
    private final String cpu;
    private final String ram;
    private final String storage;
 
 
    public static class Builder {
        private String cpu = "default";
        private String ram = "default";
        private String storage = "default";
 
        public Builder cpu(String val1) {
            cpu = val1;
            return this;
        }
        public Builder ram(String val2) {
            ram = val2;
            return this;
        }
        public Builder storage(String val3) {
            storage = val3;
            return this;
        }
 
        public ComputerBuilder build() {
            return new ComputerBuilder(this);
        }
    }
 
    public ComputerBuilder(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }
 
 
    @Override
    public String toString() {
        return "ComputerBuilder{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}
```

