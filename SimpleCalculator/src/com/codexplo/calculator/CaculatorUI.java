package com.codexplo.calculator;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class CaculatorUI extends JFrame implements ActionListener {

	// Constant
	private final static Font BIGGER_FONT = new Font("monspaced", Font.PLAIN,
			20);
	private final static String buttonOrder = "789/456*123-0.=+";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDisplay;
	private JPanel extraKeyPanel;
	private JButton btnClear;

	// here is some flag used different purpose
	private boolean addition = false; // while true program perform addition
	private boolean substraction = false; // while true program perform
											// subtraction
	private boolean multiplication = false; // while true program perform
	// multiplication
	private boolean divition = false; // while true program perform division
	private final boolean startNumber = true; // decided to use for further
	// development. here actually no use
	// it..
	private boolean dotCheck = false;// if it is false we can put dot otherwise
	// not..

	private String firstValue, Secondvalue; // here our all operation between
	private CaculatorLogic calcLogic = new CaculatorLogic();
	private JLabel lblCurrentOperation;
	private JLabel lblOpration;

	/**
	 * Create the frame.
	 */
	public CaculatorUI() {

		setTitle("Simple Calculator");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		txtDisplay = new JTextField("", 12);
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
		txtDisplay.setFont(BIGGER_FONT);

		contentPane.add(txtDisplay, BorderLayout.NORTH);
		txtDisplay.setColumns(10);

		JPanel keyPanel = new JPanel();
		contentPane.add(keyPanel, BorderLayout.CENTER);
		keyPanel.setLayout(new GridLayout(0, 4, 10, 10));

		extraKeyPanel = new JPanel();
		contentPane.add(extraKeyPanel, BorderLayout.SOUTH);

		btnClear = new JButton("Clear");
		extraKeyPanel.add(btnClear);

		lblCurrentOperation = new JLabel("Current Operation: ");
		extraKeyPanel.add(lblCurrentOperation);

		lblOpration = new JLabel("");
		extraKeyPanel.add(lblOpration);
		btnClear.addActionListener(this);

		for (int i = 0; i < buttonOrder.length(); i++) {
			String keyName = buttonOrder.substring(i, i + 1);
			JButton key = new JButton(keyName);
			keyPanel.add(key);
			key.addActionListener(this);
		}

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				areYouSureAboutClosingWindow();
			}
		});
	}

	// this method will prompt a dialog box to user to be sure about exit.. ?
	protected void areYouSureAboutClosingWindow() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this,
				"Are you sure?", "Exit ?", JOptionPane.OK_CANCEL_OPTION)) {
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * here is some if else condition ... if startNumber is true then we can
		 * add some value in the txtDisplay to perform our operation
		 */
		if (e.getActionCommand().endsWith("7")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "7");
			}
		} else if (e.getActionCommand().endsWith("8")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "8");
			}
		} else if (e.getActionCommand().endsWith("9")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "9");
			}
		} else if (e.getActionCommand().endsWith("4")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "4");
			}
		} else if (e.getActionCommand().endsWith("5")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "5");
			}
		} else if (e.getActionCommand().endsWith("6")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "6");
			}
		} else if (e.getActionCommand().endsWith("3")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "3");
			}
		} else if (e.getActionCommand().endsWith("2")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "2");
			}
		} else if (e.getActionCommand().endsWith("1")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "1");
			}
		} else if (e.getActionCommand().endsWith("0")) {
			if (startNumber) {
				txtDisplay.setText(txtDisplay.getText() + "0");
			}
		} else if (e.getActionCommand().endsWith(".")) {
			/*
			 * if dotCheck boolean type is false, then we can add a dot in the
			 * displayFiled otherwise not. it is used to avoid multiple dot in
			 * the displayFiled
			 */
			if (dotCheck == false) {
				dotCheck = true;
				txtDisplay.setText(txtDisplay.getText() + ".");
			}
		} else if (e.getActionCommand().endsWith("+")) {
			changeOperationalFlags(true, false, false, false, "+");

		} else if (e.getActionCommand().endsWith("-")) {
			changeOperationalFlags(false, true, false, false, "-");

		} else if (e.getActionCommand().endsWith("*")) {
			changeOperationalFlags(false, false, false, true, "*");

		} else if (e.getActionCommand().endsWith("/")) {
			changeOperationalFlags(false, false, true, false, "/");

		} else if (e.getActionCommand().endsWith("=")) {
			/***
			 * here we store the second value in the SecondValue String calling
			 * the getText() method
			 */
			
			if (txtDisplay.getText().equals(""))
				return;		// to avoid error when user click ¡°=¡± after operator without second Value
			
			Secondvalue = txtDisplay.getText();
			lblOpration.setText("=");

			/**
			 * here I've done some complex operation of java if additon flag is
			 * true then, we fist call the add() method from the CalculatorLogig
			 * class the method takes two variable that is double. but our value
			 * is String type. so we need to parse it in double. we call the
			 * method stringToDouble() from my CalculatorLogig class. it takes a
			 * string parameter and return double so now we get the result of
			 * add() method. now we need to display the result in our
			 * txtDisplay. our value is in double. so we need to make it String
			 * type. So here we called String.valueOf() method which is a static
			 * method of String class. it takes double parameter and returns
			 * String. lastly we display the result in the display area by
			 * calling setText() method from the JTextField class.
			 */

			/* we have done the same things for the rest of the operation */

			if (addition) {
				txtDisplay.setText(String.valueOf((calcLogic.add(
						calcLogic.stringToDouble(firstValue),
						calcLogic.stringToDouble(Secondvalue)))));
			} else if (substraction) {
				txtDisplay.setText(String.valueOf((calcLogic.substruct(
						calcLogic.stringToDouble(firstValue),
						calcLogic.stringToDouble(Secondvalue)))));
			} else if (divition) {
				txtDisplay.setText(String.valueOf((calcLogic.divide(
						calcLogic.stringToDouble(firstValue),
						calcLogic.stringToDouble(Secondvalue)))));
			} else if (multiplication) {
				txtDisplay.setText(String.valueOf((calcLogic.multiply(
						calcLogic.stringToDouble(firstValue),
						calcLogic.stringToDouble(Secondvalue)))));
			}
		} else if (e.getActionCommand().endsWith("Clear")) {
			// if clear button press, it clears the txtDisplays
			txtDisplay.setText("");
			lblOpration.setText("");
		}
	}

	/***
	 * here if the actionCommand is equal to "+" then, we need to perform
	 * addition . so first we store the first Value to firstValue String calling
	 * the getText() method and then clear the display area for next value and
	 * make the addition boolean type true so that we can perform addition and
	 * make the dotCheck variable false so that second value can contain dot
	 */

	private void changeOperationalFlags(boolean addition,
			boolean subustraction, boolean divition, boolean multiplication,
			String operation) {

		firstValue = txtDisplay.getText();
		txtDisplay.setText("");
		this.addition = addition;
		this.substraction = subustraction;
		this.divition = divition;
		this.multiplication = multiplication;
		dotCheck = false;
		lblOpration.setText(operation);
	}
}
