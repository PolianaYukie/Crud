package br.com.crud.main;
import br.com.crud.dao.ContatoDAO;
import br.com.crud.model.Contato;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Teste {

	public static void main(String[] args) {
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato = new Contato();
		
		
		contato.setNomeCompleto("Poliana");
		contato.setEmail("polianayukie@gmail.com");
		
		try {
			String dataString = "01/09/1987"; 
			DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
			java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
			contato.setNascimento(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contatoDAO.save(contato);
	
		
		
		
		for (Contato c : contatoDAO.getContatos()) {
			System.out.println("NOME: " + c.getNomeCompleto());
			System.out.println("EMAIL: " + c.getEmail());
			System.out.println("DATA DE NASCIMENTO: " + c.getNascimento());
			System.out.println("CIDADE: " + c.getCidade());
			contatoDAO.removeById(c.getId());
		}
	}

}
