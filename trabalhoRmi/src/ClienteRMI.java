
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {

	public static void main(String[] args) {

		try {
			Registry registro = LocateRegistry.getRegistry("localhost", 1091);

			Servidor stub = (Servidor) registro.lookup("urnaTerminalFisco");

			Candidato voto1 = new Candidato("Jose Ferreira", 2020);
			Candidato voto2 = new Candidato("Paulo Augusto", 3030);
			Candidato voto3 = new Candidato("Afonso Fonseca", 1100);
			Candidato voto4 = new Candidato("Paulo Augusto", 3030);
			Candidato voto5 = new Candidato("Paulo Augusto", 3030);
			Candidato voto6 = new Candidato("Paulo Augusto", 3030);
			Candidato voto7 = new Candidato("Paulo Augusto", 3030);
			Candidato voto8 = new Candidato("Paulo Augusto", 3030);
			Candidato voto9 = new Candidato("Maria Fernandes", 5050);
			Candidato voto10 = new Candidato("Maria Fernandes", 5050);

			stub.receberEnviarVoto(voto1);
			stub.receberEnviarVoto(voto2);
			stub.receberEnviarVoto(voto3);
			stub.receberEnviarVoto(voto4);
			stub.receberEnviarVoto(voto5);
			stub.receberEnviarVoto(voto6);
			stub.receberEnviarVoto(voto7);
			stub.receberEnviarVoto(voto8);
			stub.receberEnviarVoto(voto9);
			stub.receberEnviarVoto(voto10);

			System.out.println("Finalizado o processo de votação!! ");

			stub.exibirResulado();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
