package view;

import java.io.IOException;
import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController();
		
		String dirWin = "C:\\Windows";
		String path = "C:\\Users\\lucas\\Documents\\arquivos";
		String nome = "teste.txt";
	
		
		
		try {
		arqCont.readDir(dirWin);
		arqCont.createFile(path, nome);
		arqCont.readFile(path, nome);
		arqCont.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
