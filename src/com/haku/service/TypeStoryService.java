package com.haku.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.haku.model.DBconnector;
import com.haku.model.Temp;

public class TypeStoryService {
	private DBconnector bconnector = DBconnector.getInstance();

	public ArrayList<Temp> getType() {
		ArrayList<Temp> list = new ArrayList<>();
		Connection connection = bconnector.getConnecion();
		try {

			String query = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='shortstory'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String rs = resultSet.getString(3);
				if (!rs.equals("account") && !rs.equals("")) {
					int n = getLastNumberItem(rs);
					String s = stupidMapping(rs);
					list.add(new Temp(s, n, rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconnector.closeConnection(connection);
		}

		return list;
	}

	private int getLastNumberItem(String table_name) {
		int max = 0;
		Connection connection = bconnector.getConnecion();
		String query = "SELECT * FROM " + table_name + " where id=(select max(id) from " + table_name + ")";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (resultSet.getInt(1) >= 0) {
					max = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBconnector.closeConnection(connection);
		}
		return max;
	}

	public String stupidMapping(String table_name) {
		String result = "error";
		switch (table_name) {
		case "after_marriage":
			result = "Sau hôn nhân";
			break;
		case "blog_life":
			result = "Truyện blog: cuộc sống";
			break;
		case "blog_love":
			result = "Truyện blog: Tình yêu";
			break;
		case "break_love":
			result = "Tình yêu tan vỡ";
			break;
		case "family_story":
			result = "Truyện ngắn: Gia đình";
			break;
		case "friendship_story":
			result = "Truyện ngắn: Bạn thân";
			break;
		case "life_story":
			result = "Truyện ngắn: Cuộc sống";
			break;
		case "love_story":
			result = "Truyện ngắn: Tình yêu";
			break;
		case "trangha_story":
			result = "Truyện ngắn: Trang hạ";
			break;
		case "history":
			result = "Lịch sử đọc";
			break;
		default:
			break;
		}
		return result;
	}

	public static String getTableName(String page_name) {
		String result = "error";

		switch (page_name) {
		case "Sau hôn nhân":
			result = "after_marriage";
			break;
		case "Truyện blog: cuộc sống":
			result = "blog_life";
			break;
		case "Truyện blog: Tình yêu":
			result = "blog_love";
			break;
		case "Tình yêu tan vỡ":
			result = "break_love";
			break;
		case "Truyện ngắn: Gia đình":
			result = "family_story";
			break;
		case "Truyện ngắn: Bạn thân":
			result = "friendship_story";
			break;
		case "Truyện ngắn: Cuộc sống":
			result = "life_story";
			break;
		case "Truyện ngắn: Tình yêu":
			result = "love_story";
			break;
		case "Truyện ngắn: Trang hạ":
			result = "trangha_story";
			break;
		case "Lịch sử đọc":
			result = "history";
			break;
		default:
			break;
		}

		return result;
	}
}
