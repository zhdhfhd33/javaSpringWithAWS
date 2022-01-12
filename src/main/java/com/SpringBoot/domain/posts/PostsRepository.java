package com.SpringBoot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {//JpaRepository를 상속하면 기본적은 CRUD메소드가 자동으로 생성된다
//Entity클래스와 repository클래스는 같은 패키지 안에 있어야 한다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();//accessor없이 선언한 함수인듯.


}