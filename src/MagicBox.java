/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MagicBox extends JPanel implements Runnable, MouseListener {

	/*
	 * Work together as a TEAM of 2 or 3 to make this project. We are going to hide secrets within the magic box. 
	 * When the user clicks on a secret place, stuff will happen.
	 * 
	 * 1. Make the frame respond to mouse clicks.
	 * 
	 * 2. When the mouse is clicked, use the Media Palace (bit.ly/media-palace) to play sounds, show images or speak.
	 * 
	 * 3. backgroundImage.getRGB(keyEvent.getX(), keyEvent.getY()) will give you the color of the current pixel.
	 */

	BufferedImage backgroundImage;

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new MagicBox());
		
		
		
		
	}

	@Override
	public void run() {
		try {
			loadBackgroundImage();
			createUI();
		} catch (Exception w) {
			System.err.println(w.getMessage());
		}
	}
	Image img;
	private void createUI() {
		MediaPalace media = new MediaPalace();
		JFrame frame = new JFrame("The Magic Box contains many secrets...");
		frame.add(this);
		img  = backgroundImage.getScaledInstance(500, 750, 0);
		setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
		frame.addMouseListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void loadBackgroundImage() throws Exception {
		String imageFile = "src/magic-box.jpg";
		try {
			backgroundImage = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			throw new Exception("Could not load image: " + imageFile);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null); 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int mX = e.getX();
		int mY = e.getY();
		System.out.println(mY + "Y and " + mX + "X");
		if (mX >= 140 && mX <= 160 && mY >= 530 && mY <= 570  ) {
			System.out.println("Eligha is gay.");
			speak("Ur mum heterosexual"); //
		}
		if (mX >= 143 && mX <= 168 && mY >= 332 && mY <= 359  ) {
			System.out.println("Eligha is gay.");
			speak("Ur mum very nice lady"); //
		}
		if (mX >= 269 && mX <= 264 && mY >= 410 && mY <= 393  ) {
			System.out.println("Eligha is gay.");
			speak("Gateway to 6:30 coding class: aka hell"); //
		}
	
	}// there are 10 kinds of people in the world. people who undertsand binary, and the people who don't.

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


