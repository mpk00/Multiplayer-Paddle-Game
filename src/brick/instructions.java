package brick;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class instructions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructions frame = new instructions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public instructions() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 467);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Instructions");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1 = new JLabel("This game was intended to be single player, but it can played with two people if desired ");
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_2 = new JLabel("The ball will bounce if it comes into contact with either the tiles or the paddle");
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("The objective of the game is to break all of the tiles and prevent the ball from falling");
		lblNewLabel_3.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_4 = new JLabel("by controlling the 2 paddles");
		lblNewLabel_4.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_5 = new JLabel("\"A\" and \"D\" move the green paddle left and right, respectively");
		lblNewLabel_5.setForeground(Color.WHITE);
		
		JLabel lblLeftAndRight = new JLabel("Left and Right arrow keys move the red paddle left and right, respectively");
		lblLeftAndRight.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_6 = new JLabel("To start the game, move any of the paddles ");
		lblNewLabel_6.setForeground(Color.WHITE);
		
		JLabel lblBothPaddlesCannot = new JLabel("Both paddles cannot be moved at the same time. ");
		lblBothPaddlesCannot.setForeground(Color.WHITE);
		
		JLabel lblHoweverBothPaddles = new JLabel("However, both paddles can be tapped quickly in unison");
		lblHoweverBothPaddles.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLeftAndRight, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBothPaddlesCannot, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHoweverBothPaddles, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addGap(18)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblLeftAndRight)
					.addGap(18)
					.addComponent(lblNewLabel_6)
					.addGap(18)
					.addComponent(lblBothPaddlesCannot)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblHoweverBothPaddles)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
