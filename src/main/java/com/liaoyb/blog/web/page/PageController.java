package com.liaoyb.blog.web.page;

import com.liaoyb.blog.domain.model.Article;
import com.liaoyb.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
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
	public String index(Map<String,Object> map,
	                    @RequestParam(defaultValue = "0") int page,
	                    @RequestParam(defaultValue = "10") int size) {
		Page<Article> articlePage= articleService.findAll(page,size);
		map.put("articlePage",articlePage);
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
