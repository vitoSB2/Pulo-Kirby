package visual;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import util.Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class KirbyIsland extends JPanel {
	
	JLabel fundo, fundo2, sprite;

	public KirbyIsland() {
		this.setLayout(null);
		this.add(getSprite());
		this.add(getFundo());
		this.add(getFundo2());
	}
	
	public JLabel getSprite() {
		if(sprite == null) {
			sprite = new JLabel();
			sprite.setIcon(resizeIcon("idle1", 96, 111));
			sprite.setBounds(600, 392, 96, 111);
		}
		return sprite;
	}
	
	public JLabel getFundo() {
		if(fundo == null) {
			fundo = new JLabel();
			fundo.setIcon(resizeIcon("bgKirby", 1280, 720));
			fundo.setSize(1280, 720);
			fundo.setLocation(0, 0);
		}
		return fundo;
	}
	
	public JLabel getFundo2() {
		if(fundo2 == null) {
			fundo2 = new JLabel();
			fundo2.setIcon(resizeIcon("bgKirby2", 1280, 720));
			fundo2.setSize(1280, 720);
			fundo2.setLocation(0, 0);
		}
		return fundo2;
	}
	
	public static ImageIcon resizeIcon(String nomeDoIcone, int width, int height) {

		ImageIcon imageIcon = new ImageIcon(Util.class.getResource("/images/" + nomeDoIcone + ".png"));

		Image image = imageIcon.getImage();
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		return new ImageIcon(scaledImage);

	}

}
