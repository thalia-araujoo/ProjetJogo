import java.util.Scanner;

class Batalha {
    public void iniciarBatalha(Personagem jogador, Personagem oponente, Scanner scanner) {
        System.out.println("Preparando-se para a batalha!\n");
        System.out.println("Você é o(a) " + jogador.getNome() + ". Seu oponente é o(a) " + oponente.getNome() + ".");
        System.out.println("\tQUE A BATALHA COMECE!\n");
        

        while (jogador.getVida() > 0 && oponente.getVida() > 0) {
            System.out.println("Escolha sua ação, " + jogador.getNome() + "!");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Poder");

            int escolhaAcao = scanner.nextInt();

            switch (escolhaAcao) {
                case 1:
                    // Ataque
                    realizarAtaque(jogador, oponente);
                    break;
                case 2:
                    // Usar Poder 
                    if (jogador.getPoder() != null && jogador.temManaSuficiente()) {
                        jogador.getPoder().usarPoder(jogador, oponente);
                    } else {
                        System.out.println("Sem poder disponível ou mana insuficiente.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            // Troca de papéis para o próximo turno
            Personagem temp = jogador;
            jogador = oponente;
            oponente = temp;

            exibirEstadoBatalha(jogador, oponente);
        }

        exibirResultadoBatalha(jogador, oponente);
    }

    public void realizarAtaque(Personagem atacante, Personagem oponente) {
        Arma armaAtacante = atacante.getArma();
        Arma armaOponente = oponente.getArma();

        double chanceAcertoAtacante = (armaAtacante.getPrecisao() * 0.6) + (armaAtacante.getForca() * 0.4);
        double chanceAcertoOponente = (armaOponente.getPrecisao() * 0.6) + (armaOponente.getForca() * 0.4);

        if (chanceAcertoAtacante > chanceAcertoOponente) {
            System.out.println("O ataque com a " + armaAtacante.getNome() + " é bem-sucedido! " +
                    atacante.getNome() + " ganha a jogada!");

            // Descontar vida do oponente
            int dano = calcularDano(armaAtacante);
            oponente.sofrerDano(dano);
        } else if (chanceAcertoAtacante < chanceAcertoOponente) {
            System.out.println("O ataque com a " + armaOponente.getNome() + " é bem-sucedido! " +
                    oponente.getNome() + " ganha a jogada!");

            // Descontar vida do atacante
            int dano = calcularDano(armaOponente);
            atacante.sofrerDano(dano);
        } else {
            System.out.println("Ambos os ataques falharam!");
        }
    }

    public int calcularDano(Arma arma) {
        //calcular o dano com base nos atributos da arma
        return arma.getForca() + arma.getPrecisao();
    }

    public void exibirEstadoBatalha(Personagem jogador1, Personagem jogador2) {
        System.out.println("----- Estado da Batalha -----");
        System.out.println(jogador1.getNome() + ": Vida - " + jogador1.getVida());
        System.out.println(jogador2.getNome() + ": Vida - " + jogador2.getVida());
        System.out.println("-----------------------------");
    }

    public void exibirResultadoBatalha(Personagem jogador1, Personagem jogador2) {
        System.out.println("----- Resultado da Batalha -----");
        if (jogador1.getVida() > 0) {
            System.out.println(jogador1.getNome() + " venceu!");
        } else if (jogador2.getVida() > 0) {
            System.out.println(jogador2.getNome() + " venceu!");
        } else {
            System.out.println("Empate!");
        }
        System.out.println("-------------------------------");
    }
}
