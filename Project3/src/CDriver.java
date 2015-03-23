
public class CDriver {

	String customerNum;
	String customerName;
	String drivingYears;
	String jeepOwner;
	String models;
	String transmission;
	String[] modelsArray;
	String model1;
	String model2;
	String model3;
	String model4;
	String model5;
	String trans1;
	String trans2;
	String trans3;
	String trans4;
	Integer numCount;
	Integer nameCount;
	Integer beforeYearsCount;
	Integer yearsCount;
	Integer jeepCount;
	Integer modelsCount;
	Integer transmissionCount;
	String numSpaces = "";
	String nameSpaces = "";
	String yearsSpaces = "";
	String beforeYearsSpaces = "";
	String jeepSpaces = "";
	String modelsSpaces = "";
	String tranmsissionSpaces = "";

	private String newNum;
	private String newName;
	private String newYears;
	private String newJeep;
	private String newModel;
	private String newTransmission;
	private String newRow;


	public CDriver(String cNum, String cName, String cYears, String cJeep, String cModels, String cTransmission){

		customerNum = cNum;
		customerName = cName;
		drivingYears = cYears;
		jeepOwner = cJeep;
		models = cModels;
		transmission = cTransmission;
		
		System.out.print(models);
		modelsArray = models.split("");
		System.out.print(modelsArray);
		model1 = modelsArray[0];
		model2 = modelsArray[1];
		model3 = modelsArray[2];
		model4 = modelsArray[3];
		model5 = modelsArray[4];
		
		
	}

	public String getCustomerNum(){return customerNum;}
	
	public String getCustomerData(){
		
		numCount = 17 - customerNum.length();
		nameCount = 25 - customerName.length() - drivingYears.length();
		//beforeYearsCount = 19 - customerName.length();
		yearsCount = 9;
		jeepCount = 15 - jeepOwner.length();
		modelsCount = 17 - models.length();
		transmissionCount = 17 - transmission.length();

		int i;
		for (i=0; i<numCount; i++){
			numSpaces += " ";
		}
		for (i=0; i<nameCount; i++){
			nameSpaces += " ";
		}
		//for (i=0; i<beforeYearsCount; i++){
		//	beforeYearsSpaces += " ";
		//}
		for (i=0; i<yearsCount; i++){
			yearsSpaces += " ";
		}
		for (i=0; i<jeepCount; i++){
			jeepSpaces += " ";
		}
		for (i=0; i<modelsCount; i++){
			modelsSpaces += " ";
		}
		for (i=0; i<transmissionCount; i++){
			tranmsissionSpaces += " ";
		}
		
		newNum = customerNum + numSpaces;
		newName = customerName + nameSpaces;
		newYears = drivingYears + yearsSpaces;
		newJeep = jeepOwner + jeepSpaces;
		newModel = models + modelsSpaces;
		newTransmission = transmission;

		newRow = newNum + newName + newYears + newJeep + newModel + newTransmission;
		return newRow;
		
	}
}


