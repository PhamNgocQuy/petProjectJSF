package com.haku.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.haku.model.DBconnector;
import com.haku.model.StoryProperties;

public class ReaderService {
	private DBconnector dBconnector = DBconnector.getInstance();

	public ArrayList<StoryProperties> getListHF(String tableName) {
		ArrayList<StoryProperties> list = new ArrayList<>();
		Connection connection = dBconnector.getConnecion();
		String query = "SELECT * FROM "+ tableName;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				list.add(new StoryProperties(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("content"),
						resultSet.getString("image_url")));
			}
		} catch (SQLException e) {
			System.out.println("Size of list from " + tableName + ": " + list.size());
			e.printStackTrace();
		} finally {
			/*System.out.println("close Connection: getListHF");*/
			DBconnector.closeConnection(connection);
		}

		return list;
	}

	public void insertStory(StoryProperties properties, String tableName) {
		Connection connection = dBconnector.getConnecion();
		String query = "INSERT INTO " + tableName + "(title,content,image_url) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, properties.getTitle());
			preparedStatement.setString(2, properties.getContent());
			preparedStatement.setString(3, properties.getImg_url());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("InsertStory: ERROR");
			e.printStackTrace();
		} finally {
			DBconnector.closeConnection(connection);
		}

	}

	public void deleteStory(int id, String tableName) {
		Connection connection = dBconnector.getConnecion();
		String query = "DELETE FORM " + tableName + "WHERE id = ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("deleteStory: ERROR");
			e.printStackTrace();
		}finally {
			DBconnector.closeConnection(connection);
		}

	}

}
