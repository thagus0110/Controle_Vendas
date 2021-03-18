package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexao {
	
	private Connection con = null;
	public Statement stat = null;	

	public boolean conectar() {
		String servidor = "jdbc:mysql://localhost:3306/bdvendas";
		String usuario = "root";
		String senha = "";
		
		try {
			this.con = DriverManager.getConnection(servidor, usuario, senha);
			this.stat = this.con.createStatement();
			return true;
		}
		
		catch (Exception e) {			
			return false;			
		}
	}
	
	
	public boolean desconectar() {
		try {
			con.close();
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
	public void verificarBanco() {

		if(this.conectar()) {
			System.out.println("CONNECTED!");
		}
		
		else {
			System.out.println("ERROR!");
		}
		
		if(this.desconectar()) {
			System.out.println("DISCONNECTED!");
		}
		
		else {
			System.out.println("ERROR!");
		}
	}
}
