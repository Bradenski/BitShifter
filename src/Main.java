/*		Braden Starcher | Bit Shifter 0.1 |
 *		Simple bit shifter. Mode radials dictate what value will be 
 *		accepted in the Second value field, only accepts 32-bit integers.
 *		4/10/2014 
 */		
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;


public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField byteField;
	private JTextField binaryField;
	private JTextField hexField;
	private JTextField secondValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBitshifter = new JLabel("BitShifter ");
		lblBitshifter.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		lblBitshifter.setBounds(13, 9, 153, 21);
		contentPane.add(lblBitshifter);
		
		final JRadioButton byteRadio = new JRadioButton("");
		byteRadio.setSelected(true);
		byteRadio.setBounds(319, 91, 137, 21);
		contentPane.add(byteRadio);
		
		final JRadioButton binaryRadio = new JRadioButton("");
		binaryRadio.setBounds(319, 171, 137, 21);
		contentPane.add(binaryRadio);		
		
		final JRadioButton hexRadio = new JRadioButton("");
		hexRadio.setBounds(319, 249, 33, 21);
		contentPane.add(hexRadio);	
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(binaryRadio);
		bGroup.add(byteRadio);
		bGroup.add(hexRadio);
																			//HELP MENU
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Help");       
        JMenuItem eMenuItem = new JMenuItem("Help");
        eMenuItem.setToolTipText("How to use this program");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	JOptionPane.showMessageDialog(null,
            		     "Enter a value into a field\n Select which radix you are converting from\n"
            			+"Select Convert to see the entered value in Integer, Binary, Hex radix\n"
            		    +"The mode you select also dictates what is input into the second value field for use of bitwise operations\n"
            			+"If you are not seeing expected results, consider that this program only works with 32-bit signed ints.", 
            		    "How to Use BitShifter",
            		    JOptionPane.PLAIN_MESSAGE);
            }
        });
        file.add(eMenuItem);
        menubar.add(file);
        setJMenuBar(menubar);        
        
		JLabel lblByte = new JLabel("Integer");
		lblByte.setBounds(195, 73, 54, 12);
		contentPane.add(lblByte);
		
		secondValue = new JTextField();
		secondValue.setBounds(13, 357, 260, 18);
		contentPane.add(secondValue);
		secondValue.setColumns(10);
		
		byteField = new JTextField();		
		byteField.setBounds(130, 94, 184, 18);
		contentPane.add(byteField);
		byteField.setColumns(10);
		
		JLabel lblBinary = new JLabel("Binary");
		lblBinary.setBounds(201, 151, 42, 12);
		contentPane.add(lblBinary);
		
		binaryField = new JTextField();
		binaryField.setColumns(10);
		binaryField.setBounds(130, 172, 184, 18);
		contentPane.add(binaryField);
		
		hexField = new JTextField();
		hexField.setColumns(10);
		hexField.setBounds(130, 250, 184, 18);
		contentPane.add(hexField);
		
		JLabel lblHex = new JLabel("Hex");
		lblHex.setBounds(205, 229, 33, 12);
		contentPane.add(lblHex);
																				//RIGHT SHIFT BUTTOn
		JButton rightShiftButton = new JButton(">>");
		rightShiftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(byteRadio.isSelected()) {
					int val = Integer.parseInt(byteField.getText());
					int i = Integer.parseInt(secondValue.getText());
					int product = val >> i; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if(binaryRadio.isSelected()) {
					int val = Integer.parseInt(binaryField.getText(), 2);
					int i = Integer.parseInt(secondValue.getText(), 2);
					int product = val >> i; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if(hexRadio.isSelected()) {
					int val = Integer.parseInt(hexField.getText(), 16);
					int i = Integer.parseInt(secondValue.getText(), 16);
					int product = val >> i; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}
				
			}
		});
		rightShiftButton.setBounds(13, 248, 70, 21);
		contentPane.add(rightShiftButton);
		
		JButton leftShiftButton = new JButton("<<");
		leftShiftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(byteRadio.isSelected()) {
					int val = Integer.parseInt(byteField.getText());
					int i = Integer.parseInt(secondValue.getText());
					int product = val << i; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if(binaryRadio.isSelected()) {
					int val = Integer.parseInt(binaryField.getText(), 2);
					int i = Integer.parseInt(secondValue.getText(), 2);
					int product = val << i; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if(hexRadio.isSelected()) {
					int val = Integer.parseInt(hexField.getText(), 16);
					int i = Integer.parseInt(secondValue.getText(), 16);
					int product = val << i; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}
			}
		});
		leftShiftButton.setBounds(13, 295, 70, 21);
		contentPane.add(leftShiftButton);
		
		ImageIcon bg = new ImageIcon("bitshifter.png");
																				//AND BUTTON
		JButton andButton = new JButton("AND");
		andButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(byteRadio.isSelected()) {
					int val1 = Integer.parseInt(byteField.getText());
					int val2 = Integer.parseInt(secondValue.getText());
					int product = val1 & val2;
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}
				else if(binaryRadio.isSelected()) {
					int val1 = Integer.parseInt(binaryField.getText(), 2);
					int val2 = Integer.parseInt(secondValue.getText(), 2);
					int product = val1 & val2; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));					
				}
				else if(hexRadio.isSelected()) {
					int val1 = Integer.parseInt(hexField.getText(), 16);
					int val2 = Integer.parseInt(secondValue.getText(), 16);
					int product = val1 & val2; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));					
				}
			}
		});
		andButton.setBounds(13, 60, 70, 21);
		contentPane.add(andButton);
																				//NOT BUTTON
		JButton notButton = new JButton("NOT");
		notButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(byteRadio.isSelected()) {
					int val = Integer.parseInt(byteField.getText());
					int product = -val-1; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}
				if(binaryRadio.isSelected()) {
					String binaryString = binaryField.getText();
					int val = Integer.parseInt(binaryString, 2);
					int product = -val-1; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}
				if(hexRadio.isSelected()) {
					String hexString = hexField.getText();
					int val = Integer.parseInt(hexString, 16);
					int product = -val-1; 
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}
			}
		});
		notButton.setBounds(12, 107, 70, 21);
		contentPane.add(notButton);
																					//OR BUTTOn
		JButton orButton = new JButton("OR");
		orButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (byteRadio.isSelected()) {
					int val1 = Integer.parseInt(byteField.getText());
					int val2 = Integer.parseInt(secondValue.getText());
					int product = val1 | val2;
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if (binaryRadio.isSelected()) {
					int val1 = Integer.parseInt(binaryField.getText(), 2);
					int val2 = Integer.parseInt(secondValue.getText(), 2);
					int product = val1 | val2;
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if (hexRadio.isSelected()) {
					int val1 = Integer.parseInt(hexField.getText(), 16);
					int val2 = Integer.parseInt(secondValue.getText(), 16);
					int product = val1 | val2;
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}

			}
		});
		orButton.setBounds(12, 154, 70, 21);
		contentPane.add(orButton);
																				//XOR BUTTON
		JButton xorButton = new JButton("XOR");
		xorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (byteRadio.isSelected()) {
					int val1 = Integer.parseInt(byteField.getText());
					int val2 = Integer.parseInt(secondValue.getText());
					int product = val1 ^ val2;
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if (binaryRadio.isSelected()) {
					int val1 = Integer.parseInt(binaryField.getText(), 2);
					int val2 = Integer.parseInt(secondValue.getText(), 2);
					int product = val1 ^ val2;
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				} else if (hexRadio.isSelected()) {
					int val1 = Integer.parseInt(hexField.getText(), 16);
					int val2 = Integer.parseInt(secondValue.getText(), 16);
					int product = val1 ^ val2;
					byteField.setText(String.valueOf(product));
					binaryField.setText(Integer.toBinaryString(product));
					hexField.setText(Integer.toHexString(product));
				}
			}
		});
		xorButton.setBounds(13, 201, 70, 21);
		contentPane.add(xorButton);
																					//CONVERTER BUTTON 
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(byteRadio.isSelected()) {
					int i = Integer.parseInt(byteField.getText());
					hexField.setText(Integer.toHexString(i));
					binaryField.setText(Integer.toBinaryString(i));					
				}
				else if(binaryRadio.isSelected()) {
					//binary to decimal 
					String binaryString = binaryField.getText();
					int decimal = Integer.parseInt(binaryString, 2);
					byteField.setText(String.valueOf(decimal));
					//binary to hex 
					String decimalString = byteField.getText();
					int hex = Integer.parseInt(decimalString);
					hexField.setText(Integer.toHexString(hex));				
				}
				else if(hexRadio.isSelected()) {
					String hex = hexField.getText();
					//hex to decimal 
					int decimal = Integer.parseInt(hex, 16);
					byteField.setText(String.valueOf(decimal));
					//hex to binary
					String binary = Integer.toBinaryString(decimal);
					binaryField.setText(binary);
					
				}
				
			}
		});
		btnConvert.setBounds(170, 295, 103, 21);
		contentPane.add(btnConvert);
		
		JLabel lblConvertFrom = new JLabel("Mode:");
		lblConvertFrom.setBounds(321, 73, 103, 12);
		contentPane.add(lblConvertFrom);
		
		JLabel lblOperateWith = new JLabel("Second value/bits to shift:");
		lblOperateWith.setFont(new Font("Lucida Console", Font.BOLD, 13));
		lblOperateWith.setBounds(13, 336, 243, 12);
		contentPane.add(lblOperateWith);
					
		JLabel bgLabel = new JLabel();
		bgLabel.setBounds(12, 150, 434, 311);
		bgLabel.setIcon(new ImageIcon("C:\\Java\\workspace\\BitShifter\\src\\bitshifter.png"));
		contentPane.add(bgLabel);
		
		JLabel lblFirstValue = new JLabel("First value:");
		lblFirstValue.setFont(new Font("Lucida Console", Font.BOLD, 13));
		lblFirstValue.setBounds(131, 49, 118, 12);
		contentPane.add(lblFirstValue);
		
				
		
	}
}
