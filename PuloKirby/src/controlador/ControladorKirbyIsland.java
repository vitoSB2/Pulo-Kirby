package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import util.Util;
import visual.Frame;
import visual.KirbyIsland;

public class ControladorKirbyIsland implements KeyListener {

	KirbyIsland mapa;
	Frame frame;
	int gravidade = 1, velY = 0, forcaPulo = -26, chao = 392, estado = 1, estadoParado = 1, temp = 0;
	float alt = 0;

	boolean pulou = false;

	public ControladorKirbyIsland(KirbyIsland mapa, Frame frame) {
		
		Util.play("ostKirby");
		
		this.mapa = mapa;
		this.frame = frame;
		mapa.setFocusable(true);
		mapa.requestFocusInWindow();
		mapa.addKeyListener(this);
		
		parado();
		mapa.repaint();
		mapa.revalidate();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			pular();
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void parado() {

		Timer timer = new Timer(12, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				temp++;

				if (temp % 10 == 0) {
					if (estadoParado == 8) {
						estadoParado = 1;
					}
					mapa.getSprite().setIcon(KirbyIsland.resizeIcon((String) "idle" + estadoParado, 96, 111));
					estadoParado++;
				}

				if (pulou) {

					((Timer) e.getSource()).stop();
					estadoParado = 1;
					temp = 0;

					mapa.getSprite().setIcon(KirbyIsland.resizeIcon("idle1", 96, 111));
				}

				frame.repaint();
				frame.revalidate();
			}
		});

		timer.start();

	}

	public void pular() {

		if (pulou) {
			return;
		}

		pulou = true;
		velY = forcaPulo;
		alt = 0;
		estado = 1;
		
		Util.play("unknown1");

		Timer timer = new Timer(12, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				alt++;

				if(estado == 1 && alt<20) estado = 2;
				if(estado == 2 && alt<20) estado = 1;
				mapa.getSprite().setIcon(KirbyIsland.resizeIcon((String) "pulo" + estado, 96, 111));
				
				if (alt % 3 == 0 && alt > 20 && alt < 46) {
					estado++;
					mapa.getSprite().setIcon(KirbyIsland.resizeIcon((String) "pulo" + estado, 96, 111));
				}
				
				if(alt == 50) {
					estado = 11;
					mapa.getSprite().setIcon(KirbyIsland.resizeIcon((String) "pulo" + estado, 96, 111));
				}

				velY += gravidade;
				int puloSprite = mapa.getSprite().getY() + velY;
				System.out.println(puloSprite);

				if (puloSprite >= chao) {
					puloSprite = chao;
					velY = 0;
					pulou = false;

					((Timer) e.getSource()).stop();
					mapa.getSprite().setIcon(KirbyIsland.resizeIcon((String) "pulo" + estado, 96, 111)); 
					mapa.getSprite().setIcon(KirbyIsland.resizeIcon("idle1", 96, 111));
					parado();
				}

				mapa.getSprite().setLocation(600, puloSprite);

				frame.repaint();
				frame.revalidate();
			}
		});

		timer.start();

	}

}
