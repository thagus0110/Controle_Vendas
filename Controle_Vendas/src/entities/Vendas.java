package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.Testes;
import conn.Conexao;
import ui.FrmCadVendas;

public class Vendas {
	
		// INSTANCIAS
		Conexao con = new Conexao();		
		Testes tst = new Testes();
		FrmCadVendas frm;
		
		
		int codVenda;
		int codProd;
		String cpfCli;
		String descricaoProd;
		String nomeCli;
		String nomeProd;
		double precoProd;
		int quantidadeItens;
		double totalVenda;
		
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
		
		
		public void dadosBanco(String cpfCli, int codProd, int quantidadeItens) throws SQLException {

						
			//PEGAR DADOS DO PRODUTO	
			try{
				con.conectar();
				
				String prod = "SELECT descricaoProd, nomeProd, precoProd FROM tbestoque WHERE codProd ="+codProd+"";
				ResultSet rs = con.stat.executeQuery(prod);
			
				try {
					
					while(rs.next()) {
						
						 setNomeProd(rs.getString("nomeProd"));
						 setDescricaoProd(rs.getString("descricaoProd"));
						 setPrecoProd(rs.getDouble("precoProd"));
						
				}
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			
			//PEGAR DADOS DO CLIENTE
			try{
					con.conectar();
					String cli = "SELECT nomeCli FROM tbcliente WHERE cpfCli ='"+cpfCli+"'";
					ResultSet rs = con.stat.executeQuery(cli);
					
				
					try {
						
						while(rs.next()) {
							setNomeCli(rs.getString("nomeCli"));
						}
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			//ENVIA PARA CADASTRO
			cadastrarVenda(getNomeCli(), getNomeProd(), getDescricaoProd(), getPrecoProd(), cpfCli, codProd, quantidadeItens);

		}
		
		public void excluirVenda(int codVenda) {
			
						try{
							con.conectar();
							String query = "DELETE FROM tbVenda WHERE codVenda = "+codVenda+"";
							con.stat.executeUpdate(query);
							
							JOptionPane.showMessageDialog(null,"EXLCUSÃO REALIZADA");
							con.desconectar();
						}
						
						catch (Exception e){
							System.out.println(e.getMessage());
						}
						
						
					}
		
		public void alterarVenda(int codVenda, int codProd, String cpfCli, int quantidadeItens) {
			
			try{
				con.conectar();
				ResultSet rs;
				rs = con.stat.executeQuery("SELECT precoProd FROM tbestoque WHERE codProd = '"+ codProd +"' ");
				
				while(rs.next()) {
					setPrecoProd(rs.getDouble("precoProd"));
					setTotalVenda(quantidadeItens);
				}				
						
				
				String query = "UPDATE tbvenda SET codProd = "+codProd+", cpfCli = '"+cpfCli+"', quantidadeItens = "+quantidadeItens+", totalVenda = "+ getTotalVenda() + "  WHERE codVenda = "+codVenda+"";
				con.stat.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"ALTERAÇÃO DO REGISTRO DE VENDA REALIZADA");
				con.desconectar();
			}
			
			catch (Exception e){
				System.out.println(e.getMessage());
			}	
			
			
		}
		
		public void cadastrarVenda(String nomeCli, String nomeProd, String descricaoProd, double precoProd, String cpfCli, int codProd, int quantidadeItens) throws SQLException{
						
						//CADASTRA NO BANCO
						double totalVenda = quantidadeItens*precoProd;
						
						
								try{
									con.conectar();
									String query = "INSERT INTO tbvenda(codProd, cpfCli, descricaoProd, nomeCli, nomeProd, precoProd, quantidadeItens, totalVenda) "
											+ "VALUES ("+codProd+", '"+cpfCli+"', '"+descricaoProd+"', '"+nomeCli+"','"+nomeProd+"', "+precoProd+","+quantidadeItens+", "+totalVenda+")";
									
									con.stat.executeUpdate(query);
									JOptionPane.showMessageDialog(null,"VENDA REALIZADA");
									con.desconectar();
								
									}catch (Exception e) {
										System.out.println(e.getMessage());
									}
									
					}
		
		public void whatToDo() throws SQLException {
			int esc = Integer.parseInt(JOptionPane.showInputDialog("O QUE DESEJA FAZER?\n"
					+ "1 - CADASTRAR UMA NOVA COMPRA\n"
					+ "2 - EXIBIR COMPRAS\n"
					+ "3 - DELETAR COMPRAS\n"
					+ "0 - SAIR\n"));
			
			switch(esc) {
			
			case 1:
				cpfCli = JOptionPane.showInputDialog("Informe o CPF do Cliente: ");
				codProd = Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do produto: "));
				quantidadeItens = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantia de itens comprados: "));
				
				dadosBanco(cpfCli, codProd, quantidadeItens);
				whatToDo();
				break;
			case 2:
				
				//consultarVendas();
				whatToDo();
				break;
			case 3:
				codVenda = Integer.parseInt(JOptionPane.showInputDialog("Informe o Código da venda: "));
				excluirVenda(codVenda);
				whatToDo();
				break;	
			case 0:
				tst.whatToDo();
				break;
			
			}
		}
		
}

