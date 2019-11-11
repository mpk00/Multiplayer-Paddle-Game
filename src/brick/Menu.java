package brick;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu extends JFrame {

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int response = JOptionPane.showConfirmDialog(null, "Do you actually want to play this game?", "", JOptionPane.YES_NO_OPTION);
					
					if(response > 0)
					{
						System.exit(0);
					}
					
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 557);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setBackground(Color.GREEN);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				
					JFrame obj = new JFrame();
					Gameplay gamePlay = new Gameplay();
					
					obj.setBounds(0, 0, 1500, 800);
					obj.setLocationRelativeTo(null);
					obj.setTitle("this game was made for learning purposes");
					obj.setResizable(false);
					obj.setVisible(true);
					obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					obj.getContentPane().add(gamePlay);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
		btnPlay.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 29));
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instructions lesson = new instructions();
				lesson.setVisible(true);
				lesson.setLocationRelativeTo(null);
			}
		});
		btnInstructions.setForeground(Color.WHITE);
		btnInstructions.setBackground(Color.RED);
		btnInstructions.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 16));
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settings difficulty = new settings();
				difficulty.setBounds(0,0, 431, 300);
				difficulty.setLocationRelativeTo(null);
				difficulty.setTitle("Adjust Difficulty");
				difficulty.setVisible(true);
				difficulty.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				difficulty.setResizable(false);
				//INCOMPLETE , settings must be able to modify the values of the ball and paddle in gameplay.java
				
			}
		});
		btnSettings.setForeground(Color.BLACK);
		btnSettings.setBackground(Color.YELLOW);
		btnSettings.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 19));
		
		JLabel lblMosesPark = new JLabel("Your screen resolution should be at least 1500 x 800 ");
		lblMosesPark.setForeground(Color.WHITE);
		lblMosesPark.setBackground(Color.BLACK);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(140, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnInstructions, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addGap(138))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblMosesPark, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(btnInstructions, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
					.addComponent(lblMosesPark)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
}
