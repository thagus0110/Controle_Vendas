package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conn.Conexao;
import ui.FrmCadVendas;

public class Vendas {

	// ATRIBUTOS
	int codVenda;
	int codProd;
	String cpfCli;
	String descricaoProd;
	String nomeCli;
	String nomeProd;
	double precoProd;
	int quantidadeItens;
	double totalVenda;

	// GETTERS E SETTERS
	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public int getCodProd() {
		return codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public String getCpfCli() {
		return cpfCli;
	}

	public void setCpfCli(String cpfCli) {
		this.cpfCli = cpfCli;
	}

	public String getDescricaoProd() {
		return descricaoProd;
	}

	public void setDescricaoProd(String descricaoProd) {
		this.descricaoProd = descricaoProd;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public double getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(double precoProd) {
		this.precoProd = precoProd;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	public double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(int quantidadeItens) {
		this.totalVenda = quantidadeItens * getPrecoProd();
	}

	// OBJETOS
	Conexao con = new Conexao();
	FrmCadVendas frm;
	Estoque est = new Estoque();

	// METODOS
	public void getDadosParaVenda(String cpfCli, int codProd, int quantidadeItens) throws SQLException {
		// Dados do produto
		try {
			con.conectar();

			String prod = "SELECT descricaoProd, nomeProd, precoProd FROM tbestoque WHERE codProd =" + codProd + "";
			ResultSet rs = con.stat.executeQuery(prod);

			try {
				while (rs.next()) {

					setNomeProd(rs.getString("nomeProd"));
					setDescricaoProd(rs.getString("descricaoProd"));
					setPrecoProd(rs.getDouble("precoProd"));
				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Dados do cliente
		try {
			con.conectar();
			String cli = "SELECT nomeCli FROM tbcliente WHERE cpfCli ='" + cpfCli + "'";
			ResultSet rs = con.stat.executeQuery(cli);

			try {
				while (rs.next()) {
					setNomeCli(rs.getString("nomeCli"));
				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// ENVIAR PARA CADASTRO
		this.cadastrarVenda(getNomeCli(), getNomeProd(), getDescricaoProd(), getPrecoProd(), cpfCli, codProd,
				quantidadeItens);
	}

	public void excluirVenda(int codVenda) {
		try {
			con.conectar();
			String query = "DELETE FROM tbVenda WHERE codVenda = " + codVenda + "";
			con.stat.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "EXLCUSÃO REALIZADA");
			con.desconectar();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void alterarVenda(int codVenda, int codProd, String cpfCli, int quantidadeItens) {
		try {
			con.conectar();
			ResultSet rs;
			rs = con.stat.executeQuery("SELECT precoProd FROM tbestoque WHERE codProd = '" + codProd + "' ");
			

			while (rs.next()) {
				setPrecoProd(rs.getDouble("precoProd"));
				setTotalVenda(quantidadeItens);
			}

			int quantidadeAtual = quantidadeItens;
			int quantidadeAntiga=0;
			
			
			rs = con.stat.executeQuery("SELECT quantidadeProd from tbestoque where codProd = '"+ codProd +"'");
			
			while(rs.next()) {
				quantidadeAntiga = rs.getInt("quantidadeProd");
			}
			
			int quantidadeADescontar = quantidadeAtual - quantidadeAntiga;
			
			est.descontaEstoque(codProd, quantidadeADescontar);
			
			
			String query = "UPDATE tbvenda SET codProd = " + codProd + ", cpfCli = '" + cpfCli + "', quantidadeItens = "
					+ quantidadeItens + ", totalVenda = " + getTotalVenda() + "  WHERE codVenda = " + codVenda + "";
			con.stat.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "ALTERAÇÃO DO REGISTRO DE VENDA REALIZADA");
			con.desconectar();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void cadastrarVenda(String nomeCli, String nomeProd, String descricaoProd, double precoProd, String cpfCli, int codProd, int quantidadeItens) throws SQLException {
		// CADASTRA NO BANCO
		double totalVenda = quantidadeItens * precoProd;

		try {
			con.conectar();
			String query = "INSERT INTO tbvenda(codProd, cpfCli, descricaoProd, nomeCli, nomeProd, precoProd, quantidadeItens, totalVenda) "
					+ "VALUES (" + codProd + ", '" + cpfCli + "', '" + descricaoProd + "', '" + nomeCli + "','"
					+ nomeProd + "', " + precoProd + "," + quantidadeItens + ", " + totalVenda + ")";

			con.stat.executeUpdate(query);
			est.descontaEstoque(codProd, quantidadeItens);
			
			JOptionPane.showMessageDialog(null, "VENDA REALIZADA");
			con.desconectar();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
