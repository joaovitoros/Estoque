package conexão;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class connect {
	public Statement stm;
	public ResultSet rs;
	private String caminho = "jdbc:sqlserver://DESKTOP-ICC:1433;databaseName=estoque";
	private String usuario = "DESKTOP-ICC//joaov";
	private String senha = "";
	public Connection conexao;
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public void conectar(){
		try{
			System.setProperty("jdbc.Drivers", driver);
			conexao = DriverManager.getConnection(caminho, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
		} catch(SQLException e){
			Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + e.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void desconectar(){
		try{
			conexao.close();
			JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + e.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
	}
}
