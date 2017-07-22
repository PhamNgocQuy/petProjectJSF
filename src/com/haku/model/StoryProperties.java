package com.haku.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "history")
public class StoryProperties {

	private int id;
	private String title;
	private String content;
	private String img_url;
	
	
	
	public StoryProperties() {
	}
	public StoryProperties(String title, String content, String img_url) {
		
		this.title = title;
		this.content = content;
		this.img_url = img_url;
	}
	public StoryProperties(int id,String title, String content, String img_url) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.img_url = img_url;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="image_url")
	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public void check() {
		System.out.println(id);
		System.out.println(title);
		System.out.println(content);
		System.out.println(img_url);
	}

}
