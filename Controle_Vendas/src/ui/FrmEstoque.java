/*
 * Created by JFormDesigner on Sun Mar 21 02:58:43 GMT-03:00 2021
 */

package ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Gustavo
		scrollPane1 = new JScrollPane();
		tabEstoque = new JTable();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		label1 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label2 = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		label5 = new JLabel();
		textField6 = new JTextField();
		label6 = new JLabel();
		separator1 = new JSeparator();
		vSpacer1 = new JPanel(null);

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
		scrollPane1.setBounds(0, 0, 595, 215);
		contentPane.add(textField2);
		textField2.setBounds(15, 235, 71, 25);
		contentPane.add(textField3);
		textField3.setBounds(95, 235, 130, 25);
		contentPane.add(textField4);
		textField4.setBounds(250, 235, 50, 25);
		contentPane.add(textField5);
		textField5.setBounds(325, 235, 60, 25);

		//---- label1 ----
		label1.setText("PRODUTO");
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(30, 220), label1.getPreferredSize()));

		//---- label3 ----
		label3.setText("QUANTIDADE");
		contentPane.add(label3);
		label3.setBounds(240, 220, 85, 14);

		//---- label4 ----
		label4.setText("DESCRI\u00c7\u00c3O");
		contentPane.add(label4);
		label4.setBounds(135, 220, 75, 14);

		//---- label2 ----
		label2.setText("PRE\u00c7O");
		contentPane.add(label2);
		label2.setBounds(335, 220, 49, 14);

		//---- button1 ----
		button1.setText("CADASTRAR");
		contentPane.add(button1);
		button1.setBounds(new Rectangle(new Point(60, 280), button1.getPreferredSize()));

		//---- button2 ----
		button2.setText("ALTERAR");
		contentPane.add(button2);
		button2.setBounds(180, 280, 95, button2.getPreferredSize().height);

		//---- label5 ----
		label5.setText("-->");
		contentPane.add(label5);
		label5.setBounds(285, 285, 30, label5.getPreferredSize().height);
		contentPane.add(textField6);
		textField6.setBounds(310, 280, 40, 25);

		//---- label6 ----
		label6.setText("C\u00d3DIGO");
		contentPane.add(label6);
		label6.setBounds(310, 305, 49, 14);
		contentPane.add(separator1);
		separator1.setBounds(405, 240, separator1.getPreferredSize().width, 107);
		contentPane.add(vSpacer1);
		vSpacer1.setBounds(420, 225, vSpacer1.getPreferredSize().width, 140);

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
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JLabel label1;
	private JLabel label3;
	private JLabel label4;
	private JLabel label2;
	private JButton button1;
	private JButton button2;
	private JLabel label5;
	private JTextField textField6;
	private JLabel label6;
	private JSeparator separator1;
	private JPanel vSpacer1;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
