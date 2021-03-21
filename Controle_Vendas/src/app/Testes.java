package app;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import conn.Conexao;
import entities.Cliente;
import entities.Estoque;
import entities.Vendas;

public class Testes {

	public void whatToDo() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		Estoque es = new Estoque();

		Conexao con = new Conexao();
		Cliente cli = new Cliente();		
		Vendas vn = new Vendas();
				
		int i = 1;
		
		while(i != 0) {
			int esc = Integer.parseInt(JOptionPane.showInputDialog("O que deseja fazer?\n"
					+ "1 - CLIENTE\n"
					+ "2 - ESTOQUE\n"
					+ "3 - TESTAR O BANCO DE DADOS\n"
					+ "4 - CONSULTAR ESTOQUE\n"
					+ "5 - ACESSAR VENDAS\n"
					+ "0 - SAIR\n"));
				
				switch(esc) {
				
				case 1:
					cli.whatToDo();
					break;
					
				case 2:
					es.whatToDo();			
					break;
					
				case 3:
					con.verificarBanco();
					break;
					
				case 4:
					
					break;
				
				case 5:
					vn.whatToDo();
					break;
					
				case 0:
					i = 0;
					break;
				}
						
		}
		
		sc.close();				
		}


}
