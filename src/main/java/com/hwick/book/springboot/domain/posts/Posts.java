package com.hwick.book.springboot.domain.posts;

import com.hwick.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 클래스 내 모든 필드의 Getter 메소드 작성
@NoArgsConstructor // 기본 생성자 자동 추가, Public Posts() {}
@Entity // JPA의 어노테이션, 테이블과 링크될 클래스, 기본값으로 클래스의 카멜케이스 이름 : 테이블 이름 언더스코어 네이밍 매칭
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙, 부트 2.0에서 IDENTITY를 추가해야 auto_increment 됨
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며 선언하지 않아도 클래스의 필드는 모두 컬럼이 됨
    // 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    // 문자열의 경우 VARCHAR(255)가 기본값, 사이즈를 500으로 늘리고 싶거나 타입을 변경(TEXT 등) 경우에 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
