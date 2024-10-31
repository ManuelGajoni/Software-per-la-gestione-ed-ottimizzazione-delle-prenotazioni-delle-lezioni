package ProvaGitt.Tesi;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import ProvaGitt.Tesi.Model.Disponibilita;
import ProvaGitt.Tesi.Model.Lezione;
import ProvaGitt.Tesi.Model.Model;
import ProvaGitt.Tesi.Model.Studente;
import ProvaGitt.Tesi.Model.Tutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController 
{
	Model model = new Model ();
	List <String> Materie;
	List <Tutor> Tutor;
	List <String> Orario;
	List <String> Classe;
	List <String> Mese;
	List <Studente> Studenti;
	List <Lezione> Lezioni2 = new ArrayList <Lezione> ();
	List <Lezione> LezioniBest;
	List <String> Materia6 = new ArrayList <String> ();
	List <String> Materie3 = new ArrayList <String> ();
	List <Lezione> Lezioni3;
	List <Lezione> LezFissate;
	List <Lezione> Tutte3;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Area1;

    @FXML
    private TextArea Area2;

    @FXML
    private TextArea Area3;

    @FXML
    private TextArea Area4;

    @FXML
    private TextArea Area5;

    @FXML
    private TextArea Area6;

    @FXML
    private TextArea Area7;
    
    @FXML
    private ComboBox<String> BoxClasse4;

    @FXML
    private ComboBox<String> BoxMateria1;

    @FXML
    private ComboBox<String> BoxMateria2;

    @FXML
    private ComboBox<String> BoxMaterie5;

    @FXML
    private ComboBox<String> BoxMaterie6;

    @FXML
    private ComboBox<String> BoxMese7;

    @FXML
    private ComboBox<String> BoxOrario1;

    @FXML
    private ComboBox<String> BoxOrario2;

    @FXML
    private ComboBox<String> BoxOrario5;

    @FXML
    private ComboBox<Lezione> BoxLezioni3;
    
    @FXML
    private ComboBox<Tutor> BoxTutor1;

    @FXML
    private ComboBox<Tutor> BoxTutor5;

    @FXML
    private ComboBox<Tutor> BoxTutor7;

    @FXML
    private CheckBox CheckEducatoreNo6;

    @FXML
    private CheckBox CheckEducatoreYes6;

    @FXML
    private CheckBox CheckInternoNo6;

    @FXML
    private CheckBox CheckInternoYes6;

    @FXML
    private CheckBox CheckNo4;

    @FXML
    private CheckBox CheckYes4;

    @FXML
    private DatePicker Data1;

    @FXML
    private DatePicker Data2;

    @FXML
    private DatePicker Data3;

    @FXML
    private DatePicker Data5;

    @FXML
    private TextField txtCognomeStud1;

    @FXML
    private TextField txtCognomeStud2;

    @FXML
    private TextField txtCognomeStud4;

    @FXML
    private TextField txtCognomeStud7;

    @FXML
    private TextField txtCognomeTutor6;

    @FXML
    private TextField txtFormazione6;

    @FXML
    private TextField txtNomeStud1;

    @FXML
    private TextField txtNomeStud2;

    @FXML
    private TextField txtNomeStud4;

    @FXML
    private TextField txtNomeStud7;

    @FXML
    private TextField txtNomeTutor6;

    // HANDLENO DSA 4		
    @FXML
    void HandleNoDSA4(ActionEvent event) 
    {
    	if(this.CheckNo4.isSelected())
    	{
    		this.CheckYes4.setSelected(false);
    	}
    }
    
    // HANDLEYES DSA 4
    @FXML
    void HandleYesDSA4(ActionEvent event) 
    {
    	if(this.CheckYes4.isSelected())
    	{
    		this.CheckNo4.setSelected(false);
    	}
    }

    // HANDLENO EDUCATORE 6
    @FXML
    void HandleNoEducatore6(ActionEvent event) 
    {
    	if(this.CheckEducatoreNo6.isSelected())
    	{
    		this.CheckEducatoreYes6.setSelected(false);
    	}
    }
    
    // HANDLEYES EDUCATORE 6
    @FXML
    void HandleYesEducatore6(ActionEvent event) 
    {
    	if(this.CheckEducatoreYes6.isSelected())
    	{
    		this.CheckEducatoreNo6.setSelected(false);
    	}
    }

    // HANDLENO INTERNO 6
    @FXML
    void HandleNoInterno6(ActionEvent event) 
    {
    	if(this.CheckInternoNo6.isSelected())
    	{
    		this.CheckInternoYes6.setSelected(false);
    	}
    }

    // HANDLEYES INTERNO 6
    @FXML
    void HandleYesInterno6(ActionEvent event) 
    {
    	if(this.CheckInternoYes6.isSelected())
    	{
    		this.CheckInternoNo6.setSelected(false);
    	}
    }

    // AGGIORNA MATERIA 5
    @FXML
    void doAggiornaMateria5(ActionEvent event) 
    {
    	this.Area5.clear();
    	try
    	{
    		Tutor t = this.BoxTutor5.getValue();
        	if(t==null)
        	{
        		this.Area5.setText("SELEZIONARE IL TUTOR PRIMA DI PROCEDERE");
        		return; 
        	}
        	String mat = this.BoxMaterie5.getValue();
        	if(mat == null)
        	{
        		this.Area5.setText("SELEZIONARE LA MATERIA DA AGGIUNGERE");
        		return; 
        	}
        	
        	if(!t.getMaterie().contains(mat))
        	{
        		t.getMaterie().add(mat);
        		model.CancellaTutor(t.getIdTutor());
        		model.InserisciTutor(t);
        		this.Area5.setText("MATERIA AGGIUNTA CON SUCCESSO");
        		return;
        	}else {
        		this.Area5.setText("AGGIUNTA NON RIUSCITA PERCHE' GIA' PRESENTE PER IL TUTOR");
        		return;
        	}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area5.setText("ATTENZIONE!\n ERRORE IN AGGIORNA MATERIA");
    	}catch(RuntimeException e)
    	{
    		this.Area5.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // AGGIORNA STUDENTE 4
    @FXML
    void doAggiornaStudente4(ActionEvent event) 
    {
    	this.Area4.clear();
    	try
    	{
    		String name = this.txtNomeStud4.getText().substring(0,1).toUpperCase() + this.txtNomeStud4.getText().substring(1,this.txtNomeStud4.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud4.getText().substring(0,1).toUpperCase() + this.txtCognomeStud4.getText().substring(1,this.txtCognomeStud4.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		if(model.trovaIdStudente(model.getStudenti(), nome ) == -1)
    		{
    			this.Area4.setText("STUDENTE NON TROVATO NEL DATABASE!");
    			return;
    		}
    		Studente s = model.getStudenteByNome(nome);
    		
    		String classe = this.BoxClasse4.getValue();
    		
    		boolean dsa = false;
    		boolean selezionato = false;
    		
    		if(this.CheckYes4.isSelected())
    		{
    			dsa = true;
    			selezionato = true;
    		}
    		if(this.CheckNo4.isSelected())
    		{
    			selezionato = true;
    		}
    		
    		if( (selezionato == true) || (classe != null) )
    		{
    			if(selezionato == true)
    			{
    				if(dsa != s.isDSA())
    				{
	    				Studente nuovo = new Studente (s.getIdStudente(), s.getNome(),s.getClasse(), dsa);
	    				model.CancellaStudente(s.getIdStudente());
	    				model.InserisciStudente(nuovo);
	    				this.Area4.appendText("AGGIORNATO IL VALORE DSA PER LO STUDENTE: "+s.getNome()+"\n");
    				}else {
    					this.Area4.appendText("IL VALORE SELEZIONATO PER DSA E' GIA' AGGIORNATO \n");
    				}
    			}
    			if(classe != null)
    			{
    				if(!classe.equals(s.getClasse()))
    				{
    					Studente nuovo = new Studente (s.getIdStudente(), s.getNome(),classe, s.isDSA());
	    				model.CancellaStudente(s.getIdStudente());
	    				model.InserisciStudente(nuovo);
	    				this.Area4.appendText("AGGIORNATO IL VALORE CLASSE PER LO STUDENTE: "+s.getNome()+"\n");
    				}else {
    					this.Area4.appendText("IL VALORE SELEZIONATO PER LA CLASSE E' GIA' AGGIORNATO \n");
    				}
    			}
    		} else {
    			this.Area4.setText("SELEZIONARE UN CAMPO PER AGGIORNARE LO STUDENTE");
    			return;
    		}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area4.setText("ATTENZIONE!\n IMPOSSIBILE AGGIORNARE LO STUDENTE");
    	}catch(RuntimeException e)
    	{
    		this.Area4.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // DO AGGIUNGI DISPONIBILITA 5
    @FXML
    void doAggiungiDisponibilita5(ActionEvent event) 
    {
    	this.Area5.clear();
    	try
    	{
    		Tutor t = this.BoxTutor5.getValue();
        	if(t==null)
        	{
        		this.Area5.setText("SELEZIONARE IL TUTOR PRIMA DI PROCEDERE");
        		return; 
        	}
        	
        	LocalDate d = this.Data5.getValue();
        	if(d==null)
        	{
        		this.Area5.setText("INSERIRE UNA DATA PRIMA DI CONTINUARE");
        		return;
        	}
        	
        	String orario = this.BoxOrario5.getValue();
        	if(orario == null)
        	{
        		this.Area5.setText("INSERIRE UN ORARIO PRIMA DI CONTINUARE");
        		return;
        	}
        	
        	List <Disponibilita> disp = model.getDisponibilitaFuture(d.getDayOfYear(), d.getYear(), t.getIdTutor());
        	Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, d.getYear());
			cal.set(Calendar.MONTH, d.getMonthValue() - 1);                                     
			cal.set(Calendar.DAY_OF_MONTH, d.getDayOfMonth());
			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
        	
        	Disponibilita di = new Disponibilita (model.getContoDisponibilita()+1 ,t.getIdTutor(), date, orario, d.getDayOfYear(), d.getDayOfMonth(), d.getMonthValue(), d.getYear());
        	boolean procedere = true;
    		for(int i=0; i<disp.size(); i++)
    		{
    			if( (disp.get(i).getAnno() == di.getAnno()) && (disp.get(i).getDayY() == di.getDayY()) && (disp.get(i).getOrario().equals(di.getOrario())) && (disp.get(i).getId_Tutor() == di.getId_Tutor()) )
    			{
    				procedere = false;
    			}
    		}
    		if(d.getDayOfWeek().getValue() == 7)
    		{
    			this.Area5.setText("IMPOSSIBILE AGGIUNGERE UNA DISPONIBILITA' LA DOMENICA!");
    			return;
    		}
    		if(procedere == true)
    		{
    			if(model.InserisciDisponibilita(di))
    			{
    				this.Area5.setText("AGGIUNTA DISPONIBILITA' IL GIORNO: "+di.getData().toString()+ "\n IL TUTOR: "+t.getNome()+" ORARIO: "+di.getOrario());
    				return;
    			}
    			else
    			{
    				this.Area5.setText("ERRORE NELL'AGGIUNTA DELLA DISPONIBILITA' IL GIORNO: "+di.getData().toString()+ " PER IL TUTOR: "+t.getNome());
    				return;
    			}
    		}else
    		{
    			this.Area5.setText("DISPONIBILITA' GIA' INSERITA ");
    			return; 
    		}
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area5.setText("ATTENZIONE!\n IMPOSSIBILE AGGIUNGERE DISPONIBILITA");
    	}catch(RuntimeException e)
    	{
    		this.Area5.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // AGGIUNGI MATERIA 2
    @FXML
    void doAggiungiMateria2(ActionEvent event) 
    {
    	this.Area2.clear();
    	try
    	{
    		String name = this.txtNomeStud2.getText().substring(0,1).toUpperCase() + this.txtNomeStud2.getText().substring(1,this.txtNomeStud2.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud2.getText().substring(0,1).toUpperCase() + this.txtCognomeStud2.getText().substring(1,this.txtCognomeStud2.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		Studente stud = model.getStudenteByNome(nome);
    		if(stud == null)
    		{
    			this.Area2.setText("NESSUNO STUDENTE CON IL NOME: "+nome+" E' STATO TROVATO!");
    			return;
    		}
    		
    		LocalDate d = Data2.getValue();
    		if(d == null)
    		{
    			this.Area2.setText("SELEZIONARE UNA DATA PER LA LEZIONE!");
    			return;
    		}
    		String orario = this.BoxOrario2.getValue();
    		if(orario == null)
    		{
    			this.Area2.setText("SELEZIONARE UN ORARIO PER LA LEZIONE!");
    			return;
    		}
    		String materia = this.BoxMateria2.getValue();
    		if(materia == null)
    		{
    			this.Area2.setText("SELEZIONARE UNA MATERIA PER LA LEZIONE!");
    			return;
    		}
    		
    		Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, d.getYear());
			cal.set(Calendar.MONTH, d.getMonthValue() - 1);                                     
			cal.set(Calendar.DAY_OF_MONTH, d.getDayOfMonth());
			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
			if(d.getDayOfWeek().getValue() != 7)
			{
	    		Lezione l = new Lezione (model.getContoLezioni()+1, stud.getIdStudente(), 1, date, orario, materia, d.getDayOfMonth(), d.getMonthValue(), d.getYear(), d.getDayOfYear(), d.getDayOfWeek().getValue());
	    		boolean trovato = false;
	    		
	    		for(int i=0; i<Lezioni2.size(); i++)
	    		{
	    			if( (l.getDayY() == Lezioni2.get(i).getDayY()) && (l.getAnno() == Lezioni2.get(i).getAnno()) && (l.getOrario().equals(Lezioni2.get(i).getOrario())) && (l.getIdStudente() == Lezioni2.get(i).getIdStudente())  )
	    			{
	    				trovato = true;
	    			}
	    		}
	    		if(trovato == false)
	    		{
	    			this.Lezioni2.add(l);
	    			this.Area2.appendText("LEZIONE AGGIUNTA CON SUCCESSO! \n");
	    			this.Area2.appendText("ELENCO LEZIONI AGGIUNTE:  \n");
	    			for(int i=0; i<Lezioni2.size(); i++)
	    			{
	    				this.Area2.appendText(Lezioni2.get(i)+"\n");
	    			}
	    		} else
	    		{
	    			this.Area2.setText("IMPOSSIBILE AGGIUNGERE LA LEZIONE ");
	    			return;
	    		}
			}
			else
    		{
    			this.Area2.setText("IMPOSSIBILE AGGIUNGERE LA LEZIONE: IL GIORNO SELEZIONATO E' DOMENICA!");
    			return;
    		}
    	}catch(NumberFormatException e)
    	{
    		this.Area2.setText("ATTENZIONE!\n IMPOSSIBILE AGGIUNGERE LA LEZIONE");
    	}catch(RuntimeException e)
    	{
    		this.Area2.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // AGGIUNGI MATERIA 6
    @FXML
    void doAggiungiMateria6(ActionEvent event) 
    {
    	this.Area6.clear();
    	String materia = this.BoxMaterie6.getValue();
		if(materia == null)
		{
			this.Area6.setText("SELEZIONARE UNA MATERIA DA AGGIUNGERE");
			return;
		}
		if(!this.Materia6.contains(materia))
		{
			Materia6.add(materia);
			this.Area6.appendText("MATERIA AGGIUNTA CON SUCCESSO! \n");
		} else
		{
			this.Area6.appendText("MATERIA GIA' INSERITA \n");
		}
		this.Area6.appendText("ELENCO MATERIE GIA' INSERITE: \n");
		for(int i=0; i<Materia6.size(); i++)
		{
			this.Area6.appendText(Materia6.get(i)+"\n");
		}
    }

    // AGGIUNGI STUDENTE 4
    @FXML
    void doAggiungiStudente4(ActionEvent event) 
    {
    	this.Area4.clear();
    	try
    	{
    		String name = this.txtNomeStud4.getText().substring(0,1).toUpperCase() + this.txtNomeStud4.getText().substring(1,this.txtNomeStud4.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud4.getText().substring(0,1).toUpperCase() + this.txtCognomeStud4.getText().substring(1,this.txtCognomeStud4.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		if(model.trovaIdStudente(model.getStudenti(), nome ) != -1)
    		{
    			this.Area4.setText("STUDENTE GIA' INSERITO");
    			return;
    		}
    		
    		String classe = this.BoxClasse4.getValue();
    		if(classe == null)
    		{
    			this.Area4.setText("SELEZIONARE LA CLASSE PRIMA DI PROCEDERE");
    			return;
    		}
    		
    		boolean dsa = false;
    		if( (!this.CheckYes4.isSelected()) && (!this.CheckNo4.isSelected()))
    		{
    			this.Area4.setText("COMPLETARE IL CAMPO: STUDENTE DSA");
    			return;
    		}
    		
    		if(this.CheckYes4.isSelected())
    		{
    			dsa = true;
    		}
    		
    		Studente s = new Studente (model.getContoStudenti()+1, nome, classe,dsa);
    		
    		
    		if(model.InserisciStudente(s))
    		{
    			this.Area4.setText("STUDENTE: "+nome+" AGGIUNTO CORRETTAMENTE! ");
    			this.txtCognomeStud4.clear();
    			this.txtNomeStud4.clear();
    			return;
    		}else {
    			this.Area4.setText("ERRORE NELL'AGGIUNTA DEL TUTOR");
    			return;
    		}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area4.setText("ATTENZIONE!\n IMPOSSIBILE AGGIUNGERE STUDENTE");
    	}catch(RuntimeException e)
    	{
    		this.Area4.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // AGGIUNGI TUTOR 6
    @FXML
    void doAggiungiTutor6(ActionEvent event) 
    {
    	this.Area6.clear();
    	try
    	{
    		String name = this.txtNomeTutor6.getText().substring(0,1).toUpperCase() + this.txtNomeTutor6.getText().substring(1,this.txtNomeTutor6.getText().length()).toLowerCase();
    		String surname = this.txtCognomeTutor6.getText().substring(0,1).toUpperCase() + this.txtCognomeTutor6.getText().substring(1,this.txtCognomeTutor6.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		
    		if(model.trovaIdTutor(model.getTutor(), nome) != -1)
    		{
    			this.Area6.setText("TUTOR GIA' INSERITO");
    			return;
    		}
    		
    		if(this.Materia6.isEmpty())
    		{
    			this.Area6.setText("INSERIRE ALMENO UNA MATERIA PRIMA DI INSERIRE IL TUOTR ");
    			return;
    		}
    		
    		String form = this.txtFormazione6.getText();
    		if(form == null)
    		{
    			this.Area6.setText("COMPLETARE LA FORMAZIONE DEL TUTOR PRIMA DI INSERIRE IL TUTOR");
    			return;
    		}
    		
    		if((!this.CheckEducatoreYes6.isSelected()) && (!this.CheckEducatoreNo6.isSelected()))
    		{
    			this.Area6.setText("COMPLETARE IL CAMPO EDUCATORE");
    			return;
    		}
    		
    		if( (!this.CheckInternoYes6.isSelected()) && (!this.CheckInternoNo6.isSelected()))
    		{
    			this.Area6.setText("COMPLETARE IL CAMPO INTERNO");
    			return;
    		}
    		
    		boolean educatore = false;
    		boolean interno = false;
    		
    		if(this.CheckEducatoreYes6.isSelected())
    		{
    			educatore = true;
    		}
    		if(this.CheckInternoYes6.isSelected())
    		{
    			interno = true;
    		}
    		
    		Tutor t = new Tutor (model.getContoTutor()+1, nome, Materia6, form, educatore, interno);
    		if(model.InserisciTutor(t))
    		{
    			this.Area6.setText("TUTOR AGGIUNTO CORRETTAMENTE! ");
        		this.BoxTutor1.getItems().removeAll(Tutor);
            	this.BoxTutor5.getItems().removeAll(Tutor);
            	this.BoxTutor7.getItems().removeAll(Tutor);
        		this.Tutor = model.getTutor();
            	this.BoxTutor1.getItems().addAll(Tutor);
            	this.BoxTutor5.getItems().addAll(Tutor);
            	this.BoxTutor7.getItems().addAll(Tutor);
            	this.Materia6.clear();
            	this.txtCognomeTutor6.clear();
            	this.txtNomeTutor6.clear();
            	this.txtFormazione6.clear();
    			return;
    		}else {
    			this.Area6.setText("ERRORE NELL'AGGIUNTA DEL TUTOR");
    			return;
    		}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area6.setText("ATTENZIONE!\n ERRORE NELL'AGGIUNTA DEL TUTOR");
    	}catch(RuntimeException e)
    	{
    		this.Area6.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // CALCOLA LEZIONI GIORNALIERE 3
    @FXML
    void doCalcolaLezioniGiornaliere3(ActionEvent event) 
    {
    	this.Area3.clear();
    	try
    	{
    		LocalDate d = this.Data3.getValue();
        	if(d==null)
        	{
        		this.Area3.setText("INSERIRE UNA DATA PRIMA DI CONTINUARE");
        		return;
        	}
        	this.LezioniBest = model.getSoluzioneMigliore(this.Lezioni3, this.LezFissate);
        	if(Lezioni3.isEmpty())
        	{
        		this.Area3.setText("NESSUNA LEZIONE PRENOTATA PER LA DATA SELEZIONATA");
        		return;
        	}
        	if(LezioniBest.isEmpty())
        	{
        		this.Area3.setText("IMPOSSIBILE TROVARE DEGLI ABBINAMENTI PER LE LEZIONI GIORNALIERE");
        		return;
        	}
        	if(model.isMeglio(LezioniBest, Lezioni3))
        	{
        		this.Area3.appendText("TROVATA UNA SOLUZIONE MIGLIORE! \n");
	        	for(int i=0; i<LezioniBest.size(); i++)
	        	{
	        		this.Area3.appendText(LezioniBest.get(i).toString()+"PUNTEGGIO: "+model.calcolaPunteggio(LezioniBest.get(i))+"\n \n");
	        	}
	        	this.Area3.appendText("PUNTEGGIO LEZIONI PRECEDENTI: "+model.calcolaPunteggioTot(Lezioni3)+"\n");
	        	this.Area3.appendText("PUNTEGGIO LEZIONI CALCOLATE: "+model.calcolaPunteggioTot(LezioniBest));
        	} else
        	{
        		this.Area3.appendText("LE SOLUZIONI CERCATE SONO: \n");
        		this.Area3.appendText("LEZIONI PRENOTATE: \n");
        		for(int i=0; i<Lezioni3.size(); i++)
	        	{
	        		this.Area3.appendText(Lezioni3.get(i).toString()+"\n  PUNTEGGIO: "+model.calcolaPunteggio(Lezioni3.get(i))+"\n");
	        	}
        		this.Area3.appendText("LEZIONI CALCOLATE: \n");
        		for(int i=0; i<LezioniBest.size(); i++)
	        	{
	        		this.Area3.appendText(LezioniBest.get(i).toString()+"\n  PUNTEGGIO: "+model.calcolaPunteggio(LezioniBest.get(i))+"\n");
	        	}
	        	this.Area3.appendText("PUNTEGGIO LEZIONI PRECEDENTI: "+model.calcolaPunteggioTot(Lezioni3)+"\n");
	        	this.Area3.appendText("PUNTEGGIO LEZIONI CALCOLATE: "+model.calcolaPunteggioTot(LezioniBest)+"\n");
        		this.Area3.appendText("PREMERE IL PULSANTE 'PRENOTA' PER PRENOTARE I NUOVI ABBINAMENTI \n");

        	}
        	
        	
    	}catch(NumberFormatException e)
    	{
    		this.Area3.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area3.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // CALCOLA LEZIONI MULTIPLE 2
    @FXML
    void doCalcolaLezioniMultiple2(ActionEvent event) 
    {
    	this.Area2.clear();
    	if(this.Lezioni2.isEmpty())
    	{
    		this.Area2.setText("INSERIRE UNA LEZIONE PRIMA DI CALCOLARE LE LEZIONI");
    		return;
    	}
    	
    	List <Lezione> migliori = new ArrayList <Lezione> ();
    	for(int i=0; i<Lezioni2.size(); i++)
    	{
    		List <Integer> id = model.getTutorDisponibili(Lezioni2.get(i).getDayY(), Lezioni2.get(i).getAnno(), Lezioni2.get(i).getOrario());
    		if(id.isEmpty())
    		{
    			this.Area2.setText("NESSUNA DISPONIBILITA' DI TUTOR PER IL GIORNO: "+Lezioni2.get(i).getData()+" E ORARIO: "+Lezioni2.get(i).getOrario());
    			return;
    		}
    		int max = 0;
    		Lezione migliore = null;
    		for(int j=0; j<id.size(); j++)
    		{
    			Lezione l = new Lezione (-1, Lezioni2.get(i).getIdStudente(), id.get(j), Lezioni2.get(i).getData(), Lezioni2.get(i).getOrario(), Lezioni2.get(i).getMateria(), Lezioni2.get(i).getGiorno(), Lezioni2.get(i).getMese(), Lezioni2.get(i).getAnno(), Lezioni2.get(i).getDayY(), Lezioni2.get(i).getNumGiorno());
    			if(model.calcolaPunteggio(l)>max)
    			{
    				if(model.isCorrettaLezione(l, migliori))
    				{
	    				max = model.calcolaPunteggio(l);
	    				migliore = l;
    				}
    			}
    		}
    		if(max != 0)
    		{
    			
    			migliori.add(migliore);
    		}
    		else
    		{
    			this.Area2.setText("NESSUNA LEZIONE PRENOTABILE ");
    			return;
    		}
    	}
    	for(int i=0; i<migliori.size(); i++)
    	{
    		this.Area2.appendText(migliori.get(i)+"");
    	}
    	Lezioni2 = migliori;
    	this.Area2.appendText("LEZIONI CON IL PUNTEGGIO DI: "+model.calcolaPunteggioTot(Lezioni2));

    }

    // CALENDARIO 1
    @FXML
    void doCalendario1(ActionEvent event) 
    {
    	this.Area1.clear();
    	try
    	{
    		Tutor t = this.BoxTutor1.getValue();
    		if(t == null)
    		{
    			this.Area1.setText("SELEZIONARE IL TUTOR DESIDERATO PRIMA DI INIZIARE");
    			return;
    		}
    		Calendar now = Calendar.getInstance();
    		int anno = now.get(Calendar.YEAR);
    		int DayY = now.get(Calendar.DAY_OF_YEAR);
    		
    		List <Lezione> lezioni = model.getResocontoLezioniPrenotateTutor(DayY, t.getIdTutor(), anno);
    		StringBuilder sb = new StringBuilder();
    		
    		sb.append(String.format("%100s","RESOCONTO LEZIONI PRENOTATE TUTOR"));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("%-30s %-60s %-30s %-10s", "Data", "Studente", "Materia", "Orario"));
    		sb.append("\n");
    		sb.append("\n");
    		if(lezioni.isEmpty())
    		{
    			sb.append("NESSUNA LEZIONE PRENOTATA");
    		}
    		Studenti = model.getStudenti();
    		
    		for(int i=0; i<lezioni.size();i++)
    		{
    			Studente s = model.trovaStudente(Studenti, lezioni.get(i).getIdStudente());
    			if(s!= null && t!= null)
    			{
	    			sb.append(String.format("%-25s", lezioni.get(i).getData()));
	    			sb.append(String.format("%-40s", s.getNome()));
	    			sb.append(String.format("%-50s", lezioni.get(i).getMateria()));
	    			sb.append(String.format("%-10s", lezioni.get(i).getOrario()));
	    			sb.append("\n");
    			}
    		}
    		sb.append("\n");
    		sb.append("\n");
    		
    		List <Disponibilita> disp = model.getDisponibilitaFuture(DayY, anno, t.getIdTutor());
    		
    		sb.append(String.format("%100s","RESOCONTO DISPONIBILITA' TUTOR"));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("%-30s %-10s", "Data", "Orario"));
    		sb.append("\n");
    		sb.append("\n");
    		for(int i=0; i<disp.size(); i++)
    		{
    			sb.append(String.format("%-30s",disp.get(i).getData()));
    			sb.append(String.format("%-30s",disp.get(i).getOrario()));
    			sb.append("\n");
    		}
    		
    		if(disp.isEmpty())
    		{
    			sb.append("NESSUNA DISPONIBILITA' DEL TUTOR NEL MESE SELEZIONATO ");
    			sb.append("\n");
        		sb.append("\n");
    		}
    		
    		this.Area1.appendText(sb.toString());
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area1.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area1.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
    
    // CANCELLA LEZIONE 1
    @FXML
    void doCancellaLezione1(ActionEvent event) 
    {
    	this.Area1.clear();
    	try
    	{
    		
    		LocalDate d = Data1.getValue();
    		if(d == null)
    		{
    			this.Area1.setText("SELEZIONARE UNA DATA PER LA LEZIONE!");
    			return;
    		}
    		String orario = this.BoxOrario1.getValue();
    		if(orario == null)
    		{
    			this.Area1.setText("SELEZIONARE UN ORARIO PER LA LEZIONE!");
    			return;
    		}
    		
    		Tutor tutor = this.BoxTutor1.getValue();
    		if(tutor == null)
    		{
    			this.Area1.setText("SELEZIONARE UN TUTOR PRIMA DI COMPLETARE LA PRENOTAZIONE");
    			return;
    		}
    		
    		int idLez = model.TrovaLezione(tutor.getIdTutor(), d.getDayOfYear(), d.getYear(), orario);
    		if(idLez != -1)
    		{
    			if(model.CancellaLezione(idLez))
    			{
    				this.Area1.setText("LEZIONE CANCELLATA CON SUCCESSO! ");
    				return;
    			}
    		} else
    		{
    			this.Area1.setText("NESSUNA LEZIONE TROVATA PER LA DATA E L'ORA SELEZIONATA");
    			return;
    		}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area1.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area1.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // CANCELLA MATERIA 2
    @FXML
    void doCancellaMateria2(ActionEvent event) 
    {
    	this.Area2.clear();
    	try
    	{
    		String name = this.txtNomeStud2.getText().substring(0,1).toUpperCase() + this.txtNomeStud2.getText().substring(1,this.txtNomeStud2.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud2.getText().substring(0,1).toUpperCase() + this.txtCognomeStud2.getText().substring(1,this.txtCognomeStud2.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		Studente stud = model.getStudenteByNome(nome);
    		if(stud == null)
    		{
    			this.Area2.setText("NESSUNO STUDENTE CON IL NOME: "+nome+" E' STATO TROVATO!");
    			return;
    		}
    		
    		LocalDate d = Data2.getValue();
    		if(d == null)
    		{
    			this.Area2.setText("SELEZIONARE UNA DATA PER LA LEZIONE!");
    			return;
    		}
    		String orario = this.BoxOrario2.getValue();
    		if(orario == null)
    		{
    			this.Area2.setText("SELEZIONARE UN ORARIO PER LA LEZIONE!");
    			return;
    		}
    		String materia = this.BoxMateria2.getValue();
    		if(materia == null)
    		{
    			this.Area2.setText("SELEZIONARE UNA MATERIA PER LA LEZIONE!");
    			return;
    		}
    		
    		Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, d.getYear());
			cal.set(Calendar.MONTH, d.getMonthValue() - 1);                                     
			cal.set(Calendar.DAY_OF_MONTH, d.getDayOfMonth());
			
			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
    		Lezione l = new Lezione (-1, stud.getIdStudente(), -1, date, orario, materia, d.getDayOfMonth(), d.getMonthValue(), d.getYear(), d.getDayOfYear(), d.getDayOfWeek().getValue());
    		for(int i=0;i<Lezioni2.size(); i++)
    		{
    			if(model.trovaStudente(model.getStudenti(), Lezioni2.get(i).getIdStudente()) == null)
        		{
        			this.Area2.appendText("STUDENTE NON PIU' PRESENTE NEL DATABASE:"+Lezioni2.get(i).getIdStudente()+ "  IMPOSSIBILE PRENOTARE LA LEZIONE! ");
        			this.Area2.appendText("TUTTE LE LEZIONI CANCELLATE CON SUCCESSO!");
        			this.Lezioni2.clear();
        			return; 
        		}
    		}
    		boolean trovato = false;
    		if(Lezioni2.isEmpty())
    		{
    			this.Area2.setText("NESSUNA LEZIONE AGGIUNTA!");
    			return;
    		}
    		for(int i=0; i<Lezioni2.size(); i++)
    		{
	    		if( (l.getDayY() == Lezioni2.get(i).getDayY()) && (l.getAnno() == Lezioni2.get(i).getAnno()) && (l.getOrario().equals(Lezioni2.get(i).getOrario())) && (l.getIdStudente() == Lezioni2.get(i).getIdStudente())  )
	    		{
	    			this.Lezioni2.remove(Lezioni2.get(i));
	    			this.Area2.setText("LEZIONE ELIMINATA CON SUCCESSO");
	    			trovato = true;
	    		} 
    		}
    		if(trovato == false)
    		{
    			this.Area2.clear();
    			this.Area2.appendText("LEZIONE NON TROVATA! \n");
    			this.Area2.appendText("LEZIONI RIMANENTI: \n");
    			for(int i=0; i<Lezioni2.size(); i++)
    			{
    				this.Area2.appendText(Lezioni2.get(i)+"\n");
    			}
    			
    			return;
    		}
    		else
    		{
    			this.Area2.appendText("LEZIONI RIMANENTI: \n");
    			for(int i=0; i<Lezioni2.size(); i++)
    			{
    				this.Area2.appendText(Lezioni2.get(i)+"\n");
    			}
    		}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area2.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area2.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
    
    // LEZIONI PRENOTATE TUTOR 7
    @FXML
    void doLezioniPrenotateTutor7(ActionEvent event) 
    {
    	this.Area7.clear();
    	try
    	{
    		Tutor t = this.BoxTutor7.getValue();
    		if(t == null)
    		{
    			this.Area7.setText("SELEZIONARE IL TUTOR DESIDERATO PRIMA DI INIZIARE");
    			return;
    		}
    		Calendar now = Calendar.getInstance();
    		int anno = now.get(Calendar.YEAR);
    		int DayY = now.get(Calendar.DAY_OF_YEAR);
    		
    		List <Lezione> lezioni = model.getResocontoLezioniPrenotateTutor(DayY, t.getIdTutor(), anno);
    		
    		if(lezioni.isEmpty())
    		{
    			this.Area7.setText("NESSUNA LEZIONE PRENOTATA! ");
    			return;
    		}
    		StringBuilder sb = new StringBuilder();
    		sb.append(String.format("%100s","RESOCONTO LEZIONI PRENOTATE TUTOR"));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("%-30s %-60s %-30s %-10s", "Data", "Studente", "Materia", "Orario"));
    		sb.append("\n");
    		Studenti = model.getStudenti();
    		
    		for(int i=0; i<lezioni.size();i++)
    		{
    			Studente s = model.trovaStudente(Studenti, lezioni.get(i).getIdStudente());
    			if(s!= null && t!= null)
    			{
	    			sb.append(String.format("%-25s", lezioni.get(i).getData()));
	    			sb.append(String.format("%-40s", s.getNome()));
	    			sb.append(String.format("%-50s", lezioni.get(i).getMateria()));
	    			sb.append(String.format("%-10s", lezioni.get(i).getOrario()));
	    			sb.append("\n");
    			}
    		}
    		this.Area7.appendText(sb.toString());
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area7.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area7.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // PRENOTA LEZIONE 1
    @FXML
    void doPrenotaLezione1(ActionEvent event) 
    {
    	this.Area1.clear();
    	try
    	{
    		String name = this.txtNomeStud1.getText().substring(0,1).toUpperCase() + this.txtNomeStud1.getText().substring(1,this.txtNomeStud1.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud1.getText().substring(0,1).toUpperCase() + this.txtCognomeStud1.getText().substring(1,this.txtCognomeStud1.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		Studente stud = model.getStudenteByNome(nome);
    		if(stud == null)
    		{
    			this.Area1.setText("NESSUNO STUDENTE CON IL NOME: "+nome+" E' STATO TROVATO!");
    			return;
    		}
    		
    		LocalDate d = Data1.getValue();
    		if(d == null)
    		{
    			this.Area1.setText("SELEZIONARE UNA DATA PER LA LEZIONE!");
    			return;
    		}
    		String orario = this.BoxOrario1.getValue();
    		if(orario == null)
    		{
    			this.Area1.setText("SELEZIONARE UN ORARIO PER LA LEZIONE!");
    			return;
    		}
    		String materia = this.BoxMateria1.getValue();
    		if(materia == null)
    		{
    			this.Area1.setText("SELEZIONARE UNA MATERIA PER LA LEZIONE!");
    			return;
    		}
    		List <Integer> id = model.getTutorDisponibili(d.getDayOfYear(), d.getYear(), orario);
    		if(id.isEmpty())
    		{
    			this.Area1.setText("NESSUNA DISPONIBILITA' DI TUTOR PER IL GIORNO E ORARIO SELEZIONATO");
    			return;
    		}
    		
    		Tutor tutor = this.BoxTutor1.getValue();
    		if(tutor == null)
    		{
    			this.Area1.setText("SELEZIONARE UN TUTOR PRIMA DI COMPLETARE LA PRENOTAZIONE");
    			return;
    		}
    		
    		
    		if(id.contains(tutor.getIdTutor()))
    		{
    			int tot = model.getContoLezioni()+1;
    			Calendar cal = Calendar.getInstance();
    			cal.set(Calendar.YEAR, d.getYear());
    			cal.set(Calendar.MONTH, d.getMonthValue() - 1);                                     
    			cal.set(Calendar.DAY_OF_MONTH, d.getDayOfMonth());
    			
    			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
    			Lezione lez = new Lezione (tot, stud.getIdStudente(), tutor.getIdTutor(), date, orario, materia, d.getDayOfMonth(), d.getMonthValue(), d.getYear(), d.getDayOfYear(),d.getDayOfWeek().getValue());
    			List <Lezione> lezioni = model.getResocontoLezioniPrenotateTutor(d.getDayOfYear(), tutor.getIdTutor(), d.getYear());
    			
    			
    			for(int i=0; i<lezioni.size(); i++)
    			{
    				if((lezioni.get(i).getOrario().equals(lez.getOrario())) && (lezioni.get(i).getDayY() == d.getDayOfYear()) && (lezioni.get(i).getAnno() == d.getYear()))
    				{
    					this.Area1.setText("IMPOSSIBILE PRENOTARE UNA LEZIONE! IL TUTOR NON E' DISPONIBILE");
    					return;
    				}
    			}
    			
    			if(lez.getNumGiorno() == 6)
    			{
    				this.Area1.setText("IMPOSSIBILE PRENOTARE UNA LEZIONE DI DOMENICA");
    				return; 
    			}
    			
    			if(model.InserisciLezione(lez))
    			{
    				this.Area1.setText("LEZIONE PRENOTATA CON SUCCESSO! ");
    				return;
    			}else
    			{
    				this.Area1.setText("ERRORE NELLA PRENOTAZIONE DELLA LEZIONE");
    				return;
    			}
    		}else
    		{
    			this.Area1.setText("IL TUTOR SELEZIONATO NON E' DISPONIBILE PER LA GIORNATA SELEZIONATA");
    			return;
    		}
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area1.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area1.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // PRENOTA LEZIONI 2
    @FXML
    void doPrenotaLezioni2(ActionEvent event) 
    {
    	this.Area2.clear();
    	if(Lezioni2.isEmpty())
    	{
    		this.Area2.setText("AGGIUNGERE LEZIONI PRIMA DI PROCEDERE!");
			return; 
    	}
    	for(int i=0; i<Lezioni2.size(); i++)
    	{
    		if(model.trovaStudente(model.getStudenti(), Lezioni2.get(i).getIdStudente()) == null)
    		{
    			this.Area2.appendText("STUDENTE NON PIU' PRESENTE NEL DATABASE:"+Lezioni2.get(i).getIdStudente()+ "  IMPOSSIBILE PRENOTARE LA LEZIONE! ");
    			this.Area2.appendText("LEZIONI CANCELLATE CON SUCCESSO!");
    			this.Lezioni2.clear();
    			return; 
    		}
    		if(model.calcolaPunteggio(Lezioni2.get(i)) <1)
    		{
    			this.Area2.setText("IMPOSSIBILE PRENOTARE LE LEZIONI PERCHE' PER LA LEZIONE: "+Lezioni2.get(i).toString() +" NON HA TROVATO UN ABBINAMENTO!");
    			return; 
    		}
    	}
    	
    	for(int i=0; i<Lezioni2.size(); i++)
    	{
			Lezione l = new Lezione (model.getContoLezioni()+1, Lezioni2.get(i).getIdStudente(), Lezioni2.get(i).getIdTutor(), Lezioni2.get(i).getData(), Lezioni2.get(i).getOrario(), Lezioni2.get(i).getMateria(), Lezioni2.get(i).getGiorno(), Lezioni2.get(i).getMese(), Lezioni2.get(i).getAnno(), Lezioni2.get(i).getDayY(), Lezioni2.get(i).getNumGiorno());
			if(!model.InserisciLezione(l))
			{
				this.Area2.setText("ERRORE NELL'AGGIUNTA DELLE LEZIONI SELEZIONATE");
				return;
			}
    	}
    	this.Area2.appendText("LEZIONI PRENOTATE CON SUCCESSO! \n CON IL PUNTEGGIO DI: "+model.calcolaPunteggioTot(Lezioni2));
    	this.Lezioni2.clear();
    }

    // PRENOTA LEZIONE 3
    @FXML
    void doPrenotaLezioni3(ActionEvent event) 
    {
    	this.Area3.clear();
    	try
    	{
    		if(!this.Lezioni3.isEmpty())
    		{
    			
				for(int i=0; i<Lezioni3.size(); i++)
				{
					
					if(!model.CancellaLezione(Lezioni3.get(i).getIdLezione()))
    				{
    					this.Area3.appendText("ERRORE NELLA CANCELLAZIONE DELLA LEZIONE: "+Lezioni2.get(i)+"\n");
    					return;
    				}
					
				}
    				
    			for(int i=0; i<LezioniBest.size(); i++)
    			{
    				if(!model.InserisciLezione(LezioniBest.get(i)))
    				{
    					this.Area3.appendText("ERRORE NELL'AGGIUNTA DELLA LEZIONE: "+LezioniBest.get(i)+"\n");
    					return;
    				}
    			}
    		} 
    		else
    		{
    			this.Area3.setText("PRIMA DI PROCEDERE CALCOLARE LE MIGLIORI LEZIONI PER UNA DATA");
    			return;
    		}
    		this.Area3.setText("LEZIONI PRENOTATE CON SUCCESSO \n");
    		this.Area3.appendText("LEZIONI CALCOLATE NUOVE: \n");
    		for(int i=0; i<LezioniBest.size(); i++)
        	{
        		this.Area3.appendText(LezioniBest.get(i).toString()+"\n");
        	}
    		this.Area3.appendText("LEZIONI FISSATE: \n");
    		for(int i=0; i<LezFissate.size(); i++)
        	{
        		this.Area3.appendText(LezFissate.get(i).toString()+"\n");
        	}
    		this.Lezioni3.clear();
    		this.LezFissate.clear();
    		this.LezioniBest.clear();
    		this.Tutte3.clear();
    	}catch(NumberFormatException e)
    	{
    		this.Area3.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area3.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // RESET 1
    @FXML
    void doReset1(ActionEvent event) 
    {
    	this.txtNomeStud1.clear();
    	this.txtCognomeStud1.clear();
    	this.Data1.setValue(null);
    	this.BoxOrario1.setValue(null);
    	this.BoxTutor1.setValue(null);
    	this.BoxMateria1.setValue(null);
    	this.Area1.clear();
    }

    // RESET 2
    @FXML
    void doReset2(ActionEvent event) 
    {
    	this.txtNomeStud2.clear();
    	this.txtCognomeStud2.clear();
    	this.Data2.setValue(null);
    	this.BoxOrario2.setValue(null);
    	this.BoxMateria2.setValue(null);
    	this.Area2.clear();
    	this.Lezioni2.clear();
    }
  
    // RESET 3
    @FXML
    void doReset3(ActionEvent event) 
    {
    	this.Area3.clear();
    	this.Data3.setValue(null);
    	this.BoxLezioni3.getItems().clear();
    	this.Lezioni3.clear();
    	this.Lezioni2.clear();
    	this.LezFissate.clear();
    	this.Tutte3.clear();
    }

    // RESET 4
    @FXML
    void doReset4(ActionEvent event) 
    {
    	this.txtNomeStud4.clear();
    	this.txtCognomeStud4.clear();
    	this.Area4.clear();
    	this.BoxClasse4.setValue(null);
    	this.CheckYes4.setSelected(false);
    	this.CheckNo4.setSelected(false);
    }

    // RESET 5
    @FXML
    void doReset5(ActionEvent event) 
    {
    	this.BoxTutor5.setValue(null);
    	this.BoxMaterie5.setValue(null);
    	this.Data5.setValue(null);
    	this.BoxOrario5.setValue(null);
    	this.Area5.clear();
    }

    // RESET 6
    @FXML
    void doReset6(ActionEvent event) 
    {
    	this.txtNomeTutor6.clear();
    	this.txtCognomeTutor6.clear();
    	this.BoxMaterie6.setValue(null);
    	this.txtFormazione6.clear();
    	this.Area6.clear();
    	this.CheckEducatoreYes6.setSelected(false);
    	this.CheckEducatoreNo6.setSelected(false);
    	this.CheckInternoYes6.setSelected(false);
    	this.CheckInternoNo6.setSelected(false);
    	this.Materia6.clear();
    }

    // RESET 7
    @FXML
    void doReset7 (ActionEvent event)
    {
    	this.txtNomeStud7.clear();
    	this.txtCognomeStud7.clear();
    	this.Area7.clear();
    	this.BoxTutor7.setValue(null);
    	this.BoxMese7.setValue(null);
    }
        
    // RESOCONTO STUDENTE 7
    @FXML
    void doResocontoStudente7(ActionEvent event) 
    {
    	this.Area7.clear();
    	try
    	{
    		if(this.BoxMese7.getValue() == null)
    		{
    			this.Area7.setText("SELEZIONARE IL MESE DESIDERATO PRIMA DI INIZIARE!");
    			return;
    		}
    		String name = this.txtNomeStud7.getText().substring(0,1).toUpperCase() + this.txtNomeStud7.getText().substring(1,this.txtNomeStud7.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud7.getText().substring(0,1).toUpperCase() + this.txtCognomeStud7.getText().substring(1,this.txtCognomeStud7.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		Studente stud = model.getStudenteByNome(nome);
    		if(stud == null)
    		{
    			this.Area7.setText("NESSUNO STUDENTE CON IL NOME: "+nome+" E' STATO TROVATO!");
    			return;
    		}
    		String m = this.BoxMese7.getValue();
    		int mese = model.OttieniMesi(m);
    		Calendar now = Calendar.getInstance();
    		int anno = now.get(Calendar.YEAR);
    		List <Lezione> lezioni = model.getResocontoLezioniStudente(mese, stud.getIdStudente(),anno);
    		if(lezioni.isEmpty())
    		{
    			this.Area7.setText("NESSUNA LEZIONE PER LO STUDENTE: "+nome+" E' STATA TROVATA NEL MESE DI "+m);
    			return;
    		}
    		StringBuilder sb = new StringBuilder();
    		sb.append(String.format("%100s","RESOCONTO LEZIONI STUDENTE"));
    		sb.append("\n");
    		sb.append(String.format("- Mese: %-10s -", m));
    		sb.append("\n");
    		sb.append(String.format("Studente: %-20s", nome));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("%-30s %-40s %-30s %-10s", "Data", "Tutor", "Materia", "Orario"));
    		sb.append("\n");
    		Tutor = model.getTutor();
    		
    		for(int i=0; i<lezioni.size();i++)
    		{
    			Tutor t = model.trovaTutor(Tutor, lezioni.get(i).getIdTutor());
    			sb.append(String.format("%-25s", lezioni.get(i).getData()));
    			sb.append(String.format("%-40s", t.getNome()));
    			sb.append(String.format("%-50s", lezioni.get(i).getMateria()));
    			sb.append(String.format("%-10s", lezioni.get(i).getOrario()));
    			sb.append("\n");
    		}
    		this.Area7.appendText(sb.toString());
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area7.setText("ATTENZIONE!\n PER STAMPARE IL RESOCONTO STUDENTE E' NECESSARIO INSERIRE: NOME, COGNOME E MESE");
    	}catch(RuntimeException e)
    	{
    		this.Area7.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
    
    // RESOCONTO TUTOR 7
    @FXML
    void doResocontoTutor7(ActionEvent event) 
    {
    	this.Area7.clear();
    	try
    	{
    		if(this.BoxMese7.getValue() == null)
    		{
    			this.Area7.setText("SELEZIONARE IL MESE DESIDERATO PRIMA DI INIZIARE!");
    			return;
    		}
    		Tutor t = this.BoxTutor7.getValue();
    		if(t == null)
    		{
    			this.Area7.setText("SELEZIONARE IL TUTOR DESIDERATO PRIMA DI INIZIARE");
    			return;
    		}
    		String m = this.BoxMese7.getValue();
    		int mese = model.OttieniMesi(m);
    		Calendar now = Calendar.getInstance();
    		int anno = now.get(Calendar.YEAR);
    		
    		List <Lezione> lezioni = model.getResocontoLezioniTutor(mese, t.getIdTutor(),anno);
    		
    		if(lezioni.isEmpty())
    		{
    			this.Area7.setText("NESSUNA LEZIONE PRENOTATA! ");
    			return;
    		}
    		StringBuilder sb = new StringBuilder();
    		sb.append(String.format("%100s","RESOCONTO LEZIONI TUTOR"));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("%-30s %-60s %-30s %-10s", "Data", "Studente", "Materia", "Orario"));
    		sb.append("\n");
    		Studenti = model.getStudenti();
    		
    		for(int i=0; i<lezioni.size();i++)
    		{
    			Studente s = model.trovaStudente(Studenti, lezioni.get(i).getIdStudente());
    			if(s!= null && t!= null)
    			{
	    			sb.append(String.format("%-25s", lezioni.get(i).getData()));
	    			sb.append(String.format("%-40s", s.getNome()));
	    			sb.append(String.format("%-50s", lezioni.get(i).getMateria()));
	    			sb.append(String.format("%-10s", lezioni.get(i).getOrario()));
	    			sb.append("\n");
    			}
    		}
    		this.Area7.appendText(sb.toString());
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area7.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area7.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
     
    // RIMUOVI DISPONIBILITA 5
    @FXML
    void doRimuoviDisponibilita5(ActionEvent event) 
    {
    	this.Area5.clear();
    	try
    	{
    		Tutor t = this.BoxTutor5.getValue();
        	if(t==null)
        	{
        		this.Area5.setText("SELEZIONARE IL TUTOR PRIMA DI PROCEDERE");
        		return; 
        	}
        	
        	LocalDate d = this.Data5.getValue();
        	if(d==null)
        	{
        		this.Area5.setText("INSERIRE UNA DATA PRIMA DI CONTINUARE");
        		return;
        	}
        	
        	String orario = this.BoxOrario5.getValue();
        	if(orario == null)
        	{
        		this.Area5.setText("INSERIRE UN ORARIO PRIMA DI CONTINUARE");
        		return;
        	}
        	
        	List <Disponibilita> disp = model.getDisponibilitaFuture(d.getDayOfYear(), d.getYear(), t.getIdTutor());
        	Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, d.getYear());
			cal.set(Calendar.MONTH, d.getMonthValue() - 1);                                     
			cal.set(Calendar.DAY_OF_MONTH, d.getDayOfMonth());
			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
        	
        	Disponibilita di = new Disponibilita (-1,t.getIdTutor(), date, orario, d.getDayOfYear(), d.getDayOfMonth(), d.getMonthValue(), d.getYear());
        	boolean procedere = false;
        	int id = -1;
    		for(int i=0; i<disp.size(); i++)
    		{
    			if( (disp.get(i).getAnno() == di.getAnno()) && (disp.get(i).getDayY() == di.getDayY()) && (disp.get(i).getOrario().equals(di.getOrario())) && (disp.get(i).getId_Tutor() == di.getId_Tutor()) )
    			{
    				procedere = true;
    				id = disp.get(i).getId_Disp();
    			}
    		}
    		if(procedere == true)
    		{
    			model.CancellaDisponibilita(id);
    			this.Area5.setText("RIMOSSA DISPONIBILITA' IL GIORNO: "+di.getData().toString()+ " PER IL TUTOR: "+t.getNome());
    			return;
    		}else
    		{
    			this.Area5.setText("DISPONIBILITA' NON TROVATA");
    			return; 
    		}
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area5.setText("ATTENZIONE!\n ERRORE NELLA RIMOZIONE DELLE DISPONIBILITA' ");
    	}catch(RuntimeException e)
    	{
    		this.Area5.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // RIMUOVI MATERIA 5
    @FXML
    void doRimuoviMateria5(ActionEvent event) 
    {
    	this.Area5.clear();
    	try
    	{
    		Tutor t = this.BoxTutor5.getValue();
        	if(t==null)
        	{
        		this.Area5.setText("SELEZIONARE IL TUTOR PRIMA DI PROCEDERE");
        		return; 
        	}
        	String mat = this.BoxMaterie5.getValue();
        	if(mat == null)
        	{
        		this.Area5.setText("SELEZIONARE LA MATERIA DA AGGIUNGERE");
        		return; 
        	}
        	
        	if(t.getMaterie().contains(mat))
        	{
        		t.getMaterie().remove(mat);
        		model.CancellaTutor(t.getIdTutor());
        		model.InserisciTutor(t);
        		this.Area5.setText("MATERIA RIMOSSA CON SUCCESSO");
        		return;
        	}else {
        		this.Area5.setText("RIMOZIONE NON RIUSCITA! LA MATERIA NON E' PRESENTE");
        		return;
        	}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area5.setText("ATTENZIONE!\n ERRORE NELLA RIMOZIONE DELLA MATERIA");
    	}catch(RuntimeException e)
    	{
    		this.Area5.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // RIMUOVI MATERIA 6
    @FXML
    void doRimuoviMateria6(ActionEvent event) 
    {
    	this.Area6.clear();
    	String materia = this.BoxMaterie6.getValue();
		if(materia == null)
		{
			this.Area6.setText("SELEZIONARE UNA MATERIA DA RIMUOVERE");
			return;
		}
		if(this.Materia6.contains(materia))
		{
			Materia6.remove(materia);
			this.Area6.appendText("MATERIA RIMOSSA CON SUCCESSO! \n");
		} else
		{
			this.Area6.appendText("MATERIA NON TROVATA \n");
		}
		this.Area6.appendText("ELENCO MATERIE GIA' INSERITE: \n");
		for(int i=0; i<Materia6.size(); i++)
		{
			this.Area6.appendText(Materia6.get(i)+"\n");
		}
    }

    // RIMUOVI STUDENTE 4
    @FXML
    void doRimuoviStudente4(ActionEvent event) 
    {
    	this.Area4.clear();
    	try
    	{
    		String name = this.txtNomeStud4.getText().substring(0,1).toUpperCase() + this.txtNomeStud4.getText().substring(1,this.txtNomeStud4.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud4.getText().substring(0,1).toUpperCase() + this.txtCognomeStud4.getText().substring(1,this.txtCognomeStud4.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		if(model.trovaIdStudente(model.getStudenti(), nome ) == -1)
    		{
    			this.Area4.setText("STUDENTE NON TROVATO NEL DATABASE!");
    			return;
    		}
    		Studente s = model.getStudenteByNome(nome);
    		
    		if(model.CancellaStudente(s.getIdStudente()))
    		{
    			this.Area4.setText("STUDENTE: "+s.getNome()+" RIMOSSO CON SUCCESSO");
    			return;
    		}
    		else
    		{
    			this.Area4.setText("ERRORE NELLA RIMOZIONE DELLO STUDENTE DAL DATABASE");
    			return;
    		}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area4.setText("ATTENZIONE!\n ERRORE NELLA RIMOZIONE DELLO STUDENTE");
    	}catch(RuntimeException e)
    	{
    		this.Area4.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // RIMUOVI TUTOR 5
    @FXML
    void doRimuoviTutor5(ActionEvent event) 
    {
    	Tutor t = this.BoxTutor5.getValue();
    	if(t==null)
    	{
    		this.Area5.setText("SELEZIONARE IL TUTOR PRIMA DI PROCEDERE");
    		return; 
    	}
    	if(model.CancellaTutor(t.getIdTutor()))
    	{
    		this.Area5.setText("TUTOR ELIMINATO CON SUCCESSO");
    		this.BoxTutor1.getItems().removeAll(Tutor);
        	this.BoxTutor5.getItems().removeAll(Tutor);
        	this.BoxTutor7.getItems().removeAll(Tutor);
    		this.Tutor = model.getTutor();
        	this.BoxTutor1.getItems().addAll(Tutor);
        	this.BoxTutor5.getItems().addAll(Tutor);
        	this.BoxTutor7.getItems().addAll(Tutor);
    		return; 
    	}else {
    		this.Area5.setText("ERRORE NELLA RIMOZIONE DEL TUTOR: "+t.getNome());
    		return; 
    	}
    }

    // STAMPA INFO 4
    @FXML
    void doStampaInfo4(ActionEvent event) 
    {
    	this.Area4.clear();
    	try
    	{
    		String name = this.txtNomeStud4.getText().substring(0,1).toUpperCase() + this.txtNomeStud4.getText().substring(1,this.txtNomeStud4.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud4.getText().substring(0,1).toUpperCase() + this.txtCognomeStud4.getText().substring(1,this.txtCognomeStud4.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		if(model.trovaIdStudente(model.getStudenti(), nome ) == -1)
    		{
    			this.Area4.setText("STUDENTE NON TROVATO NEL DATABASE!");
    			return;
    		}
    		Studente s = model.getStudenteByNome(nome);
    		Calendar now = Calendar.getInstance();
    		int mese = now.get(Calendar.MONTH);
    		int anno = now.get(Calendar.YEAR);
    		List <Lezione> lezmese = model.getResocontoLezioniStudente(mese, s.getIdStudente(), anno);
    		
    		StringBuilder sb = new StringBuilder();
    		sb.append(String.format("%100s","RESOCONTO STUDENTE"));
    		sb.append("\n");
    		sb.append(String.format("- Tutor: %-30s ", s.getNome()));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("Classe: %-15s", s.getClasse()));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("DSA:  %-10s", s.isDSA()));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("%100s","LEZIONI PRENOTATE NEL MESE ATTUALE: \n"));
    		sb.append("\n");
    		
    		for(int i=0; i<lezmese.size(); i++)
    		{
    			sb.append(String.format("%-100s", lezmese.get(i)));
        		sb.append("\n");
    		}
    		if(lezmese.isEmpty())
    		{
    			sb.append(String.format("Nessuna lezione prenotata nel mese attuale!"));
        		sb.append("\n");
    		}
    		
    		List <Lezione> lezpre = model.getResocontoLezioniPrenotate(anno, now.get(Calendar.DAY_OF_YEAR));
    		sb.append(String.format("%100s","LEZIONI PRENOTATE DALLO STUDENTE: \n"));

    		for (int i=0; i<lezpre.size(); i++)
    		{
    			if(lezpre.get(i).getIdStudente() == model.trovaIdStudente(model.getStudenti(), nome))
    			{
    				sb.append(String.format("%-100s", lezpre.get(i)));
            		sb.append("\n");
    			}
    		}
    		this.Area4.appendText(sb.toString());
    		
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area4.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE INFORMAZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area4.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // STAMPA INFO 5
    @FXML
    void doStampaInfo5(ActionEvent event) 
    {
    	this.Area5.clear();
    	try
    	{
    		Tutor t = this.BoxTutor5.getValue();
        	if(t==null)
        	{
        		this.Area5.setText("SELEZIONARE IL TUTOR PRIMA DI PROCEDERE");
        		return; 
        	}
        	
        	StringBuilder sb = new StringBuilder();
    		sb.append(String.format("%100s","RESOCONTO TUTOR"));
    		sb.append("\n");
    		sb.append(String.format("- Tutor: %-30s -", t.getNome()));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("Formazione: %-400S", t.getFormazione()));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("Materie:  "));
    		sb.append("\n");
    		sb.append("\n");
    		
    		for(int i=0; i<t.getMaterie().size(); i++)
    		{
    			sb.append(String.format("%-30s", t.Materie.get(i)));
        		sb.append("\n");
    		}
    		this.Area5.appendText(sb.toString());
    		
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area5.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE INFORMAZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area5.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    	
    }

    // STAMPA LEZIONI PRENOTATE 7
    @FXML
    void doStampaLezioniPrenotate7(ActionEvent event) 
    {
    	this.Area7.clear();
    	try
    	{
    		Calendar now = Calendar.getInstance();
    		int DayY = now.get(Calendar.DAY_OF_YEAR);
    		int anno = now.get(Calendar.YEAR);
    		
    		List <Lezione> lezioni = model.getResocontoLezioniPrenotate(anno, DayY);
    		if(lezioni.isEmpty())
    		{
    			this.Area7.setText("NESSUNA LEZIONE PRENOTATA! ");
    			return;
    		}
    		StringBuilder sb = new StringBuilder();
    		sb.append(String.format("%100s","RESOCONTO LEZIONI PRENOTATE"));
    		sb.append("\n");
    		sb.append("\n");
    		sb.append(String.format("%-30s %-40s %-40s %-30s %-10s", "Data", "Studente", "Tutor", "Materia", "Orario"));
    		sb.append("\n");
    		Studenti = model.getStudenti();
    		Tutor = model.getTutor();
    		
    		for(int i=0; i<lezioni.size();i++)
    		{
    			Studente s = model.trovaStudente(Studenti, lezioni.get(i).getIdStudente());
    			Tutor t = model.trovaTutor(Tutor, lezioni.get(i).getIdTutor());
    			if(s!= null && t!= null)
    			{
	    			sb.append(String.format("%-10s", lezioni.get(i).getData()));
	    			sb.append(String.format("%30s", s.getNome()));
	    			sb.append(String.format("%30s", t.getNome()));
	    			sb.append(String.format("%20s", lezioni.get(i).getMateria()));
	    			sb.append(String.format("%25s", lezioni.get(i).getOrario()));
	    			sb.append("\n");
    			}
    		}
    		this.Area7.appendText(sb.toString());
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area7.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area7.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
   
    // TUTTI I TUTOR 7
    @FXML 
    void doTuttiTutor7(ActionEvent event) 
    {
    	this.Area7.clear();
    	try
    	{
    		if(this.BoxMese7.getValue() == null)
    		{
    			this.Area7.setText("SELEZIONARE IL MESE DESIDERATO PRIMA DI INIZIARE!");
    			return;
    		}
    		
    		String m = this.BoxMese7.getValue();
    		int mese = model.OttieniMesi(m);
    		Calendar now = Calendar.getInstance();
    		int anno = now.get(Calendar.YEAR);
    		StringBuilder sb = new StringBuilder();
    		sb.append(String.format("%100s","RESOCONTO LEZIONI TUTTI TUTOR"));
    		sb.append("\n");
    		sb.append("\n");
    		Tutor = model.getTutor();
    		for(int i=0; i<Tutor.size();i++)
    		{
    			List <Lezione> lezioni = model.getResocontoLezioniTutor(mese, Tutor.get(i).getIdTutor(),anno);
    			sb.append(String.format("Tutor: %-20s", Tutor.get(i).getNome()));
        		sb.append("\n");
        		sb.append("\n");
        		sb.append(String.format("%-30s %-60s %-30s %-10s", "Data", "Studente", "Materia", "Orario"));
        		sb.append("\n");
        		int cont = 0;
        		for(int j=0; j<lezioni.size();j++)
        		{
        			Studente s = model.trovaStudente(model.getStudenti(), lezioni.get(j).getIdStudente());
        			sb.append(String.format("%-25s", lezioni.get(j).getData()));
	    			sb.append(String.format("%-40s", s.getNome()));
	    			sb.append(String.format("%-50s", lezioni.get(j).getMateria()));
	    			sb.append(String.format("%-10s", lezioni.get(j).getOrario()));
	    			sb.append("\n");
	    			cont++;
        		}
        		sb.append("\n");
        		sb.append("\n");
        		sb.append(String.format("ORE TOTALI: %10s", cont*2));
        		sb.append("\n");
        		sb.append("\n");
    		}
    		
    		this.Area7.appendText(sb.toString());
    		
    	
    	}catch(NumberFormatException e)
    	{
    		this.Area7.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI");
    	}catch(RuntimeException e)
    	{
    		this.Area7.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
    
    // VERIFICA DISPONIBILITA 1
    @FXML
    void doVerificaDisponibilita1(ActionEvent event) 
    {
    	this.Area1.clear();
    	try
    	{
    		String name = this.txtNomeStud1.getText().substring(0,1).toUpperCase() + this.txtNomeStud1.getText().substring(1,this.txtNomeStud1.getText().length()).toLowerCase();
    		String surname = this.txtCognomeStud1.getText().substring(0,1).toUpperCase() + this.txtCognomeStud1.getText().substring(1,this.txtCognomeStud1.getText().length()).toLowerCase();

    		String nome = name.replaceAll(" ", "")+" "+surname.replaceAll(" ", "");
    		Studente stud = model.getStudenteByNome(nome);
    		if(stud == null)
    		{
    			this.Area1.setText("NESSUNO STUDENTE CON IL NOME: "+nome+" E' STATO TROVATO!");
    			return;
    		}
    		
    		LocalDate d = Data1.getValue();
    		if(d == null)
    		{
    			this.Area1.setText("SELEZIONARE UNA DATA PER LA LEZIONE!");
    			return;
    		}
    		String orario = this.BoxOrario1.getValue();
    		if(orario == null)
    		{
    			this.Area1.setText("SELEZIONARE UN ORARIO PER LA LEZIONE!");
    			return;
    		}
    		String materia = this.BoxMateria1.getValue();
    		if(materia == null)
    		{
    			this.Area1.setText("SELEZIONARE UNA MATERIA PER LA LEZIONE!");
    			return;
    		}
    		
    		List <Integer> id = model.getTutorDisponibili(d.getDayOfYear(), d.getYear(), orario);
    		if(id.isEmpty())
    		{
    			this.Area1.setText("NESSUNA DISPONIBILITA' DI TUTOR PER IL GIORNO E ORARIO SELEZIONATO");
    			return;
    		}
    		List <Tutor> tutor = new ArrayList <Tutor> ();
    		for(int i=0; i<id.size(); i++)
    		{
    			Tutor t = model.trovaTutor(model.getTutor(), id.get(i));
    			tutor.add(t);
    		}
    		List <Lezione> l = new ArrayList <Lezione> ();
    		int conto = model.getContoLezioni();
    		for(int i=0; i<tutor.size(); i++)
    		{
    			Calendar cal = Calendar.getInstance();
    			cal.set(Calendar.YEAR, d.getYear());
    			cal.set(Calendar.MONTH, d.getMonthValue() - 1);                                     
    			cal.set(Calendar.DAY_OF_MONTH, d.getDayOfMonth());
    			
    			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
    			Lezione lez = new Lezione (conto+1, stud.getIdStudente(), tutor.get(i).getIdTutor(), date, orario, materia, d.getDayOfMonth(), d.getMonth().getValue(), d.getYear(), d.getDayOfYear(),d.getDayOfWeek().getValue());
    			l.add(lez);
    		}
    		
			this.Area1.appendText("ELENCO TUTOR DISPONIBILI:  \n" );
    		for(int i=0; i<l.size(); i++)
    		{
    			this.Area1.appendText("Tutor:  "+ model.trovaTutor(model.getTutor(), l.get(i).getIdTutor()) + "   PUNTI:   "+model.calcolaPunteggio(l.get(i))+ "\n" );
    		}
    		
    		List <Lezione> tutte = model.getLezioniGiorno(d.getDayOfYear(), d.getYear());
			this.Area1.appendText("\nELENCO LEZIONI GIA' PRENOTATE:  \n" );

    		for(int i=0; i<tutte.size(); i++)
    		{
    			if(tutte.get(i).getOrario().equals(orario))
    			{
    				this.Area1.appendText("TUTOR: "+ model.trovaTutor(model.getTutor(), tutte.get(i).getIdTutor()).getNome() +"\nLEZIONE: "+tutte.get(i)+"" );
    			}
    		}
    		
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area1.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE DISPONIBILITA' ");
    	}catch(RuntimeException e)
    	{
    		this.Area1.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }

    // VISUALIZZA 3
    @FXML
    void doVisualizza3 (ActionEvent event)
    {
    	this.Area3.clear();
    	try
    	{
    		
    		LocalDate d = Data3.getValue();
    		if(d == null)
    		{
    			this.Area3.setText("SELEZIONARE UNA DATA PER LA LEZIONE!");
    			return;
    		}
    		 List <Lezione> l = model.getLezioniGiorno(d.getDayOfYear(), d.getYear());
    		 if(l.isEmpty())
    		 {
    			 this.Area3.setText("NESSUNA LEZIONE TROVATA PER LA DATA SELEZIONATA: "+d.toString());
    			 return; 
    		 }
    		 for(int i=0; i<l.size(); i++)
    		 {
    			 this.Area3.appendText(l.get(i)+"PUNTEGGIO: "+model.calcolaPunteggio(l.get(i))+"\n");
    		 }
    		 this.Area3.appendText("PUNTEGGIO TOTALE: "+model.calcolaPunteggioTot(l)+"     TOTALE LEZIONI: "+l.size());
    		 
    		 this.BoxLezioni3.getItems().clear();
    		 this.BoxLezioni3.getItems().addAll(l);
    		 this.Lezioni3 = new ArrayList <> (l);
    		 this.LezFissate = new ArrayList <Lezione> ();
    		 this.Tutte3 = new ArrayList <> (l);
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area3.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI GIORNALIERE ");
    	}catch(RuntimeException e)
    	{
    		this.Area3.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
    
    // FISSA LEZIONE 3
    @FXML
    void doFissaLezione3 (ActionEvent event)
    {
    	this.Area3.clear();
    	try
    	{
    		Lezione l = this.BoxLezioni3.getValue();
    		if(l==null)
    		{
    			this.Area3.setText("SELEZIONARE UNA LEZIONE PRIMA DI PROSEGUIRE");
    			return;
    		}
    		this.LezFissate.add(l);
    		this.Lezioni3.remove(l);
    		this.Area3.appendText("LEZIONE FISSATA: "+l.toString()+"\n");
    		this.Area3.appendText("LEZIONI DISPONIBILI: \n");
    		 for(int i=0; i<this.Lezioni3.size(); i++)
    		 {
    			 this.Area3.appendText(this.Lezioni3.get(i)+"\n");
    		 }
    		 
    		 this.BoxLezioni3.getItems().clear();
    		 this.BoxLezioni3.getItems().addAll(this.Lezioni3);
    		
    	}catch(NumberFormatException e)
    	{
    		this.Area3.setText("ATTENZIONE!\n ERRORE NELLA STAMPA DELLE LEZIONI GIORNALIERE ");
    	}catch(RuntimeException e)
    	{
    		this.Area3.setText("ERRORE DI CONNESSIONE AL DATABASE");
    	}
    }
    
    @FXML
    void initialize() {
        assert Area1 != null : "fx:id=\"Area1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Area2 != null : "fx:id=\"Area2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Area3 != null : "fx:id=\"Area3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Area4 != null : "fx:id=\"Area4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Area5 != null : "fx:id=\"Area5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Area6 != null : "fx:id=\"Area6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Area7 != null : "fx:id=\"Area7\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxMateria1 != null : "fx:id=\"BoxMateria1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxMateria2 != null : "fx:id=\"BoxMateria2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxMaterie5 != null : "fx:id=\"BoxMaterie5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxMaterie6 != null : "fx:id=\"BoxMaterie6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxMese7 != null : "fx:id=\"BoxMese7\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxOrario1 != null : "fx:id=\"BoxOrario1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxOrario2 != null : "fx:id=\"BoxOrario2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxOrario5 != null : "fx:id=\"BoxOrario5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxTutor1 != null : "fx:id=\"BoxTutor1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxTutor5 != null : "fx:id=\"BoxTutor5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert BoxTutor7 != null : "fx:id=\"BoxTutor7\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckEducatoreNo6 != null : "fx:id=\"CheckEducatoreNo6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckEducatoreYes6 != null : "fx:id=\"CheckEducatoreYes6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckInternoNo6 != null : "fx:id=\"CheckInternoNo6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckInternoYes6 != null : "fx:id=\"CheckInternoYes6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckNo4 != null : "fx:id=\"CheckNo4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckYes4 != null : "fx:id=\"CheckYes4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Data1 != null : "fx:id=\"Data1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Data2 != null : "fx:id=\"Data2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Data3 != null : "fx:id=\"Data3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Data5 != null : "fx:id=\"Data5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognomeStud1 != null : "fx:id=\"txtCognomeStud1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognomeStud2 != null : "fx:id=\"txtCognomeStud2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognomeStud4 != null : "fx:id=\"txtCognomeStud4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognomeStud7 != null : "fx:id=\"txtCognomeStud7\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognomeTutor6 != null : "fx:id=\"txtCognomeTutor6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtFormazione6 != null : "fx:id=\"txtFormazione6\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeStud1 != null : "fx:id=\"txtNomeStud1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeStud2 != null : "fx:id=\"txtNomeStud2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeStud4 != null : "fx:id=\"txtNomeStud4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeStud7 != null : "fx:id=\"txtNomeStud7\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeTutor6 != null : "fx:id=\"txtNomeTutor6\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    private void setComboItems()
    {
    	Materie = model.getMaterie();
    	Collections.sort(Materie);
    	this.BoxMateria1.getItems().addAll(Materie);
    	this.BoxMateria2.getItems().addAll(Materie);
    	this.BoxMaterie5.getItems().addAll(Materie);
    	this.BoxMaterie6.getItems().addAll(Materie);
    	
    	this.Orario = model.RiempiOrario();
    	this.BoxOrario1.getItems().addAll(Orario);
    	this.BoxOrario2.getItems().addAll(Orario);
    	this.BoxOrario5.getItems().addAll(Orario);
    	
    	this.Mese = model.RiempiMesi();
    	this.BoxMese7.getItems().addAll(Mese);
    	
    	this.Tutor = model.getTutor();
    	this.BoxTutor1.getItems().addAll(Tutor);
    	this.BoxTutor5.getItems().addAll(Tutor);
    	this.BoxTutor7.getItems().addAll(Tutor);

    	this.Classe = model.RiempiClasse();
    	this.BoxClasse4.getItems().addAll(Classe);
    	
    }
    
    public void setModel(Model model)
    {
    	this.model = model;
    	setComboItems();
    }

}
