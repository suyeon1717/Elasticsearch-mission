package com.back.global.initData;

import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;

    @Bean
    public ApplicationRunner baseInitDataRunner (){
        return args->{
            work1();
        };
    }

    private void work1() { // 애플리케이션 시작 시 Post 개수를 로깅하여 연결 확인
        log.debug("애플리케이션 시작, Post 개수: " + postService.count());
    }
}