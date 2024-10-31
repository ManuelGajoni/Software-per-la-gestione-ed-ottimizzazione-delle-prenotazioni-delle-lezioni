package ProvaGitt.Tesi.Model;

import java.util.List;

public class Tutor 
{
	private int IdTutor;
	private String Nome;
	public List <String> Materie;
	private String Formazione;
	private boolean Educatore;
	private boolean Interno;
	
	public Tutor(int idTutor, String nome, List<String> materie, String formazione, boolean educatore,
			boolean interno) 
	{
		super();
		IdTutor = idTutor;
		Nome = nome;
		Materie = materie;
		Formazione = formazione;
		Educatore = educatore;
		Interno = interno;
	}

	public int getIdTutor() 
	{
		return IdTutor;
	}

	public void setIdTutor(int idTutor) 
	{
		IdTutor = idTutor;
	}

	public String getNome() 
	{
		return Nome;
	}

	public void setNome(String nome) 
	{
		Nome = nome;
	}

	public List<String> getMaterie() 
	{
		return Materie;
	}

	public void setMaterie(List<String> materie) 
	{
		Materie = materie;
	}

	public String getFormazione() 
	{
		return Formazione;
	}

	public void setFormazione(String formazione) 
	{
		Formazione = formazione;
	}

	public boolean isEducatore() 
	{
		return Educatore;
	}

	public void setEducatore(boolean educatore) 
	{
		Educatore = educatore;
	}

	public boolean isInterno() 
	{
		return Interno;
	}

	public void setInterno(boolean interno) 
	{
		Interno = interno;
	}

	@Override
	public String toString() 
	{
		return Nome;
	}

}
