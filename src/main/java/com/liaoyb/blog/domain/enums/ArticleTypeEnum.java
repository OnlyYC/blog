package com.liaoyb.blog.domain.enums;

/**
 * Article type
 * @author liaoyb
 */
public enum  ArticleTypeEnum {
	HTML(){
		String toHtml(String content){
			return content;
		}
	},
	MARKDOWN(){
		String toHtml(String content){
			return content;
		}
	};

	abstract String toHtml(String content);
}
