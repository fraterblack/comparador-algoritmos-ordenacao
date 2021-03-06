package com.analise;

import java.awt.Frame;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Application extends JFrame {
	private static final long serialVersionUID = 7947693168368714055L;
	
	private JDesktopPane desktop;
	
	public Application() {
		super();

		desktop = new JDesktopPane();
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		desktop.setVisible(true);
		setContentPane(desktop);

		//Full screen
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		Algorithms frame = new Algorithms();

		try {
			desktop.add(frame);

			frame.setSelected(true);
			frame.setMaximum(true);
			frame.setVisible(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(rootPane, "Houve um erro ao abrir a janela", "", JOptionPane.ERROR_MESSAGE, null);
		}
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(() -> {
			Application application = new Application();
			application.setVisible(true);
		});
	}
}
