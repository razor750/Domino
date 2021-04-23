import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

	public static void main(String[] args) {
		String domino = "";
		int iterations = 0;
		
		do
		{
			System.out.println("Wprowadz domino:");
			domino = readLine();
		} while (!isDominoValid(domino));

		boolean pass = true;
		do
		{
			System.out.println("Wprowadz liczbe iteracji (znak oznacza kierunek iteracji):");
			try
			{
				iterations = Integer.parseInt(readLine());
				pass = true;
			} catch (Exception e)
			{
				pass = false;
			}
		} while (!pass);
		
		System.out.println("Ciag domina po " + iterations + " iteracjach wyglada nastepujaco:");
		System.out.println(predictDomino(domino, iterations));
	}
	
	static String predictDomino(String domino, int iterations)
	{
		StringBuilder retval = new StringBuilder(domino);
		
		if(iterations >= 0)
			for(int iter=0; iter<iterations; iter++)
			{
				domino = retval.toString();
				if(domino.charAt(0) == '|' && domino.charAt(1) == '\\')
					retval.setCharAt(0, '\\');
				for(int i=1; i<domino.length()-1; i++)
				{
					if(domino.charAt(i) != '|')
						continue;
					if(domino.charAt(i-1) == '/' && domino.charAt(i+1) != '\\')
						retval.setCharAt(i, '/');
					if(domino.charAt(i+1) == '\\' && domino.charAt(i-1) != '/')
						retval.setCharAt(i, '\\');
				}
				if(domino.charAt(domino.length()-1) == '|' && domino.charAt(domino.length()-2) == '/')
					retval.setCharAt(domino.length()-1, '/');
			}
		else
			for(int iter=0; iter<-iterations; iter++)
			{
				domino = retval.toString();
				if(domino.charAt(0) == '/' && domino.charAt(0+1) != '/')
					retval.setCharAt(0, '|');
				if(domino.charAt(0) == '\\')
					retval.setCharAt(0, '|');
				for(int i=1; i<domino.length()-1; i++)
				{
					if(domino.charAt(i) == '|')
						continue;
					if(domino.charAt(i) == '/' && domino.charAt(i+1) != '/')
						retval.setCharAt(i, '|');
					if(domino.charAt(i) == '\\' && domino.charAt(i-1) != '\\')
						retval.setCharAt(i, '|');
				}
				if(domino.charAt(domino.length()-1) == '\\' && domino.charAt(domino.length()-2) != '\\')
					retval.setCharAt(domino.length()-1, '|');
				if(domino.charAt(domino.length()-1) == '/')
					retval.setCharAt(0, '|');
			}
		return retval.toString();
	}

	private static boolean isDominoValid(String domino)
	{
		for (int i = 0; i < domino.length(); i++)
			if( ! (domino.charAt(i) == '/' || domino.charAt(i) == '|' || domino.charAt(i) == '\\') )
				return false;
		return true;
	}

	private static String readLine()
	{
		if (System.console() != null)
			return System.console().readLine();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "4";
		}
	}
}
