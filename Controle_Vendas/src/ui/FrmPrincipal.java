/*
 * Created by JFormDesigner on Sun Mar 21 00:18:47 GMT-03:00 2021
 */

package ui;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.event.*;

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
		FrmCadCli cadCli = new FrmCadCli(owner);
		cadCli.setVisible(true);
		
		
	}


	private void menuCadVendaActionPerformed(ActionEvent e) {
		FrmCadVendas cadVenda = new FrmCadVendas(owner);
		cadVenda.setVisible(true);
	}

	private void menuEstActionPerformed(ActionEvent e) {
	
	}

	private void menuAltEstoqueActionPerformed(ActionEvent e) {
		FrmEstoque est = new FrmEstoque(owner);
		est.setVisible(true);
	}



	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Gustavo
		frmPrincipal = new JDialog();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuCadCli = new JMenuItem();
		menuEst = new JMenu();
		menuAltEstoque = new JMenuItem();
		menu3 = new JMenu();
		menuCadVenda = new JMenuItem();
		panel1 = new JPanel();

		//======== frmPrincipal ========
		{
			frmPrincipal.setTitle("THAGUS");
			var frmPrincipalContentPane = frmPrincipal.getContentPane();
			frmPrincipalContentPane.setLayout(null);

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

				//======== menuEst ========
				{
					menuEst.setText("ESTOQUE");
					menuEst.addActionListener(e -> menuEstActionPerformed(e));

					//---- menuAltEstoque ----
					menuAltEstoque.setText("ALTERAR ESTOQUE");
					menuAltEstoque.addActionListener(e -> menuAltEstoqueActionPerformed(e));
					menuEst.add(menuAltEstoque);
				}
				menuBar1.add(menuEst);

				//======== menu3 ========
				{
					menu3.setText("VENDA");

					//---- menuCadVenda ----
					menuCadVenda.setText("NOVA VENDA");
					menuCadVenda.addActionListener(e -> menuCadVendaActionPerformed(e));
					menu3.add(menuCadVenda);
				}
				menuBar1.add(menu3);
			}
			frmPrincipal.setJMenuBar(menuBar1);

			//======== panel1 ========
			{
				panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
				. swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing
				.border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
				Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
				) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
				public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName (
				) ) )throw new RuntimeException( ) ;} } );
				panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
			}
			frmPrincipalContentPane.add(panel1);
			panel1.setBounds(25, 25, panel1.getPreferredSize().width, 0);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < frmPrincipalContentPane.getComponentCount(); i++) {
					Rectangle bounds = frmPrincipalContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = frmPrincipalContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				frmPrincipalContentPane.setMinimumSize(preferredSize);
				frmPrincipalContentPane.setPreferredSize(preferredSize);
			}
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
	private JMenu menuEst;
	private JMenuItem menuAltEstoque;
	private JMenu menu3;
	private JMenuItem menuCadVenda;
	private JPanel panel1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
}
