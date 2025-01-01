package swingex;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import task3.BankATM;

public class ATMInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
    private JTextField amountField;
	private JTextArea transactionArea;
    private BankATM bankAtm;
    private String correctPin="1234";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ATMInterface();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ATMInterface() {
		bankAtm=new BankATM(1000);

	       frame=new JFrame("ATM System");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setSize(600,600);
	       frame.setLayout(new BorderLayout());

	       String enteredPin=JOptionPane.showInputDialog("Enter the ATM Pin: ");
	       if (enteredPin == null || !enteredPin.equals(correctPin)) {
	            JOptionPane.showMessageDialog(frame, "Incorrect PIN. Closing the application.");
	            System.exit(0); // Close the application if the PIN is incorrect
	       }

	       JPanel panel=new JPanel();
	       panel.setLayout(new GridLayout(6,2,5,5));

	       JLabel label=new JLabel("Amount: ");
	       amountField=new JTextField();
	       
	       JButton depositButton=new JButton("Deposit");
	       JButton withdrawButton=new JButton("Withdraw");
	       JButton transferButton=new JButton("Transfer");
	       JButton checkBalButton=new JButton("Check Balance");
	      
	       transactionArea=new JTextArea(10,30);
	       transactionArea.setEditable(false);
	        
	       label.setFont(new Font("Times New Roman", Font.BOLD, 20));
	       amountField.setFont(new Font("Times New Roman", Font.BOLD, 20));
	       depositButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	       withdrawButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	       transferButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	       checkBalButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	       transactionArea.setFont(new Font("Times New Roman", Font.BOLD, 20));

	       panel.add(label);
	       panel.add(amountField);
	       panel.add(depositButton);
	       panel.add(withdrawButton);
	       panel.add(transferButton);
	       panel.add(checkBalButton);

	       frame.add(panel,BorderLayout.CENTER);
	       frame.add(new JScrollPane(transactionArea),BorderLayout.SOUTH);

	       depositButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e){
	               try{
	                   double amount=Double.parseDouble(amountField.getText());
	                   bankAtm.deposit(amount);
	                   transactionArea.append("Deposited: $" + amount + "\n");
	                   amountField.setText("");
	               }
	               catch(NumberFormatException ex){
	                   JOptionPane.showMessageDialog(frame,"Invalid Amount.");
	               }
	           }
	       });

	       withdrawButton.addActionListener(new ActionListener(){
	           public void actionPerformed(ActionEvent e){
	               try{
	                   double amount=Double.parseDouble(amountField.getText());
	                   bankAtm.withdraw(amount);
	                   transactionArea.append("Withdrew: $" + amount + "\n");
	                   amountField.setText("");   
	               }
	               catch(NumberFormatException ex){
	                   JOptionPane.showMessageDialog(frame,"Invalid Amount.");
	               }
	           }
	       });

	       transferButton.addActionListener(new ActionListener(){
	           public void actionPerformed(ActionEvent e){
	              try{
	                  double amount=Double.parseDouble(amountField.getText());
	                  String receipent=JOptionPane.showInputDialog("Enter receipent account number: ");
	                  bankAtm.transfer(amount,receipent);
	                  transactionArea.append("Transferred: $" + amount + " to account "+ receipent + "\n");
	                  amountField.setText("");
	              }
	              catch(NumberFormatException ex){
	                  JOptionPane.showMessageDialog(frame,"Invalid Amount.");
	              }
	           }
	       });

	       checkBalButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e){
	                transactionArea.append("Balance: $" + bankAtm.getBalance() + "\n");
	           }
	       });

	       frame.setVisible(true);
	}
}
