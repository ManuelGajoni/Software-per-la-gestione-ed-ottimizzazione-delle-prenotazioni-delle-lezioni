package ProvaGitt.Tesi.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ProvaGitt.Tesi.Model.Disponibilita;
import ProvaGitt.Tesi.Model.Lezione;
import ProvaGitt.Tesi.Model.Studente;
import ProvaGitt.Tesi.Model.Tutor;

public class TestDB 
{
	public static void main(String[] args) 
	{
		LezioniDAO dao = new LezioniDAO ();
		// System.out.println(dao.getResocontoLezioni(2, 21));
		/*
		List <String> s = dao.getTutor().get(1).getMaterie();
		for(int i=0; i<s.size(); i++)
		{
			if(s.get(i).equals("Geometria"))
			{
				System.out.println(s.get(i));
			}
		}*/
		
		// System.out.println(dao.getMaterie());
		
		// List<Lezione> l = dao.getResocontoLezioniTutor(2,1);
		// System.out.print(dao.getResocontoLezioniTutor(2,1));
		// System.out.println(dao.getResocontoLezioniPrenotateTutor(50, 1, 2024));
		// System.out.println(dao.getResocontoLezioniPrenotate(2024, 50));
		// Studente s = new Studente(32, "Manuel Biggiani", "Medie", false);
		// dao.InserisciStudente(s);
		// dao.CancellaStudente(32);
		/*
		List <String> a = new ArrayList <String> ();
		a.add("Chimica");
		a.add("Storia");
		a.add("Biologia");
		Tutor t = new Tutor(30,"Simone Blu",a,"Studia",true,false);
		dao.InserisciTutor(t);
		*/
		// dao.CancellaTutor(30);
		Date da = new Date (2024-9-20);
		// Disponibilita d = new Disponibilita (1,2,da,"11-13",2,30,10,2024);
		// dao.InserisciDisponibilita(d);
		// System.out.print(dao.getDisponibilitaFuture(203, 2023, 5));
		// dao.CancellaDisponibilita(1);
		
		// Lezione l = new Lezione(4,32,2,da, "11-13", "Fisica", 20,9,2024, 300,2);
		// dao.InserisciLezione(l);
		System.out.println(dao.getLezioniGiorno(33, 2024));
		List <String> mat = new ArrayList <String> ();
		mat.add("Storia");
		mat.add("Chimica");
		
		
		
		
		
		
		
	} 
	
}
