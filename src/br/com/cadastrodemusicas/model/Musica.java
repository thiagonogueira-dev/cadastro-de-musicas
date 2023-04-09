package br.com.cadastrodemusicas.model;


public class Musica 
{
	private String nome;
	private Album album;
	private Artista artista;
	private Usuario usuario;
	private int id;	
	
	public int getId() 
	{
		return this.id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public Artista getArtista() 
	{
		return this.artista;
	}

	public void setArtista(Artista artista) 
	{
		this.artista = artista;
	}
	
	public String getNome() 
	{
		return this.nome;
	}
	

	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public Album getAlbum() 
	{
		return this.album;
	}
	
	public void setAlbum(Album album) 
	{
		this.album = album;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
