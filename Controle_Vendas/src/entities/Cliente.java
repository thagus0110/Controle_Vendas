package entities;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import conn.Conexao;

public class Cliente {

	// ATRIBUTOS
	private String cpf;
	private String nome;

	// GETTERS E SETTERS
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// OBJETOS
	Conexao con = new Conexao();

	// METODOS
	public void alterarNome(String cpf, String nome) throws SQLException {
		String cmd = "UPDATE tbcliente SET nomeCli = '" + nome + "' WHERE cpfCli = '" + cpf + "'";

		try {
			con.conectar();
			con.stat.executeUpdate(cmd);
			JOptionPane.showMessageDialog(null, "Alteração realizada!");
			con.desconectar();
		}

		catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	public void addCliente(String cpf, String nome) {
		String cmd = "INSERT INTO tbcliente (cpfCli, nomeCli) values ('" + cpf + "', '" + nome + "')";

		try {
			con.conectar();
			con.stat.executeUpdate(cmd);
			JOptionPane.showMessageDialog(null, "Cadastro realizado!");
			con.desconectar();
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void removerCliente(String cpf) {
		try {
			con.conectar();
			con.stat.executeUpdate("DELETE FROM tbcliente WHERE cpfCli = '" + cpf + "'");
			JOptionPane.showMessageDialog(null, "Exclusão realizada!");
			con.desconectar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
