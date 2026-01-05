package com.back.domain.post.service;

import com.back.domain.post.document.Post;
import com.back.domain.post.repository.PostRepository;
import com.back.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    // Post 생성
    public Post create(String title, String content, String author) {
        Post post = new Post(title, content, author);
        return postRepository.save(post); // 영속성 컨텍스트가 없으므로 변경 시마다 save() 호출 필수
    }

    // Post 수정
    public Post update(String id, String title, String content) {
        Post post = findById(id);
        if (title != null)
            post.setTitle(title);
        if (content != null)
            post.setContent(content);
        post.setLastModifiedAt(OffsetDateTime.now());
        return postRepository.save(post);
    }

    // Post 목록 조회
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    // Post 단건 조회
    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(()-> new NotFoundException("Post를 찾을 수 없습니다. id: " + id));
    }
}
