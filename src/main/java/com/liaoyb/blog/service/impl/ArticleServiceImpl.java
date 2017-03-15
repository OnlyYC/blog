package com.liaoyb.blog.service.impl;

import com.liaoyb.blog.domain.dto.PageParam;
import com.liaoyb.blog.domain.model.Article;
import com.liaoyb.blog.repository.ArticleRepository;
import com.liaoyb.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liaoyb
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleRepository articleRepository;
	@Override
	public Page<Article> getArticles(PageParam queryParam) {
		Pageable pageable = queryParam.convertToPageRequest();
		return articleRepository.findAll(pageable);
	}

	@Override
	public Article getArticle(Long articleId) {
		return articleRepository.findOne(articleId);
	}
}
