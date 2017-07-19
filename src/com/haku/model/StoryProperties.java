package com.haku.model;

public class StoryProperties {

	private int id;
	private String title;
	private String content;
	private String img_url;

	public StoryProperties(int id, String title, String content, String img_url) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.img_url = img_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
