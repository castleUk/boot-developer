package me.castleuk.springbootdeveloper.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.castleuk.springbootdeveloper.domain.Article;
import me.castleuk.springbootdeveloper.dto.AddArticleRequest;
import me.castleuk.springbootdeveloper.dto.UpdateArticleRequest;
import me.castleuk.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    //블로그 글 전체 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    //단건 블로그 글 조회
    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found :" + id));
    }

    //글 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
