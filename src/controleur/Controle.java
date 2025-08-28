package controleur;

import outils.connexion.AsyncResponse;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;
import outils.connexion.ClientSocket;
import vue.EntreeJeu;
import vue.Arene;
import vue.ChoixJoueur;

public class Controle implements AsyncResponse {
	
	/**
	 * N° du port d'écoute serveur
	 */
	private static final int PORT = 6666;
	/**
	 * frame EntreeJeu
	 */
	private EntreeJeu frmEntreeJeu ;
	/**
	 * frame Arene
	 */
	private Arene frmArene;
	/**
	 * frame ChoixJoueur
	 */
	private ChoixJoueur frmChoixJoueur;
	/*
	 * type du jeu: client ou serveur
	 */
	private String typeJeu;
	
	/**
	 * Méthode de démarrage
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		new Controle();

	}
	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this) ;
		this.frmEntreeJeu.setVisible(true);
	}


	/**
	 * demmande provenant de la vue EntreeJeu
	 * @param Info
	 */
	public void evenementEntreeJeu(String info) {
		if(info.equals("serveur")){
			this.typeJeu = "serveur";
			new ServeurSocket (this, PORT);
			this.frmEntreeJeu.dispose();
			this.frmArene = new Arene();
			this.frmArene.setVisible(true);
			
		}else {
			this.typeJeu = "client";
			new ClientSocket(this, info, PORT);
		}
	}
	
	/**
	 * information prevenant de la vue ChoixJoueur
	 * @param pseudo
	 * @param numPerso
	 */
	public void evenementChoixJoueur(String pseudo, int numPerso) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
	}
	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch (ordre) {
		case "connexion" :
			if(this.typeJeu.equals("client")) {
				this.frmEntreeJeu.dispose();
				this.frmArene = new Arene();
				this.frmChoixJoueur = new ChoixJoueur(this);
				this.frmChoixJoueur.setVisible(true);
			}break;
		case"reception":
			break;
		case "deconnexion":
			break;
		}
	}
}
