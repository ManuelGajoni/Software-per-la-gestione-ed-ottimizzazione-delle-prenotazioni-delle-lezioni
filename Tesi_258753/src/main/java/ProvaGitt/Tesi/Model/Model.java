package ProvaGitt.Tesi.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ProvaGitt.Tesi.DAO.LezioniDAO;

public class Model 
{
	public LezioniDAO dao = new LezioniDAO();
	List <Lezione> LezMigliori; 
	List <Lezione> LezFissate;
	int punteggio; 
	
	// TROVO L'ID DEL TUTOR DAL NOME
	public int trovaIdTutor (List <Tutor> tutor, String nome)
	{
		for(int i=0; i<tutor.size(); i++)
		{
			if(tutor.get(i).getNome().equals(nome))
				return i;
		}
		return -1;
	}
	
	// TROVO L'ID DELLO STUDENTE DAL NOME
	public int trovaIdStudente (List <Studente> studenti, String nome)
	{
		for (int i=0; i<studenti.size(); i++)
		{
			if(studenti.get(i).getNome().equals(nome))
				return i;
		}
		return -1;
	}
	
	// TROVO LO STUDENTE DAL SUO ID
	public Studente trovaStudente (List <Studente> studenti, int id)
	{
		Studente s = null;
		for(int i=0; i<studenti.size(); i++)
		{
			if(studenti.get(i).getIdStudente() == id)
			{
				s = studenti.get(i);
			}
		}
		return s; 
	}
	
	// TROVO IL TUTOR DAL SUO ID
	public Tutor trovaTutor (List <Tutor> tutor, int id)
	{
		Tutor t = null;
		for(int i=0; i<tutor.size(); i++)
		{
			if(tutor.get(i).getIdTutor() == id)
			{
				t = tutor.get(i);
			}
		}
		return t;
	}

	// CREO L'ARRAY DEI MESI
	public List <String> RiempiMesi ()
	{
		List <String> m = new ArrayList <>();
		m.add("Gennaio");
		m.add("Febbraio");
		m.add("Marzo");
		m.add("Aprile");
		m.add("Maggio");
		m.add("Giugno");
		m.add("Luglio");
		m.add("Agosto");
		m.add("Settembre");
		m.add("Ottobre");
		m.add("Novembre");
		m.add("Dicembre");
		return m;
	}
	
	// RICAVO IL NUMERO DEL MESE DAL NOME
	public int OttieniMesi (String s)
	{
		int r = -1;
		switch (s)
		{
			case "Gennaio":
				r=1;
				return r;
			case "Febbraio":
				r=2;
				return r;
			case "Marzo":
				r=3;
				return r;
			case "Aprile":
				r=4;
				return r;
			case "Maggio":
				r=5;
				return r;
			case "Giugno":
				r=6;
				return r;
			case "Luglio":
				r=7;
				return r;
			case "Agosto":
				r=8;
				return r;
			case "Settembre":
				r=9;
				return r;
			case "Ottobre":
				r=10;
				return r;
			case "Novembre":
				r=11;
				return r;
			case "Dicembre":
				r=12;
				return r;
		}
		return r;
	}

	// CREO L'ARRAY DEGLI ORARI 
	public List <String> RiempiOrario ()
	{
		List <String> s = new ArrayList <String> ();
		s.add("9-11");
		s.add("11-13");
		s.add("15-17");
		s.add("17-19");
		return s;
	}
	
	// CREO L'ARRAY DELLE CLASSI
	public List <String> RiempiClasse ()
	{
		List <String> c = new ArrayList <> ();
		c.add("Elementari");
		c.add("Medie");
		c.add("Superiori");
		c.add("Università");
		return c;
	}

	// CONTROLLO SE E' STATA GIA' INSERITA LA LEZIONE
	public boolean isCorrettaLezione (Lezione l, List <Lezione> lez)
	{	
		for(int i=0; i<lez.size(); i++)
		{
			if( (l.getDayY() == lez.get(i).getDayY()) && (l.getAnno() == lez.get(i).getAnno()) && (l.getOrario().equals(lez.get(i).getOrario())) && (l.getIdTutor() == lez.get(i).getIdTutor()))
			{
				return false;
			}
		}
		return true;
	}

