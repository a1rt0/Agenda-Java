import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Contato> agenda = new ArrayList<>();

        while(true){
            System.out.println("# Agenda de Contatos #");
            System.out.println("[1] Adicionar contato");
            System.out.println("[2] Editar contato");
            System.out.println("[3] Excluir contato");
            System.out.println("[4] Listar contatos");
            System.out.println("[5] Sair");
            int opcao = input.nextInt();

            /* Limpa o buffer do teclado */
            input.nextLine();

            switch(opcao){

                /* Adicionar contato */
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = input.nextLine();
                    System.out.println("DIgite o telefone: ");
                    String telefone = input.nextLine();

                    agenda.add(new Contato(nome , telefone));


                    break;

                /* Editar contato */
                case 2:
                    System.out.println("Digite o nome do contato: ");
                    String mudarnome = input.nextLine();

                    for(Contato contato: agenda){
                        if(contato.getNome().equalsIgnoreCase(mudarnome)){
                            System.out.println("digite o novo telefone: ");
                            String newtelefone = input.nextLine();
                            contato.setTelefone(newtelefone);
                        }
                        else{
                            System.out.println("contato inexistente");
                            break;
                        }
                    }
                    break;

                /* Excluir contato */
                case 3:
                    System.out.println("digite o nome para excluir: ");
                    String excluir = input.nextLine();
                    for(int i = 0 ;i  < agenda.size(); i++){
                        if(agenda.get(i).getNome().equalsIgnoreCase(excluir)){
                            agenda.remove(i);
                            System.out.println("contato excluido!");
                        }
                    }
                    break;

                /* Listar contatos */
                case 4:
                    for(int i = 0 ; i < agenda.size(); i++){
                        if(agenda.isEmpty()){
                            System.out.println("lista vazia");
                        }
                        else{
                            Contato agendas = agenda.get(i);
                            agendas.mostrarInformacoes();
                        }
                    }
                    break;

                /* Sair */
                case 5:

                    input.close();

                    return; /* Finaliza o programa */

                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
}

class Contato{
    private String nome;
    private String telefone;

    /* Construtor */
    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    /* Setters e getters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }




    /* Método para mostrar informacoes */
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println();
    }
}