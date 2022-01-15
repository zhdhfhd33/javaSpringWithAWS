package com.SpringBoot.service.posts;

import com.SpringBoot.domain.posts.Posts;
import com.SpringBoot.domain.posts.PostsRepository;
import com.SpringBoot.web.dto.PostsListResponseDto;
import com.SpringBoot.web.dto.PostsResponseDto;
import com.SpringBoot.web.dto.PostsSaveRequestDto;
import com.SpringBoot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository; ///@RequiredArgsConstructor를 사용하기 때문에 final을 꼭 붙여야 한다.

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)); //못찾았다면 여기서 throw Exception이다. 여기서 걸리지 않아야 아래로 내려갈 수 있음.
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);

    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts); //JpaRepository에서 이미 delete메소드를 지원하고 있으니 이를 활용하면 된다.

    }


}
