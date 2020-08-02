import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Data {
	
	public static int d = 10;

	
	// tradeoff $\alpha$
	public static float alpha = 0.001f;  //alpha_y and alpha_t
	public static float alpha_u = 0.001f; //alpha_u
	public static float beta_b = 0.001f;
	
	// learning rate $\gamma$
	public static float gamma = 0.001f;
	
	// Input data files
	public static String fnTrainData = "";
	public static String fnTestData = "";
	//
	public static int n = 0; // number of users
	public static int m = 0; // number of items
	public static int num_train = 0; // number of the total (user, item) pairs in training data
	
	// scan number over the whole data
	public static int T = 0; 
	
	// Evaluation,top k in evaluation
	public static int topK = 5;  

	// === training data
	public static HashMap<Integer, ArrayList<Integer>> TrainData = new HashMap<Integer, ArrayList<Integer>>();
	public static HashMap<Integer, HashSet<Integer>> TrainData_Item2Users =new HashMap<Integer, HashSet<Integer>>();
	
	// === training data used for uniformly random sampling
	public static int[] indexUserTrain; // start from index "0", used to uniformly sample (u, i) pair
	public static int[] indexItemTrain; // start from index "0", used to uniformly sample (u, i) pair

	// === test data
	public static HashMap<Integer, HashSet<Integer>> TestData = new HashMap<Integer, HashSet<Integer>>();
	// === whole data (items)
	public static HashSet<Integer> ItemSetWhole = new HashSet<Integer>();
		
	// === some statistics, start from index "1"
	public static int[] userRatingNumTrain;
	public static int[] itemRatingNumTrain;

	// === model parameters to learn, start from index "1"
	public static float[][] U;
	public static float[][] V;
	public static float[] t;      // global translation vector, start from index "0" to d-1
	public static float[] b_i;    // bias of item
}
