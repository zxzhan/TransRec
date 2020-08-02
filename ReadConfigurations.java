import java.io.IOException;
import java.util.Arrays;

public class ReadConfigurations {
	public static void readConfigurations(String[] args) throws IOException {
		// === Read the configurations
		for (int k = 0; k < args.length; k++) {
			if (args[k].equals("-d"))
				Data.d = Integer.parseInt(args[++k]);
			else if (args[k].equals("-alpha")) {
				Data.alpha = Float.parseFloat(args[++k]);
				Data.alpha_u = Float.parseFloat(args[k]);
				Data.beta_b = Float.parseFloat(args[k]);
			}
			else if (args[k].equals("-gamma"))
				Data.gamma = Float.parseFloat(args[++k]);
			else if (args[k].equals("-fnTrainData"))
				Data.fnTrainData = args[++k];
			else if (args[k].equals("-fnTestData"))
				Data.fnTestData = args[++k];
			else if (args[k].equals("-n"))
				Data.n = Integer.parseInt(args[++k]);
			else if (args[k].equals("-m"))
				Data.m = Integer.parseInt(args[++k]);
			else if (args[k].equals("-T"))
				Data.T = Integer.parseInt(args[++k]);
			else if (args[k].equals("-topK"))
				Data.topK = Integer.parseInt(args[++k]);
		}

		// === Print the configurations
		System.out.println(Arrays.toString(args));
		System.out.println("fnTrainData: " + Data.fnTrainData);
		System.out.println("fnTestData: " + Data.fnTestData);
		System.out.println("n: " + Integer.toString(Data.n));
		System.out.println("m: " + Integer.toString(Data.m));
		System.out.println("gamma: " + Float.toString(Data.gamma));
		System.out.println("d: " + Integer.toString(Data.d));
		System.out.println("alpha: " + Float.toString(Data.alpha));
		System.out.println("alpha_u: " + Float.toString(Data.alpha_u));
		System.out.println("beta_b: " + Float.toString(Data.beta_b));
		System.out.println("T: "+ Integer.toString(Data.T));
		System.out.println("topK: " + Integer.toString(Data.topK));
	}
	
	public static void readConfigurationsTest() throws IOException {
		// === When testing, automatically fill configurations. 
		Data.d = 20;
		Data.alpha = 0.01f;
		Data.alpha_u = 0.01f;
		Data.beta_b = 0.01f;
		Data.gamma = 0.01f;
		Data.fnTrainData = "C:\\Users\\ZHUO\\Desktop\\实验室\\TransRec\\Data-S-FMSM\\ML100K-TXT-FORMAT\\train_5.csv";
		Data.fnTestData = "C:\\Users\\ZHUO\\Desktop\\实验室\\TransRec\\Data-S-FMSM\\ML100K-TXT-FORMAT\\valid_5.csv";
		Data.n = 943;
		Data.m = 1349;
		Data.T = 1000;
		Data.topK = 20;

		// === Print the configurations
		System.out.println("fnTrainData: " + Data.fnTrainData);
		System.out.println("fnTestData: " + Data.fnTestData);
		System.out.println("n: " + Integer.toString(Data.n));
		System.out.println("m: " + Integer.toString(Data.m));
		System.out.println("gamma: " + Float.toString(Data.gamma));
		System.out.println("d: " + Integer.toString(Data.d));
		System.out.println("alpha: " + Float.toString(Data.alpha));
		System.out.println("alpha_u: " + Float.toString(Data.alpha_u));
		System.out.println("beta_b: " + Float.toString(Data.beta_b));
		System.out.println("T: "+ Integer.toString(Data.T));
		System.out.println("topK: " + Integer.toString(Data.topK));
	}
}
