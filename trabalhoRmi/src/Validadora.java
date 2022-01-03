
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validadora extends Remote {

	public void contadorTotalVotos() throws RemoteException;

	public void exibirResulado() throws RemoteException;

	public String receberEnviarVoto(Candidato candidato) throws RemoteException;

}
