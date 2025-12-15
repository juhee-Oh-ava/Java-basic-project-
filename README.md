# 1. 프로젝트 개요

사용자는 스토어에서 **전자책(Book)**, **영화(Movie)**, **음악(Music)**을 확인할 수 있다.

각 콘텐츠는 **공통 정보를 가지지만 종류별로 고유한 정보/기능이 있다.**

또한, 일부 콘텐츠는 **구매(Purchase)** 또는 **대여(Rent)**가 가능하며,

인터페이스를 통해 공통 기능을 강제한다.

---

---

# 2. 클래스 설계 명세

---

## ✔ 2-1. 추상적 상위 클래스: `Content`

### ● 목적

책/영화/음악의 공통 속성과 기능을 정의한다.

### ● 접근 제어

클래스: **public class Content**

### ● 필드(멤버 변수)

| 접근제어 | 타입 | 이름 | 설명 |
| --- | --- | --- | --- |
| protected | String | title | 콘텐츠 제목 |
| protected | int | price | 가격 |

### ● 생성자

```java
public Content(String title, int price)
```

### ● 메소드

### 1) `public void showInfo()`

- 제목과 가격을 출력한다.
- 자식 클래스에서 **오버라이드**하여 추가 정보 출력 가능.

예시 출력 형식:

`[Book] Title: ~~ / Price: ~~`

`[Movie] Title: ~~ / Price: ~~ / Running Time: ~~`

### 2) Getter/Setter

| 메소드 | 설명 |
| --- | --- |
| `getTitle()` | 제목 반환 |
| `setTitle(String title)` | 제목 변경 |
| `getPrice()` | 가격 반환 |
| `setPrice(int price)` | 가격 설정 (0 미만일 경우 예외 발생) |

---

---

# 3. 하위 클래스 설계

---

## ✔ 3-1. 클래스: `Book` (Content 상속)

### ● 필드

| 타입 | 이름 | 설명 |
| --- | --- | --- |
| String | author | 저자 이름 |

### ● 생성자

```java
public Book(String title, int price, String author)
```

### ● 메소드

- `@Override public void showInfo()`
    - 출력 예:
        
        `"[Book] Title: ~~ / Price: ~~ / Author: ~~"`
        

---

## ✔ 3-2. 클래스: `Movie` (Content 상속)

### ● 필드

| 타입 | 이름 | 설명 |
| --- | --- | --- |
| int | runningTime | 상영 시간(분) |

### ● 생성자

```java
public Movie(String title, int price, int runningTime)
```

### ● 메소드

- `@Override public void showInfo()`
    - 출력 예:
        
        `"[Movie] Title: ~~ / Price: ~~ / Running Time: ~~min"`
        

---

## ✔ 3-3. 클래스: `Music` (Content 상속)

### ● 필드

| 타입 | 이름 | 설명 |
| --- | --- | --- |
| String | singer | 가수 이름 |

### ● 생성자

```java
public Music(String title, int price, String singer)
```

### ● 메소드

- `@Override public void showInfo()`
    - 출력 예:
        
        `"[Music] Title: ~~ / Price: ~~ / Singer: ~~"`
        

---

---

# 4. 인터페이스 설계 명세

---

## ✔ 4-1. 인터페이스: `Purchasable`

```java
public interface Purchasable {
    void buy();
}
```

### ● 규칙

- Book, Movie, Music 모두 구매 가능
    
    → **3개 클래스 모두 Purchasable을 implements**
    

### ● buy() 동작

- 구현 클래스에서 구매 메시지를 출력한다.
- 출력 예:
    - `"[Book] 해리포터 구매 완료"`
    - `"[Movie] 인셉션 구매 완료"`
    - `"[Music] Dynamite 구매 완료"`

---

## ✔ 4-2. 인터페이스: `Rentable`

```java
public interface Rentable {
    void rent();
    void extendRent();
}
```

### ● 규칙

- **Book, Movie만 implements Rentable**
- Music은 rent 불가

### ● rent() 출력 예

- `"[Book] ~~ 대여 완료"`
- `"[Movie] ~~ 대여 완료"`

### ● extendRent() 출력 예

- `"대여 기간 연장 완료"`

---

---

# 5. 메인 프로그램 요구사항 (Main class)

---

## ✔ 5-1. ArrayList로 다양한 콘텐츠 저장

```java
ArrayList<Content> contents = new ArrayList<>();
```

### 리스트에 추가해야 할 콘텐츠(예시)

```java
new Book("해리포터", 12000, "J.K. Rowling")
new Movie("인셉션", 15000, 148)
new Music("Dynamite", 2000, "BTS")
```

---

## ✔ 5-2. showInfo() 출력

```java
for(Content c : contents) {
    c.showInfo();
}
```

### 동적 바인딩 확인

각 객체 타입(Book/Movie/Music)에 맞게 오버라이딩된 showInfo() 출력되어야 함.

---

## ✔ 5-3. 구매 기능 테스트

```java
if(c instanceof Purchasable) {
    ((Purchasable)c).buy();
}
```

---

## ✔ 5-4. 대여 기능 테스트

```java
if(c instanceof Rentable) {
    ((Rentable)c).rent();
    ((Rentable)c).extendRent();
}
```

(Music은 instanceof Rentable → false)

---

---

# 6. 예외 처리 요구사항

- Content의 `setPrice(int price)` 실행 시
    
    price < 0 이면 `IllegalArgumentException` 발생
    
    ```java
    if(price < 0) throw new IllegalArgumentException("가격은 음수가 될 수 없습니다.");
    ```
    

---

---

# 7. 출력 예 (최종 실행 흐름 예시)

[Book] Title: 해리포터 / Price: 12000 / Author: J.K. Rowling
[Movie] Title: 인셉션 / Price: 15000 / Running Time: 148min
[Music] Title: Dynamite / Price: 2000 / Singer: BTS

[Book] 해리포터 구매 완료
[Book] 해리포터 대여 완료
대여 기간 연장 완료

[Movie] 인셉션 구매 완료
[Movie] 인셉션 대여 완료
대여 기간 연장 완료

[Music] Dynamite 구매 완료