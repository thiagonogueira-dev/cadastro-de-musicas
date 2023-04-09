package br.com.cadastrodemusicas.model;


public class Artista 
{
	private String nome;
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

	public Usuario getUsuario() 
	{
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) 
	{
		this.usuario = usuario;
	}

	public String getNome() 
	{
		return this.nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
}
