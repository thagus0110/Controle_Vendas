package entities;

import javax.swing.JOptionPane;
import conn.Conexao;

public class Estoque {

	// ATRIBUTOS
	private int codProd;
	private String nomeProd;
	private String descricaoProd;
	private int quantidadeProd;
	private double precoProd;

	// GETTERS E SETTERS
	public int getCodigo() {
		return codProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getDescricaoProd() {
		return descricaoProd;
	}

	public void setDescricaoProd(String descricaoProd) {
		this.descricaoProd = descricaoProd;
	}

	public int getQuantidadeProd() {
		return quantidadeProd;
	}

	public void setQuantidadeProd(int quantidadeProd) {
		this.quantidadeProd = quantidadeProd;
	}

	public double getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(double precoProd) {
		this.precoProd = precoProd;
	}

	// INSTANCIAS
	Conexao con = new Conexao();

	// METODOS
	public void cadastrarEstoque(String nomeProd, String descricaoProd, int quantidadeProd, double precoProd) {
		String query = "INSERT INTO tbestoque(nomeProd, descricaoProd, quantidadeProd, precoProd) "
				+ "VALUES ('" + nomeProd + "', '" + descricaoProd + "'," + quantidadeProd + ", " + precoProd + ")";

		try {
			con.conectar();
			con.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO");
			con.desconectar();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizarEstoque(int codProd, String nomeProd, String descricaoProd, int quantidadeProd, double precoProd) {
		try {
			con.conectar();
			String query = "UPDATE tbestoque SET nomeProd ='" + nomeProd + "', descricaoProd = '" + descricaoProd
					+ "', quantidadeProd = " + quantidadeProd + ", precoProd = " + precoProd + " WHERE codProd = '"
					+ codProd + "'";
			con.stat.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "ATUALIZAÇÃO REALIZADA");
			con.desconectar();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void excluirEstoque(int codProd) {
		try {
			con.conectar();
			String query = "DELETE FROM tbestoque WHERE codProd ='" + codProd + "'";
			con.stat.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "EXLCUSÃO REALIZADA");
			con.desconectar();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
