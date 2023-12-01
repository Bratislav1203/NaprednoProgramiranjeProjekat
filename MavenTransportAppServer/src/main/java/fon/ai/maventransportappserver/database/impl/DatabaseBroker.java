/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.database.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappserver.databases.IDatabaseBroker;

/**
 *
 * @author Bratislav
 */
public class DatabaseBroker implements IDatabaseBroker {
	Connection connection;

	public void loadDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public Connection openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transportapp", "root", "");
		return connection;
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

	public void connectToDatabase() throws Exception {
		try {
			FileInputStream in = new FileInputStream("db.properties");
			Properties props = new Properties();
			props.load(in);
			// String driver=props.getProperty("driver");
			String address = props.getProperty("address");
			String port = props.getProperty("port");
			String database = props.getProperty("database");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String url = "jdbc:mysql://" + address + ":" + port + "/" + database;
			// Class.forName(driver);
			System.out.println(address + port + database + user + password + url);

			connection = DriverManager.getConnection(url, user, "");

			connection.setAutoCommit(false);
			System.out.println("Successfully connected to database!");
		} catch (IOException | SQLException ex) {
			throw new Exception("Unsuccessfully connected to database!\n" + ex.getMessage());
		}

	}

	public void disconnectFromDatabase() throws Exception {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new Exception("There is some error at disconnecting to database!\n" + ex.getMessage());
			}
		}
	}

	public void commit() throws Exception {
		if (connection != null) {
			try {
				connection.commit();
			} catch (SQLException ex) {
				throw new Exception("There is some error in commit!\n" + ex.getMessage());
			}
		}
	}

	public void rollback() throws Exception {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new Exception("There is some error in rollback!\n" + ex.getMessage());
			}
		}
	}

	@Override
	public int sacuvaj(IGeneralEntity entity) throws Exception {
		try {
			String query = "insert into " + entity.getTableName() + "(" + entity.getAttributes() + ")" + " values("
					+ entity.getValues() + ")";
			System.out.println(query);
			PreparedStatement preparedStatement = connection.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			System.out.println("Uspesno sam sacuvao u bazi");
			if (rs != null && rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
	}

	@Override
	public void obrisi(IGeneralEntity entity) throws Exception {
		try {
			System.out.println("Uspostavljena je konekcija sa bazom");
			String query = "delete from " + entity.getTableName() + " where " + entity.getDeleteCondition();
			System.out.println(query);
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void izmeni(IGeneralEntity entity) throws Exception {
		try {
			String query = "update " + entity.getTableName() + " set " + entity.setAttributes() + " where "
					+ entity.getUpdateCondition();
			System.out.println(query);
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<IGeneralEntity> vratiPoUslovu(IGeneralEntity entity) throws Exception {
		ArrayList<IGeneralEntity> objekti;
		String query = "select * from " + entity.getTableName() + " where " + entity.getSelectContidion();
		
		System.out.println(query);
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(query);
		objekti = (ArrayList<IGeneralEntity>) entity.getList(rs);
		return objekti;
	}

	@Override
	public IGeneralEntity vratiPoId(IGeneralEntity entity) throws Exception {
		ArrayList<IGeneralEntity> objekti;
		String query = "select * from " + entity.getTableName() + " where " + entity.getSelectContidion();
		if(entity instanceof Drive) {
			query = "SELECT d.id, d.date, d.factureprice, d.truck, d.trailer, d.driver, t.loadcapacity AS \"dozvoljena tezina\", tr.productyear AS \"godina kamiona\",\r\n"
					+ " tr.weight, t.productyear AS \"godina prikolice\", t.weight as \"tezina prikolice\", dr.idcard\r\n"
					+ "  FROM drive d JOIN vehicle tr ON d.truck = tr.registrationmark JOIN vehicle t ON t.registrationmark = d.trailer JOIN driver dr ON d.driver = dr.idcard "+ " where " + entity.getSelectContidion();;
		}
		System.out.println(query);
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(query);
		objekti = (ArrayList<IGeneralEntity>) entity.getList(rs);
		IGeneralEntity objekat = objekti.get(0);
		return objekat;
	}

	@Override
	public List<IGeneralEntity> vratiSve(IGeneralEntity entity) throws Exception {
		ArrayList<IGeneralEntity> objekti;
		String query = "select * from " + entity.getTableName();
		if(entity instanceof Drive) {
			query = "SELECT d.id, d.date, d.factureprice, d.truck, d.trailer, d.driver, t.loadcapacity AS \"dozvoljena tezina\", tr.productyear AS \"godina kamiona\",\r\n"
					+ " tr.weight, t.productyear AS \"godina prikolice\", t.weight as \"tezina prikolice\", dr.idcard\r\n"
					+ "  FROM drive d JOIN vehicle tr ON d.truck = tr.registrationmark JOIN vehicle t ON t.registrationmark = d.trailer JOIN driver dr ON d.driver = dr.idcard ";
		}
		System.out.println(query);
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(query);
		objekti = (ArrayList<IGeneralEntity>) entity.getList(rs);
		return objekti;
	}

}
