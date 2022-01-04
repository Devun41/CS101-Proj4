import java.lang.Math.*;

public class Rational implements Comparable
{
	private long numerator;
	private long denominator;
	
	public Rational()
	{
		numerator=0;
		denominator=1;
	}
	

	public Rational(long a)
	{
		denominator=1;
		numerator= a;
	}

	public Rational(long a, long b) throws ArithmeticException
	{
		super();
		this.numerator=a/gcd(a,b);
		if(b==0) {
			throw new ArithmeticException("Denominator cant equal zero");
		}
		this.denominator=b/gcd(a,b);
		
		if(this.denominator<0) {
			this.numerator=this.numerator*-1;
			this.denominator=this.denominator*-1;
		}

	}

	public long getDenominator()
	{
		return denominator;
	}

	public long getNumerator()
	{
		return numerator;
	}

	public Rational add(Rational r)
	{
		Rational hold=null;
		if(r==null) {
			hold=new Rational(getNumerator(),getDenominator());
		}
		else {
			long num;
			long den;
			num=this.getNumerator()*r.getDenominator()+r.getNumerator()*this.getDenominator();
			den=this.getDenominator()*r.getDenominator();
			long g=gcd(num,den);
			num=num/g;
			den=den/g;
			hold=new Rational(num,den);
		}
		return hold;
	}
	

	public Rational subtract(Rational r)
	{	
		Rational hold=null;
		if(r==null) {
			hold=new Rational(getNumerator(),getDenominator());
		}
		else {
			long num;
			long den;
			num=this.getNumerator()*r.getDenominator()-r.getNumerator()*this.getDenominator();
			den=this.getDenominator()*r.getDenominator();
			long g=gcd(num,den);
			num=num/g;
			den=den/g;
			hold=new Rational(num,den);
		}

		return hold;
		
	}

	public Rational multiply(Rational r)
	{
		Rational hold=null;
		if(r==null) {
			hold=new Rational(0);
		}
		else {
			long num;
			long den;
			num=this.getNumerator()*r.getNumerator();
			den=this.getDenominator()*r.getDenominator();
			long gcd=gcd(num,den);
			num=num/gcd;
			den=den/gcd;
			hold=new Rational(num,den);
		}
		return hold;
	}

	public Rational divide(Rational r)
	{
		Rational hold=null;
		if(r==null) {
			throw new ArithmeticException("null");
		}
		else { 
			long num;
			long den;
			num=this.getNumerator()*r.getDenominator();
			den=this.getDenominator()*r.getNumerator();
			long gcd=gcd(num,den);
			num=num/gcd;
			den=den/gcd;
			hold=new Rational(num,den);
		}
		return hold;
	}

	//
	// Find the Greatest Common Divisor of Two Integers
	//
	public long gcd(long p, long q)
	{
		long holder;

		long r;

		if(q==0) {
			return p;
		}
		if(p==0) {
			return q;
		}
		if(p < 0) {
			p = p * -1;
		}
		if(q < 0) {
			q = q * -1;
		}
		if(p < q) {
			holder = p;
			p = q;
			q = holder;
		}
		r = p % q;
		if(r == 0) {
			return q;
		}
		else {
			return gcd(q,r);
		}
	}

	public String toString()
	{
		if (denominator == 1) return "" + numerator;

		return numerator + "/" + denominator;
	}

	public int compareTo(Object obj)
	{
      if (obj == null) return -1;

		if (!(obj instanceof Rational)) return 1;

		if (this.equals((Rational)(obj))) return 0;

		return (this.subtract((Rational)(obj)).getNumerator() > 0 ? 1 : -1);
	}

	// Returns true if and only if obj are the same number or reference the same object
	public boolean equals(Object obj)
	{
		if (obj == null) return false;

		if (obj == this) return true;

		if (this.subtract((Rational)obj).getNumerator() == 0) return true;

		return false;
	}
}
