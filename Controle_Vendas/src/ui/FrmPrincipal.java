/*
 * Created by JFormDesigner on Sun Mar 21 00:18:47 GMT-03:00 2021
 */

package ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.*;

/**
 * @author Gustavo
 */
public class FrmPrincipal {
	private static Frame owner;
	public FrmPrincipal() {
		
		initComponents();
		frmPrincipal.setVisible(true);
	}

	private void menuCadCliActionPerformed(ActionEvent e) {
		FrmCadCli cadCli = new FrmCadCli(owner);
		cadCli.setVisible(true);
		
	}

	private void btnEstqStateChanged(ChangeEvent e) {
		FrmEstoque estoque = new FrmEstoque(owner);
		estoque.setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Gustavo
		frmPrincipal = new JDialog();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuCadCli = new JMenuItem();
		btnEstq = new JMenu();
		menu3 = new JMenu();

		//======== frmPrincipal ========
		{
			frmPrincipal.setTitle("THAGUS");
			var frmPrincipalContentPane = frmPrincipal.getContentPane();
			frmPrincipalContentPane.setLayout(new BoxLayout(frmPrincipalContentPane, BoxLayout.X_AXIS));

			//======== menuBar1 ========
			{

				//======== menu1 ========
				{
					menu1.setText("CLIENTE");

					//---- menuCadCli ----
					menuCadCli.setText("CADASTRO DE CLIENTE");
					menuCadCli.addActionListener(e -> menuCadCliActionPerformed(e));
					menu1.add(menuCadCli);
				}
				menuBar1.add(menu1);

				//======== btnEstq ========
				{
					btnEstq.setText("ESTOQUE");
					btnEstq.addChangeListener(e -> btnEstqStateChanged(e));
				}
				menuBar1.add(btnEstq);

				//======== menu3 ========
				{
					menu3.setText("VENDA");
				}
				menuBar1.add(menu3);
			}
			frmPrincipal.setJMenuBar(menuBar1);
			frmPrincipal.setSize(805, 515);
			frmPrincipal.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Gustavo
	private JDialog frmPrincipal;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuCadCli;
	private JMenu btnEstq;
	private JMenu menu3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
}
