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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import conn.Conexao;
import entities.Cliente;

/**
 * @author Gustavo
 */

public class FrmCadCli extends JDialog {

	// ATRIBUTOS
	private String cpf;
	private String nome;

	// INSTANCIAS
	Cliente cli = new Cliente();
	Conexao con = new Conexao();
	ResultSet rs = null;

	// GETTERS E SETTERS
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// CONSTRUTOR
	public FrmCadCli(Window owner) {
		super(owner);
		initComponents();
		attTable();
	}

	// AÇÕES
	private void btnCadastrarActionPerformed(ActionEvent e) {
		this.setCpf(txtCpf.getText());
		this.setNome(txtNome.getText());

		cli.addCliente(cpf, nome);
		txtCpf.setText("");
		txtNome.setText("");
		attTable();
	}

	public void attTable() {
		try {
			con.conectar();
	        ResultSet rs = con.stat.executeQuery("SELECT * FROM tbcliente");

	        DefaultTableModel tb = (DefaultTableModel) tabCliente.getModel();

	        tb.setNumRows(0);

	        while(rs.next()){

	            tb.addRow(new Object[]{rs.getString("cpfCli"),
	            rs.getString("nomeCli")	            
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

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Gustavo
		txtCpf = new JTextField();
		txtNome = new JTextField();
		label2 = new JLabel();
		label3 = new JLabel();
		btnCadastrar = new JButton();
		scrollPane1 = new JScrollPane();
		tabCliente = new JTable();
		btnAtualizar = new JButton();
		btnCadastrar2 = new JButton();
		btnCadastrar3 = new JButton();

		//======== this ========
		var contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(txtCpf);
		txtCpf.setBounds(140, 280, 80, 20);
		contentPane.add(txtNome);
		txtNome.setBounds(140, 330, 205, txtNome.getPreferredSize().height);

		//---- label2 ----
		label2.setText("CPF");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(140, 260), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("NOME");
		contentPane.add(label3);
		label3.setBounds(140, 315, 45, 14);

		//---- btnCadastrar ----
		btnCadastrar.setText("CADASTRAR");
		btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(btnCadastrar.getFont().getSize() - 2f));
		btnCadastrar.addActionListener(e -> btnCadastrarActionPerformed(e));
		contentPane.add(btnCadastrar);
		btnCadastrar.setBounds(405, 255, 100, 35);

		//======== scrollPane1 ========
		{

			//---- tabCliente ----
			tabCliente.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"CPF", "NOME"
				}
			));
			scrollPane1.setViewportView(tabCliente);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(140, 10, 365, 235);

		//---- btnAtualizar ----
		btnAtualizar.setText("ATUALIZAR");
		btnAtualizar.addActionListener(e -> btnAtualizarActionPerformed(e));
		contentPane.add(btnAtualizar);
		btnAtualizar.setBounds(525, 120, 104, 35);

		//---- btnCadastrar2 ----
		btnCadastrar2.setText("EDITAR");
		btnCadastrar2.setFont(btnCadastrar2.getFont().deriveFont(btnCadastrar2.getFont().getSize() - 2f));
		btnCadastrar2.addActionListener(e -> btnCadastrarActionPerformed(e));
		contentPane.add(btnCadastrar2);
		btnCadastrar2.setBounds(405, 295, 101, 35);

		//---- btnCadastrar3 ----
		btnCadastrar3.setText("REMOVER");
		btnCadastrar3.setFont(btnCadastrar3.getFont().deriveFont(btnCadastrar3.getFont().getSize() - 2f));
		btnCadastrar3.addActionListener(e -> btnCadastrarActionPerformed(e));
		contentPane.add(btnCadastrar3);
		btnCadastrar3.setBounds(405, 335, 101, 35);

		contentPane.setPreferredSize(new Dimension(685, 450));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Gustavo
	private JTextField txtCpf;
	private JTextField txtNome;
	private JLabel label2;
	private JLabel label3;
	private JButton btnCadastrar;
	private JScrollPane scrollPane1;
	private JTable tabCliente;
	private JButton btnAtualizar;
	private JButton btnCadastrar2;
	private JButton btnCadastrar3;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
