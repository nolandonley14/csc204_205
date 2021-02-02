import java.io.FileNotFoundException;

import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.util.Scanner;


public class BuyAPhone {
	
	static String firstName;
	static ArrayList<String> phones = new ArrayList<String>();
	static ArrayList<Double> price1 = new ArrayList<Double>();
	static ArrayList<Double> price2 = new ArrayList<Double>();
	static ImageIcon[] phonePictures = new ImageIcon[4];
	static String[] areaCodes = new String[4];
	
	// #7 Beautify your GUIs by using a store logo. 
	static ImageIcon icon = new ImageIcon("phoneStoreLogo.png");
	static File phoneInfo = new File("phoneinfo.txt");

	public static void main(String[] args) throws FileNotFoundException {
	
		// #3 Read phone data from a text file and parse useful information for later usage.
		
		Scanner scan = new Scanner(phoneInfo);
		String line;
		int j = 0;
		int k = 0;
		
		while (scan.hasNextLine())
		{
			line = scan.nextLine();
	
			if (line.startsWith("Smart") || line.startsWith("Area"))
			{
				continue;
			}
			else if ((Character.isDigit(line.charAt(0))))
			{
				areaCodes[j] = line; 
				j++;
			}
			else
			{
				String[] readLine = line.split(", ");
				phones.add(readLine[0]);
				price1.add(Double.valueOf(readLine[1]));
				price2.add(Double.valueOf(readLine[2]));
				ImageIcon icon = new ImageIcon(readLine[3]);
				phonePictures[k] = icon;
				k++;
				continue;
			}
			
		}
		
		// #1 Prompt the customer for name and say hello with only first name.
		
		getName();
		
		// #2 Ask the customer if a contract is needed
			if (startSequence() == 0)
			{
				int answer = 0;
				while (answer != 1)
				{
					// #4 Present phone models with appropriate prices to the customer
					int contractNumber = contract();
			
					if (contractNumber == 0)
					{
						String selection = (String) JOptionPane.showInputDialog(null, "Please select a phone:", "Phone Selection",
							JOptionPane.PLAIN_MESSAGE, icon, phonesWithContract(), null);
						if (selection == null)
						{
							JOptionPane.showMessageDialog(null, "Transaction Canceled.", "Cancel", JOptionPane.WARNING_MESSAGE, null);
							answer = 1;
							continue;
						}
						
						// #5 Present area code options to the customer
			
						int code = chooseAreaCode();
				
						// #6 Show invoice to the customer with all information from the previous steps.
						int invoice = showInvoice(selection, code);
						if (invoice == 1)
						{
							answer = 1;
						}
						else {
							answer = startOver();
						}
					}
					else if (contractNumber == 1)
					{
						String selection = (String) JOptionPane.showInputDialog(null, "Please select a phone:", "Phone Selection",
							JOptionPane.PLAIN_MESSAGE, icon, phonesWithOutContract(), phonesWithOutContract()[0]);
						if (selection == null)
						{
							JOptionPane.showMessageDialog(null, "Transaction Canceled.", "Cancel", JOptionPane.WARNING_MESSAGE, null);
							answer = 1;
							continue;
						}
						
						int code = chooseAreaCode();
						int invoice = showInvoice(selection, code);
						if (invoice == 1)
						{
							answer = 1;
						}
						else
						{
							answer = startOver();
						}
					}
					else
					{
						System.out.println("Error Occured");
						answer = 1;
					}
				}		
			}
	}
	
	public static String getName() {
	
		String name = (String) JOptionPane.showInputDialog(null, "What is your name?", "Nolan's Phone Store",
				JOptionPane.OK_CANCEL_OPTION, icon, null, null);
		firstName = name.split(" ")[0];
		return firstName;
		
	}
	
	public static int startSequence() {
		
		String[] buttons = {"Yes", "No"};
		int start = (int) JOptionPane.showOptionDialog(null, "Hello " + firstName +  "! Would you like to buy a phone today?",
				"Welcome",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, buttons, 0);
		return start;
	}

	public static int contract() {
		
		String[] buttons = {"Yes", "No"};
		int needContract = (int) JOptionPane.showOptionDialog(null, "Would you like to start a contract with us\n today to experience lower phone prices?",
				"Nolan's Phone Store",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, buttons, 0);
		return needContract;
	}

	public static String[] phonesWithContract() {
		
		String[] phoneModels = {"" + phones.get(0) + " - $" + price2.get(0),
				"" + phones.get(1) + " - $" + price2.get(1),
				"" + phones.get(2) + " - $" + price2.get(2),
				"" + phones.get(3) + " - $" + price2.get(3)};
		return phoneModels;
		
	}
	
	public static String[] phonesWithOutContract() {
		
		String[] phoneModels = {"" + phones.get(0) + " - $" + price1.get(0),
				"" + phones.get(1) + " - $" + price1.get(1),
				"" + phones.get(2) + " - $" + price1.get(2),
				"" + phones.get(3) + " - $" + price1.get(3)};
		return phoneModels;
	}

	public static int chooseAreaCode() {
		
		int code = JOptionPane.showOptionDialog(null, "Please select an area code from below",
				"Area Code Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, areaCodes, null);
		return Integer.valueOf(areaCodes[code]);
		
	}
	
	public static int showInvoice(String s, int i)	{
		
		String[] yes = {"Okay"};
		int number1 = (int) (900 * Math.random() + 100);
		int number2 = (int) (9000 * Math.random() + 1000
				);
		int invoice = JOptionPane.showOptionDialog(null, "Congratulations, " + firstName + "!\nYour new phone is the " + s + "."
				+ "\nAnd your new phone number is " + i + "-" + number1 + "-" + number2 + "!",
				"Congratulations!", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, yes, null);
		System.out.println(invoice);
		if (invoice == -1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static int startOver() {
		
		String[] buttons = {"Yes", "No"};
		int startover = JOptionPane.showOptionDialog(null, "Would you like to buy another phone " + firstName + "?",
				"Awesome Smartphone", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, buttons, null);
		if (startover == -1)
		{
			return 1;
		}
		return startover;
	}
	
}
