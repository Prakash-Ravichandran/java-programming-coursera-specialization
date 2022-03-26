import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
/**
 * Write a description of Testing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Testing {
  public static void main(String[] args)
	{
		String s = "Techie Delight";

		CharacterIterator it = new StringCharacterIterator(s);

		while (it.current() != CharacterIterator.DONE)
		{
			System.out.print(it.current());
			
			System.out.print("Hello");
			it.next();
		}
	}
}

