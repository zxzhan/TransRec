import java.util.ArrayList;

public class Initialization {
	
	public static void initialization() 
	{
		Data.indexUserTrain = new int[Data.num_train];
		Data.indexItemTrain = new int[Data.num_train];
		// === Locate memory for the data structure of the model parameters
		Data.U = new float[Data.n + 1][Data.d];
		Data.V = new float[Data.m + 1][Data.d];
		Data.t = new float[Data.d];
		Data.b_i = new float[Data.m + 1]; // bias of item
		
		int idx = 0;
		for (int u = 1; u <= Data.n; u++) 
		{
			// --- check whether the user $u$ is in the training data
			if (!Data.TrainData.containsKey(u))
			{
				continue;
			}
			// --- get a copy of the data in indexUserTrain and indexItemTrain
			ArrayList<Integer> ItemSet = new ArrayList<Integer>();
			if (Data.TrainData.containsKey(u))
			{
				ItemSet = Data.TrainData.get(u);
			}
			for (int i : ItemSet)
			{
				Data.indexUserTrain[idx] = u;
				Data.indexItemTrain[idx] = i;
				idx += 1;
			}
		}

		// --- initialization of V and t (unit vectors)
		float range = 6.0f / (float)Math.sqrt(Data.d);
		for (int i = 1; i < Data.m + 1; i++) 
		{
			for (int f = 0; f < Data.d; f++)
			{
				Data.V[i][f] = (float) (range - 2*range*Math.random());  //@@@
			}
			Common.normalization(Data.V[i]); 
		}
		for (int f = 0; f < Data.d; f++)
		{
			Data.t[f]= (float) (range - 2*range*Math.random());         //@@@
		}
		Common.normalization(Data.t);
		
		// --- initialization of U and b_i(zero vectors) 
		for (int i = 1; i < Data.m + 1; i++) 
		{
			Data.b_i[i] = 0f;
		}
		for (int u = 1; u < Data.n + 1 ; u++) 
		{
			for (int f = 0; f < Data.d; f++)
			{
				Data.U[u][f] = 0f;
			}
			
		}

	}
}
