# 카카오페이 사전과제 (2020) - 쿠폰 제공 서비스
## 목차
- 개발 환경
- 프레임워크
- 문제 해결 전략

## 개발 환경 
- 일단 저의 개발 커리어는 그동안 반도체 설비들을 타겟으로 전반적인 하드웨어 구동에 초점을 맞추어서 소프트웨어를 개발하였습니다. 
그래서 웹 어플리케이션 쪽의 경험이 그리 많지가 않고 사실 이번 과제를 수행하는 것조차 쉽지는 않았습니다.
- 보통의 소프트웨어가 (Framework + Algorithm)으로 구성이 된다면 이번 과제 같은 경우 저는 Algorithm보다 Framework을 공부하고 
구현하는데 많은 시간을 들였습니다.
- 많은 부분에서 어설픈 점들이 눈에 들어오실텐데 이는 테크니컬한 측면에서 시간이 약간 필요한거지 기본적인 개념들은 다 파악이 된 상태입니다.
- 순수 소프트웨어 실력도 중요하지만 저같이 반도체 라인이라는 도메인 내에서 robust하게 설비를 제어했던 개발 경험도 카카오페이에 필요하지 
않을까 생각합니다. 

## 프레임워크 
- Java 8 
- Spring Boot 2.3.0
- Gradle
- JPA

## 문제 해결 전략 

### 기본 엔터티 

쿠폰 아이디  |       만료일            |      사용자        |      사용완료여부
------------|-----------------------|-------------------|------------------
ID (String) | dateExpired (String)  | ofUser (String)   |  bUsed (boolean)   


### 100억개 이상 쿠폰 관리 저장 가능

+ 언뜻 봐서는 Random을 이용해야할 것 같지만 쿠폰 ID는 굳이 무작위 선택이 아닌 앞에서부터 하나씩 배정해도 큰 상관이 없음
+ 100억 = 10^10, log(2)(10^10) ~ 33.2 = 34, 즉 이론적으로는 34비트로 접근이 가능
+ OS의 메모리 관리 파트에서 Heap 영역에서 이루어지는 동적 할당 개념을 참조 
````
    struct Block {
        boolean bUsed;  //해당 메모리 사용 여부
        Integer iSize;  //얼마만큼 사용하는지 (또는, 얼마만큼 비어있는지)
    }

````

### 10만개 이상 벌크 csv Import 기능

+ CsvToBean이라는 library를 사용







