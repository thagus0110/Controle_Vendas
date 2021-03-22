/*
 * Created by JFormDesigner on Sun Mar 21 00:50:53 GMT-03:00 2021
 */

package ui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

import conn.Conexao;
import entities.Cliente;
import entities.Vendas;

/**
 * @author Thais
 */

public class FrmCadVendas extends JDialog {

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
	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}


	//INSTANCIAS
	Vendas ven = new Vendas();
	Conexao con = new Conexao();
	ResultSet rs = null;


	
	// CONSTRUTOR
	public FrmCadVendas(Window owner) {
		super(owner);
		initComponents();
		con.conectar();
		attTable();
	}

	// AÇÕES
	private void btnCadastrarActionPerformed(ActionEvent e) throws SQLException {
		
		this.setCodProd(Integer.parseInt(txtCodProd.getText()));
		this.setCpfCli(txtCpf.getText());
		this.setQuantidadeItens(Integer.parseInt(txtQuantidade.getText()));
		
		
		ven.dadosBanco(cpfCli, codProd, quantidadeItens);;

		txtCodProd.setText("");
		txtQuantidade.setText("");
		txtCpf.setText("");
		attTable();

		
	}

	public void attTable() {
		try {
			con.conectar();
			
	        ResultSet rs = con.stat.executeQuery("SELECT * FROM tbVenda");

	        DefaultTableModel tb = (DefaultTableModel) tbVenda.getModel();

	        tb.setNumRows(0);

	        while(rs.next()){

	        	ven.dadosBanco(cpfCli, codProd, quantidadeItens);
	        	
	            tb.addRow(new Object[]{rs.getInt("codVenda"),
	            rs.getString("cpfCli"),
	            rs.getString("nomeCli"),
	            rs.getInt("codProd"),
				rs.getString("nomeProd"),
				rs.getDouble("precoProd"),
				rs.getInt("quantidadeItens"),
				rs.getDouble("totalVenda")
				
	            });

	        }

	    } 
		catch (SQLException e){
	        System.out.println("Ocorreu um erro de SQL");

	    }
		
		con.desconectar();
	}

	private void btnAtualizarActionPerformed(ActionEvent e) {
		attTable();
	}

	private void btnAltActionPerformed(ActionEvent e) throws SQLException {
		
		this.setCodVenda(Integer.parseInt(txtCodVenda.getText()));
		this.setCodProd(Integer.parseInt(txtCodProd.getText()));
		this.setCpfCli(txtCpf.getText());
		this.setQuantidadeItens(Integer.parseInt(txtQuantidade.getText()));
		
		ven.alteraVenda(codVenda, codProd, cpfCli, quantidadeItens);
		
		txtCodVenda.setText("");
		txtCodProd.setText("");
		txtQuantidade.setText("");
		txtCpf.setText("");
		attTable();
	}

	private void btnRemoverActionPerformed(ActionEvent e) {

		this.setCodVenda(Integer.parseInt(txtCodVenda.getText()));
		
		ven.excluirVenda(codVenda);
		
		txtCodVenda.setText("");
		txtCodProd.setText("");
		txtQuantidade.setText("");
		txtCpf.setText("");
		attTable();
	}



	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Gustavo
		txtCodProd = new JTextField();
		txtCpf = new JTextField();
		label2 = new JLabel();
		label3 = new JLabel();
		btnCadastrar = new JButton();
		scrollPane1 = new JScrollPane();
		tbVenda = new JTable();
		btnAtualizar = new JButton();
		btnAlt = new JButton();
		btnRemover = new JButton();
		txtQuantidade = new JTextField();
		label4 = new JLabel();
		label5 = new JLabel();
		txtCodVenda = new JTextField();

		//======== this ========
		setTitle("CLIENTE");
		var contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(txtCodProd);
		txtCodProd.setBounds(235, 275, 125, 20);
		contentPane.add(txtCpf);
		txtCpf.setBounds(30, 335, 165, txtCpf.getPreferredSize().height);

		//---- label2 ----
		label2.setText("C\u00d3DIGO DO PRODUTO");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(235, 260), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("CPF DO CLIENTE");
		contentPane.add(label3);
		label3.setBounds(30, 320, 155, 14);

		//---- btnCadastrar ----
		btnCadastrar.setText("CADASTRAR");
		btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(btnCadastrar.getFont().getSize() - 2f));
		btnCadastrar.addActionListener(e -> {
			try {
				btnCadastrarActionPerformed(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		contentPane.add(btnCadastrar);
		btnCadastrar.setBounds(405, 295, 135, 35);

		//======== scrollPane1 ========
		{

			//---- tbVenda ----
			tbVenda.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, "", "", "", null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null},
				},
				new String[] {
					"C\u00d3D. VENDA", "CPF CLIENTE", "NOME ", "COD. PRODUTO", "NOME PRODUTO", "PRE\u00c7O", "QUANTIDADE", "TOTAL"
				}
			) {
				boolean[] columnEditable = new boolean[] {
					true, false, true, true, true, true, true, true
				};
				@Override
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return columnEditable[columnIndex];
				}
			});
			{
				TableColumnModel cm = tbVenda.getColumnModel();
				cm.getColumn(1).setResizable(false);
			}
			scrollPane1.setViewportView(tbVenda);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(25, 10, 635, 235);

		//---- btnAtualizar ----
		btnAtualizar.setText("ATUALIZAR");
		btnAtualizar.addActionListener(e -> btnAtualizarActionPerformed(e));
		contentPane.add(btnAtualizar);
		btnAtualizar.setBounds(405, 255, 135, 35);

		//---- btnAlt ----
		btnAlt.setFont(btnAlt.getFont().deriveFont(btnAlt.getFont().getSize() - 2f));
		btnAlt.setText("ALTERA VENDA");
		btnAlt.addActionListener(e -> {
			try {
				btnAltActionPerformed(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		contentPane.add(btnAlt);
		btnAlt.setBounds(405, 335, 135, 35);

		//---- btnRemover ----
		btnRemover.setText("REMOVER");
		btnRemover.setFont(btnRemover.getFont().deriveFont(btnRemover.getFont().getSize() - 2f));
		btnRemover.addActionListener(e -> btnRemoverActionPerformed(e));
		contentPane.add(btnRemover);
		btnRemover.setBounds(405, 375, 135, 35);
		contentPane.add(txtQuantidade);
		txtQuantidade.setBounds(235, 335, 125, 20);

		//---- label4 ----
		label4.setText("QUANTIA COMPRADA");
		contentPane.add(label4);
		label4.setBounds(235, 320, 155, 14);

		//---- label5 ----
		label5.setText("C\u00d3DIGO DA VENDA");
		contentPane.add(label5);
		label5.setBounds(30, 265, 111, 14);
		contentPane.add(txtCodVenda);
		txtCodVenda.setBounds(30, 280, 125, 20);

		contentPane.setPreferredSize(new Dimension(685, 450));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Gustavo
	private JTextField txtCodProd;
	private JTextField txtCpf;
	private JLabel label2;
	private JLabel label3;
	private JButton btnCadastrar;
	private JScrollPane scrollPane1;
	private JTable tbVenda;
	private JButton btnAtualizar;
	private JButton btnAlt;
	private JButton btnRemover;
	private JTextField txtQuantidade;
	private JLabel label4;
	private JLabel label5;
	private JTextField txtCodVenda;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
