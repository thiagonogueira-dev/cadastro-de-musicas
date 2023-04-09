package br.com.cadastrodemusicas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastrodemusicas.model.Album;
import br.com.cadastrodemusicas.model.Artista;
import br.com.cadastrodemusicas.model.Musica;
import br.com.cadastrodemusicas.model.Usuario;

public class MusicaDao 
{
	
	private Connection con = null;
	
	public MusicaDao()
	{
		con = ConnectionFactory.getConnection();
	}
	
	public void add(Musica musica) throws SQLException
	{
		String sql = "insert into musica(nome, album_id) " + " values(?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, musica.getNome());
		stmt.setInt(2, musica.getAlbum().getId());
		
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Musica> listar(Usuario usuario) throws SQLException
	{
		String sql = "select musica.nome nome, musica.id id, album.titulo album, artista.nome artista from usuario join artista ON(usuario.id = artista.usuario_id) "
				+ "join album on(artista.id = album.artista_id) join musica on(album.id = musica.album_id)"
				+ "where usuario.id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, usuario.getId());
		ResultSet rs = stmt.executeQuery();

		Musica musica = null;
		Album album = null;
		Artista artista = null;
		List<Musica> musicas = new ArrayList<Musica>();
		
		while(rs.next()) {
			musica = new Musica();
			album = new Album();
			artista = new Artista();
			album.setTitulo(rs.getString("album"));
			artista.setNome(rs.getString("artista"));
			musica.setNome(rs.getString("nome"));
			musica.setId(rs.getInt("id"));
			musica.setAlbum(album);	
			musica.setArtista(artista);
			musicas.add(musica);
		}
		
		stmt.execute();
		stmt.close();
		con.close();
		return musicas;
	}
	
	public void excluir(int id) throws SQLException
	{
		String sql = "delete from musica where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Musica buscar(int id) throws SQLException
	{
		String sql = "select nome from musica where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Musica musica = null;
		
		while(rs.next()) 
		{
			musica = new Musica();
			musica.setNome(rs.getString("nome"));
		}
		
		stmt.execute();
		stmt.close();
		con.close();
		return musica;
	}
	
	public void alterar(int id, String nome) throws SQLException
	{
		String sql = "update musica set nome = ? where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setInt(2, id);
		
		stmt.execute();
		stmt.close();
		con.close();
	}
}
