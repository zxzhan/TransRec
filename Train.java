import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Train 
{
	public static void train() throws FileNotFoundException 
	{
		for (int iter = 1; iter <= Data.T; iter++) 
		{
			
			if (iter == 20 || iter == 50 || iter == 100 ||iter == 500||iter == 1000) 
			{
				if (Data.fnTestData.length() > 0) 
				{
					System.out.println("Iter:" + Integer.toString(iter) + "| ");
					Test.testRanking(Data.TestData);
				}
			}
			//else System.out.println("Iter:" + Integer.toString(iter));
			// =================================================================
			for (int iter2 = 0; iter2 < Data.num_train; iter2++) 
			{
				// -----randomly sample a user-item pair, Math.random(): [0.0,1.0)
				int u = -1, i = -1, i_next = -1, idx2 = -1;
				while (true) 
				{
					idx2 = (int) Math.floor(Math.random() * Data.num_train);
					u = Data.indexUserTrain[idx2];
					i = Data.indexItemTrain[idx2];
					if(!Data.TrainData.containsKey(u))
					{
						continue;
					}
					int i_location = Data.TrainData.get(u).indexOf(i);
					if (i_location == Data.TrainData.get(u).size()-1) //do not have next item
					{
						continue;
					}
					i_next = Data.TrainData.get(u).get(i_location+1);
					if (i_next>=0) break;

				}//-----got the positive sample
				TransRec(u, i, i_next);
			}
			// =================================================================
		}
	}
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void TransRec(int u, int i, int i_next) 
	{
		ArrayList<Integer> ItemSet = Data.TrainData.get(u);
		int ItemSetSize = ItemSet.size();
		
		// -----got the negative sample:j
		int j = -1;
		if (true) 
		{
			while (true) 
			{
				j = (int) (Math.floor(Math.random() * Data.m) + 1);  //[1,m]
				if (Data.ItemSetWhole.contains(j)&& (!ItemSet.contains(j))) 
				{
					break;
				}
			}
		}
		
		float[] v_x_y = new float[Data.d];
		float[] v_x_yn = new float[Data.d];

		for (int k=0; k<Data.d; k++) {
			v_x_y[k]  = Data.t[k] + Data.U[u][k] + Data.V[i][k] - Data.V[i_next][k];
			v_x_yn[k] = Data.t[k] + Data.U[u][k] + Data.V[i][k] - Data.V[j][k];
		}
		
		float z = -Data.b_i[i_next] + Data.b_i[j];
		for (int k=0; k<Data.d; k++) {
			z -= v_x_y[k] * v_x_y[k] - v_x_yn[k] * v_x_yn[k];
		}
		
		float deri = 1 / (1 + (float)Math.exp(z));

		Data.b_i[i_next]   += Data.gamma * (-deri - Data.beta_b * Data.b_i[i_next]);
		Data.b_i[j]  += Data.gamma * ( deri - Data.beta_b * Data.b_i[j]);

		for (int k = 0; k < Data.d; k ++) {
			Data.V[i][k]    += Data.gamma * (deri * 2 * (-v_x_y[k] + v_x_yn[k]) - Data.alpha * Data.V[i][k]);
			Data.V[j][k]   += Data.gamma * (deri * 2 * (-v_x_yn[k]) - Data.alpha * Data.V[j][k]);
			Data.V[i_next][k]    += Data.gamma * (deri * 2 * (v_x_y[k]) - Data.alpha * Data.V[i_next][k]);
			Data.t[k]       += Data.gamma * (deri * 2 * (-v_x_y[k] + v_x_yn[k]) - Data.alpha * Data.t[k]);
			Data.U[u][k] += Data.gamma * (deri * 2 * (-v_x_y[k] + v_x_yn[k]) - Data.alpha_u * Data.U[u][k]);
		}
		
		Common.normalization(Data.V[i]);
		Common.normalization(Data.V[i_next]);
		Common.normalization(Data.V[j]);
	}
}
