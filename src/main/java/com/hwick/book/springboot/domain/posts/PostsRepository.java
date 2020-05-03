package com.hwick.book.springboot.domain.posts;

import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO = Repository, JpaRepository <Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동 생성 됨
public interface PostsRepository extends JpaRepository <Posts, Long> {

}
