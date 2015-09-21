package scenarioeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class MapPanel extends JPanel implements MouseListener,
		MouseMotionListener, MouseWheelListener {

	BufferedImage biBackend, biFrontendOriginal, biBackendOriginal;
	JScrollBar sliderX, sliderY;
	JLabel image;
	Point drag;
	float zoomFactorSelected = 0.3f;
	float zoomFactor = (float) 0.1;
	Map map2;
	int x = 10000, y = 2000;
	int newHeight, newWidth;

	public MapPanel(BufferedImage Frontend, BufferedImage Backend,
			Map<Color, Integer> map) {
		super();
		this.setOpaque(true);
		this.setLayout(null);
		map2 = map;

		biFrontendOriginal = Frontend;
		biBackend = biBackendOriginal = Backend;
		// image = new JLabel(new ImageIcon(Frontend));
		sliderX = new JScrollBar();
		sliderY = new JScrollBar();
		sliderY.setOrientation(SwingConstants.VERTICAL);
		sliderX.setOrientation(SwingConstants.HORIZONTAL);
		sliderX.setVisible(true);
		sliderY.setVisible(true);
		this.add(sliderX);
		this.add(sliderY);
		// this.add(image);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
		mouseWheelMoved(new MouseWheelEvent(this, 1, 1, 1, 1, 1, 0, false, 0,
				0, 0));

	}

	public void paintComponent(Graphics g) {
		System.out.println(x);
		System.out.println(y);
		System.out.println(zoomFactorSelected);
		super.paintComponent(g);
		newHeight = (int) (biFrontendOriginal.getHeight() * zoomFactorSelected / 2);
		newWidth = (int) ((float) newHeight * ((float) this.getWidth() / (float) this
				.getHeight()));

		if ((y + newHeight) > biFrontendOriginal.getHeight()) {
			y = biFrontendOriginal.getHeight() - newHeight;
		}
		if ((x + newWidth) > biFrontendOriginal.getWidth()) {
			x = biFrontendOriginal.getWidth() - newWidth;
		}

		if (newHeight > y) {
			y = newHeight;
		}
		if (newWidth > x) {
			x = newWidth;
		}

		g.drawImage(biFrontendOriginal, 0, 0, this.getWidth(),
				this.getHeight(), x - newWidth, y - newHeight, x + newWidth, y
						+ newHeight, null);

	}

	public void mouseClicked(MouseEvent arg0) {
		Graphics2D g = (Graphics2D) biBackend.getGraphics();

		g.drawImage(biBackendOriginal, 0, 0, this.getWidth(), this.getWidth(),
				x - newWidth, y - newHeight, x + newWidth, y + newHeight * 2,
				null);
		Color target = new Color(biBackend.getRGB(
				(arg0.getX() + sliderX.getValue()),
				(arg0.getY() + sliderY.getValue())));
		System.out.println("Red:" + target.getRed() + " Green:"
				+ target.getGreen() + " Blue:" + target.getBlue());
		System.out.println(map2.get(target));

		// ********************************************************
		// Hier Code einfügen!
		// target ist die ausgewählte Provinz
		// map2.get(target) ist die gespeicherte ID für die Provinz
		// ********************************************************

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {
		drag = arg0.getPoint();

	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void mouseDragged(MouseEvent e) {

		float factor = (float) newWidth / (float) this.getWidth();
		factor = factor * 2;

		x = -(int) ((e.getX() - drag.getX()) * factor) + x;
		y = -(int) ((e.getY() - drag.getY()) * factor) + y;

		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;

		drag = e.getPoint();
		repaint();

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		zoomFactorSelected = zoomFactorSelected + zoomFactor
				* e.getWheelRotation();
		if (zoomFactorSelected < 0.1)
			zoomFactorSelected = 0.1f;
		if (zoomFactorSelected > 0.5)
			zoomFactorSelected = 0.5f;
		repaint();
	}
}
