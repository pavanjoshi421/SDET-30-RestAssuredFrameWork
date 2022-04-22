package commonLibrary;

import java.util.Random;
/**
 * This class contains Java specific methods
 * @author VIVEK
 *
 */

public class JavaLibrary
{
	/**
	 * This method will genrate random number and return it to user
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran= new Random();
		return ran.nextInt(1000);
	}

}
