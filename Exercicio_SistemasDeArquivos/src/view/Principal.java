package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		
		String arquivos = "C:\\TEMP\\cadastro.csv";
		
		int codigo =Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo: "));
		
		String nome = JOptionPane.showInputDialog(null, "Digite o nome: ");
		
		String email = JOptionPane.showInputDialog(null, "Digite o email: ");
		
		
				
		try {
			
		arqCont.verificaDirTemp();
		
		arqCont.verificaRegistro(arquivos, codigo);
		
		arqCont.imprimeCadastro(arquivos, codigo);
			
		arqCont.insereCadastro(arquivos, codigo, nome, email);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
