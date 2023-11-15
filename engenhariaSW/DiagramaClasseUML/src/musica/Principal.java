package musica;

public class Principal {
    public static void main(String[] args) {
        Musica favorita = new Musica();
        favorita.setTitulo("It's My Life");
        favorita.setCantor("Bon Jovi");

        for (int i = 0; i < 1000; i++) {
            favorita.reproduz();
        }

        for (int i = 0; i < 50; i++) {
            favorita.curte();
        }

        Podcast meuPodcast = new Podcast();
        meuPodcast.setTitulo("MundoDev");
        meuPodcast.setApresentador("Lucas Costa");

        for (int i = 0; i < 5000; i++) {
            meuPodcast.reproduz();
        }

        for (int i = 0; i < 1000; i++) {
            meuPodcast.curte();
        }

        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(meuPodcast);
        preferidas.inclui(favorita);
    }
}