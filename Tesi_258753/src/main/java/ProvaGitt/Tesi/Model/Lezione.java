package ProvaGitt.Tesi.Model;

import java.util.Date;

public class Lezione 
{
	private int IdLezione;
	private int IdStudente;
	private int IdTutor;
	private Date data;
	private String Orario;
	private String Materia;
	private int Giorno;
	private int Mese;
	private int Anno;
	private int DayY;
	private int NumGiorno;

	public Lezione(int idLezione, int idStudente, int idTutor, Date data, String orario, String materia, int giorno,
			int mese, int anno, int dayY, int numgiorno) 
	{
		super();
		IdLezione = idLezione;
		IdStudente = idStudente;
		IdTutor = idTutor;
		this.data = data;
		Orario = orario;
		Materia = materia;
		Giorno = giorno;
		Mese = mese;
		Anno = anno;
		DayY = dayY;
		NumGiorno = numgiorno;
	}
	
	public int getIdLezione() 
	{
		return IdLezione;
	}

	public void setIdLezione(int idLezione) 
	{
		IdLezione = idLezione;
	}

	public int getIdStudente() 
	{
		return IdStudente;
	}

	public void setIdStudente(int idStudente) 
	{
		IdStudente = idStudente;
	}

	public int getIdTutor() 
	{
		return IdTutor;
	}

	public void setIdTutor(int idTutor) 
	{
		IdTutor = idTutor;
	}

	public Date getData() 
	{
		return data;
	}

	public void setData(Date data) 
	{
		this.data = data;
	}

	public String getOrario() 
	{
		return Orario;
	}

	public void setOrario(String orario) 
	{
		Orario = orario;
	}

	public String getMateria() 
	{
		return Materia;
	}

	public void setMateria(String materia) 
	{
		Materia = materia;
	}

	public int getGiorno() 
	{
		return Giorno;
	}

	public void setGiorno(int giorno) 
	{
		Giorno = giorno;
	}

	public int getMese() 
	{
		return Mese;
	}

	public void setMese(int mese) 
	{
		Mese = mese;
	}
	
	public int getAnno() 
	{
		return Anno;
	}

	public void setAnno(int anno) 
	{
		Anno = anno;
	}

	public int getDayY() 
	{
		return DayY;
	}

	public void setDayY(int dayY) 
	{
		DayY = dayY;
	}

	public int getNumGiorno() 
	{
		return NumGiorno;
	}

	public void setNumGiorno(int numGiorno) 
	{
		NumGiorno = numGiorno;
	}

	@Override
	public String toString() 
	{
		return "IdLezione:" + IdLezione + ", IdStudente:" + IdStudente + ", IdTutor:" + IdTutor + ", Data:"
				+ data + ", Orario:" + Orario + ", Materia: " + Materia + "\n";
	}
	
}
