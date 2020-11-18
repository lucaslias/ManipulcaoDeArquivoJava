package controller;

import java.io.IOException;

public interface IArquivosController {
	
	public boolean verificaRegistro(String arquivo, int codigo) throws IOException;
	
	public void imprimeCadastro(String arquivo, int codigo) throws IOException; 
	
	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException;
	
	public void verificaDirTemp() throws IOException;
	
	
}

