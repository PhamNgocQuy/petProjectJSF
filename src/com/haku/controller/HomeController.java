package com.haku.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.haku.model.StoryProperties;
import com.haku.service.ReaderService;
import com.haku.service.TypeStoryService;

@SuppressWarnings("deprecation")
@ManagedBean(name="homeController")
@SessionScoped
public class HomeController {

	private String currentType;
	private StoryProperties currentStory;
	private ReaderService readerService = new ReaderService();

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		System.out.println("Current type");
		this.currentType = currentType;
	}

	public String getPage() {
		return "liststory";
	}
	public String getPageHistory() {
		currentType = "Lịch sử đọc";
		return "liststory";
	}
	public ArrayList<StoryProperties> getListStory() {
		ArrayList<StoryProperties> list = readerService.getListHF(TypeStoryService.getTableName(currentType));
		return list;
	}

	public StoryProperties getCurrentStory() {
		return currentStory;
	}

	public void setCurrentStory(StoryProperties currentStory) {
		System.out.println("================================ " + currentStory.getTitle());
		this.currentStory = currentStory;
		readerService.insertStory(currentStory,"history");
	}
	public void InsertToHistory(StoryProperties properties)
	{
		readerService.insertStory(properties,"history");
	}
}