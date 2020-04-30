요구사항
상품 주문하기 위해 주문서진입, 결제과정을 구현하라
- 상품객체
- 고객객체 (gubun 0: 임직원, 1: 일반고객)

**주문서 진입가능한 상태인지 체크한다.**
- 상품을 주문하기 위한 주문서 진입 전 주문가능한 상태인지 일련의 과정을 체크해야한다.
- Method명 :orderSheetRequest(Customer customer, Product product) : Map<String, String>
- return type : Map<String, String> 결과값으로  Status(E:진입불가, S:진입가능)와 Message를 리턴받는다. 

과정
1. 주문서에 진입 시 로그인 상태인지 체크한다. checkLoginStatus() : boolean
2. 고객이 주문가능한 상태인지 체크한다. checkCustomerStatus(Customer customer) : boolean
- 일반고객과 임직원고객에 대해 주문가능 상태 체크 알고리즘이 다르다
- 일반고객일 경우 
- 임직원 고객은 보유 포인트가 0원 이상이여야 구매가능함.
3. 상품에 대한 재고를 체크한다.  checkProduct(String prdNo) : boolean
4. 사은품에 대한 재고를 체크한다. checkGift(String giftNo) : boolean
- 이때 임직원은 사은품이 있으면 구매불가능하다.


*주의사항
일반고객과 임직원고객에 대해 주문가능 상태 체크, 사은품 재고체크 알고리즘이 다름


**주문서 주문가능한 상태일 경우 결제한다.pay(long point) : void**
1. 결제수단은 카카오페이, 신용카드, 현금결제, 포인트사용 중 가능하다.
2. 포인트 사용은 3000원까지만 가능하며 상품가격이 3000원 이상일 경우는 나머지 금액은 카카오페이, 신용카드, 현금결제 중 골라야한다.



- 상품객체
```java
public class Product {
    public long prdCd;      // 상품코드
    public long prdPrc;     // 상품가격
    public boolean giftFlg; // 사은품 여부
    
    public Product(long prdCd, long prdPrc, boolean giftFlg) {
        this.prdCd = prdCd;
        this.prdPrc = prdPrc;
        this.giftFlg = giftFlg;
    }
}
'''
- 고객객체 (gubun 0: 임직원, 1: 일반고객, 2:블랙컨슈머)

```java
public class Customer {

    public String userId;
    public String userName;
    public int gubun;			// 0: 임직원, 1: 일반고객, 2: 블랙컨슈머
    public long point;

    public Customer(String userId, String userName, int gubun, long point) {
        this.userId = userId;
        this.userName = userName;
        this.gubun = gubun;
        this.point = point;
    }
}
```


public class shopMain {

    public static void main(String [] args) {

        Customer customer = new Customer("dynee313", "dy", 0, 0);    //도연 임직원
        //Customer customer = new Customer("imesung", "hs", 0, 10000);     //혜성 임직원
        //Customer customer = new Customer("mike6321", "jw", 1, 2000);    //준우 일반고객
        //Customer customer = new Customer("leetsh", "sh", 2, 0);      //상현 블랙컨슈머
    }
}



	
	
