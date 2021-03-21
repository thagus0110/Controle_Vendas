package entities;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.Testes;
import conn.Conexao;

public class Cliente {

	//INSTANCIAS
	Conexao con = new Conexao();
	Testes tst = new Testes();
	
	//ATRIBUTOS
	private String cpf;
	private String nome;
			
	//GETTERS E SETTERS
	public String getCpf() {
		return cpf;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//METODOS
	public void alterarNome(String cpf, String nome) throws SQLException {		
		String cmd = "UPDATE tbcliente SET nomeCli = '" + nome + "' WHERE cpfCli = '" + cpf + "'";	
		
		try {
			con.conectar();
			con.stat.executeUpdate(cmd);
			JOptionPane.showMessageDialog(null,"Alteração realizada!");
			con.desconectar();
		}
		
		catch(Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		
	}
	
	public void addCliente(String cpf, String nome){
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
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	// PARA TESTES
	public void whatToDo() throws SQLException {
		int esc = Integer.parseInt(JOptionPane.showInputDialog("O QUE DESEJA FAZER?\n"
				+ "1 - CADASTRAR UM NOVO CLIENTE\n"
				+ "2 - ALTERAR O NOME DE UM CLIENTE\n"
				+ "0 - SAIR\n"));
		
		switch(esc) {
		case 1:
			cpf = JOptionPane.showInputDialog("Digite o CPF do cliente: ");
			nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
			
			addCliente(cpf, nome);
			whatToDo();
			break;
		case 2:
			cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser alterado: ");
			nome = JOptionPane.showInputDialog("Digite o novo nome para o cliente em questão: ");
			
			alterarNome(cpf, nome);
			whatToDo();
			break;
		case 0:
			tst.whatToDo();
			break;
		
		}
	}
	
}
