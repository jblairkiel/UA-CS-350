
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
	Integer yearsCount;
	Integer jeepCount;
	Integer modelsCount;
	Integer transmissionCount;
	String numSpaces = "";
	String nameSpaces = "";
	String yearsSpaces = "";
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
		
		modelsArray = models.split("");
		model1 = modelsArray[1];
		model2 = modelsArray[2];
		model3 = modelsArray[3];
		model4 = modelsArray[4];
		model5 = modelsArray[5];
		
		
	}

	public String getCustomerNum(){return customerNum;}
	
	public String getCustomerData(){
		
		numCount = 25 - customerNum.length();
		nameCount = 25 - customerName.length();
		yearsCount = 28 - drivingYears.length();
		jeepCount = 25 - jeepOwner.length();
		modelsCount = 25 - models.length();
		transmissionCount = 25 - transmission.length();

		int i;
		for (i=0; i<numCount; i++){
			numSpaces += " ";
		}
		for (i=0; i<nameCount; i++){
			nameSpaces += " ";
		}
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
		//String newRow = "00001                    Dustin Mark            7                            Yes                     C--R-                   5-Manual";
		return newRow;
		
	}
}

