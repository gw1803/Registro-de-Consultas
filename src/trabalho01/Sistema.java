package trabalho01;

//A classe sistema não tem Main
public class Sistema {
    Paciente[] pacientes = new Paciente[100];
    Anamnese[] anamneses;
    int contador = 0;
    
    boolean addPaciente(Paciente p){
        
        //verifica se o vetor de pacientes existe
        if(pacientes != null && contador > 0){
            for (int i = 0; i < pacientes.length; i++) {
                if(p.numCNS == pacientes[i].numCNS){
                    return false;
                }
            }
        }
        
        pacientes[contador] = p;
        contador++;
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
    
    Paciente retornarPaciente(Long numero){
        
        for (int i = 0; i < this.pacientes.length; i++) {
            if(numero == this.pacientes[i].numCNS){
                return pacientes[i];
            }
        }
        Paciente p = new Paciente();
        return p;
    }
    
    boolean addAnamnese(Anamnese a){
        
        return true;
    }
    boolean alterar(Paciente pAlterado){
        return true;        
    }
    boolean excluir(long numCNS){
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
        p.dataNasc = "123";
        p.sexo = 1;
        p.telefone = 123123123;
        e.cidade = "Timoteo";
        e.logradouro = "sei la";
        e.numero = 697;
        e.uf = "MG";
        p.endereco = e;
        addPaciente(p);
    }
}
