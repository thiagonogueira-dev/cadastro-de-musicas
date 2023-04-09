package br.com.cadastrodemusicas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastrodemusicas.model.Artista;
import br.com.cadastrodemusicas.model.Usuario;

public class ArtistaDao 
{
	private Connection con = null;
	
	public ArtistaDao()
	{
		con = ConnectionFactory.getConnection();
	}

	public void add(Artista artista) throws SQLException
	{
		String sql = "insert into artista(usuario_id, nome) " + " values(?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, artista.getUsuario().getId());
		stmt.setString(2, artista.getNome());
		
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Artista> listar(Usuario usuario) throws SQLException
	{
		String sql = "select nome from artista where usuario_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, usuario.getId());
		ResultSet rs = stmt.executeQuery();

		Artista artista = null;
		List<Artista> artistas = new ArrayList<Artista>();
		
		while(rs.next()) {
			artista = new Artista();
			artista.setNome(rs.getString("nome"));
				
			artistas.add(artista);			
		}
		
		stmt.execute();
		stmt.close();
		con.close();
		return artistas;
	}
	
	public Artista buscar(String nome, int usuarioId) throws SQLException
	{
		String sql = "select id from artista where nome = ? and usuario_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setInt(2, usuarioId);
		ResultSet rs = stmt.executeQuery();
		
		Artista artista = null;
		
		while(rs.next()) 
		{
			artista = new Artista();
			artista.setId(rs.getInt("id"));		
		}
		
		stmt.execute();
		stmt.close();
		con.close();
		return artista;
	}
	
	public Artista buscarPorAlbum(String titulo, int usuarioId) throws SQLException
	{
		String sql = "select artista.id from album join artista ON(artista.id = album.artista_id) "
				+ "where album.titulo = ? and artista.usuario_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, titulo);
		stmt.setInt(2, usuarioId);
		ResultSet rs = stmt.executeQuery();
		
		Artista artista = null;
		
		while(rs.next()) 
		{
			artista = new Artista();
			artista.setId(rs.getInt("artista.id"));		
		}
		
		stmt.execute();
		stmt.close();
		con.close();
		return artista;
	}
}
