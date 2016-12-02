package connexion;

public class Person {
		
	private int code_isep;
	private String statut;
	private String classe;
	private int groupe;
	
	
	public Person(int code_isep, String statut, String classe, int groupe) {
		super();
		this.code_isep = code_isep;
		this.statut = statut;
		this.classe = classe;
		this.groupe = groupe;
	}

	
	public int getCode_isep() {
		return code_isep;
	}
	public void setCode_isep(int code_isep) {
		this.code_isep = code_isep;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getGroupe() {
		return groupe;
	}
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	
	
	
}
