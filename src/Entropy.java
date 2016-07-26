public class Entropy {

	private static String filename;

	/**
	 * @param args
	 */
	Double calculateEntropy(String file) {
		// TODO Auto-generated method stub
		
		int YMax = 1200,XMax = 1600;
		
		filename=file;
		Histogram h=new Histogram();
		double prob[]=new double[256], Sum_prob_1k = 0, Sum_prob_kl = 0, 
		Sum_prob_ln_1k = 0, Sum_prob_ln_kl = 0, Entropy[]=new double[256];
		int i;
		int hist[]=h.histogram(filename);
		//System.out.println(hist[23]);
		int ThresholdLevel;
		for( i = 0; i< 256; i++)
			prob[i] =  (double) hist[i] / (XMax * YMax); 

		for( int k = 0; k< 255; k++)		
		{
			Sum_prob_1k = 0; Sum_prob_kl = 0; 
			Sum_prob_ln_1k = 0; Sum_prob_ln_kl = 0;
			     
	                   //From 1 to k
			for(i = 1; i < k; i++)			
			{	
								                                                                
	                              //Sums probablities to k
				Sum_prob_1k += prob[i];		

	                            //Sums prob times Log of prob to k
				if(prob[i]!=0) Sum_prob_ln_1k += (prob[i] * Math.log(prob[i]));
			}
			
			for(i = k; i < 256; i++)		

	                          //From k to end
			{								 
	                           //Sums prob of k to end
				Sum_prob_kl += prob[i];		

	                           //Sums prob times log of prob
			        if(prob[i]!=0) Sum_prob_ln_kl += (prob[i] * Math.log(prob[i]));
			}
			     //Final equation of entropy for each k
			Entropy[k] = Math.log(Sum_prob_1k) + Math.log(Sum_prob_kl)
				- (Sum_prob_ln_1k / Sum_prob_1k)
				- (Sum_prob_ln_kl / Sum_prob_kl);
			     //protects against divide by zero
			if(Entropy[k]<0) Entropy[k]=0;
		}
		
		ThresholdLevel = 0;
		int m=0;
		while(Double.isNaN(Entropy[m]))
		{
		m++;
		}
			
		ThresholdLevel = m;
		int k;
		for(k = 0; k<256; k++)	//Finds Maximum
		{
			if(Entropy[k] > Entropy[ThresholdLevel]) 
			{
				ThresholdLevel = k;
				//System.out.println("entreed comparison");
			}
				//Thresholds there
			//System.out.println("Entropy at  : "+k+" "+Entropy[k]+" Thresholded at :" +Entropy[ThresholdLevel]);
		}
		
		//System.out.println("Max threshold=>"+Entropy[ThresholdLevel]);
		return Entropy[ThresholdLevel];
	}

}
