// Classe base para Personagem
class Personagem {
    private String nome;
    private int vida;
    private Arma arma;
    private Poder poder;

    public Personagem(String nome, int vida, Arma arma, Poder poder) {
        this.nome = nome;
        this.vida = vida;
        this.arma = arma;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public Arma getArma() {
        return arma;
    }

    public Poder getPoder() {
        return poder;
    }

    public void sofrerDano(int dano) {
        this.vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean temManaSuficiente() {
        return poder != null && poder.getCustoMana() <= 0;
    }
}