import javax.print.attribute.standard.Media;
import java.io.File;

public class Main implements ReprodutorMusical{
    private MediaPlayer mediaPlayer;
    private boolean reproduzindo = false;


    public void tocarMusica(String caminhoArquivo) {
        if (!reproduzindo) {
            Media media = new Media(new File(caminhoArquivo).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setOnEndOfMedia(() -> {
                System.out.println("Música terminou de tocar.");
                reproduzindo = false;
            });

            mediaPlayer.play();
            reproduzindo = true;
            System.out.println("Tocando música: " + caminhoArquivo);
        } else {
            System.out.println("Já existe uma música em reprodução.");
        }
    }

    @Override
    public void tocarMusica() {

    }

    @Override
    public void pausarMusica() {
        if (mediaPlayer != null && reproduzindo) {
            mediaPlayer.pause();
            System.out.println("Música pausada.");
        } else {
            System.out.println("Nenhuma música em reprodução para ser pausada.");
        }
    }

    @Override
    public void selecionarMusica() {

    }


    public void selecionarMusica(String caminhoArquivo) {
        if (reproduzindo) {
            mediaPlayer.stop();
            reproduzindo = false;
        }
        tocarMusica(caminhoArquivo);
    }

}