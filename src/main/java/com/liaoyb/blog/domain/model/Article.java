package com.liaoyb.blog.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Article
 */
@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@Column(name = "`describe`")
	private String describe;


	@Column(columnDefinition="text")
	private String html;

	@Column(columnDefinition="text")
	private String content;
	private String contentType;

	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "update_time")
	private Date updateTime;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "article_tag",
			joinColumns = { @JoinColumn(name = "article_id", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "id") })
	private List<Tag> tags=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
