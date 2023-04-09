package br.com.cadastrodemusicas.model;

public class Usuario 
{
	private String nome;
	private String login;
	private String senha;
	private int id;
	
	public int getId() 
	{
		return this.id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getNome() 
	{
		return this.nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) 
	{
		this.login = login;
	}
	public String getSenha() 
	{
		return this.senha;
	}
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	
	
}
