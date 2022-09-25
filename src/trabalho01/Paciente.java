package trabalho01;
import java.time.LocalDate;

public class Paciente {
    long numCNS;
    String nome, nomeMae;
    LocalDate dataNasc;
    int sexo, telefone;
    Endereco endereco;
    
    void add(Endereco end){
        endereco = new Endereco();
    }
}
