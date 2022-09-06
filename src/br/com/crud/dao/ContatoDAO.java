package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Contato;

public class ContatoDAO {
	
	public void save (Contato contato) {
		String sql = "INSERT INTO cadastro (nomeCompleto, email, nascimento)" + "VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,contato.getNomeCompleto());
			pstm.setString(2, contato.getEmail());
			pstm.setDate(3,  contato.getNascimento());
			
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
	public void removeById (int id) {
		String sql = "DELETE FROM cadastro where id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1,id);
			
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public void update (Contato contato) {
		String sql = "UPDATE cadastro set nome = ?, idade = ?, dataCadastro = ?" + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,contato.getNomeCompleto());
			pstm.setString(2, contato.getEmail());
			pstm.setDate(3, contato.getNascimento());
		            
			
			pstm.setInt(4, contato.getId());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
	public List<Contato> getContatos(){
		
		String sql = "SELECT * FROM cadastro";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
		while(rset.next()) {
			Contato contato = new Contato();
			
		contato.setId(rset.getInt("id"));
		
		contato.setNomeCompleto(rset.getString("nomeCompleto"));
		
		contato.setEmail(rset.getString("email"));
		
		contato.setNascimento(rset.getDate("Nascimento"));
		
		contatos.add(contato);
		}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if (rset != null) {
				rset.close();
				}
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return contatos;	
	}

}
