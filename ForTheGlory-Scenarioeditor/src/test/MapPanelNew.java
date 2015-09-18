package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JPanel;

/**
 * @author Felix Beutter
 */

public class MapPanelNew extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static final long serialVersionUID = 1L;
	BufferedImage frontend, backend;
	HashMap<Color, Integer> colorMap = new HashMap<Color, Integer>();
	int centerX, centerY;
	float zoomFactor = 0.1f, zoomFactorSelected = 1f;

	public MapPanelNew(BufferedImage f, BufferedImage b, HashMap<Color, Integer> m) {

		super();

		colorMap = m;
		frontend = f;
		backend = b;

		centerX = f.getWidth() / 2;
		centerY = f.getHeight() / 2;

		this.setLayout(null);
		this.setOpaque(true);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		int x, y, width, height;

		width = (int) ((float) (frontend.getWidth()) * zoomFactorSelected);
		height = (int) ((float) frontend.getHeight() * zoomFactorSelected);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
