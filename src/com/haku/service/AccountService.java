package com.haku.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.haku.model.Account;
import com.haku.model.DBconnector;

public class AccountService {
	private DBconnector dbconnector = DBconnector.getInstance();

	public boolean authenticAccount(Account account) {
		Connection connection = dbconnector.getConnecion();
		String query = "SELECT * FROM account";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (account.getEmail().equals(resultSet.getString("email"))
						&& account.getPasswrod().equals(resultSet.getString("password"))) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			System.out.println("authenticAccount: ERROR");
			e.printStackTrace();
		} finally {
			System.out.println("close Conection: authenticAccount");
			DBconnector.closeConnection(connection);
		}

		return false;
	}

	public boolean registerEmail(Account account) {
		Connection connection = dbconnector.getConnecion();
		String query = "SELECT * FROM account WHERE email LIKE" + "'" + account.getEmail() + "'";
		String query_ = "INSERT INTO account (email,password) VALUES (?,?)";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				if (account.getEmail().equals(resultSet.getString("email")))
					return false;
			}
			PreparedStatement preparedStatement = connection.prepareStatement(query_);
			preparedStatement.setString(1, account.getEmail());
			preparedStatement.setString(2, account.getPasswrod());
			boolean rs = preparedStatement.execute();
			if (rs) {
				System.out.println("Register: SUCCESS");
			}
		} catch (SQLException e) {
			System.out.println("register email: ERROR");
			e.printStackTrace();
		} finally {
			System.out.println("close Connection: registerEmail");
			DBconnector.closeConnection(connection);
		}

		return true;
	}

}
