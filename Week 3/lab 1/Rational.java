/**
 * A class that represents a rational number. 
 * 
 * @author Charles Hoot 
 * @version 4.0
*/
public class Rational
{
	private int denominator;
	private int numerator;
	
	// PUT PRIVATE DATA FIELDS HERE
    /**
     * The default constructor for objects of class Rational.  Creates the rational
number 1.
     */
    public Rational()
    {     
    	this.numerator = 1;
    	this.denominator = 1;
       
    }
    /**
     * The alternate constructor for objects of class Rational.  Creates a rational
number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d)
    {
    	try
    	{
    	this.numerator = n;
    	this.denominator = d;
    	
    	int r = n/d;
    	
    	normalize();
    	}
    	catch(Exception e)
    	{
    		throw new ZeroDenominatorException("The denominator is Zero");
    	}
    	
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        return numerator;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        return denominator;
    }
    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	Rational temp = new Rational(-numerator,denominator);
        return temp;
    }
    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert()
    {               
    	Rational temp = new Rational(denominator, numerator);
        return temp;
    }
    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
    	Rational temp = new Rational((numerator*other.getDenominator()+ other.getNumerator()*denominator), denominator*other.getDenominator());
        return temp;
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
    	Rational temp = new Rational((numerator*other.getDenominator()- other.getNumerator()*denominator), denominator*other.getDenominator());
        return temp;
    }
    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other 
rational.
     */    
    public Rational multiply(Rational other)
    {       
       Rational temp = new Rational((numerator*other.getNumerator()), denominator*other.getDenominator());
       return temp;
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {               
    	Rational temp = new Rational((numerator*other.getDenominator()), denominator*other.getNumerator());
        return temp;
    }
     
 
 
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the 
numerator
     * is negative.
     *
     */
    private void normalize()
    {
    	int gcd = gcd(this.numerator, this.denominator);
        numerator /= gcd;
        denominator /= gcd;
        
    	boolean positive = true;
    	
    	if((numerator/denominator) > 0)
    	{
    		positive = true;
    	
		    	if(numerator < 0)
				{
				numerator *= -1;
				}
		    	else if(denominator < 0)
				{
				denominator *= -1;
				}
    	}
    	else if(numerator < 0)
    		{
    		numerator *= -1;
    		positive = false;
    		}
    	else if(denominator < 0)
    		{
    		denominator *= -1;
    		positive = false;
    		}
    	  
        if(!positive)
        	numerator *= -1;
    }
        
    
    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}