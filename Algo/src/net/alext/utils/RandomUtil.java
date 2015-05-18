package net.alext.utils;

import java.util.Date;
import java.util.Random;

public class RandomUtil {
	private static Random random = new Random(new Date().getTime());
	
	public static int getRandomInt(int moduleRange){
		
		    int sign = random.nextInt(2) == 1 ? -1 : 1;
		    
		    return sign * random.nextInt(moduleRange);
		
	}
}
