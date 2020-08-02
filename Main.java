import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException 
	{	
		// 1. read configurations		
		ReadConfigurations.readConfigurations(args);    //when run by bat
		//ReadConfigurations.readConfigurationsTest();  //when run on Eclipse

		// 2. read training data and test data
        ReadData.readData();
               
		// 3. initialization
		Initialization.initialization();
		
		// 4. train			
		Train.train();
			
    }
}
