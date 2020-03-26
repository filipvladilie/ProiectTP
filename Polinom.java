package proiect;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polinom {
	
	 private static final int MAXIMUM_EXPO = 15;	
	private ArrayList<Monomial> monomial = new ArrayList<Monomial>();
	public static String MONOMIAL_PATTERN = "([-+]?([0-9]*)?)(([xX]?(\\^[0-9]+)?)?)";
	private int nrmonomial;

	//public static String MONOMIAL_PATTERN = "([+-]?[^-+]+)";

	public Polinom (String sourcePolynomial){
        this.nrmonomial = 0;
        this.monomial = new ArrayList<Monomial>(MAXIMUM_EXPO);

        Pattern monomialPattern = Pattern.compile(MONOMIAL_PATTERN);
        Matcher monomialMatcher = monomialPattern.matcher(sourcePolynomial);

        while (monomialMatcher.find()){
            Monomial currentMonomial = new Monomial(monomialMatcher.group(0));

            boolean monomialState = this.addMonomial(currentMonomial);
            if (monomialState == true) {
                this.nrmonomial++;
            }
        }
    }
	
	public Polinom() {
		
	}
	
	public int getNrmonomial()
	{
	return this.nrmonomial;	
	}
	
	public void setNrmonomial(int n)
	{
	 this.nrmonomial=n;	
	}
	
	public ArrayList<Monomial> getMonomial() {
		return monomial;
	}

	public void setMonomial(ArrayList<Monomial> monomial) {
		this.monomial = monomial;
	}
	
	public boolean addMonomial (Monomial monomials) {
        if (!(monomials.getCoef() == 0 && monomials.getExpo() == 0))  {
            this.getMonomial().add(monomials);
         
            this.setNrmonomial(monomial.size());
            return true;
        }
        this.setNrmonomial(monomial.size());
        return false;
    }
	
	public String toString() {
		
		String output="";
		for(Monomial m : this.monomial)
		{
			output+=m.toString();
		}
		
		return output;
		
	}
	
	public int calcGrad()
	{
		int i=0;
		for (Monomial  m : this.monomial)
		{
			if(m.getExpo()>i)
				i=m.getExpo();
		}
		return i;
	}
	
	public int maximumDegree (){
        if (monomial.size() == 0){
            return 0;
        }
        int maximumDegree = -1;
        for (Monomial monomial : monomial){
            if (monomial.getCoef() != 0){
                if (monomial.getExpo() > maximumDegree){
                    maximumDegree = monomial.getExpo();
                }
            }

        }
        return maximumDegree;
    }
	
	public void addPolinom(Polinom p1)
	{
		float q=0;
		float w=0;
		Polinom p = new Polinom(MAXIMUM_EXPO);
		Polinom operand1 = new Polinom(MAXIMUM_EXPO);
		
			for(Monomial m : operand1.monomial)
			
				for(Monomial n : this.monomial  )
				{
					m.addsumMonomial(n);
					if(m.getExpo()==0)
						q=m.getCoef();
						if(n.getExpo()==0)
							w=n.getCoef();
							
				}
			q+=w;
			for(Monomial m : operand1.monomial)
				
				for(Monomial n : p1.monomial  )
				{
						m.addsumMonomial(n);
						
							if(n.getExpo()==0)
								w=n.getCoef();				}
			
			q+=w;
		operand1.addMonomial(new Monomial(q,0));	
		this.setMonomial(operand1.getMonomial());
		this.setNrmonomial(operand1.maximumDegree()-1);
		
		
	}
	
	public void mullPolinom(Polinom p1)
	{
		Polinom mull = new Polinom();
			for(Monomial m : p1.monomial)
			
				for(Monomial n : this.monomial  )
				{
					mull.addMonomial(new Monomial(n.getCoef()*m.getCoef(),n.getExpo()+m.getExpo()));
				}
			this.setMonomial(mull.monomial);
			this.setNrmonomial(mull.getNrmonomial());
	}
	
	public void subbPolinom(Polinom p1)
	{
		Polinom operand1 = new Polinom(MAXIMUM_EXPO);
		float q=0;
		float w=0;
	
	for(Monomial m : operand1.monomial)
	
		for(Monomial n : this.monomial  )
		{
			
				m.addsumMonomial(n);
				if(m.getExpo()==0)
					q=m.getCoef();
					if(n.getExpo()==0)
						w=n.getCoef();
		}
	q+=w;
	for(Monomial m : operand1.monomial)
		
		for(Monomial n : p1.monomial  )
		{
				m.addsubbMonomial(n);
				if(n.getExpo()==0)
					w=n.getCoef();
		}
	
	q-=w;
	
	this.setMonomial(operand1.getMonomial());
	this.setNrmonomial(operand1.maximumDegree());
	this.addMonomial(new Monomial(q,0));
	}
	
	public void derPolinom()
	{
		for(Monomial m : this.monomial)
			m.addderMonomial();
	}
	
	public void intPolinom()
	{
		for(Monomial m : this.monomial)
			m.addintMonomial();
	}

	public static boolean isValid (String polinom){
        if (polinom.equals("x")){
            return true;
        }

        //boolean containsAtLeastOneNumber = false;
        char[] chars = polinom.toCharArray();
        for (char c : chars){
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
	
	public Polinom(int numberOfMonomials) {
        this.nrmonomial = numberOfMonomials;
        this.monomial = new ArrayList<Monomial>(numberOfMonomials);
        int i=0;
       while(i<numberOfMonomials)
       {
    	   this.addMonomial(new Monomial(0,i));
    	   i++;
       }
	}
	
	public Polinom(int numberOfMonomials, ArrayList<Monomial> monomials) {
        this.nrmonomial = numberOfMonomials;
        this.monomial = monomials;
    }
	
}

//3x^2+2x^1+1
//6x^2-3x^1-4
