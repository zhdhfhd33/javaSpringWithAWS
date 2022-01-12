package com.SpringBoot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    //Junit에서 단위테스트가 끝날 때 마다 수행되는 메소드를 지정함. 보통 배포 전 전체테스트를 수행할 때 테스트간 데이터 침범ㅇ르 막기 위해 사용.
    //여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아있어 다음 테스트 실행시 테스트가 실패할 수 있다.
    public void cleanup(){
        postsRepository.deleteAll(); //JpaRepository를 상속받아서 생긴 함수.
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트게시글";
        String content = "테스트 본문";

        //빌터패턴의 사용
        //id가 있으면 update, 없으면 insert 쿼리가 사용된다.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("minkunShin")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
