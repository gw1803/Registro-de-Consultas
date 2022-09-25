
package trabalho01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sistema sis = new Sistema();
        sis.init();
        int opcao = -1;
        Scanner scn = new Scanner(System.in);
        System.out.println("Olá, seja bem vindo(a) ao sistema de Registro de Consultas!\n");
        do{
            System.out.print("\n1 - Criar ficha de paciente.\n2 - Ver dados de Paciente.\n3 - Atualizar dados de paciente\n4 - Excluir dados de paciente.\n0 - Sair\n\nSelecione uma opção: ");
            opcao = scn.nextInt();
            boolean g = false;
            Paciente p = new Paciente();
            
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    System.out.print("---------------------------------------------");
                    
                    Endereco e = new Endereco();
                    
                    System.out.println("\nInsira as devidas informações sobre o paciente a serem cadastradas!");
                    System.out.print("---------------------------------------------");
                    
                    System.out.print("\nNome: ");
                    p.nome = scn.next();  
                    
                    System.out.print("\nNúmero CNS: ");
                    p.numCNS = scn.nextLong(); 
                    
                    System.out.print("\nData de nascimento: ");
                    p.dataNasc = scn.next();
                    
                    System.out.print("\nSexo(1 para masculino/0 para feminino): ");
                    p.sexo = scn.nextInt();
                    
                    System.out.print("\nNome da mãe: ");
                    p.nomeMae = scn.next(); 
                    
                    System.out.print("\nTelefone de contato: ");
                    p.telefone = scn.nextInt(); 
                    
                    System.out.print("\n(Endereco)\nCidade: ");
                    e.cidade = scn.next();
                    
                    System.out.print("\nUF: ");
                    e.uf = scn.next();
                    
                    System.out.print("\nLogradouro: ");
                    e.logradouro = scn.next();
                    
                    System.out.print("\nNúmero: ");
                    e.numero = scn.nextInt();
                    
                    p.endereco = e;
                    
                    System.out.print("---------------------------------------------");
                    
                    g = sis.addPaciente(p);
                    if(g == true){
                        System.out.println("\n Usuário criado com Sucesso!");
                    } else{
                        System.out.println("\n Usuário não foi criado!");
                    }
                    
                    
                    System.out.print("---------------------------------------------");
                    break;
                case 2:
                    System.out.print("---------------------------------------------");
                    System.out.print("\nInsira o número CNS do paciente: ");
                    Long numero = scn.nextLong();
                    g = sis.verificarPaciente(numero);
                    if(g == true){
                        p = sis.retornarPaciente(numero);
                        System.out.println("\nNome\tNumero CNS\tNome da mãe\tData de Nscimento\tSexo\tTelefone\tUF\tCidade\tLogradouro\tNumero");
                        System.out.println("\n"+p.nome+"\t"+p.numCNS+"\t\t"+p.nomeMae+"\t\t"+p.dataNasc+"\t\t\t"+p.sexo+"\t"+p.telefone+"\t"+p.endereco.uf+"\t"+p.endereco.cidade+"\t"+p.endereco.logradouro+"\t\t"+p.endereco.numero);
                    } else{
                        System.out.println("\nNão existe paciente cadastrado com esse número!");
                    }
                    System.out.print("---------------------------------------------");
                    break;
                case 3:
                    
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida! ");
                    break;
          }
        }while(opcao != 0);
        
    }
    
}
