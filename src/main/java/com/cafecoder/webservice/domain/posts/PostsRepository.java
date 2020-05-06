package com.cafecoder.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}

/*
보통 ibatis/Mybatis 등에서 Dao라 불리는 DB Layer 접근자다.
JPA에선 Repository라 부르며, 인터페이스로 생성한다.

단순히 인터페이스를 생성후, JpaRepository<Entity클래스, PK타입>를 상속하면
기본적인 CRUD 메소드가 자동생성된다.

특별히 @Repository를 추가할 필요도 없다.
 */
