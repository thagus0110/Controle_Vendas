/*
 * Created by JFormDesigner on Sun Mar 21 00:18:47 GMT-03:00 2021
 */

package ui;

import java.awt.Frame;
import java.awt.event.*;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		FrmCadVendas cadVenda = new FrmCadVendas(owner);
		cadVenda.setVisible(true);
		
		
	}




	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Gustavo
		frmPrincipal = new JDialog();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuCadCli = new JMenuItem();
		menu2 = new JMenu();
		menu3 = new JMenu();
		menuCadVenda = new JMenuItem();

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

				//======== menu2 ========
				{
					menu2.setText("ESTOQUE");
				}
				menuBar1.add(menu2);

				//======== menu3 ========
				{
					menu3.setText("VENDAS");

					//---- menuCadCli ----
					menuCadVenda.setText("NOVA VENDA");
					menuCadVenda.addActionListener(e -> menuCadCliActionPerformed(e));
					menu3.add(menuCadVenda);
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
	private JMenu menu2;
	private JMenu menu3;
	private JMenuItem menuCadVenda;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
}
