package br.com.cadastrodemusicas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastrodemusicas.model.Album;
import br.com.cadastrodemusicas.model.Usuario;

public class AlbumDao 
{
	private Connection con = null;
	
	public AlbumDao()
	{
		con = ConnectionFactory.getConnection();
	}

	public void add(Album album) throws SQLException
	{
		String sql = "insert into album(titulo, artista_id) " + " values(?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, album.getTitulo());
		stmt.setInt(2, album.getArtista().getId());
		
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Album> listar(Usuario usuario) throws SQLException
	{
		String sql = "select titulo from album "
				+ "join artista on(album.artista_id = artista.id) "
				+ "where artista.usuario_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, usuario.getId());
		ResultSet rs = stmt.executeQuery();

		Album album = null;
		List<Album> albuns = new ArrayList<Album>();
		
		while(rs.next()) 
		{
			album = new Album();
			album.setTitulo(rs.getString("titulo"));
			albuns.add(album);			
		}
		
		stmt.execute();
		stmt.close();
		con.close();
		return albuns;
	}
	
	public Album buscar(String titulo, int usuarioId) throws SQLException
	{
		String sql = "select distinct album.id id "
				+ "from album join artista on(album.artista_id = artista.id)"
				+ "join usuario on(artista.usuario_id = usuario.id) "
				+ "where album.titulo = ? and usuario.id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, titulo);
		stmt.setInt(2, usuarioId);
		ResultSet rs = stmt.executeQuery();
		
		Album album = null;
		
		while(rs.next()) 
		{
			album = new Album();
			album.setTitulo(titulo);
			album.setId(rs.getInt("id"));
		}
		
		stmt.execute();
		stmt.close();
		con.close();
		return album;
	}
}