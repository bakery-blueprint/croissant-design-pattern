# 컴포지트 패턴
> 학습목표 : 컴포지트 패턴을 통해서 트리구조를 구현


### 컴포지트 패턴이란?

- 객체들을 트리구조로 구성하여 부분과 전체를 나타내는 계층구조로 나타내는 패턴
- 컴포지트 패턴을 이용하면 클라이언트에서 개별 객체와 다른 객체들로 구성된 복합 객체를 똑같은 방법으로 다룰 수 있다.(전체 부분을 구분하지 않고 동일한 인터페이스를 사용함)


### UML
![KakaoTalk_Photo_2020-05-25-21-55-11](https://user-images.githubusercontent.com/38370976/82814625-787cff80-9ed2-11ea-86d7-7e0d01821a05.png)
 - Component : 개별 객체와 복합 객체를 동일시하게 만들어주는 interface, leaf 클래스와 전체에 해당하는 Composite  클래스의 공통 인퍼테이스를 정의
 - Leaf : Component를 구현한 내용물, Composite 객체의 부품으로 설정
 - Composite : 복수개의  Component를 갖도록 정의. 복수개의 Leaf, 복수개의 Composite 객체를 부분으로 가질 수 있음 
 
 ### 예제
 
 ```java
 public abstract class Entry {
     String name;
 
     public Entry(String name) {
         this.name = name;
     }
 
     public abstract void add(Entry entry);
     public abstract void printList(String path);
 }
```
- File과 Directory를 동일시하게 해주는 추상클래스
- File, Directory 모두 Component 클래스를 상속받는다.

 ```java
public class File extends Entry {
    public File(String name) {
        super(name);
    }

    public void add(Entry entry){}
    public void printList(String path) {
        System.out.println(path +"/" +this.name);
    }
}
```
 - leaf class
 
 ```java
public class Directory extends Entry {
    
    // file, directory를 추가할 수 있는 List
    // 개별 객체와 복합객체를 동일하게 다룰 수 있음
    ArrayList<Entry> directory = new ArrayList();    

    public Directory(String name) {
        super(name);
    }

    public void add(Entry entry) {  //자식 객체 추가
        directory.add(entry);
    }

    public void printList(String path) { //디렉토리 목록을 보여줍니다.
        path += "/" +this.name;
        System.out.println(path);
        for(int i = 0; i < directory.size(); i++) {
            directory.get(i).printList(path);
        }
    }
}
```

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

        root.printList("");
    }
}

//결과
//==============================
/root
/root/file1
/root/Lkt
/root/Lkt/file3
/root/bin
/root/bin/file2
/root/bin/file3
//==============================
```

- 개별 객체던 복합 객체던 동일하게 동작하도록 할 수 있으며 재귀적인 구조로 이루어져있음


https://gmlwjd9405.github.io/2018/08/10/composite-pattern.html