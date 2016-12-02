package fiche_competence;

public class Competence {

		private String nom_competence;
		private int code_isep;
		private String note;
		private String commentaire_groupe;
		private String commentaire_prof;
		private String commentaire;
		private String version;
		
		public Competence(String nom_competence, int code_isep, String note, String commentaire_groupe,
				String commentaire_prof, String commentaire, String version) {
			super();
			this.nom_competence = nom_competence;
			this.code_isep = code_isep;
			this.note = note;
			this.commentaire_groupe = commentaire_groupe;
			this.commentaire_prof = commentaire_prof;
			this.commentaire = commentaire;
			this.version = version;
		}
		
		public String getNom_competence() {
			return nom_competence;
		}
		public void setNom_competence(String nom_competence) {
			this.nom_competence = nom_competence;
		}
		public int getCode_isep() {
			return code_isep;
		}
		public void setCode_isep(int code_isep) {
			this.code_isep = code_isep;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public String getCommentaire_groupe() {
			return commentaire_groupe;
		}
		public void setCommentaire_groupe(String commentaire_groupe) {
			this.commentaire_groupe = commentaire_groupe;
		}
		public String getCommentaire_prof() {
			return commentaire_prof;
		}
		public void setCommentaire_prof(String commentaire_prof) {
			this.commentaire_prof = commentaire_prof;
		}
		public String getCommentaire() {
			return commentaire;
		}
		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		
		
}
