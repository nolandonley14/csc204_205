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
	
	public static PhoneModel[] cellPhones = new PhoneModel[5];
	
	public static void main(String[] args) throws FileNotFoundException {
	
	
	PhoneDatabase phones = new PhoneDatabase();
	phones.getPhones();
	for (int i = 0; i < 5; i ++)
		{
			cellPhones[i] = new PhoneModel(phones.model.get(i), phones.basePrice.get(i), phones.contractPrice.get(i), phones.phonePictures[i]);
			System.out.println(cellPhones[i]);
		}
	
	System.out.println(cellPhones[2].withoutContract());
	}
	
}
	
	
	
	
	
	
	
	
