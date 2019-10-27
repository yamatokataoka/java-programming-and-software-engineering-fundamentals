
/**
 * Simulate rolling two six-sided die, keep statistics
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import java.util.Random;

public class DiceRolling
{
	public void simulate(int rolls){
		Random rand = new Random();
		int [] counts = new int [13];
	

		for(int k=0; k < rolls; k++){
			int d1 = rand.nextInt(6) + 1;
			int d2 = rand.nextInt(6) + 1;
			System.out.println("roll is " + d1 + "+" + d2 + "=" + (d1+d2));
			counts[d1+d2] += 1;
		}
		
		for (int k=2; k <=12; k++) {
		    System.out.println(k + "'s=\t" + counts[k] + "\t" + 100.0 * counts[k]/rolls);
		}
		
}

	
	public void simpleSimulate(int rolls){
		Random rand = new Random();
		int twos = 0;
		int twelves = 0;

		for(int k=0; k < rolls; k++){
			int d1 = rand.nextInt(6) + 1;
			int d2 = rand.nextInt(6) + 1;
			if (d1 + d2 == 2){
			    twos += 1;
			}
			else if (d1 + d2 == 12){
			    twelves += 1;    
			}
		}
		
		System.out.println("2's=\t" + twos + "\t" + 100.0 * twos/rolls);
		System.out.println("12's=\t"+twelves+"\t"+100.0*twelves/rolls);
	}

}
