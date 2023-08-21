package me.castleuk.springbootdeveloper.repository;

import me.castleuk.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {


}
