package trabalho01;
import java.time.LocalDate;
//A classe sistema não tem Main
public class Sistema {
    Paciente[] pacientes = new Paciente[100];
    Anamnese[] anamneses;
    int contador = 0;
    
    boolean addPaciente(Paciente p){
        //verifica se o vetor de pacientes existe
        if(pacientes != null && contador > 0){
            for (int i = 0; i < pacientes.length; i++) {
                if(pacientes[i] != null){
                    if(p.numCNS == pacientes[i].numCNS){
                        return false;
                    } 
                    if(p.nome.equals(pacientes[i].nome) && p.nomeMae.equals(pacientes[i].nomeMae)){
                        return false;
                    }
                }
            }
        }
        
        this.pacientes[contador] = p;
        this.contador++;
        return true;
    }
    
    //verifica o numero CNS corresponde a algum paciente cadastrado
    boolean verificarPaciente(Long numero){
        for (int i = 0; i < this.pacientes.length; i++) {
            if(pacientes[i]!= null){
                if(numero == this.pacientes[i].numCNS){
                    return true;
                }
            }
        }
        return false;
    }
    
    //retorna o paciente pelo numeroCNS
    Paciente retornarPaciente(Long numero){
        
        for (int i = 0; i < this.pacientes.length; i++) {
            if(numero == this.pacientes[i].numCNS){
                return pacientes[i];
            }
        }
        Paciente p = new Paciente();
        return p;
    }
    
    boolean alterarPaciente(Paciente pAlterado){
        
        for (int i = 0; i < this.pacientes.length; i++) {
            if(pacientes[i]!= null){
                if(pAlterado.numCNS == this.pacientes[i].numCNS){
                    this.pacientes[i] = pAlterado;
                    return true;
                }
            }
        }
        
        return true;        
    }
    
    boolean addAnamnese(Anamnese a){
        
        return true;
    }
    
    boolean excluir(long numero){
        for (int i = 0; i < this.pacientes.length; i++) {
            if(pacientes[i]!= null){
                if(numero == this.pacientes[i].numCNS){
                    this.pacientes[i] = null;
                }
            }
        }
        for (int i = 0; i < this.pacientes.length; i++) {
            if(pacientes[i]== null && i != pacientes.length-1){
                if(pacientes[i+1] != null){
                    pacientes[i] = pacientes[i+1];
                    pacientes[i+1] = null;
                }
            }
        }
        if(this.verificarPaciente(numero) == true){
            return false;
        }
        return true;
    }
    
    Paciente[] listarPacientes(){
        return pacientes;
    }
            
    void init(){
        Paciente p = new Paciente();
        Endereco e = new Endereco();
        
        p.nome = "Biel";
        p.nomeMae = "Rosa";
        p.numCNS = 1;
        LocalDate data = LocalDate.of(2004, 03, 18);
        
        p.dataNasc = data;
        p.sexo = 1;
        p.telefone = 123123123;
        e.cidade = "Timoteo";
        e.logradouro = "sei la";
        e.numero = 697;
        e.uf = "MG";
        p.endereco = e;
        addPaciente(p);
        
        Paciente p1 = new Paciente();
        Endereco e1 = new Endereco();
        p1.nome = "Jorge";
        p1.nomeMae = "maria";
        p1.numCNS = 2;
        data = LocalDate.of(2000, 03, 03);
        p1.dataNasc = data;
        p1.sexo = 1;
        p1.telefone = 123123123;
        e1.cidade = "Timoteo";
        e1.logradouro = "sei la";
        e1.numero = 697;
        e1.uf = "MG";
        p1.endereco = e1;
        addPaciente(p1);
    }
}
