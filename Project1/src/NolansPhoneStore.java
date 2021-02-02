import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

public class NolansPhoneStore {
	
	static String firstName;
	static ImageIcon icon = new ImageIcon("phoneStoreLogo.png");
	private static ArrayList<String> model = new ArrayList<String>();
	private static ArrayList<Double> phonePrice1 = new ArrayList<Double>();
	private static ArrayList<Double> phonePrice2 = new ArrayList<Double>();
	private static String[] phonePictures = new String[5];
	private static String[] areaCodes = new String[4];
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File phoneinfo = new File("phoneinfo.txt");
		Scanner scan = new Scanner(phoneinfo);
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
				model.add(readLine[0]);
				phonePrice1.add(Double.valueOf(readLine[1]));
				phonePrice2.add(Double.valueOf(readLine[2]));
				String icon = new String(readLine[3]);
				phonePictures[k] = icon;
				k++;
				continue;
			}
			
		}
		
		// some formatting for the JOptionPane
		UIManager.put("OptionPane.background", Color.DARK_GRAY);
		UIManager.put("Panel.background", Color.DARK_GRAY);
		UIManager.put("OptionPane.messageFont", new Font("Trivial-Light", Font.PLAIN, 16));
		UIManager.put("OptionPane.messageForeground", Color.white);
		
		
		// ask for the users name and if they want to buy a phone. If they want to buy a phone start
		// phone sequence. Else, exit.
		int answer = beginningQuestion();
		
		while (answer == 0)
		{
			answer = phoneSequence();
		}
	}
	
	// method that asks for the users name, greets them by first name and asks if they want to buy a phone
	public static int beginningQuestion() {
		
		int start;
		String name;
		
		name = (String) JOptionPane.showInputDialog(null, "What is your name?", "Welcome to Nolan's Phone Store",
				JOptionPane.QUESTION_MESSAGE, icon, null, null);
		firstName = name.split(" ")[0];
		
		if (firstName != null)
		{
			start = JOptionPane.showOptionDialog(null, "Hi " + firstName + "! Would you like\nto purchase a phone today?",
				"Nolan's Phone Store", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
			return start;
		}
		else
		{
			return 1;
		}
	}
	
	/* 
	 * 	method that runs the rest of the phone buying experience. 
	 * 	First, it determines if they need a contract. Then it runs the appropriate contract method.
	 * 	The return of the contract is an int which answers whether the user wants another phone or not
	 * 	the return of this phoneSequence method determines if the process restarts or not.
	 */
	
	public static int phoneSequence() throws FileNotFoundException {
		
		int contract;
		
		contract = JOptionPane.showOptionDialog(null, "Do you need a contract?", "Nolan's Phone Store",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon,  null, 0);
		
		if (contract == 0)
		{
			return withContract();
		}
		else if (contract == 1)
		{
			return withoutContract();
		}
		else
		{
			return cancel();
		}
	}
	
	/*
	 * This method asks which phone the user wants by showing the options based upon their contract preferences
	 * Depending on the selection, the phones image is displayed. If they cancel a cancelation dialog is shown
	 * Then the area code selection is presented. Upon area code selection, the invoice is shown summarizing 
	 * their new purchase. Then they're asked if they want to buy another phone. their answer is returned.
	 */
	
	public static int withContract() {
		{
			String choice;
			int startover;
			ImageIcon picture;
			int selectedCode;
			int number1 = (int) (900 * Math.random() + 100);
			int number2 = (int) (9000 * Math.random() + 1000);
			String[] choices = modelsForContract();
			
			// asks which phone the user wants by showing the options based upon their contract preferences
			
			choice = (String) JOptionPane.showInputDialog(null, "Which phone whould you like?", "Phone Selection", 
					JOptionPane.QUESTION_MESSAGE, icon, choices, null);
			
			// Depending on the selection, the phones image is displayed.
			if (choice == choices[0])
			{
				picture = new ImageIcon("galaxyS9.png");
			}
			else if (choice == choices[1])
			{
				picture = new ImageIcon("iphoneX.png");
			}
			else if (choice == choices[2])
			{
				picture = new ImageIcon("googlePixel.png");
			}
			else if (choice == choices[3])
			{
				picture = new ImageIcon("Motorola.png");
			}
			else if (choice == choices[4])
			{
				System.out.print("HI");
				picture = new ImageIcon("Huawei.png");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Transaction Canceled.", "Cancel", JOptionPane.WARNING_MESSAGE, null);
				selectedCode = 0;
				picture = new ImageIcon("phoneStoreLogo.png");
				return 1;
			}
			
			// Then the area code selection is presented.
			selectedCode = JOptionPane.showOptionDialog(null, "Please select an area code from below",
					"Area Code Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, picture, areaCodes, areaCodes[0]);
			
			UIManager.put("OptionPane.informationIcon", picture);
			
			JOptionPane.showMessageDialog(null, "Congratulations, " + firstName + "!\nYour new phone is the " + choice + "."
					+ "\nAnd your new phone number is " + areaCodes[selectedCode] + "-" + number1 + "-" + number2 + "!",
					"Congratulations!", JOptionPane.INFORMATION_MESSAGE, null);
			
			startover = JOptionPane.showOptionDialog(null, "Would you like to buy another phone " + firstName + "?",
					"Awesome Smartphone", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, 0);
			
			if (startover == 1)
			{
				picture = new ImageIcon("phoneStoreLogo.png");
				UIManager.put("OptionPane.informationIcon", picture);
				JOptionPane.showMessageDialog(null, "Thank you for your business!",
						"Thank You!", JOptionPane.INFORMATION_MESSAGE, null);
			}
			return startover;
		}
	}
	
	/*
	 * This method asks which phone the user wants by showing the options based upon their contract preferences
	 * Depending on the selection, the phones image is displayed. If they cancel a cancelation dialog is shown
	 * Then the area code selection is presented. Upon area code selection, the invoice is shown summarizing 
	 * their new purchase. Then they're asked if they want to buy another phone. their answer is returned.
	 */
	
	public static int withoutContract() {
		{
			String choice;
			int startover;
			ImageIcon picture;
			int selectedCode;
			int number1 = (int) (1000 * Math.random());
			int number2 = (int) (10000 * Math.random());
			String[] choices = modelsForNoContract();
			
			choice = (String) JOptionPane.showInputDialog(null, "Which phone whould you like?", "Phone Selection", 
					JOptionPane.QUESTION_MESSAGE, icon, choices, null);
			
			if (choice == choices[0])
			{
				picture = new ImageIcon("galaxyS9.png");
			}
			else if (choice == choices[1])
			{
				picture = new ImageIcon("iphoneX.png");
			}
			else if (choice == choices[2])
			{
				picture = new ImageIcon("googlePixel.png");
			}
			else if (choice == choices[3])
			{
				picture = new ImageIcon("Motorola.png");
			}
			else if (choice == choices[4])
			{
				picture = new ImageIcon("Hauwei.png");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Transaction Canceled.", "Cancel", JOptionPane.WARNING_MESSAGE, null);
				selectedCode = 0;
				picture = new ImageIcon("phoneStoreLogo.png");
				return 1;
			}
			
			selectedCode = JOptionPane.showOptionDialog(null, "Please select an area code from below",
					"Area Code Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, picture, areaCodes, areaCodes[0]);
			
			UIManager.put("OptionPane.informationIcon", picture);
			
			JOptionPane.showMessageDialog(null, "Congratulations, " + firstName + "!\nYour new phone is the " + choice + "."
					+ "\nAnd your new phone number is " + areaCodes[selectedCode] + "-" + number1 + "-" + number2 + "!",
					"Congratulations!", JOptionPane.INFORMATION_MESSAGE, null);
			
			startover = JOptionPane.showOptionDialog(null, "Would you like to buy another phone " + firstName + "?",
					"Awesome Smartphone", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, 0);
			
			if (startover == 1)
			{
				picture = new ImageIcon("phoneStoreLogo.png");
				UIManager.put("OptionPane.informationIcon", picture);
				JOptionPane.showMessageDialog(null, "Thank you for your business!",
						"Thank You!", JOptionPane.INFORMATION_MESSAGE, null);
			}
			
			return startover;
		}
	}
	
	
	// this method is for whenever the users cancels throughout the process
	public static int cancel() {
		UIManager.put("OptionPane.warningIcon", icon);
		JOptionPane.showMessageDialog(null, "Transaction Canceled.", "Cancel", JOptionPane.WARNING_MESSAGE, null);
		return 1;
	}
	
	// this method returns a string array of appropriate priced phone models from PhoneModel.java 
	
	public static String[] modelsForContract() {
		
		PhoneModel samsung = new PhoneModel(model.get(0), phonePrice1.get(0), phonePrice2.get(0), phonePictures[0]);
		PhoneModel iphone = new PhoneModel(model.get(1), phonePrice1.get(1), phonePrice2.get(1), phonePictures[1]);
		PhoneModel pixel = new PhoneModel(model.get(2), phonePrice1.get(2), phonePrice2.get(2), phonePictures[2]);
		PhoneModel motorola = new PhoneModel(model.get(3), phonePrice1.get(3), phonePrice2.get(3), phonePictures[3]);
		PhoneModel hauwei = new PhoneModel(model.get(4), phonePrice1.get(4), phonePrice2.get(4), phonePictures[4]);
		
		String[] models = {"" + samsung.getName() + " - $" + samsung.getPriceWithContract(), "" +
				iphone.getName() + " - $" + iphone.getPriceWithContract(),
				"" + pixel.getName() + " - $" + pixel.getPriceWithContract(),
				"" + motorola.getName() + " - $" + motorola.getPriceWithContract(),
				"" + hauwei.getName() + " - $" + hauwei.getPriceWithContract()}; 
		
		return models;
	}
	
	// this method returns a string array of appropriate priced phone models from PhoneModel.java
	
	public static String[] modelsForNoContract() {
		
		PhoneModel samsung = new PhoneModel(model.get(0), phonePrice1.get(0), phonePrice2.get(0), phonePictures[0]);
		PhoneModel iphone = new PhoneModel(model.get(1), phonePrice1.get(1), phonePrice2.get(1), phonePictures[1]);
		PhoneModel pixel = new PhoneModel(model.get(2), phonePrice1.get(2), phonePrice2.get(2), phonePictures[2]);
		PhoneModel motorola = new PhoneModel(model.get(3), phonePrice1.get(3), phonePrice2.get(3), phonePictures[3]);
		PhoneModel hauwei = new PhoneModel(model.get(4), phonePrice1.get(4), phonePrice2.get(4), phonePictures[4]);
		
		String[] models = {"" + samsung.getName() + " - $" + samsung.getPriceWithoutContract(), "" +
				iphone.getName() + " - $" + iphone.getPriceWithoutContract(),
				"" + pixel.getName() + " - $" + pixel.getPriceWithoutContract(),
				"" + motorola.getName() + " - $" + motorola.getPriceWithoutContract(),
				"" + hauwei.getName() + " - $" + hauwei.getPriceWithoutContract()};  
		return models;
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	