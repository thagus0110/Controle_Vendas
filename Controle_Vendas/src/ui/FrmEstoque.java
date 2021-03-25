/*
 * Created by JFormDesigner on Sun Mar 21 02:58:43 GMT-03:00 2021
 */

package ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import conn.Conexao;
import entities.Estoque;

/**
 * @author Gustavo
 */
public class FrmEstoque extends JDialog {
	// METODOS
	private void btnCadastrarActionPerformed(ActionEvent e) {
		setNomeProd(txtProduto.getText());
		setDescricaoProd(txtDescricao.getText());
		setQuantidadeProd(Integer.parseInt(txtQuantidade.getText()));
		setPrecoProd(Double.parseDouble(txtPreco.getText()));
		
		est.cadastrarEstoque(getNomeProd(), getDescricaoProd(), getQuantidadeProd(), getPrecoProd());
		
		txtCodigo.setText("");
		txtProduto.setText("");
		txtDescricao.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
		
		attTable();
	}

	private void btnAlterarActionPerformed(ActionEvent e) {
		
		setCodProd(Integer.parseInt(txtCodigo.getText()));
		setNomeProd(txtProduto.getText());
		setDescricaoProd(txtDescricao.getText());
		setQuantidadeProd(Integer.parseInt(txtQuantidade.getText()));
		setPrecoProd(Double.parseDouble(txtPreco.getText()));
		
		est.atualizarEstoque(getCodProd(), getNomeProd(), getDescricaoProd(), getQuantidadeProd(), getPrecoProd());
		
		txtCodigo.setText("");
		txtProduto.setText("");
		txtDescricao.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
		
		attTable();		
	}

	private void btnRemoverActionPerformed(ActionEvent e) {
		setCodProd(Integer.parseInt(txtCodigo.getText()));
		
		est.excluirEstoque(getCodProd());
		
		txtCodigo.setText("");
		txtProduto.setText("");
		txtDescricao.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
		
		attTable();		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Gustavo
		scrollPane1 = new JScrollPane();
		tabEstoque = new JTable();
		txtProduto = new JTextField();
		txtDescricao = new JTextField();
		txtQuantidade = new JTextField();
		txtPreco = new JTextField();
		label1 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label2 = new JLabel();
		btnCadastrar = new JButton();
		btnAlterar = new JButton();
		label5 = new JLabel();
		txtCodigo = new JTextField();
		label6 = new JLabel();
		separator1 = new JSeparator();
		btnRemover = new JButton();
		label7 = new JLabel();

		//======== this ========
		setTitle("ESTOQUE");
		var contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== scrollPane1 ========
		{

			//---- tabEstoque ----
			tabEstoque.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"CODIGO", "PRODUTO", "DESCRI\u00c7\u00c3O", "QUANTIDADE", "PRE\u00c7O"
				}
			));
			scrollPane1.setViewportView(tabEstoque);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(0, 0, 605, 275);
		contentPane.add(txtProduto);
		txtProduto.setBounds(100, 300, 71, 25);
		contentPane.add(txtDescricao);
		txtDescricao.setBounds(180, 300, 130, 25);
		contentPane.add(txtQuantidade);
		txtQuantidade.setBounds(330, 300, 50, 25);
		contentPane.add(txtPreco);
		txtPreco.setBounds(410, 300, 60, 25);

		//---- label1 ----
		label1.setText("PRODUTO");
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(115, 285), label1.getPreferredSize()));

		//---- label3 ----
		label3.setText("QUANTIDADE");
		contentPane.add(label3);
		label3.setBounds(325, 285, 85, 14);

		//---- label4 ----
		label4.setText("DESCRI\u00c7\u00c3O");
		contentPane.add(label4);
		label4.setBounds(205, 285, 75, 14);

		//---- label2 ----
		label2.setText("PRE\u00c7O");
		contentPane.add(label2);
		label2.setBounds(420, 285, 49, 14);

		//---- btnCadastrar ----
		btnCadastrar.setText("CADASTRAR");
		btnCadastrar.addActionListener(e -> btnCadastrarActionPerformed(e));
		contentPane.add(btnCadastrar);
		btnCadastrar.setBounds(60, 345, 100, 28);

		//---- btnAlterar ----
		btnAlterar.setText("ALTERAR");
		btnAlterar.addActionListener(e -> btnAlterarActionPerformed(e));
		contentPane.add(btnAlterar);
		btnAlterar.setBounds(175, 345, 100, 28);

		//---- label5 ----
		label5.setText("-->");
		contentPane.add(label5);
		label5.setBounds(285, 355, 30, label5.getPreferredSize().height);
		contentPane.add(txtCodigo);
		txtCodigo.setBounds(310, 350, 50, 25);

		//---- label6 ----
		label6.setText("C\u00d3DIGO");
		contentPane.add(label6);
		label6.setBounds(315, 335, 45, 14);
		contentPane.add(separator1);
		separator1.setBounds(405, 240, separator1.getPreferredSize().width, 107);

		//---- btnRemover ----
		btnRemover.setText("REMOVER");
		btnRemover.addActionListener(e -> btnRemoverActionPerformed(e));
		contentPane.add(btnRemover);
		btnRemover.setBounds(395, 345, 105, 28);

		//---- label7 ----
		label7.setText("<--");
		contentPane.add(label7);
		label7.setBounds(370, 355, 30, 14);

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		setSize(610, 415);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization //GEN-END:initComponents
	}

	// ATRIBUTOS
	private int codProd, quantidadeProd;
	private String nomeProd, descricaoProd;
	private double precoProd;

	// INSTANCIAS
	Conexao con = new Conexao();
	Estoque est = new Estoque();
	ResultSet rs = null;

	// ENCAPSULAMENTO
	public int getCodProd() {
		return codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public int getQuantidadeProd() {
		return quantidadeProd;
	}

	public void setQuantidadeProd(int quantidadeProd) {
		this.quantidadeProd = quantidadeProd;
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

	public double getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(double precoProd) {
		this.precoProd = precoProd;
	}

	public FrmEstoque(Window owner) {
		super(owner);
		initComponents();
		attTable();
	}
	
	public void attTable(){		
			try {
				con.conectar();			
				rs = con.stat.executeQuery("SELECT * FROM tbestoque");
				
				DefaultTableModel tb = (DefaultTableModel) tabEstoque.getModel();
				tb.setNumRows(0);				
				
				while(rs.next()) {
					tb.addRow(new Object[] { rs.getInt("codProd"), rs.getString("nomeProd"), rs.getString("descricaoProd"), rs.getInt("quantidadeProd"), rs.getDouble("precoProd")});
				}
			}
			
			catch (Exception e) {
				System.out.println("Erro ao passar os dados do Statment para ResultSet");
			}		
		
			con.desconectar();	
}

	// JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Gustavo
	private JScrollPane scrollPane1;
	private JTable tabEstoque;
	private JTextField txtProduto;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JLabel label1;
	private JLabel label3;
	private JLabel label4;
	private JLabel label2;
	private JButton btnCadastrar;
	private JButton btnAlterar;
	private JLabel label5;
	private JTextField txtCodigo;
	private JLabel label6;
	private JSeparator separator1;
	private JButton btnRemover;
	private JLabel label7;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
