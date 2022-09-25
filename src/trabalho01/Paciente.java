package trabalho01;
import java.util.Date;

public class Paciente {
    long numCNS;
    String nome, nomeMae, dataNasc;
    int sexo, telefone;
    Endereco endereco;
    
    void add(Endereco end){
        endereco = new Endereco();
    }
}
