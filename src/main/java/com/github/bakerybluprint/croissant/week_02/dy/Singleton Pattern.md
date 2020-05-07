# Singleton pattern

### 설명
하나만 생성해야할 객체를 위한 패턴

### 객체란?
- 객체 : 속성과 기능을 갖춘 것
- 클래스 : 속성과 기능을 정의한 것
- 인스턴스 : 속성과 기능을 가진 것 중 실제하는 것

<img width="585" alt="스크린샷 2020-05-03 오후 3 51 58" src="https://user-images.githubusercontent.com/38370976/80907945-283cd280-8d56-11ea-9a38-ff965718b63d.png">

ex. 
- 자동차 : 객체 (기능: 달리는것, 속성: 속도)
- 자동차를 만들기 위해서는 설계도 :  클래스
- 실제로 공장에서 만들어진 자동차 : 인스턴스

### UML
<img width="506" alt="스크린샷 2020-05-03 오후 3 56 53" src="https://user-images.githubusercontent.com/38370976/80907992-bfa22580-8d56-11ea-8965-cf96ca9f4950.png">

- 싱글턴 클래스에서 인스턴스로 싱글턴을 하나 가지고있고, 그 싱글턴을 호출할 getInstance 메소드를 가지고있음


### 예시 코드
- 요구사항 : 개발 중인 시스템에서 스피커에 접근할 수 있는 클래스를 만들어라!
- 스피커에 접근하는 클래스가 1개 이상인 경우라면, 볼륨을 수정할 경우 모든 클래스를 돌아다니면 수정해줘야함! -> 개발복잡도 증가, 시스템 리소스 증가 -> 싱글톤 개발

```java~
public class  SystemSpeaker {

	private static SystemSpeaker instance;
	private int volume;
	
 	// 다른 곳에서 생성하지 않도록 private
	private SystemSpeaker() {
		volume = 5;
	}
	
	public static SystemSpeaker getInstance(){
		if (instance == null) {
			// 시스템 
			instance = new SystemSpeaker();
		} 
		return instance;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void getVolume() {
		return this.volume;
	}
}
```
```java~

public class Application {

	public static void main(String[] args) {
		//하나의 인스턴스에만 접근!, speaker1, speaker2 둘다 같은 주소 값을 가지고 있음!
		SystemSpeaker speaker1 = SystemSpeaker.getInstance();	
		SystemSpeaker speaker2 = SystemSpeaker.getInstance();
		
		speaker1.setVolume(11);
		speaker2.setVolume(12);
		
		//같은 인스턴스이기 때문에 같은 volume 출력
		System.out.println(speaker1.getVolume());	//12 출력
		System.out.println(speaker2.getVolume());	//12 출력
		
	}
}
```
 
