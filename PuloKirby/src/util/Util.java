package util;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Util {
	
	// ########################### FUNÇÃO PARA INSTANCIAR ÁUDIOS ###########################

		public static void play(String nomeDoAudio) {
			try {
				URL audioUrl = Util.class.getResource("/images/" + nomeDoAudio + ".wav");
				if (audioUrl == null) {
					System.err.println("O arquivo de áudio não foi encontrado: " + nomeDoAudio);
					return;
				}

				AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioUrl);

				Clip audioClip = AudioSystem.getClip();
				audioClip.open(audioStream);

				audioClip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
				ex.printStackTrace();
			}
		}

	// ########################### FUNÇÃO PARA RE-ESCALAR ÍCONES ###########################

		

}
