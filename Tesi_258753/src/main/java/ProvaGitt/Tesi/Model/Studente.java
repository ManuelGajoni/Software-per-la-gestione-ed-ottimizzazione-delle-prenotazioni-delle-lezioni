package ProvaGitt.Tesi.Model;

public class Studente 
{
	private int IdStudente;
	private String Nome;
	private String Classe;
	private boolean DSA;
	
	public Studente(int idStudente, String nome, String classe, boolean dSA) 
	{
		super();
		IdStudente = idStudente;
		Nome = nome;
		Classe = classe;
		DSA = dSA;
	}

	public int getIdStudente() 
	{
		return IdStudente;
	}

	public void setIdStudente(int idStudente) 
	{
		IdStudente = idStudente;
	}

	public String getNome() 
	{
		return Nome;
	}

	public void setNome(String nome) 
	{
		Nome = nome;
	}

	public String getClasse() 
	{
		return Classe;
	}

	public void setClasse(String classe) 
	{
		Classe = classe;
	}

	public boolean isDSA() 
	{
		return DSA;
	}

	public void setDSA(boolean dSA) 
	{
		DSA = dSA;
	}

	@Override
	public String toString() 
	{
		return "Studente [IdStudente=" + IdStudente + ", Nome=" + Nome + ", Classe=" + Classe
				+ ", DSA=" + DSA + "]";
	} 
	
}
