
public class Common {
	public static float sigmoid(float x) {
		return 1.0f / (1.0f + (float)Math.exp(-x));
	}
	
	public static void normalization(float[] vec)
	{
		float sum = 0f;
		for (int k = 0; k < Data.d; k ++) {
			sum += vec[k] * vec[k];
		}
		sum = (float)Math.sqrt(sum);

		if (sum > 1) {
			for (int k = 0; k < Data.d; k ++) {
				vec[k] /= sum;
			}
		}
	}
}
