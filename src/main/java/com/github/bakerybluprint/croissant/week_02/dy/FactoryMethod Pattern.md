# Factory Method Pattern

## 학습목표
> - 팩토리 메소드 패턴에서 템플릿 메소드 패턴이 사용됨을 안다.
> - 팩토리 메소드 패턴에서 구조와 구현의 분리를 이해하고 구조와 구현의 분리의 장단점을 안다.



```java
public interface Item {
    public void use();
}
```

```java
public abstract class ItemCreator {

    public Item create() {
        Item item;
        
        requestItemInfo();
        item = createItem();
        createItemLog();

        return item;
    }

    //아이템을 생성하기 전에 데이터 베이스에서 아이템 정보를 요청합니다.
    abstract protected void requestItemInfo();
    //아이템을 생성 후 아이템 복제 등의 불법을 방지하기 위해 데이터 베이스에 아이템 생성
    abstract protected void createItemLog();
    //아이템을 생성하는 알고리즘
    abstract protected Item createItem();

}
```

```java
public class HpPotion implements Item {
    @Override
    public void use() {
        System.out.println("체력 회복");
    }
}

public class HpCreator extends ItemCreator {
    @Override
    protected void requestItemInfo() {
        System.out.println("데이터 베이스에서 체력 회복 물약의 터정보를 가져옵니다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("체력 회복 물약을 새로 생성 했습니다."+new Date());
    }

    @Override
    protected Item createItem() {

        return new HpPotion();
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Item item;
        ItemCreator itemCreator;

        itemCreator = new HpCreator();
        item = itemCreator.create();
        item.use();

        itemCreator = new MpCreator();
        item = itemCreator.create();
        item.use();

    }
}
```

