package com.liaoyb.blog.web.page;

import com.liaoyb.blog.domain.dto.PageDto;
import com.liaoyb.blog.domain.dto.PageParam;
import com.liaoyb.blog.domain.model.Article;
import com.liaoyb.blog.service.ArticleService;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ybliao2
 */
@Controller
public class PageController {
	@Resource
	private ArticleService articleService;

	@RequestMapping("/")
	public String index(Map<String,Object> map) {
		PageParam pageParam = PageParam.builder()
				.page(0,10)
				.order(PageParam.Direction.DESC,"createTime")
				.build();
		Page<Article> articlePage = articleService.getArticles(pageParam);
		map.put("articlePage", PageDto.convertFor(articlePage));
		return "index";
	}


	@RequestMapping("/article/{articleId}")
	public String article(Map<String,Object> map, @PathVariable Long articleId) throws NotFoundException {
		Article article = articleService.getArticle(articleId);
		if(article==null){
			throw new NotFoundException("article not found");
		}
		map.put("article",article);
		return "article";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
