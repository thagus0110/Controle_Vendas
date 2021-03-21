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
		
		public void cadastrarVenda(String cpfCli, int codProd, int quantidadeItens) {
	
			
			String query = "INSERT INTO tbvenda(codProd, cpfCli, descricaoProd, nomeCli, nomeProd, precoProd, quantidadeItens, totalVenda) VALUES ("+codProd+", '"+cpfCli+"', '"+descricaoProd+"', '"+nomeCli+"','"+nomeProd+"', "+precoProd+","+quantidadeItens+", "+totalVenda+")";
			
			try{
				con.conectar();
				con.stat.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"CADASTRO REALIZADO");
				con.desconectar();
			}
			
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
		
		public void whatToDo() throws SQLException {
			int esc = Integer.parseInt(JOptionPane.showInputDialog("O QUE DESEJA FAZER?\n"
					+ "1 - CADASTRAR UMA NOVA COMPRA\n"
					+ "2 - EXIBIR COMPRAS\n"
					+ "0 - SAIR\n"));
			
			switch(esc) {
			
			case 1:
				cpfCli = JOptionPane.showInputDialog("Informe o CPF do Cliente: ");
				
				codProd = Integer.parseInt(JOptionPane.showInputDialog("Informe o Nome do Cliente: "));
				quantidadeItens = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantia de itens comprados: "));
				
				cadastrarVenda(cpfCli, codProd, quantidadeItens);
				whatToDo();
				break;
			case 2:
				
				consultarVendas();
				whatToDo();
				break;
			case 0:
				tst.whatToDo();
				break;
			
			}
		}
}
