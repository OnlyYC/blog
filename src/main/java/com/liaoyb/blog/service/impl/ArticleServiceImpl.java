package com.liaoyb.blog.service.impl;

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
	public Page<Article> findAll(int page, int size) {
		PageRequest pageRequest=null;
		Pageable pageable = new PageRequest(page, size, new Sort(Sort.Direction.DESC, "createTime"));
		return articleRepository.findAll(pageable);
	}
}
