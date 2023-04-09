package br.com.cadastrodemusicas.model;


public class Album 
{
	private String titulo;
	private Artista artista;
	private int id;
	
	
	public int getId() 
	{
		return this.id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitulo() 
	{
		return this.titulo;
	}
	
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	
	public Artista getArtista() 
	{
		return artista;
	}
	
	public void setArtista(Artista artista) 
	{
		this.artista = artista;
	}
	
}
