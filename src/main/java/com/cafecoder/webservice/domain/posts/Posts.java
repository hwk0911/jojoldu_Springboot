package com.cafecoder.webservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

/*
실제 DB의 테이블과 매칭될 클래스이며 보통 Entity클래스 라고도 한다.

JPA를 사용하면, DB데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity클래스의
수정을 통해 작업한다.

Posts 클래스에는 JPA에서 제공하는 어노테이션들이 몇개 있다.
@Entity
    1. 테이블과 링크될 클래스임을 나타낸다.
    2. 언더스코어 네이밍(_)으로 이름을 매칭한다.
        ex) SalesManager.java -> sales_manager table

@Id
    1. 해당 테이블의 PK 필드를 나타낸다.
        PK 필드란 프라이머리 키 필드를 의미한다.

@GeneratedValue
    1. PK의 생성 규칙을 나타낸다.
    2. 기본값은 AUTO로, MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 된다.
    3. 스프링 부트 2.0에선 옵션을 추가해야 auto_increment가 된다.

@Column
    1. 테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다.
    2. 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용한다.
    3. 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나 (ex: title)
       타입을 TEXT로 변경하고 싶거나(ex : content)등의 경우에 사용된다.

 */
