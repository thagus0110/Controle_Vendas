package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import app.Testes;
import conn.Conexao;

public class Vendas {
	
		// INSTANCIAS
		Conexao con = new Conexao();		
		Testes tst = new Testes();
		
		int codProd;
		String cpfCli;
		String descricaoProd;
		String nomeCli;
		String nomeProd;
		double precoProd;
		int quantidadeItens;
		double totalVenda;
		
		
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
		public void setTotalVenda(double totalVenda) {
			this.totalVenda = totalVenda;
		}
		
		
		public void consultarVendas() throws SQLException {		
			
			String sql = "SELECT * FROM tbVenda";

			con.conectar();
			ResultSet rs = con.stat.executeQuery(sql);
			
			ArrayList<Vendas> cVendas = new ArrayList<Vendas>();
			
			try {
				while(rs.next()) {
					nomeCli = rs.getString(1);
					codProd = rs.getInt(2);
					nomeProd = rs.getString(3);
					descricaoProd = rs.getString(4);
					totalVenda = rs.getDouble(5);
					precoProd = rs.getDouble(6);
					cpfCli = rs.getString(8);
					quantidadeItens = rs.getInt(7);
					
					
				}
					
					System.out.println(codProd +" - "+nomeProd+" - "+ descricaoProd +" - "+ quantidadeItens + " - " + "Cliente: "+cpfCli+" - "+nomeCli+" - " +totalVenda);
				
			}
			
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

}
}
