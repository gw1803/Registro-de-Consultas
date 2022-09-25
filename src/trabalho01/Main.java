
package trabalho01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sistema sis = new Sistema();
        sis.init();
        
        int opcao = -1;
        Scanner scn = new Scanner(System.in);
        System.out.println("Olá, seja bem vindo(a) ao sistema de Registro de Consultas!\n");
        do{
            System.out.print("\n1 - Criar ficha de paciente.\n2 - Ver dados de Paciente.\n3 - Atualizar dados de paciente.\n4 - Excluir dados de paciente.\n5 - Listar pacientes.\n0 - Sair\n\nSelecione uma opção: ");
            opcao = scn.nextInt();
            
            String[] dataVetor;
            boolean g;
            boolean h;
            LocalDate ld;
            String data;
            Long numero;
            
            Paciente p = new Paciente();
            Endereco e = new Endereco();
            
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    System.out.print("---------------------------------------------");
                    System.out.println("\nInsira as devidas informações sobre o paciente a serem cadastradas!");
                    System.out.print("---------------------------------------------");
                    
                    System.out.print("\nNome: ");
                    p.nome = scn.next();  
                    
                    System.out.print("\nNúmero CNS: ");
                    p.numCNS = scn.nextLong(); 
                    
                    System.out.print("\nData de nascimento(dia-mês-ano): ");
                    data = scn.next();
                    dataVetor = data.split("-");
                    ld = LocalDate.of(Integer.parseInt(dataVetor[2]), Integer.parseInt(dataVetor[1]), Integer.parseInt(dataVetor[0]));
                    
                    p.dataNasc = ld;
                            
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
                        System.out.println("\n Usuário não foi criado! Verifique se já há algum paciente com\n o mesmo número CNS cadastrado, ou se há um paciente com nome e\n nome da mãe iguais.");
                    }
                    
                    
                    System.out.print("---------------------------------------------");
                    break;
                case 2:
                    System.out.print("---------------------------------------------");
                    System.out.print("\nInsira o número CNS do paciente: ");
                    numero = scn.nextLong();
                    g = sis.verificarPaciente(numero);
                    if(g == true){
                        p = sis.retornarPaciente(numero);
                        
                        System.out.print("\nNome: "+p.nome);
                        System.out.print("\nNome da mãe: "+p.nomeMae);
                        System.out.print("\nData de Nascimento: "+ p.dataNasc.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        System.out.print("\nSexo: "+p.sexo);
                        System.out.print("\nTelefone: "+p.telefone);
                        System.out.print("\nUF: "+p.endereco.uf);
                        System.out.print("\nCidade: "+p.endereco.cidade);
                        System.out.print("\nLogradouro: "+p.endereco.logradouro);
                        System.out.print("\nNúmero: "+p.endereco.numero);
                    } else{
                        System.out.println("\nNão existe paciente cadastrado com esse número!");
                    }
                    System.out.print("\n---------------------------------------------");
                    break;
                    
                case 3:
                    System.out.print("---------------------------------------------");
                    System.out.print("\nInsira o número CNS do paciente cujos dados serão alterados: ");
                    numero = scn.nextLong();
                    
                    g = sis.verificarPaciente(numero);
                    if(g == true){
                        System.out.print("---------------------------------------------");
                        System.out.println("\nInsira as devidas informações sobre o paciente a serem alteradas!");
                        System.out.print("---------------------------------------------");

                        System.out.print("\nNome: ");
                        p.nome = scn.next();  

                        p.numCNS = numero; 

                        System.out.print("\nData de nascimento(dia-mês-ano): ");
                        data = scn.next();
                        dataVetor = data.split("-");
                        ld = LocalDate.of(Integer.parseInt(dataVetor[2]), Integer.parseInt(dataVetor[1]), Integer.parseInt(dataVetor[0]));

                        p.dataNasc = ld;

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
                        
                        h = sis.alterarPaciente(p);
                        
                        if(h==true){
                            System.out.println("\nPaciente alterado com sucesso!");
                        } else{
                            System.out.println("\nPaciente não foi alterado!");
                        }
                    } else{
                        System.out.println("\nNão existe paciente cadastrado com esse número!");
                    }
                    System.out.print("---------------------------------------------");
                    break;
                case 4:
                    System.out.print("---------------------------------------------");
                    System.out.print("\nInsira o número CNS do paciente a ser deletado: ");
                    numero = scn.nextLong();
                    
                    g = sis.verificarPaciente(numero);
                    if(g == true){
                        int decisao = -1;
                        while(decisao<0 || decisao>1){
                            System.out.print("\nConfirme sua decisão(1 - quero deletar, 0 - não quero deletar): ");
                            decisao = scn.nextInt();
                            if(decisao<0 || decisao>1){
                                System.out.println("\nOpção inválida!");
                            }
                        }
                        if(decisao == 1){
                            h = sis.excluir(numero);
                            if(h==true){
                                System.out.println("\nPaciente excluido com sucesso!");
                            } else{
                                System.out.println("\nO paciente não foi excluído!");
                            }
                        } else{
                            break;
                        }
                    } else{
                        System.out.println("Não existe paciente cadastrado com esse núemro CNS!");
                    }
                    break;
                case 5:
                    System.out.print("\n---------------------------------------------\n");
                    Paciente pacientes[] = sis.listarPacientes();
                    
                    System.out.printf("%s%10s%37s%37s","Numero CNS","Nome","Nome da mãe","Telefone");
                        
                    for (int i = 0; i < pacientes.length; i++) {
                        if(pacientes[i] == null){
                            i = pacientes.length;
                        } else{
                            String nomeFinal = pacientes[i].nome;
                            String nomeMaeFinal = pacientes[i].nomeMae;
                        
                            if(pacientes[i].nome.chars().filter(ch -> ch != ' ').count() > 26 ){
                                String nomeCortado = pacientes[i].nome.substring(0, 23) ;
                                nomeFinal = nomeCortado.concat("(...)");
                            } 
                            if(pacientes[i].nomeMae.chars().filter(ch -> ch != ' ').count() > 26 ){
                                String nomeCortado = pacientes[i].nomeMae.substring(0, 23) ;
                                nomeMaeFinal = nomeCortado.concat("(...)");
                            } 
                            System.out.printf("\n%3s%-13d%-30s%-40s%s"," ",pacientes[i].numCNS,nomeFinal,nomeMaeFinal,pacientes[i].telefone);
                        }
                    }
                    System.out.print("\n---------------------------------------------");
                    break;
                default:
                    System.out.println("Opção inválida! ");
                    break;
          }
        }while(opcao != 0);
        
    }
    
}