	// CALCOLO IL PUNTEGGIO DELLA SINGOLA LEZIONE
	public int calcolaPunteggio (Lezione l)
	{
		Tutor t = this.trovaTutor(getTutor(), l.getIdTutor());
		if(t == null)
		{
			return -1;
		}
		Studente s = this.trovaStudente(getStudenti(), l.getIdStudente());
		if(s == null)
		{
			return -1;
		}
		
		List <Lezione> lez = this.getLezioniTutorStudenteFatte(s.getIdStudente(), t.getIdTutor(), l.getDayY() , l.getAnno());
		
		if( (l.getMateria().equals("Sostegno DSA")) ||  (l.getMateria().equals("Consulenza Educatore")) )
		{
			if(t.isEducatore())
			{
				return 1;
			}
			if(!t.isEducatore())
			{
				return 0;
			}
		}
		
		if(s.getClasse().equals("Elementari") || s.getClasse().equals("Medie"))
		{
			if(s.isDSA())
			{
				if( (lez.isEmpty()) && (!t.isEducatore()))
				{
					return 1;
				}
				if( (lez.isEmpty()) && (t.isEducatore()))
				{
					return 2;
				}
				if( (!lez.isEmpty()) && (!t.isEducatore()))
				{
					return 2;
				}
				if( (!lez.isEmpty()) && (t.isEducatore()))
				{
					return 3;
				}
			} else
			{
				if( (lez.isEmpty()) && (!t.isEducatore()))
				{
					return 1;
				}
				if( (lez.isEmpty()) && (t.isEducatore()))
				{
					return 1;
				}
				if( (!lez.isEmpty()) && (!t.isEducatore()))
				{
					return 2;
				}
				if( (!lez.isEmpty()) && (t.isEducatore()))
				{
					return 2;
				}
			}
		}
		if(s.getClasse().equals("Superiori") || s.getClasse().equals("Università"))
		{
			if(s.isDSA())
			{
				if(!t.Materie.contains(l.getMateria()))
				{
					return 0;
				}
				if( (t.Materie.contains(l.getMateria())) && (lez.isEmpty()) && (!t.isEducatore())  )
				{
					return 1;
				}
				if( (t.Materie.contains(l.getMateria())) && (lez.isEmpty()) && (t.isEducatore())  )
				{
					return 2;
				}
				if( (t.Materie.contains(l.getMateria())) && (!lez.isEmpty()) && (!t.isEducatore()) && (!this.isMateriaSeguita(lez, l.getMateria()))  )
				{
					return 3;
				}
				if( (t.Materie.contains(l.getMateria())) && (!lez.isEmpty()) && (t.isEducatore()) &&  (!this.isMateriaSeguita(lez, l.getMateria())) )
				{
					return 3;
				}
				if( (t.Materie.contains(l.getMateria())) && (this.isMateriaSeguita(lez, l.getMateria())) && (!t.isEducatore())  )
				{
					return 4;
				}
				if( (t.Materie.contains(l.getMateria())) && (this.isMateriaSeguita(lez, l.getMateria())) && (t.isEducatore())  )
				{
					return 5;
				}
				
			} else
			{
				if(!t.Materie.contains(l.getMateria()))
				{
					return 0;
				}
				if( (t.Materie.contains(l.getMateria())) && (lez.isEmpty()) && (!t.isEducatore())  )
				{
					return 2;
				}
				if( (t.Materie.contains(l.getMateria())) && (lez.isEmpty()) && (t.isEducatore())  )
				{
					return 2;
				}
				if( (t.Materie.contains(l.getMateria())) && (!lez.isEmpty()) && (!t.isEducatore()) &&  (!this.isMateriaSeguita(lez, l.getMateria())) )
				{
					return 3;
				}
				if( (t.Materie.contains(l.getMateria())) && (!lez.isEmpty()) && (t.isEducatore()) &&  (!this.isMateriaSeguita(lez, l.getMateria())) )
				{
					return 3;
				}
				if( (t.Materie.contains(l.getMateria())) && (this.isMateriaSeguita(lez, l.getMateria())) && (!t.isEducatore())  )
				{
					return 4;
				}
				if( (t.Materie.contains(l.getMateria())) && (this.isMateriaSeguita(lez, l.getMateria())) && (t.isEducatore())  )
				{
					return 4;
				}
			}
			
			
		}
		
		
		return -1;
	}
	
