package etec.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
		String strMysqlConn = "jdbc:mysql://localhost:3306/cadastro";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(strMysqlConn, "root", "");
		return connection;
	}

}
