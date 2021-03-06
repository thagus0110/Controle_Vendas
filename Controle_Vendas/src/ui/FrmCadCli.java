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
import javax.swing.table.DefaultTableModel;

import conn.Conexao;
import entities.Cliente;

public class FrmCadCli extends JDialog {

	// ATRIBUTOS
	private String cpf;
	private String nome;

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

	// OBJETOS
	Cliente cli = new Cliente();
	Conexao con = new Conexao();
	ResultSet rs = null;

	// METODOS
	public FrmCadCli(Window owner) {
		super(owner);
		con.conectar();
		initComponents();
		attTable();
	}

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

			while (rs.next()) {
				tb.addRow(new Object[] { rs.getString("cpfCli"), rs.getString("nomeCli") });
			}

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro de SQL");
		}

		con.desconectar();
	}

	private void btnAtualizarActionPerformed(ActionEvent e) {
		attTable();
	}

	private void btnAltActionPerformed(ActionEvent e) {
		this.setNome(txtNome.getText());
		this.setCpf(txtCpf.getText());

		try {
			cli.alterarNome(cpf, nome);
		}

		catch (Exception i) {
			System.out.println(i.getMessage());
		}
		
		txtCpf.setText("");
		txtNome.setText("");
		attTable();
	}

	private void btnRemoverActionPerformed(ActionEvent e) {
		this.setCpf(txtCpf.getText());

		try {
			cli.removerCliente(cpf);
		}

		catch (Exception i) {
			System.out.println(i.getMessage());
		}
		
		txtCpf.setText("");
		txtNome.setText("");
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
		btnAlt = new JButton();
		btnRemover = new JButton();

		// ======== this ========
		setTitle("CLIENTE");
		var contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(txtCpf);
		txtCpf.setBounds(140, 280, 80, 20);
		contentPane.add(txtNome);
		txtNome.setBounds(140, 330, 205, txtNome.getPreferredSize().height);

		// ---- label2 ----
		label2.setText("CPF");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(140, 260), label2.getPreferredSize()));

		// ---- label3 ----
		label3.setText("NOME");
		contentPane.add(label3);
		label3.setBounds(140, 315, 45, 14);

		// ---- btnCadastrar ----
		btnCadastrar.setText("CADASTRAR");
		btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(btnCadastrar.getFont().getSize() - 2f));
		btnCadastrar.addActionListener(e -> btnCadastrarActionPerformed(e));
		contentPane.add(btnCadastrar);
		btnCadastrar.setBounds(405, 255, 135, 35);

		// ======== scrollPane1 ========
		{

			// ---- tabCliente ----
			tabCliente.setModel(new DefaultTableModel(new Object[][] { { null, null }, { null, null }, { null, null },
					{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
					{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
					{ null, null }, { null, null }, }, new String[] { "CPF", "NOME" }));
			scrollPane1.setViewportView(tabCliente);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(140, 10, 365, 235);

		// ---- btnAtualizar ----
		btnAtualizar.setText("ATUALIZAR");
		btnAtualizar.addActionListener(e -> btnAtualizarActionPerformed(e));
		contentPane.add(btnAtualizar);
		btnAtualizar.setBounds(525, 120, 104, 35);

		// ---- btnAlt ----
		btnAlt.setText("ALTERAR (pelo cpf)");
		btnAlt.setFont(btnAlt.getFont().deriveFont(btnAlt.getFont().getSize() - 2f));
		btnAlt.addActionListener(e -> btnAltActionPerformed(e));
		contentPane.add(btnAlt);
		btnAlt.setBounds(405, 295, 135, 35);

		// ---- btnRemover ----
		btnRemover.setText("REMOVER");
		btnRemover.setFont(btnRemover.getFont().deriveFont(btnRemover.getFont().getSize() - 2f));
		btnRemover.addActionListener(e -> btnRemoverActionPerformed(e));
		contentPane.add(btnRemover);
		btnRemover.setBounds(405, 335, 135, 35);

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
	private JButton btnAlt;
	private JButton btnRemover;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
