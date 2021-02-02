import javax.swing.ImageIcon;

public class PhoneModel implements Comparable<PhoneModel> {

	private double basePrice;
	private String modelName;
	private double priceWithContract;
	private String imagePath;
	
	public PhoneModel(String name, double p1, double p2, String ip)  {
		basePrice = p1;
		modelName = name;
		priceWithContract = p2;
		imagePath = ip;
	}
	
	public String getName() {
		return this.modelName;
	}
	
	public double getPriceWithContract() {
		return this.priceWithContract;
	}
	
	public double getPriceWithoutContract() {
		return this.basePrice;
	}
	
	public void setPriceWithContract(float price){
		this.priceWithContract = price;
	}
	
	public String toString() {
		return (modelName + " - $" + priceWithContract + " ($" +
				basePrice + " no-contract)");
	}
	
	public boolean equals(Object o) {
		if (o instanceof PhoneModel)
		{
			PhoneModel phone = (PhoneModel) o;
			return this.modelName == phone.modelName;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int compareTo(PhoneModel o) {
		// TODO Auto-generated method stub
		int value = 0;
		value = this.modelName.compareToIgnoreCase(o.modelName);
		return value;
	}

	
}