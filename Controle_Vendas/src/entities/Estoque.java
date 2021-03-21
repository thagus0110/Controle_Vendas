package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.Testes;
import conn.Conexao;

public class Estoque {

	//ATRIBUTOS
	private int codProd;
	private String nomeProd;
	private String descricaoProd;
	private int quantidadeProd;
	private double 	precoProd;
	
	
	// INSTANCIAS
	Conexao con = new Conexao();		
	Testes tst = new Testes();
	
	
		//ENCAPSULAMENTO
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
		
				
		
		//METODOS COM MUDANÇA NO BANCO DE DADOS
		public void cadastrarEstoque(String nomeProd, String descricaoProd, int quantidadeProd, double precoProd) {
		
			String query = "INSERT INTO tbestoque(nomeProd, descricaoProd, quantidadeProd, precoProd) VALUES ('" + nomeProd + "', '" + descricaoProd + "'," + quantidadeProd + ", " + precoProd + ")";
			
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
		
		
		public void atualizarEstoque(int codProd, String nomeProd, String descricaoProd, int quantidadeProd, double precoProd) {
			
			try{
				con.conectar();
				String query = "UPDATE tbestoque SET nomeProd ='"+nomeProd+"', descricaoProd = '"+descricaoProd +"', quantidadeProd = "+quantidadeProd+", precoProd = "+precoProd+" WHERE codProd = '"+codProd+"'";
				con.stat.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"ATUALIZAÇÃO REALIZADA");
				con.desconectar();
			}
			
			catch (Exception e){
				System.out.println(e.getMessage());
			}						
		}
		
		public void excluirEstoque(int codProd) {
			
			
			try{
				con.conectar();
				String query = "DELETE FROM tbestoque WHERE codProd ='"+codProd+"'";
				con.stat.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"EXLCUSÃO REALIZADA");
				con.desconectar();
			}
			
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		
		public void consultarEstoque() {		
			ResultSet rs=null;
			
			try {
				con.conectar();
				
				
				rs = con.stat.executeQuery("SELECT * FROM tbestoque");
			}
			
			catch (Exception e) {
				System.out.println("Erro ao passar os dados do Statment para ResultSet");
			}
			
			try {
				while(rs.next()) {
					int codProd = rs.getInt("codProd");
					String nomeProd = rs.getString("nomeProd");
					String descricaoProd = rs.getString("descricaoProd");
					int quantidadeProd = rs.getInt("quantidadeProd");
					double precoProd = rs.getDouble("precoProd");
					
					System.out.println(codProd + "  " + nomeProd + "  " + descricaoProd + "  " + quantidadeProd + "  " + precoProd);
				}
			}
			
			catch (Exception e) {
				
			}
			
		}
		
		
		
		public void whatToDo() throws SQLException{
					
					int opc = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção: \n1- CADASTRAR NO ESTOQUE \n2- ALTERAR \n3- EXCLUIR DO ESTOQUE \n0- VOLTAR AO MENU ANTERIOR"));
					
					switch(opc) {
					
						case 1:
							nomeProd = JOptionPane.showInputDialog("Porfavor, informe o nome do produto");
							descricaoProd = JOptionPane.showInputDialog("Porfavor, informe a descrição do produto");
							quantidadeProd = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, informe a quantidade do produto"));
							precoProd = Double.parseDouble(JOptionPane.showInputDialog("Porfavor, informe o preço do produto"));
						
							cadastrarEstoque(nomeProd, descricaoProd, quantidadeProd, precoProd);
							whatToDo();
							break;
							
						case 2:
							codProd = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, informe o codigo do produto que deseja alterar"));

							nomeProd = JOptionPane.showInputDialog("Porfavor, informe o novo nome do produtor");
							descricaoProd = JOptionPane.showInputDialog("Porfavor, informe a nova descrição do produto");
							quantidadeProd = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, informe a nova quantidade do produto"));
							precoProd = Double.parseDouble(JOptionPane.showInputDialog("Porfavor, informe o novo preço do produto"));
						
							atualizarEstoque(codProd, nomeProd, descricaoProd, quantidadeProd, precoProd);
							break;
							
						case 3:
							codProd = Integer.parseInt(JOptionPane.showInputDialog("Porfavor, informe o codigo do produto que deseja excluir"));
							
						
							excluirEstoque(codProd);
							break;
						
						case 0:
							tst.whatToDo();
							break;	
						
					}
				}
}
