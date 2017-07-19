package com.haku.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.haku.model.Temp;
import com.haku.service.TypeStoryService;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class TypeController {

	private TypeStoryService typeStoryService = new TypeStoryService();
	public ArrayList<Temp> getType() {
		ArrayList<Temp> listType_of_story = typeStoryService.getType();
		return listType_of_story;
	}
}
