import javax.print.attribute.standard.Media;

public class CustomMediaPlayer implements ReprodutorMusical{
    private MediaPlayer mediaPlayer;
    private boolean emReproducao = false;

    @Override
    public void tocarMusica(String caminhoArquivo) {
        if (!emReproducao) {
            Media media = new Media(new File(caminhoArquivo).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            // Define um evento para quando a música terminar de tocar
            mediaPlayer.setOnEndOfMedia(() -> {
                System.out.println("Música terminou de tocar.");
                emReproducao = false;
            });

            // Toca a música
            mediaPlayer.play();
            emReproducao = true;
        } else {
            System.out.println("Uma música já está sendo reproduzida.");
        }
    }

    @Override
    public void pausarMusica() {
        if (emReproducao) {
            mediaPlayer.pause();
        } else {
            System.out.println("Não há música em reprodução para ser pausada.");
        }
    }

    @Override
    public void selecionarMusica(String caminhoArquivo) {
        if (emReproducao) {
            mediaPlayer.stop();
        }
        tocarMusica(caminhoArquivo);
    }

    public void pararReproducao() {
        if (emReproducao) {
            mediaPlayer.stop();
            emReproducao = false;
        } else {
            System.out.println("Não há música em reprodução para ser parada.");
        }
    }
}
