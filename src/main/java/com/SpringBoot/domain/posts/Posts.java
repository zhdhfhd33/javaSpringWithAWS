package com.SpringBoot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity //저자는 중요한 어노테이션일 수록 클래스와 가까이 둔다고 함. 위의 2개는 롬복으로 코드를 간편하게 해주는 어노테이션으로 필수는 아니다.
//이렇게 하면 코틀린 등 새 언어로 전환할 때 롬복이 더 이상 필요없어지면 쉽게 삭제할 수 있다.
//이 클래스는 실제 DB의 테이블과 매칭될 클래스임. 보통 Entity클래스라고 하기도 한다.
public class Posts extends BaseTimeEntity {
    //실제 DB에 쿼리를 날리는 것이 아니라 Entity클래스를 수정해서 DB에 작업할 수 있다.

    @Id//PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)//A.I.를 위한 코드.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
