import java.util.Scanner;

// Classe Jogo
class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Introdução do Jogo
        System.out.println("##############################################################################\n");
        System.out.println("\tBem-vindos ao Jogo de Luta entre Espadachins!");
        System.out.println("\tZoro, o maior espadachim do mundo e \n \tKisame, o melhor espadachim da nevoa.");
        System.out.println("\tCada personagem tem sua arma única e poder especial.");
        System.out.println("\tEscolha sabiamente suas ações durante a batalha para sair vitorioso!\n");
        System.out.println("##############################################################################\n");
        // Criação de instâncias de armas
        Arma EspadaEnma = new Arma("Espada Enma", 500, 80, null);
        Arma Samehada = new Arma("Samehada", 300, 60, null);

        // Criação de instâncias de poderes
        Poder envenenamento = new Poder("Envenenamento", 20, 40);
        Poder congelamento = new Poder("Congelamento", 30, 50);

        // Criação de instâncias de personagens
        Zoro Zoro = new Zoro("Zoro", 100, EspadaEnma, envenenamento);
        Kisame Kisame = new Kisame("Kisame", 100, Samehada, congelamento);

        // Escolha do Personagem
        System.out.println("Escolha com qual personagem você deseja jogar:");
        System.out.println("1. Zoro");
        System.out.println("2. Kisame");

        int escolhaPersonagem = scanner.nextInt();
        Personagem jogadorEscolhido = null;

        if (escolhaPersonagem == 1) {
            jogadorEscolhido = Zoro;
        } else {
            jogadorEscolhido = Kisame;
        }
        // Exibir status inicial do personagem escolhido
        exibirStatusPersonagem(jogadorEscolhido);

        Batalha batalha = new Batalha();
        batalha.iniciarBatalha(jogadorEscolhido, escolherOponente(jogadorEscolhido, Zoro, Kisame), scanner);

        scanner.close();
    }


    public static void exibirStatusPersonagem(Personagem personagem) {
        System.out.println("----- Status de " + personagem.getNome() + " -----");
        System.out.println("Vida: " + personagem.getVida());
        System.out.println("Arma: " + personagem.getArma().getNome());
        if (personagem.getPoder() != null) {
            System.out.println("Poder: " + personagem.getPoder().getNome());
        }
        System.out.println("-----------------------------");
    }
    public static Personagem escolherOponente(Personagem jogadorEscolhido, Zoro Zoro, Kisame Kisame) {
        if (jogadorEscolhido == Zoro) {
            return Kisame;
        } else {
            return Zoro;
        }
    }
    
}