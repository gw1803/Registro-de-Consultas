package trabalho01;
import java.time.LocalDate;
//A classe sistema não tem Main
public class Sistema {
    Paciente[] pacientes = new Paciente[100];
    Anamnese[] anamneses = new Anamnese[100];
    int contador = 0;
    int contadorA = 0;
    
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
    
    boolean verificarPacienteNome(String nome){
        for (int i = 0; i < this.pacientes.length; i++) {
            if(pacientes[i]!= null){
                if(pacientes[i].nome.equals(nome)){
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
    
    Paciente[] retornarPacientes(String nome){
        Paciente[] p = new Paciente[pacientes.length];
        int cont = 0;
        
        for (int i = 0; i < this.pacientes.length; i++) {
            if(this.pacientes[i]!=null){
                if(this.pacientes[i].nome.equals(nome)){
                        p[cont] = pacientes[i];
                        cont++;
                }
            }
        }
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
    
    Paciente[] listarPacientes(){
        return pacientes;
    }
    
    boolean excluirPaciente(long numero){
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
    
    boolean addAnamnese(Anamnese a, Long n) {
       if (anamneses != null) {
           if (verificarPaciente(n)) {
               Paciente pa = new Paciente();
               pa = retornarPaciente(n);
               a.paciente = pa;
               anamneses[contadorA] = a;
               this.contadorA = this.contadorA + 1;
               return true;
           }
       }
       return false;
   }
            
    Anamnese[] listarAnamneses(Paciente[] p){
        Anamnese[] a = new Anamnese[100];
        int cont = 0;
        
        for (int i = 0; i < this.anamneses.length; i++) {
            if(this.anamneses[i]!= null){
                if(this.anamneses[i].paciente.nome.equals(p[0].nome)){
                        a[cont] = anamneses[i];
                        cont++;
                    }
            }
            
        }
        return a;
    }

    boolean verificarAnamnese(Long numero){
        for (int i = 0; i < this.anamneses.length; i++) {
            if(anamneses[i]!= null){
                if(numero == this.anamneses[i].id){
                    return true;
                }
            }
        }
        return false;
    }
 
    boolean excluirAnamnese(long numero){
         
       for (int i = 0; i < this.anamneses.length; i++) {
           if(anamneses[i]!= null){
               if(numero == this.anamneses[i].id){
                   this.anamneses[i] = null;
               }
           }
       }
       for (int i = 0; i < this.anamneses.length; i++) {
           if(anamneses[i]== null && i != anamneses.length-1){
               if(anamneses[i+1] != null){
                   anamneses[i] = anamneses[i+1];
                   anamneses[i+1] = null;
               }
           }
       }
       
       if(this.verificarAnamnese(numero) == true){
           return false;
       }
       return true;
   }
    
    boolean verificarAnamnesePaciente(Long numero){
        for (int i = 0; i < this.anamneses.length; i++) {
            if(anamneses[i]!= null){
                if(this.anamneses[i].paciente.numCNS == numero){
                    return true;
                }
            }
        }
        return false;
    }
    
        boolean alterarAnamnese(Anamnese aAlterado){
        
        for (int i = 0; i < this.anamneses.length; i++) {
            if(anamneses[i]!= null){
                if(aAlterado.id == this.anamneses[i].id){
                    this.anamneses[i] = aAlterado;
                    return true;
                }
            }
        }
        
        return true;        
    }

    Anamnese[] listarAnamnese(){
        return anamneses;
    }
      
    void init(){
        Paciente p = new Paciente();
        Endereco e = new Endereco();
        
        p.nome = "Jorge";
        p.nomeMae = "Rosa";
        p.numCNS = 1;
        LocalDate data = LocalDate.of(2004, 03, 18);
        
        p.dataNasc = data;
        p.sexo = Sexo.MASCULINO;
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
        p1.nomeMae = "Maria Fernandina Josefina Barbosina";
        p1.numCNS = 2;
        data = LocalDate.of(2000, 03, 03);
        p1.dataNasc = data;
        p.sexo = Sexo.MASCULINO;
        p1.telefone = 123123123;
        e1.cidade = "Timoteo";
        e1.logradouro = "sei la";
        e1.numero = 697;
        e1.uf = "MG";
        p1.endereco = e1;
        addPaciente(p1);
        
        Paciente p2 = new Paciente();
        Endereco e2 = new Endereco();
        p2.nome = "Bianca";
        p2.nomeMae = "Josefina";
        p2.numCNS = 3;
        data = LocalDate.of(1980, 10, 18);
        p2.dataNasc = data;
        p.sexo = Sexo.FEMININO;
        p2.telefone = 123123123;
        e2.cidade = "Cel. Fabriciano";
        e2.logradouro = "22";
        e2.numero = 101;
        e2.uf = "MG";
        p2.endereco = e2;
        addPaciente(p2);
        
        Paciente p3 = new Paciente();
        Endereco e3 = new Endereco();
        p3.nome = "Luci";
        p3.nomeMae = "Yasmin";
        p3.numCNS = 4;
        data = LocalDate.of(1985, 10, 18);
        p3.dataNasc = data;
        p.sexo = Sexo.FEMININO;
        p3.telefone = 123123123;
        e3.cidade = "Cel. Fabriciano";
        e3.logradouro = "23";
        e3.numero = 1012;
        e3.uf = "MG";
        p3.endereco = e3;
        addPaciente(p3);
        
        Paciente p4 = new Paciente();
        Endereco e4 = new Endereco();
        p4.nome = "Joao";
        p4.nomeMae = "Paula";
        p4.numCNS = 5;
        data = LocalDate.of(1950, 12, 15);
        p4.dataNasc = data;
        p.sexo = Sexo.MASCULINO;
        p4.telefone = 123123123;
        e4.cidade = "Ipatinga";
        e4.logradouro = "07";
        e4.numero = 1012;
        e4.uf = "MG";
        p4.endereco = e4;
        addPaciente(p4);
        
        Anamnese a = new Anamnese();
        a.paciente = p;
        a.historico = "1";
        a.id = 0;
        a.motivo = "1";
        a.queixa = "123";
        addAnamnese(a,p.numCNS);
        
        Anamnese a1 = new Anamnese();
        a1.paciente = p1;
        a1.historico = "2";
        a1.id = 1;
        a1.motivo = "2";
        a1.queixa = "123";
        addAnamnese(a1,p1.numCNS);
        
        Anamnese a2 = new Anamnese();
        a2.paciente = p1;
        a2.historico = "2";
        a2.id = 2;
        a2.motivo = "2";
        a2.queixa = "123";
        addAnamnese(a2,p1.numCNS);
    }

}
