package ProvaGitt.Tesi.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ProvaGitt.Tesi.Model.Disponibilita;
import ProvaGitt.Tesi.Model.Lezione;
import ProvaGitt.Tesi.Model.Studente;
import ProvaGitt.Tesi.Model.Tutor;

public class LezioniDAO 
{
	// RESOCONTO TUTOR
	// TROVO TUTTE LE LEZIONI DEL TUTOR NEL MESE SELEZIONATO
	public List<Lezione> getResocontoLezioniTutor (int mese, int id, int anno) 
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE l.`id_Tutor` = ? AND MONTH(l.`Data`) = ? AND YEAR(l.`Data`)= ? "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.setInt(2, mese);
			st.setInt(3, anno);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), id, rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	
	public List <Lezione> getResocontoLezioniPrenotateTutor (int DayY, int id, int anno)
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE l.`id_Tutor` = ? AND DAYOFYEAR(l.`Data`) >= ? AND YEAR(l.`Data`) = ? "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.setInt(2, DayY);
			st.setInt(3, anno);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), id, rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// RESOCONTO STUDENTE
	// TROVO TUTTE LE LEZIONI DELLO STUDENTE NEL MESE SELEZIONATO
	public List <Lezione> getResocontoLezioniStudente (int mese, int id, int anno)
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`id_Tutor`, l.`Data`, l.`Orario`, l.`Materia`,DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE l.`id_Stud` = ? AND MONTH(l.`Data`) = ? AND YEAR(l.`Data`) = ? "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.setInt(2, mese);
			st.setInt(3, anno);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), rs.getInt("id_Tutor"), rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	// LEZIONI PRENOTATE
	// TROVO TUTTE LE LEZIONI PRENOTATE, SUCCESSIVE ALLA DATA ODIERNA
 	public List <Lezione> getResocontoLezioniPrenotateMese (int mese, int giorno)
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`id_Tutor`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE MONTH(l.`Data`) = ? AND DAY(l.`Data`) >= ? "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, mese);
			st.setInt(2, giorno);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), rs.getInt("id_Tutor"), rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
 	
 	public List <Lezione> getResocontoLezioniPrenotate (int anno, int DayY)
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`id_Tutor`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE (YEAR(l.`Data`) = ? AND DAYOFYEAR(l.`Data`) >= ?) OR (YEAR(l.`Data`)>?) "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			st.setInt(2, DayY);
			st.setInt(3, anno);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), rs.getInt("id_Tutor"), rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

 	
	// TROVO TUTTI I TUTOR PER RIEMPIRE IL MENU A TENDINA
	public List <Tutor> getTutor ()
	{
		final String sql = "SELECT t.`id_Tutor`, t.`nomeTutor`, t.`materieTutor`, t.`formazioneTutor`, t.`educatoreTutor`, t.`interno` "
				+ "FROM Tutor AS t";

		List<Tutor> tutor = new ArrayList<Tutor>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				String tot = rs.getString("materieTutor");
		    	String [] s = tot.split(",");
		    	List <String> m = new ArrayList <String> ();
		    	boolean edu = false;
		    	boolean interno = false;
		    	if(rs.getString("educatoreTutor").equals("true"))
		    		edu=true;
		    	if(rs.getString("interno").equals("true"))
		    		interno = true;
		    	for(int i=0; i<s.length; i++)
		    	{
		    		m.add(s[i]);
		    	}
				Tutor l = new Tutor(rs.getInt("id_Tutor"), rs.getString("nomeTutor"), m, rs.getString("formazioneTutor"), edu, interno);
				tutor.add(l);
			}

			conn.close();
			return tutor;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	// TROVO TUTTE LE MATERIE PER RIEMPIRE IL MENU A TENDINA
	public List <String> getMaterie ()
	{
		final String sql = "SELECT m.`nome` "
				+ "FROM Materie AS m";

		List<String> m = new ArrayList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				m.add(rs.getString("nome"));
			}

			conn.close();
			return m;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	// TROVO TUTTI GLI STUDENTI 
	public List <Studente> getStudenti()
	{
		final String sql = "SELECT s.`id_Stud`, s.`nomeStud`, s.`classeStud`, s.`dsaStud` "
				+ "FROM Studente AS s ";

		List<Studente> studenti = new ArrayList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
		    	boolean dsa = false;
		    	if(rs.getString("dsaStud").equals("true"))
		    		dsa=true;
		        
				Studente l = new Studente(rs.getInt("id_Stud"), rs.getString("nomeStud"), rs.getString("classeStud"), dsa);
				studenti.add(l);
			}

			conn.close();
			return studenti;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// PRENDO LE DISPONIBILITA' DALLA DATA ODIERNA
	public List <Disponibilita> getDisponibilitaFuture (int DayY, int anno, int id)
	{
		final String sql = "SELECT d.`id_Disp`, d.`id_Tutor`, d.`Data`, d.`Orario`, DAYOFYEAR(d.data) AS dy, DAY (d.`Data`) AS g, MONTH(d.`Data`) AS m, YEAR (d.`Data`) AS a "
				+ "FROM Disponibilita AS d "
				+ "WHERE ((DAYOFYEAR (d.`Data`) >= ? AND YEAR(d.`Data`) = ?) OR (YEAR (d.`Data`) > ?)) AND d.`id_Tutor` = ? "
				+ "ORDER BY d.`Data`, d.`Orario`";

		List<Disponibilita> disp = new ArrayList<Disponibilita>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, DayY);
			st.setInt(2, anno);
			st.setInt(3, anno);
			st.setInt(4, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
		    	
		        
				Disponibilita d = new Disponibilita(rs.getInt("id_Disp"), rs.getInt("id_Tutor"), rs.getDate("d.Data"), rs.getString("Orario"), rs.getInt("dy"), rs.getInt("g"), rs.getInt("m"),rs.getInt("a"));
				disp.add(d);
			}

			conn.close();
			return disp;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List <Integer> getTutorDisponibili (int DayY, int anno, String ora)
	{
		final String sql = "SELECT d.`id_Tutor` "
				+ "FROM Disponibilita AS d "
				+ "WHERE YEAR(d.`Data`) = ? AND DAYOFYEAR(d.`Data`) = ? AND d.`Orario` = ? "
				+ "GROUP BY d.`id_Tutor`";

		List<Integer> t = new ArrayList<Integer>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			st.setInt(2, DayY);
			st.setString(3, ora);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				t.add(rs.getInt("id_Tutor"));
			}

			conn.close();
			return t;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	// TROVO LO STUDENTE SELEZIONATO
	public Studente getStudenteByNome (String Nome)
	{
		final String sql = "SELECT s.`id_Stud`, s.`nomeStud`, s.`classeStud`, s.`dsaStud` "
				+ "FROM Studente AS s "
				+ "WHERE s.`nomeStud` = ?";

		Studente l = null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, Nome);

			ResultSet rs = st.executeQuery();

			if (rs.next()) 
			{
				boolean dsa = false;
		    	if(rs.getString("dsaStud").equals("true"))
		    		dsa=true;
				l = new Studente(rs.getInt("id_Stud"), rs.getString("nomeStud"), rs.getString("classeStud"), dsa);
			}

			conn.close();
			return l;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List <Lezione> getLezioniTutorStudente (int idStud, int idTut)
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`id_Tutor`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE l.`id_Stud`= ? AND l.`id_Tutor` = ? "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idStud);
			st.setInt(2, idTut);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), rs.getInt("id_Tutor"), rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List <Lezione> getLezioniTutorStudenteFatte (int idStud, int idTut, int DayY, int anno)
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`id_Tutor`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE l.`id_Stud`= ? AND l.`id_Tutor` = ? AND ( (DAYOFYEAR(l.`Data`)< ? AND YEAR(l.`Data`) = ?) OR (YEAR(l.`Data`) < ?)) "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idStud);
			st.setInt(2, idTut);
			st.setInt(3, DayY);
			st.setInt(4, anno);
			st.setInt(5, anno);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), rs.getInt("id_Tutor"), rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}	
	
	public Integer getContoLezioni ()
	{
		final String sql = "SELECT MAX(l.`id_Lez`) AS c "
				+ "FROM Lezioni AS l ";

		int tot = 0;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if (rs.next()) 
			{
				tot = rs.getInt("c");
			}

			conn.close();
			return tot;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Integer getContoDisponibilita ()
	{
		final String sql = "SELECT MAX(d.`id_Disp`) as c "
				+ "FROM Disponibilita AS d ";
		int tot = 0;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
		
			ResultSet rs = st.executeQuery();
		
			if (rs.next()) 
			{
				tot = rs.getInt("c");
			}
		
			conn.close();
			return tot;
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Integer getContoStudenti ()
	{
		final String sql = "SELECT MAX(s.`id_Stud`) AS c "
				+ "FROM Studente AS s";
		int tot = 0;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
		
			ResultSet rs = st.executeQuery();
		
			if (rs.next()) 
			{
				tot = rs.getInt("c");
			}
		
			conn.close();
			return tot;
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Integer getContoTutor ()
	{
		final String sql = "SELECT MAX(t.`id_Tutor`) AS c "
				+ "FROM Tutor AS t";
		int tot = 0;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
		
			ResultSet rs = st.executeQuery();
		
			if (rs.next()) 
			{
				tot = rs.getInt("c");
			}
		
			conn.close();
			return tot;
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Integer TrovaLezione (int id, int DayY, int anno, String orario)
	{
		final String sql = "SELECT l.`id_Lez` "
				+ "FROM Lezioni AS l "
				+ "WHERE l.`id_Tutor` = ? AND DAYOFYEAR (l.`Data`) = ? AND YEAR(l.`Data`) = ? AND l.`Orario` = ?";

		int res = -1;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.setInt(2, DayY);
			st.setInt(3, anno);
			st.setString(4,orario);

			ResultSet rs = st.executeQuery();

			if (rs.next()) 
			{
				res = rs.getInt("id_lez");
			}

			conn.close();
			return res;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Lezione> getLezioniGiorno (int DayY, int anno) 
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`id_Tutor`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE DAYOFYEAR(l.`Data`) = ? AND YEAR(l.`Data`)= ? "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, DayY);
			st.setInt(2, anno);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), rs.getInt("id_Tutor"), rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	
	public List<Lezione> getLezioniGiornoOra (int DayY, int anno, String orario) 
	{
		final String sql = "SELECT l.`id_Lez`, l.`id_Stud`, l.`id_Tutor`, l.`Data`, l.`Orario`, l.`Materia`, DAY(l.`Data`) AS g, MONTH (l.`Data`) AS m, YEAR (l.`Data`) AS a, DAYOFYEAR(l.`Data`) AS d, WEEKDAY (l.`Data`) AS w "
				+ "FROM Lezioni AS l "
				+ "WHERE DAYOFYEAR(l.`Data`) = ? AND YEAR(l.`Data`)= ? AND l.`Orario` = ? "
				+ "ORDER BY l.`Data`, l.`Orario`";

		List<Lezione> lezioni = new ArrayList<Lezione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, DayY);
			st.setInt(2, anno);
			st.setString(3, orario);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				Lezione l = new Lezione(rs.getInt("id_Lez"), rs.getInt("id_Stud"), rs.getInt("id_Tutor"), rs.getDate("Data"), rs.getString("Orario"), rs.getString("Materia"), rs.getInt("g"),rs.getInt("m"),rs.getInt("a"),rs.getInt("d"),rs.getInt("w"));
				lezioni.add(l);
			}

			conn.close();
			return lezioni;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	
	public boolean InserisciStudente (Studente s)
	{
		String sql = "INSERT IGNORE INTO `SpecialmenteTu`.`Studente` (`id_Stud`, `nomeStud`, `classeStud`, `dsaStud`) VALUES(?,?,?,?)";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			String r = null;
			if (s.isDSA())
				r = "true";
			if(!s.isDSA())
				r="false";
			
			st.setInt(1, s.getIdStudente());
			st.setString(2, s.getNome());
			st.setString(3, s.getClasse());
			st.setString(4, r);
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}

	public boolean CancellaStudente (int id)
	{
		String sql = "DELETE FROM Studente AS s "
				+ "WHERE s.`id_Stud` = ?";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}

	public boolean InserisciTutor (Tutor t)
	{
		String sql = "INSERT IGNORE INTO `SpecialmenteTu`.`Tutor` (`id_Tutor`, `nomeTutor`, `materieTutor`, `formazioneTutor`,`educatoreTutor`,`interno`) VALUES(?,?,?,?,?,?)";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			String ed = null;
			String in = null;
			String mat = "";
			
			if(t.isEducatore())
			{
				ed = "true";
			} else {
				ed = "false";
			}
			
			if(t.isInterno())
			{
				in = "true";
			} else {
				in = "false";
			}
			for(int i=0; i<t.Materie.size(); i++)
			{
				if(i == t.Materie.size()-1)
				{
					mat += t.Materie.get(i);
				}
				else
				{
					mat+=t.Materie.get(i)+",";	
				}
			}
			
			
			st.setInt(1, t.getIdTutor());
			st.setString(2, t.getNome());
			st.setString(3, mat);
			st.setString(4, t.getFormazione());
			st.setString(5, ed);
			st.setString(6, in);

			
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}

	public boolean CancellaTutor (int id)
	{
		String sql = "DELETE FROM Tutor AS t "
				+ "WHERE t.`id_Tutor` = ?";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}

	public boolean InserisciDisponibilita (Disponibilita d)
	{
		String sql = "INSERT IGNORE INTO `SpecialmenteTu`.`Disponibilita` (`id_Disp`, `id_Tutor`, `Data`, `Orario`) VALUES(?,?,?,?)";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, d.getAnno());
			cal.set(Calendar.MONTH, d.getMese() - 1);                                     
			cal.set(Calendar.DAY_OF_MONTH, d.getGiorno());
			
			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
			
			st.setInt(1, d.getId_Disp());
			st.setInt(2, d.getId_Tutor());
			st.setDate(3, date);
			st.setString(4, d.getOrario());
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}

	public boolean CancellaDisponibilita (int id)
	{
		String sql = "DELETE FROM Disponibilita AS d "
				+ "WHERE d.`id_Disp` = ?";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}

	public boolean InserisciLezione (Lezione l)
	{
		String sql = "INSERT IGNORE INTO `SpecialmenteTu`.`Lezioni` (`id_Lez`, `id_Stud`, `id_Tutor`, `Data`,`Orario`, `Materia`) VALUES(?,?,?,?,?,?)";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, l.getAnno());
			cal.set(Calendar.MONTH, l.getMese() - 1);                                     
			cal.set(Calendar.DAY_OF_MONTH, l.getGiorno());
			
			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
			
			st.setInt(1, l.getIdLezione());
			st.setInt(2, l.getIdStudente());
			st.setInt(3, l.getIdTutor());
			st.setDate(4, date);
			st.setString(5, l.getOrario());
			st.setString(6, l.getMateria());
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}
	
	public boolean CancellaLezione (int id)
	{
		String sql = "DELETE FROM Lezioni AS l "
				+ "WHERE l.`id_Lez` = ?";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore inserimento Db", e);
		}
		
		return returnValue;
	}

}
