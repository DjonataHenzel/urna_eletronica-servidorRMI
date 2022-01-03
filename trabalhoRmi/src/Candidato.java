public class Candidato {
	public String nomeCandidato;
	public int numeroCandidato;

	// --------------- Construtor------------------------------
	public Candidato(String nomeCandidato, int numeroCandidato) {
		this.nomeCandidato = nomeCandidato;
		this.numeroCandidato = numeroCandidato;
	}

	// --------- Getter e setter----------------
	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public int getNumeroCandidato() {
		return numeroCandidato;
	}

	public void setNumeroCandidato(int numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}
}
