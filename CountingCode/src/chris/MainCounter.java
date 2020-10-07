package chris;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainCounter {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCounter window = new MainCounter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainCounter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Choose a .java file to count lines of code, for, if, while, and switch statements");
		lblNewLabel.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lines of Code: ");
		lblNewLabel_1.setBounds(28, 90, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(117, 90, 149, 14);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("if's");
		lblNewLabel_2.setBounds(26, 115, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("for's");
		lblNewLabel_3.setBounds(26, 140, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("while's");
		lblNewLabel_4.setBounds(26, 165, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Switch's");
		lblNewLabel_5.setBounds(26, 190, 59, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(117, 115, 149, 14);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(117, 140, 149, 14);
		frame.getContentPane().add(textArea_1_1);
		
		JTextArea textArea_1_1_1 = new JTextArea();
		textArea_1_1_1.setBounds(117, 165, 149, 14);
		frame.getContentPane().add(textArea_1_1_1);
		
		JTextArea textArea_1_1_2 = new JTextArea();
		textArea_1_1_2.setBounds(117, 190, 149, 14);
		frame.getContentPane().add(textArea_1_1_2);
		
		JButton btnNewButton = new JButton("Press Please?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int result = fc.showOpenDialog(null);
				if(result == fc.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					String countedLines;
					String countedIfs;
					String countedFors;
					String countedWhiles;
					String countedSwitches;
					try {
						Counter.countLoops(file);
						countedLines = Integer.toString(Counter.countLines(file));
						countedIfs =  Integer.toString(Counter.getIfs());
						countedFors = Integer.toString(Counter.getFors());
						countedWhiles = Integer.toString(Counter.getWhiles());
						countedSwitches = Integer.toString(Counter.getSwitches());
						textArea.setText(countedLines);
						textArea_1.setText(countedIfs);
						textArea_1_1.setText(countedFors);
						textArea_1_1_1.setText(countedWhiles);
						textArea_1_1_2.setText(countedSwitches);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setBounds(147, 36, 119, 32);
		frame.getContentPane().add(btnNewButton);
	}
}
