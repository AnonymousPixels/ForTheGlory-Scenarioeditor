package test;

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

public class MapPanelOld extends JPanel implements MouseListener,
		MouseMotionListener, MouseWheelListener {

	BufferedImage biFrontend, biBackend, biFrontendOriginal, biBackendOriginal;
	JScrollBar sliderX, sliderY;
	JLabel image;
	Point drag;
	float zoomFactorSelected = 8;
	double[] zoomFactors = { 1, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2 };
	Map map2;

	public MapPanelOld(BufferedImage Frontend, BufferedImage Backend,
			Map<Color, Integer> map) {
		super();
		this.setOpaque(true);
		this.setLayout(null);
		map2 = map;
		biFrontend = biFrontendOriginal = Frontend;
		biBackend = biBackendOriginal = Backend;
		image = new JLabel(new ImageIcon(biFrontend));
		sliderX = new JScrollBar();
		sliderY = new JScrollBar();
		sliderY.setOrientation(SwingConstants.VERTICAL);
		sliderX.setOrientation(SwingConstants.HORIZONTAL);
		sliderX.setVisible(true);
		sliderY.setVisible(true);
		this.add(sliderX);
		this.add(sliderY);
		this.add(image);
		image.addMouseListener(this);
		image.addMouseMotionListener(this);
		image.addMouseWheelListener(this);
		mouseWheelMoved(new MouseWheelEvent(this, 1, 1, 1, 1, 1, 0, false, 0,
				0, 0));
		// generatePrerenderedImages();
	}

	public void paintComponent(Graphics g) {
		sliderY.setBounds(this.getWidth() - 20, 0, 20, this.getHeight() - 20);
		sliderX.setBounds(0, this.getHeight() - 20, this.getWidth() - 20, 20);
		image.setBounds(0, 0, this.getWidth() - 20, this.getHeight() - 20);
		sliderX.setMinimum(0);
		sliderX.setMaximum(biFrontend.getWidth() - this.getWidth());
		sliderY.setMinimum(0);
		sliderY.setMaximum(biFrontend.getHeight() - this.getHeight());
		int startX = sliderX.getValue();
		int startY = sliderY.getValue();
		int endX = this.getWidth();
		int endY = this.getHeight();

		image.setIcon(new ImageIcon(biFrontend.getSubimage(startX, startY,
				endX, endY)));
		super.paintComponent(g);
	}

	public void mouseClicked(MouseEvent arg0) {
//		System.out.println(sliderX.getMaximum());
//		System.out.println(sliderX.getValue());
//		System.out.println("X:" + (arg0.getX() + sliderX.getValue()));
//		System.out.println("Y:" + (arg0.getY() + sliderY.getValue()));
		Color target = new Color(biBackend.getRGB(
				(arg0.getX() + sliderX.getValue()),
				(arg0.getY() + sliderY.getValue())));
//		System.out.println("Red:" + target.getRed() + " Green:"
//				+ target.getGreen() + " Blue:" + target.getBlue());
//		System.out.println(map2.get(target));

		// ********************************************************
		// Hier Code einfügen!
		// target ist die ausgewählte Provinz
		// map2.get(target) ist die gespeicherte ID für die Provinz
		// ********************************************************

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		drag = arg0.getPoint();

	}

	public void mouseReleased(MouseEvent arg0) {

	}

	public void mouseDragged(MouseEvent e) {
		int x = -(int) (e.getX() - drag.getX()) + sliderX.getValue();
		int y = -(int) (e.getY() - drag.getY()) + sliderY.getValue();
		x = (int) ((double) x);
		y = (int) ((double) y);
		if (x > sliderX.getMaximum())
			x = sliderX.getMaximum();
		if (y > sliderY.getMaximum())
			y = sliderY.getMaximum();

		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		sliderX.setValue(x);
		sliderY.setValue(y);
//		System.out.println(x);
		drag = e.getPoint();

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		float formerZoomFactorSelected = zoomFactorSelected;
		zoomFactorSelected = zoomFactorSelected + e.getWheelRotation();
		if (zoomFactorSelected < 0)
			zoomFactorSelected = 0;

		if (zoomFactorSelected >= zoomFactors.length)
			zoomFactorSelected = zoomFactors.length - 1;
		sliderX.setValue((int) (sliderX.getValue()
				* zoomFactors[(int) zoomFactorSelected] / zoomFactors[(int) formerZoomFactorSelected]));
		sliderY.setValue((int) (sliderY.getValue()
				* zoomFactors[(int) zoomFactorSelected] / zoomFactors[(int) formerZoomFactorSelected]));
		biFrontend = null;
		biBackend = null;
		if (zoomFactors[(int) zoomFactorSelected] == 1) {
			biFrontend = biFrontendOriginal;
			biBackend = biBackendOriginal;
		} else {
			int newImageWidth = (int) (biFrontendOriginal.getWidth() * zoomFactors[(int) zoomFactorSelected]);
			int newImageHeight = (int) (biFrontendOriginal.getHeight() * zoomFactors[(int) zoomFactorSelected]);
			biFrontend = new BufferedImage(newImageWidth, newImageHeight,
					biFrontendOriginal.getType());
			Graphics2D g = biFrontend.createGraphics();
			g.drawImage(biFrontendOriginal, 0, 0, newImageWidth,
					newImageHeight, null);
			g.dispose();
			g = null;

			biBackend = new BufferedImage(newImageWidth, newImageHeight,
					biFrontendOriginal.getType());
			Graphics2D g2 = biBackend.createGraphics();
			g2.drawImage(biBackendOriginal, 0, 0, newImageWidth,
					newImageHeight, null);
			g2.dispose();
			g2 = null;
		}
	}
}
