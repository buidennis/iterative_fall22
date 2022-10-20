import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImageInterpolation {
	public static void main(String s[]) {
		JFrame frame = new JFrame("JFrame Example");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("JFrame By Example");
		JButton button = new JButton();
		button.setText("Button");
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("src/background.png"));
			ImageIcon newIcon = new ImageIcon(myPicture);
			JLabel picLabel = new JLabel(newIcon);
			panel.add(picLabel);		
			button.addActionListener(ae -> {
				if(picLabel.isVisible()){
					picLabel.setVisible(false);
				}
				else{
					picLabel.setVisible(true);
				}
			});
		} catch (IOException e) {
			System.out.println("Image file could not be found");
			e.printStackTrace();
		}

		
		panel.add(label);
		panel.add(button);
		frame.add(panel);
		frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
}
//https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
//https://www.tabnine.com/code/java/methods/javax.swing.JLabel/isVisible