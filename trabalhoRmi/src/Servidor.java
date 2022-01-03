
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Servidor implements Validadora {
	Timer hora = new Timer();
	public static ArrayList<Candidato> listaDeVotos = new ArrayList<>();

	public Servidor() {

	}

	public static void main(String[] args) {
		try {
			Servidor s = new Servidor();
			Registry registro = LocateRegistry.createRegistry(1091);

			Validadora stub = (Validadora) UnicastRemoteObject.exportObject(s, 0);

			registro.bind("urnaTerminalFisco", stub);

			System.out.println("Servidor RMI está pronto!");

		} catch (Exception e) {
			System.out.println("Exception Servidor");
		}
	}

	// ---------- Metodos auxiliares--------------
	@Override
	public void contadorTotalVotos() throws RemoteException {
		final var qtVotos = listaDeVotos.stream().count();

		System.out.println("Total de votos até o momento: " + qtVotos);
	}

	@Override
	public void exibirResulado() throws RemoteException {
		hora.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				try {
					var totalVotoPrimeiroCandidato = listaDeVotos.stream()
							.filter(listaDeVotos -> listaDeVotos.getNomeCandidato().equals("Jose Ferreira")).count();

					System.out.println("CANDIDATO: Jose Ferreira esta com " + totalVotoPrimeiroCandidato + "votos");

					var totalVotoSegundoCandidato = listaDeVotos.stream()
							.filter(listaDeVotos -> listaDeVotos.getNomeCandidato().equals("Paulo Augusto")).count();

					System.out.println("CANDIDATO: Paulo Augusto esta com " + totalVotoSegundoCandidato + "votos");

				} catch (Exception e) {

				}
			}
		}, 5000, 1000);
	}

	@Override
	public String receberEnviarVoto(Candidato candidato) throws RemoteException {
		System.out.println("Nome: " + candidato.getNomeCandidato());
		System.out.println("Numero:" + candidato.getNumeroCandidato());
		listaDeVotos.add(candidato);
		return "Dados recebidos e registrado com sucesso!!";
	}

}
