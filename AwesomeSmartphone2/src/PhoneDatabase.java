import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class PhoneDatabase {

	
	public static ArrayList<String> model = new ArrayList<String>();
	public static ArrayList<Double> basePrice = new ArrayList<Double>();
	public static ArrayList<Double> contractPrice = new ArrayList<Double>();
	public static String[] phonePictures = new String[5];
	public static String[] areaCodes = new String[5];
	
	public void getPhones() throws FileNotFoundException {
		
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
				basePrice.add(Double.valueOf(readLine[1]));
				contractPrice.add(Double.valueOf(readLine[2]));
				String icon = new String(readLine[3]);
				phonePictures[k] = icon;
				k++;
				continue;
			}
			
		}
		
	}
	

}