	// CALCOLO IL PUNTEGGIO DELLE LEZIONI 
	public int calcolaPunteggioTot (List <Lezione> l)
	{
		int tot= 0; 
		for(int i=0; i<l.size(); i++)
		{
			tot += this.calcolaPunteggio(l.get(i));
		}
		return tot;
	}
	
	// CALCOLO IL NUMERO DI INTERNI NELLE PRENOTAZIONI
	public int calcolaInterno (List <Lezione> l)
	{
		int result = 0;
		for(int i=0; i<l.size(); i++)
		{
			Tutor t = this.trovaTutor(getTutor(), l.get(i).getIdTutor());
			if(t.isInterno())
			{
				result++;
			}
		}
		return result;
	}
	
	// CONTROLLO SE LE LEZIONI DA PRENOTARE NON CONTENGANO LEZIONI NON PRENOTABILI
	public boolean isNonZero (List<Lezione> l)
	{
		for(int i=0; i<l.size(); i++)
		{
			if(this.calcolaPunteggio(l.get(i)) == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	// CONTROLLO SE IL TUTOR HA FATTO UNA LEZIONE CON LO STUDENTE SULLA MEDESIMA MATERIA
	public boolean isMateriaSeguita (List <Lezione> l, String m)
	{
		for(int i=0; i<l.size(); i++)
		{
			if(l.get(i).getMateria().equals(m))
				return true;
		}
		return false;
	}
	
	// TROVO LE LEZIONI MENSILI DEL TUTOR
	public List <Lezione> getResocontoLezioniTutor (int mese, int id, int anno)
	{
		return dao.getResocontoLezioniTutor(mese, id,anno);
	}
	
	// TROVO LE LEZIONI DEL TUTOR PRENOTATE DA OGGI
	public List <Lezione> getResocontoLezioniPrenotateTutor(int DayY, int id, int anno)
	{
		return dao.getResocontoLezioniPrenotateTutor(DayY, id, anno);
	}
	
	// TROVO LE LEZIONI MENSILI DELLO STUDENTE
	public List<Lezione> getResocontoLezioniStudente (int mese, int id, int anno)
	{
		return dao.getResocontoLezioniStudente(mese, id, anno);
	}
	
	// TROVO TUTTE LE LEZIONI PRENOTATE DA OGGI
	public List <Lezione> getResocontoLezioniPrenotate (int anno, int DayY)
	{
		return dao.getResocontoLezioniPrenotate(anno, DayY);
	}
	
	// TROVO LE LEZIONI PRENOTATE NEL MESE SELEZIONATO
	public List <Lezione> getResocontoLezioniPrenotateMese (int mese, int day)
	{
		return dao.getResocontoLezioniPrenotateMese(mese, day);
	}
	
	// SELEZIONO TUTTI I TUTOR
	public List <Tutor> getTutor()
	{
		return dao.getTutor();
	}
	
	// SELEZIONO TUTTE LE MATERIE
	public List <String> getMaterie()
	{
		return dao.getMaterie();
	}
	
	// SELEZIONO TUTTI GLI STUDENTI
	public List <Studente> getStudenti()
	{
		return dao.getStudenti();
	}

	// INSERISCO UNO STUDENTE NEL DATABASE
	public boolean InserisciStudente (Studente s)
	{
		return dao.InserisciStudente(s);
	}
	
	// CANCELLO UNO STUDENTE DAL DATABASE
	public boolean CancellaStudente (int id)
	{
		return dao.CancellaStudente(id);
	}
	
	// INSERISCO UN TUTOR NEL DATABASE
	public boolean InserisciTutor (Tutor t)
	{
		return dao.InserisciTutor(t);
	}
	
	// CANCELLO UN TUTOR DAL DATABASE
	public boolean CancellaTutor (int id)
	{
		return dao.CancellaTutor(id);
	}
	
	// INSERISCO UNA NUOVA DISPONIBILITA' DEL TUTOR
	public boolean InserisciDisponibilita (Disponibilita d)
	{
		return dao.InserisciDisponibilita(d);
	}
	
	// CANCELLO UNA DISPONIBILITA' DAL DATABASE
	public boolean CancellaDisponibilita (int id)
	{
		return dao.CancellaDisponibilita(id);
	}
	
	// INSERISCO UNA NUOVA LEZIONE NEL DATABASE
	public boolean InserisciLezione (Lezione l)
	{
		return dao.InserisciLezione(l);
	}
	
	// CANCELLO UNA LEZIONE DAL DATABASE
	public boolean CancellaLezione (int id)
	{
		return dao.CancellaLezione(id);
	}
	
	// TROVO LE DISPONIBILITA' FUTURE DEL TUTOR SELEZIONATO 
	public List <Disponibilita> getDisponibilitaFuture (int DayY, int anno, int id)
	{
		return dao.getDisponibilitaFuture(DayY, anno, id);
	}
	
	// RICAVO LO STUDENTE DAL NOME
	public Studente getStudenteByNome (String nome)
	{
		return dao.getStudenteByNome(nome);
	}
	
	// TROVO LE LEZIONI FATTE TRA LO STUDENTE E IL TUTOR
	public List <Lezione> getLezioniTutorStudenteFatte (int idStud, int idTutor, int DayY, int anno)
	{
		return dao.getLezioniTutorStudenteFatte(idStud, idTutor, DayY, anno);
	}
	
	// TROVO L'ID DI TUTTI I TUTOR DISPONIBILI PER UNA LEZIONE
	public List<Integer> getTutorDisponibili (int DayY, int anno, String ora)
	{
		return dao.getTutorDisponibili(DayY, anno, ora);
	}
	
	// TROVO L'ULTIMO ID DELLE LEZIONI NEL DATABASE
	public int getContoLezioni ()
	{
		return dao.getContoLezioni();
	}
	
	// TROVO L'ULTIMO ID DEI TUTOR NEL DATABASE
	public int getContoTutor()
	{
		return dao.getContoTutor();
	}
	
	// TROVO L'ULTIMO ID DEGLI STUDENTI NEL DATABASE
	public int getContoStudenti ()
	{
		return dao.getContoStudenti();
	}
	
	// TROVO L'ULTIMO ID DELLE DISPONIBILITA' NEL DATABASE
	public int getContoDisponibilita ()
	{
		return dao.getContoDisponibilita();
	}
	
	// CERCO LA LEZIONE CONOSCENDO L'ORARIO, IL GIORNO E L'ID DEL TUTOR
	public int TrovaLezione (int id, int DayY, int anno, String orario)
	{
		return dao.TrovaLezione(id, DayY, anno, orario);
	}
	
	// CONTROLLO SE IL TUTOR E' STATO INSERITO NELLE LEZIONI (RICORSIONE)
	public boolean isTutorAggiunto (List <Lezione> lez, int id, String orario)
	{
		for(int i=0; i<lez.size(); i++)
		{
			if((lez.get(i).getIdTutor() == id) && (lez.get(i).getOrario().equals(orario)))
				return true;
		}
		return false;
	}
	
	// CONTROLLO SE LA LEZIONE E' STATA GIA' AGGIUNTA (RICORSIONE)
	public boolean isLezioneAggiunta (List <Lezione> lez, int id)
	{
		for(int i=0; i<lez.size(); i++)
		{
			if(lez.get(i).getIdLezione() == id)
				return true;
		}
		return false;
	}
	
	// CONTROLLO SE LA SOLUZIONE PARZIALE E' MEGLIO DELLA MIGLIORE (RICORSIONE)
	public boolean isMeglio (List <Lezione> parz, List <Lezione> tot)
	{
		if(tot.isEmpty())
		{
			return true;
		}
		if(this.calcolaPunteggioTot(parz)>this.calcolaPunteggioTot(tot))
		{
			return true;
		}
		if(this.calcolaPunteggioTot(parz)==this.calcolaPunteggioTot(tot))
		{
			if(this.calcolaInterno(parz)>this.calcolaInterno(tot))
			{
				return true;
			}
			if(this.calcolaInterno(parz)==this.calcolaInterno(tot))
			{
				if (menoTutor(parz, tot))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean menoTutor (List <Lezione> parz, List <Lezione> tot)
	{
		int p = 0;
		int t = 0;
		List <Integer> par = new ArrayList <Integer> ();
		List <Integer> to= new ArrayList <Integer> ();
		
		if( (!parz.isEmpty()) && (!tot.isEmpty()) )
		{
			for(int i=0; i<parz.size(); i++)
			{
				if(!par.contains(parz.get(i).getIdTutor()))
				{
					par.add(parz.get(i).getIdTutor());
					p++;
				}
			}
			for(int i=0; i<tot.size(); i++)
			{
				if(!to.contains(tot.get(i).getIdTutor()))
				{
					to.add(tot.get(i).getIdTutor());
					t++;
				}
			}
			if(p<t)
			{
				return true;
			}
		}
		return false;
			
	}
	
	// CONTROLLO SE LA LISTA DI LEZIONI NON CONTIENE DOPPIONI (RICORSIONE)
	 public boolean isCorretto (List <Lezione> parz)
	{
		List <Lezione> tutte = dao.getLezioniGiornoOra(parz.get(0).getDayY(), parz.get(0).getAnno(), parz.get(0).getOrario());
		List <Lezione> prenot = new ArrayList <Lezione> (parz);
		for(int i=0; i<tutte.size(); i++)
		{
			int cont = 0;
			for(int j=0; j<prenot.size(); j++)
			{
				if((tutte.get(i).getIdLezione() == prenot.get(j).getIdLezione()))
				{
					cont++;
				}
			}
			if(cont==0)
			{
				prenot.add(tutte.get(i));
			}
		}
		
		for(int i=0; i<prenot.size(); i++)
		{
			for(int j=0; j<prenot.size(); j++)
			{
				if( (prenot.get(i).getIdTutor() == prenot.get(j).getIdTutor()) && (i!=j))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	// ALGORITMO RICORSIVO PER LA RICERCA DELLE LEZIONI MIGLIORI DELLA GIORNATA MIGLIORATO
	public void cerca2(List <Lezione> parziale, int cont, List <Lezione> tutte, List <Lezione> fisse, List<Integer> id)
	{
		if(cont == tutte.size())
		{
			if((isMeglio(parziale,LezMigliori) == true) && (isCorretto(parziale) == true))
			{
				
				if(isNonZero(parziale) == true)
				{
					LezMigliori = new ArrayList <> (parziale);
					punteggio = this.calcolaPunteggioTot(LezMigliori);
				}
			}
		}
		
		if(cont>tutte.size())
		{
			return;
		}
		
		for(int i=0; i<tutte.size(); i++)
		{
			// List <Integer> id = this.getTutorDisponibiliOra(tutte, fisse);
			for(int j=0;j<id.size();j++)
			{
				if( (!isTutorAggiunto(parziale, id.get(j), tutte.get(i).getOrario())) && (!isLezioneAggiunta(parziale, tutte.get(i).getIdLezione())))
				{
					Lezione l = new Lezione (tutte.get(i).getIdLezione(), tutte.get(i).getIdStudente(),id.get(j),tutte.get(i).getData(),tutte.get(i).getOrario(),tutte.get(i).getMateria(),tutte.get(i).getGiorno(),tutte.get(i).getMese(),tutte.get(i).getAnno(),tutte.get(i).getDayY(),tutte.get(i).getNumGiorno());
					if(this.calcolaPunteggio(l)>0)
					{
						parziale.add(l);
						cerca2(parziale, cont+1,tutte, fisse, id);
						parziale.remove(parziale.size()-1);
					}
				}
			}
		}
	}

	// TROVO TUTOR DISPONIBILI PER LA LEZIONE
	public List <Integer> getTutorDisponibiliOra (List<Lezione> lez,List <Lezione> fisse)
	{
		List <Integer> id = this.getTutorDisponibili(lez.get(0).getDayY(), lez.get(0).getAnno(), lez.get(0).getOrario());
		List <Integer> id1 = new ArrayList <Integer> ();
		boolean trovato = false;
		for(int i=0; i<id.size();i++) 
		{
			trovato = false;
			for(int j=0; j<fisse.size(); j++)
			{
				if( (fisse.get(j).getIdTutor() == id.get(i)) && (fisse.get(j).getOrario().equals(lez.get(0).getOrario())) )
				{
					trovato = true;
				}
				
			}
			if(trovato == false)
			{
				id1.add(id.get(i));
			}
		}
		return id1;
	}
	
	
	// RICHIAMO DELL'ALGORITMO RICORSIVO MIGLIORATO
	public List <Lezione> getSoluzioneMigliore (List <Lezione> tutte , List <Lezione> fisse)
		{
			List <Lezione> totale = new ArrayList <Lezione> ();
			this.LezMigliori = new ArrayList <Lezione> (); 
			List <Lezione> parziale1 = new ArrayList <Lezione> ();
			List <Lezione> tutte1 = new ArrayList <Lezione> ();
			List <Lezione> parziale2 = new ArrayList <Lezione> ();
			List <Lezione> tutte2 = new ArrayList <Lezione> ();
			List <Lezione> parziale3 = new ArrayList <Lezione> ();
			List <Lezione> tutte3 = new ArrayList <Lezione> ();
			List <Lezione> parziale4 = new ArrayList <Lezione> ();
			List <Lezione> tutte4 = new ArrayList <Lezione> ();
			
			for(int i=0; i<tutte.size(); i++)
			{
				if(tutte.get(i).getOrario().equals("9-11"))
				{
					tutte1.add(tutte.get(i));
				}
				if(tutte.get(i).getOrario().equals("11-13"))
				{
					tutte2.add(tutte.get(i));
				}
				if(tutte.get(i).getOrario().equals("15-17"))
				{
					tutte3.add(tutte.get(i));
				}
				if(tutte.get(i).getOrario().equals("17-19"))
				{
					tutte4.add(tutte.get(i));
				}
			}
			if(!tutte1.isEmpty())
			{
				List <Integer> id1 = this.getTutorDisponibiliOra(tutte1, fisse);
				cerca2 (parziale1,0,tutte1, fisse, id1);
				if(!LezMigliori.isEmpty())
				{
					List <Lezione> tot1 = LezMigliori;
					for(int i=0; i<tot1.size(); i++)
					{
						totale.add(tot1.get(i));
					}
				}else
				{
					this.LezMigliori.clear();
					return this.LezMigliori;
				}
			}
			this.LezMigliori = new ArrayList <Lezione> ();
			
			if(!tutte2.isEmpty())
			{
				List <Integer> id2 = this.getTutorDisponibiliOra(tutte2, fisse);
				cerca2 (parziale2,0,tutte2, fisse, id2);
				if(!LezMigliori.isEmpty())
				{
					List <Lezione> tot2 = LezMigliori;
					for(int i=0; i<tot2.size(); i++)
					{
						totale.add(tot2.get(i));
					}
				} else
				{
					this.LezMigliori.clear();
					return this.LezMigliori;
				}
				
			}
			this.LezMigliori = new ArrayList <Lezione> ();
			
			if(!tutte3.isEmpty())
			{
				List <Integer> id3 = this.getTutorDisponibiliOra(tutte3, fisse);
				cerca2 (parziale3,0,tutte3, fisse, id3);
				if(!LezMigliori.isEmpty())
				{
					List <Lezione> tot3 = LezMigliori;
					for(int i=0; i<tot3.size(); i++)
					{
						totale.add(tot3.get(i));
					}
				} else
				{
					this.LezMigliori.clear();
					return this.LezMigliori;
				}
				
			}
			this.LezMigliori = new ArrayList <Lezione> ();
			
			if(!tutte4.isEmpty())
			{
				List <Integer> id4 = this.getTutorDisponibiliOra(tutte4, fisse);
				cerca2 (parziale4,0,tutte4, fisse, id4);
				if(!LezMigliori.isEmpty())
				{
					List <Lezione> tot4 = LezMigliori;
					for(int i=0; i<tot4.size(); i++)
					{
						totale.add(tot4.get(i));
					}
				}else
				{
					this.LezMigliori.clear();
					return this.LezMigliori;
				}
				
			}
			
			this.LezMigliori = new ArrayList <Lezione> (totale);
			
			return LezMigliori;
		}

	// TROVO LE LEZIONI DEL GIORNO (RICORSIONE)
	public List <Lezione> getLezioniGiorno (int DayY, int anno)
	{
		return dao.getLezioniGiorno(DayY, anno);
	}

	
}
