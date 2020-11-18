package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {
	
	public ArquivosController() {
		super();
	}
	
	
	
	@Override
	public void verificaDirTemp() throws IOException {
		
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "cadastro.csv");
		if(dir.exists() && dir.isDirectory()) {		
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			FileWriter fileWriter = new FileWriter(arq, existe);
			fileWriter.close();
		}
		
		else {
			dir.mkdir();
			FileWriter fileWriter = new FileWriter(dir);
			fileWriter.close();
			throw new IOException("arquivo foi criado");
		}
				

	}
	
	// ----------------------------------------------------------------------------------------------------------

	@Override
	public boolean verificaRegistro(String arquivo, int codigo) throws IOException {
		
		File arq = new File(arquivo);
		boolean afirmação = false;
		
		if (arq.exists()&&arq.isFile()) {
		
		FileInputStream fluxo = new FileInputStream(arq);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();

		
		while(linha!=null) {
			
			String separa = linha;
			String result[] = new String[3];	
			result = separa.split(";");
			
			int nova = Integer.parseInt(result[0]);

			if(nova == codigo) {	
				
				afirmação = true;

			}
			
			linha = buffer.readLine();
			
		} 
		
		buffer.close();
		leitor.close();
		fluxo.close();
		
		}else {
			
			throw new IOException("nao encontramos ninguem com esse numero");
			
		}
		
		return afirmação;

	}
	
	// ------------------------------------------------------------------------------------------------------------

	@Override
	public void imprimeCadastro(String arquivo, int codigo) throws IOException {
		
		if ( (verificaRegistro(arquivo, codigo)) == true){
		
			File arq = new File(arquivo);
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while(linha!=null) {
				String separa = linha;
				String result[] = new String[3];	
				result = separa.split(";");			
				int nova = Integer.parseInt(result[0]);
				
				if(nova == codigo) {
					System.out.println("codigo: " + result[0] );
					System.out.println("nome: " + result[1] );
					System.out.println("email: " + result[2] );
				}
				
				linha = buffer.readLine();
				
			} 
			
			buffer.close();
			leitor.close();
			fluxo.close();

		}else {
			throw new IOException("nao encontramos ninguem com esse numero");
		}
		
	}
	
// ------------------------------------------------------------------------------------------------------------
	

	@Override
	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
		
		File arq = new File(arquivo);
		
		String n_codigo = Integer.toString(codigo);
		String ponto = ";";
		String pula = "\n ";
		
		n_codigo = pula.concat(n_codigo.concat(ponto));
		nome = nome.concat(ponto);
		
		if ( (verificaRegistro(arquivo, codigo)) == false){
			
			String texto =  n_codigo.concat(nome).concat(email);
			System.out.println(texto);
			
			String conteudo = texto;
			FileWriter fileWriter = new FileWriter(arq,true);
			PrintWriter print = new PrintWriter(fileWriter);
			print.append(conteudo);
			print.flush();
			print.close();
			fileWriter.close();;
			
			
		}else {
			throw new IOException("cadastro ja existe");
		}
		
	}	
	


	}
	
	
	
