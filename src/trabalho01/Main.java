
package trabalho01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Sistema sis = new Sistema();
        sis.init();
        
        System.out.println("Olá, seja bem vindo(a) ao sistema de Registro de Consultas!\n");
        int opcao1 = -1;
        
        do {
            System.out.print("\n1 - Módulo de Pacientes.\n2 - Módulo de Anamnese.\n0 - Sair.\n\nSelecione uma opção: ");
            opcao1 = scn.nextInt();
            int opcao = -1;
            switch (opcao1) {
                case 1:
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
                                        h = sis.excluirPaciente(numero);
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
                    break;
                case 2:
                    do{
                        System.out.print("\n1 - Iserir nova anamnese.\n2 - Buscar Anamnese.\n3 - Alterar Anamnese.\n4 - Remover Anamnese.\n5 - Listar Anamneses.\n0 - Sair\n\nSelecione uma opção: ");
                        opcao = scn.nextInt();
                        
                        Long numero;
                        Anamnese a = new Anamnese();
                        boolean g;
                        
                        switch (opcao) {
                            case 0:
                                break;
                            case 1:
                                System.out.print("---------------------------------------------");
                                System.out.println("\nInsira as devidas informações sobre a anamnese");
                                System.out.print("---------------------------------------------");

                                System.out.print("\nNúmero CNS do Paciente: ");
                                numero = scn.nextLong();

                                System.out.print("\nMotivo: ");
                                a.motivo = scn.next();

                                System.out.print("\nHistorico: ");
                                a.historico = scn.next();

                                System.out.print("\nQueixa: ");
                                a.queixa = scn.next();


                                System.out.print("---------------------------------------------");

                                g = sis.addAnamnese(a, numero);
                                if (g == true) {
                                    System.out.println("\n Anamnese criada com Sucesso!");
                                } else {
                                    System.out.println("\n Anamnese não foi criada! Verifique se já há algum paciente com\n o mesmo número CNS cadastrado.");
                                }

                                break;
                            case 2:
                                System.out.print("\nInforme o nome do Paciente: ");
                                String nome = scn.next();

                                if(sis.verificarPacienteNome(nome)){
                                    Paciente[] pacientesNome;
                                    Anamnese[] anamneses;
                                    pacientesNome = sis.retornarPacientes(nome);
                                    anamneses = sis.listarAnamneses(pacientesNome);
                                    
                                    System.out.printf("%s%10s%20s","Anamneses", "Nome", "Nome da mãe");
                                    int cont = 0;
                                    for (int i = 0; i < anamneses.length; i++) {
                                        if(anamneses[i]!= null){
                                            cont++;
                                            System.out.printf("\n%d%s%3s%15s%43s",i,":",anamneses[i].id, anamneses[i].paciente.nome,anamneses[i].paciente.nomeMae);
                                        }
                                    }
                                    System.out.print("\n\nInsira a anamnese desejada: ");
                                    int opcao2 = scn.nextInt();
                                    
                                    while(opcao2<0 || opcao2 >= cont){
                                        System.out.println("Opção inválida");
                                        System.out.print("\nInsira a anamnese desejada: ");
                                        opcao2 = scn.nextInt();
                                    }
                                    
                                    System.out.println("----------------------------");
                                    System.out.println("Nome do Paciente: "+anamneses[opcao2].paciente.nome);
                                    System.out.println("Motivo: "+anamneses[opcao2].motivo);
                                    System.out.println("Historico: "+anamneses[opcao2].historico);
                                    System.out.println("Queixa: "+anamneses[opcao2].queixa);
                                    System.out.println("----------------------------");
                                    
                                } else{
                                    System.out.println("\nNão há paciente com esse nome!\n");
                                }
                                
                                break;
                            case 3:
                                break;
                            case 4:
                                System.out.print("---------------------------------------------");
                                System.out.print("\nInsira o id da anamnese do paciente a ser deletada: ");
                                numero = scn.nextLong();

                                g = sis.verificarAnamnese(numero);
                                
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
                                        boolean h = sis.excluirAnamnese(numero);
                                        if(h ==true){
                                            System.out.println("\nAnamnese excluida com sucesso!");
                                        } else{
                                            System.out.println("\nA anamnese não foi excluída!");
                                        }
                                    } else{
                                        break;
                                    }
                                } else{
                                    System.out.println("Não existe anamnese cadastrada com esse ID!");
                                }
                                break;
                            case 5:
                                  
                                System.out.print("\n---------------------------------------------\n");
                                Anamnese anamneses[] = sis.listarAnamnese();

                                System.out.printf("%11s%15s%13s%37s%46s%37s","Id Anamnese", "Numero CNS","Paciente","Motivo","Historico", "Queixa");

                                for (int i = 0; i < anamneses.length; i++) {
                                    if(anamneses[i] == null){
                                        i = anamneses.length;
                                    } else{
                                        String nomeFinal = anamneses[i].paciente.nome;
      

                                        if(anamneses[i].paciente.nome.chars().filter(ch -> ch != ' ').count() > 26 ){
                                            String nomeCortado = anamneses[i].paciente.nome.substring(0, 23) ;
                                            nomeFinal = nomeCortado.concat("(...)");
                                        } 
                                        
                                        System.out.printf("\n%3s%s%16s%-13d%-38s%-43s%-40s%s"," ",i," ",anamneses[i].paciente.numCNS,nomeFinal,anamneses[i].motivo, anamneses[i].historico, anamneses[i].queixa);
                                    }
                                }
                                System.out.print("\n---------------------------------------------");
                                break;
                            default:
                                System.out.println("Opção inválida! ");
                                break;
                        }
                    } while(opcao !=0 );
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.println("Opção inválida! ");
                    break;    
            }
        } while (opcao1!=0);
        
        
        
        
        
    }
    
}
