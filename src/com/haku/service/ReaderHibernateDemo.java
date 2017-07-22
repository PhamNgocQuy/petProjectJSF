package com.haku.service;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.haku.hibernate.HibernateUtils;
import com.haku.model.StoryProperties;

public class ReaderHibernateDemo {

	public static List<StoryProperties> getListStory(String table_name, Session session) {
		List<StoryProperties> list;
		String sql = "FROM " + table_name;
		@SuppressWarnings("unchecked")
		Query<StoryProperties> query = session.createQuery(sql);
		list = query.getResultList();
		return list;

	}

	public static void main(String[] args) {
		System.out.println("run");
		SessionFactory factory = HibernateUtils.getSessionFactory();
			try
			{
				Session  session = factory.getCurrentSession();
				session.getTransaction().begin();
				String sql = "FROM history";
				@SuppressWarnings("unchecked")
				Query<StoryProperties> query = session.createQuery(sql);
				List<StoryProperties> list = query.getResultList();
				System.out.println("run.");
				session.getTransaction().commit();
				for(StoryProperties i : list)
					i.check();
				
			}catch (Exception e) {
				System.out.println("error");
			}
	}

}
