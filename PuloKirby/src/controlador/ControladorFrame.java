package controlador;

import visual.Frame;
import visual.KirbyIsland;

public class ControladorFrame {
	
	Frame frame;
	ControladorKirbyIsland controladorMapa;

	public ControladorFrame() {
		frame = new Frame();
		KirbyIsland mapa = new KirbyIsland();
		frame.setContentPane(mapa);
		controladorMapa = new ControladorKirbyIsland(mapa, frame);
		
	}

	public static void main(String[] args) {
		new ControladorFrame();
	}

}
