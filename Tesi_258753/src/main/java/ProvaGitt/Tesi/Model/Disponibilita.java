package ProvaGitt.Tesi.Model;

import java.util.Date;

public class Disponibilita 
{
	private int id_Disp;
	private int id_Tutor;
	private Date data;
	private String Orario; 
	private int DayY;
	private int Giorno;
	private int Mese;
	private int Anno;
	
	public Disponibilita(int id_Disp, int id_Tutor, Date data, String orario, int dayY, int giorno, int mese,
			int anno) 
	{
		super();
		this.id_Disp = id_Disp;
		this.id_Tutor = id_Tutor;
		this.data = data;
		Orario = orario;
		DayY = dayY;
		Giorno = giorno;
		Mese = mese;
		Anno = anno;
	}

	public int getId_Disp() {
		return id_Disp;
	}

	public void setId_Disp(int id_Disp) {
		this.id_Disp = id_Disp;
	}

	public int getId_Tutor() {
		return id_Tutor;
	}

	public void setId_Tutor(int id_Tutor) {
		this.id_Tutor = id_Tutor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOrario() {
		return Orario;
	}

	public void setOrario(String orario) {
		Orario = orario;
	}

	public int getDayY() {
		return DayY;
	}

	public void setDayY(int dayY) {
		DayY = dayY;
	}

	public int getGiorno() {
		return Giorno;
	}

	public void setGiorno(int giorno) {
		Giorno = giorno;
	}

	public int getMese() {
		return Mese;
	}

	public void setMese(int mese) {
		Mese = mese;
	}

	public int getAnno() {
		return Anno;
	}

	public void setAnno(int anno) {
		Anno = anno;
	}

	@Override
	public String toString() {
		return "Disponibilita [id_Disp=" + id_Disp + ", id_Tutor=" + id_Tutor + ", data=" + data + ", Orario=" + Orario
				+ ", DayY=" + DayY + ", Giorno=" + Giorno + ", Mese=" + Mese + ", Anno=" + Anno + "]";
	}
	
	
	
	
	
}
