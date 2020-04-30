요구사항
특정 상품(가격 만원)을 주문하기 위해 주문서진입, 결제과정을 구현하라

주문서 진입가능한 상태인지 체크한다.
- 상품을 주문하기 위한 주문서 진입 전 주문가능한 상태인지 일련의 과정을 체크해야한다.
- orderSheetRequest(Customer customer, String prdNo, String giftNo) : Map<String, String>
- 결과값으로  Status(E:진입불가, S:진입가능)와 Message를 리턴받는다. 

과정
1. 주문서에 진입 시 로그인 상태인지 체크한다. checkLoginStatus() : boolean
2. 고객이 주문가능한 상태인지 체크한다. 고객은 일반고객, 임직원고객으로 나뉜다. checkCustomerStatus(Customer customer) : boolean
	일반고객은 다시  일반고객, 블랙컨슈머 고객으로 나뉨, 블랙컨슈머 고객은 구매불가능함.
	임직원 고객은 보유 포인트가 0원 이상이여야 구매가능함.
   3. 상품에 대한 재고를 체크한다.  checkProduct(String prdNo) : boolean
   4. 사은품에 대한 재고를 체크한다. checkGift(String giftNo) : boolean
	이때 임직원은 사은품이 있으면 구매불가능하다.

*주의사항
일반고객과 임직원고객에 대해 주문가능 상태 체크, 사은품 재고체크 알고리즘이 다름

-주문서 주문가능한 상태일 경우 결제한다.pay(long point) : void
1. 결제수단은 카카오페이, 신용카드, 현금결제, 포인트사용 중 가능하다.
2. 포인트 사용은 3000원까지만 가능하며 상품가격이 3000원 이상일 경우는 나머지 금액은 카카오페이, 신용카드, 현금결제 중 골라야한다.



public class Customer {

    public String userId;
    public String userName;
    public int gubun;			// 0: 임직원, 1: 일반고객, 2: 블
    public long point;

    public Customer(String userId, String userName, int gubun, long point) {
        this.userId = userId;
        this.userName = userName;
        this.gubun = gubun;
        this.point = point;
    }
}


public class shopMain {

    public static void main(String [] args) {

        Customer customer = new Customer("dynee313", "dy", 0, 0);    //도연 임직원
        //Customer customer = new Customer("imesung", "hs", 0, 10000);     //혜성 임직원
        //Customer customer = new Customer("mike6321", "jw", 1, 5000);    //준우 일반고객
        //Customer customer = new Customer("leetsh", "sh", 2, 0);      //상현 블랙컨슈머
    }
}



	
	
