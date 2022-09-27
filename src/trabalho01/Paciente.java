package trabalho01;
import java.time.LocalDate;

public class Paciente {
    long numCNS;
    String nome, nomeMae;
    Enum sexo;
    LocalDate dataNasc;
    int telefone;
    Endereco endereco;
    
    void add(Endereco end){
        endereco = new Endereco();
    }
}
