#3주차 

> ##Prototype Pattern 2
***
자바에서는 이미 많은 객체들이 구현되어 있음.  
사용자들이 신경써야 할 부분들이 없도록 잘 구현되어 있지만,  
개발 시 문제가 될 수 있는 상황을 방지하기 위해서라도 자바에서의 깊은 복사와 얕은 복사에 대하여 학습할 필요가 있음.
***
 ####얕은 복사(Shallow Copy) VS 깊은 복사(Deep Copy)
1. 얕은 복사 (Shallow Copy)
    * 객체를 복사할 때, 해당 객체만 복사하여 새 객체를 생성
	* 복사된 개체의 인스턴스 변수는 원본 객체의 인스턴스 변수와 같은 메모리 주소를 참조
	* 따라서, 해당 메모리 주소의 값이 변경되면 원본 객체 및 복사 객체의 인스턴스 변수 값은 같이 변경됨

2. 깊은 복사 (Deep Copy)
	* 객체를 복사할 때, 해당 객체와 인스턴스 변수까지 복사
	* 전부를 복사하여 새 주소에 담기 때문에 참조를 공유하지 않음
***
####실습 7-1.
<pre><code>
Cat navi = new Cat();    //Cat 객체1 생성
navi.setName("navi");

Cat yo = navi;           //Cat 객체2 생성 
yo.setName("yo");

System.out.println(navi.getName()); // yo 출력
System.out.println(yo.getName());   // yo 출력
</code></pre>

Q. 왜 navi 와 yo 의 name이 동일하게 "yo"로 출력?
A. 디버깅 결과 navi와 yo의 주소값이 동일. 즉, navi가 가지고 있는 주소값을 yo가 그대로 가져감. 이것이 낮은 수준의 복사라고 함.

그렇다면 깊은 복사란?

navi의 주소값을 복사하는 것이 아닌 navi가 갖고 있는 값(프로퍼티)들을 복사해 주는 것!
***
Prototype Pattern 1에서 Clone 메소드를 통하여 객체를 복사하는 방법을 배웠음
<pre><code>
@Data
public class Cat implements Cloneable {
    private String name;
    public Cat copy() throw CloneNotSupportedException {
        Cat cat = (Cat) this.clone();
        return cat;
    }
}

//main
Cat you = navi.copy();    //copy 메소드를 사용하여 깊은복사!
</code></pre>
***
<pre><code>
@Datapublic class Age {    
    private Integer year;    
    private Integer value;
}
//main
navi.setAge(new Age(2012,3));
yo.getAge().setYear(2013);
yo.getAge().setValue(2);
System.out.println(navi.getAge().getYear());    //2013
System.out.println(yo.getAge().getYear());      //2013
</code></pre>

Q. navi와 yo의 name은 깊은 복사가 됐는데, age는 깊은 복사가 되지 않음!  
A. 자바에서 제공하는 String, Integer와 같은 클래스들은 자동으로 깊은 복사가 되도록 주소값을 변경시켜줌. (native 소스)

Q. age 도 깊은 복사가 되도록 하려면?
A. Cat 클래스의 copy 메소드에서 age를 명시적으로 깊은 복사가 되도록 작성!

<pre><code>
public Cat copy() throws CloneNotSupportedException {
    Cat cat = (Cat) this.clone();
    cat.setAge(new Age(this.age.getYear(), this.age.getValue()));
    return cat;
}
</code></pre>
***
#####깊은 복사 예제
<pre><code>
    //RestTemplate의 config 설정 시 사용되는 RequestConfig의 copy 메소드
    @SuppressWarnings("deprecation")
    public static RequestConfig.Builder copy(final RequestConfig config) {
        //new 키워드를 통하여 새로운 객체 리턴
        return new Builder()
            .setExpectContinueEnabled(config.isExpectContinueEnabled())
            .setProxy(config.getProxy())
            .setLocalAddress(config.getLocalAddress())
            .setStaleConnectionCheckEnabled(config.isStaleConnectionCheckEnabled())
            .setCookieSpec(config.getCookieSpec())
            .setRedirectsEnabled(config.isRedirectsEnabled())
            .setRelativeRedirectsAllowed(config.isRelativeRedirectsAllowed())
            .setCircularRedirectsAllowed(config.isCircularRedirectsAllowed())
            .setMaxRedirects(config.getMaxRedirects())
            .setAuthenticationEnabled(config.isAuthenticationEnabled())
            .setTargetPreferredAuthSchemes(config.getTargetPreferredAuthSchemes())
            .setProxyPreferredAuthSchemes(config.getProxyPreferredAuthSchemes())
            .setConnectionRequestTimeout(config.getConnectionRequestTimeout())
            .setConnectTimeout(config.getConnectTimeout())
            .setSocketTimeout(config.getSocketTimeout())
            .setDecompressionEnabled(config.isDecompressionEnabled())
            .setContentCompressionEnabled(config.isContentCompressionEnabled());
    }
</code></pre>
copy()하는 경우, 복사하려는 객체를 파라미터로 받고,  
생성자를 이용하여 같은 데이터를 가진 새로운 객체를 리턴(new)
***
#####Reference
	* https://gwbb.tistory.com/1
	* https://woongsin94.tistory.com/223

***

> ##Builder Pattern 1
: 복잡한 단계가 있는 인스턴스 생성성과정 단순화
***

* 학습목표  
복잡한 단계가 필요한 인스턴스 생성을 빌더 패턴을 통해 구현할 수 있다.

* Builder Pattern  
복잡한 단계를 거쳐야 생성되는 객체의 구현을 서브 클래스에게 넘겨주는 패턴

* 기본 설계  
ㅋㅋㅋㅋ

***

> ##Builder Pattern 2

*  학습목표  
많은 변수를 가진 객체의 생성을 가독성 높도록 코딩할 수 있다.

* Builder Pattern  
많은 인자를 가진 객체의 생성을 다른 객체의 도움으로 생성하는 패턴

***
