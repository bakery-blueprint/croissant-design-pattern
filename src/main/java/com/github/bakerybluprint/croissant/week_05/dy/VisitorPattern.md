# 방문자 패턴
> 학습목표 : 방문자 패턴을 이용하여 객체에서 처리를 분리하여 사용할 수 있다.


### 방문자 패턴이란?

- 데이터 구조와 연산을 분리하여 데이터 구조의 원소들을 변경하지 않고 새로운 연산을 추가하는 패턴
- 새로 연산을 추가하려면 새로운 방문자를 추가해야함

 ### 예제
 <img width="704" alt="스크린샷 2020-06-11 오후 4 20 39" src="https://user-images.githubusercontent.com/38370976/84356722-926f4f80-abff-11ea-8a7a-d0ffac02b505.png">

 ```java
 public interface Element {
     public abstract void accept(Visitor v);
 }
```
- 방문자를 수용하기 위한 accept() 를 정의하는 인터페이스

```java
public abstract class Entry implements Element {
    String name;
    public Entry(String name) {
        this.name = name;
    }
    public abstract void add(Entry entry);
}
```
- File과 Directory가 공통적으로 구현해야 할 인터페이스를 정의하는 상위클래스 Entry 추상 클래스 정의

 ```java

public class File extends Entry {
    public File(String name) {
        super(name);
    }
    public void add(Entry entry){}

    public void accept(Visitor v) {
        v.visit(this);
    }
}

public class Directory extends Entry {

    ArrayList<Entry> directory = new ArrayList();    //자식 객체를 담기 위한 ArrayList

    public Directory(String name) {
        super(name);
    }
    public void add(Entry entry) {
        directory.add(entry);                       //자식 객체 추가
    }
    public void accept(Visitor v) {
        v.visit(this);                      //어느 visit() 메서드를 호출할지 결정납니다.
    }
}
```
 - 연산을 구현하는 부분을 방문자를 수용하는 accept() 메서드에서 구현
 - 실제 연산은 Visitor에서 수행.
 
 ```java
public abstract class Visitor {

    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}

public class ViewVisitor extends Visitor {

    private String Path = "";

    public void visit(File file) {
        System.out.println(Path + "/" + file.name);
    }
    public void visit(Directory dic) {
        Path = Path + "/" + dic.name;
        System.out.println(Path);
        for (int i = 0; i < dic.directory.size(); i++) {
            dic.directory.get(i).accept(this);
        }
    }
}
```
- Visitor 클래스에서 방문자들이 데이터 구조를 방문하기 위한 인터페이스를 정의.
- ViewVisitor 클래스는 데이터 구조를 방문하면서 각 Element 경로를 출력해주는 역할.
- visit 라는 이름으로 오버로딩 되고 있는 상태.

```java
public class Main {

    public static void main(String argsp[]) {
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory Lkt = new Directory("Lkt");
        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file3");

        root.add(file1);        //루트 디렉토리에 file1 포함
        bin.add(file2);        //bin 디렉토리에 file2 포함
        bin.add(file3);        //bin 디렉토리에 file3 포함
        Lkt.add(file4);        //Lkt 디렉토리에 file4 포함
        root.add(Lkt);        //root 디렉토리에 Lkt 디렉토리 포함
        root.add(bin);        //root 디렉토리에 bin 디렉토리 포함

        root.accept(new ViewVisitor());    //경로 출력
    }
}
```
- 새로운 연산을 추가하고자 한다면 새로운 visit() 메서드를 구현하면 됨