package proiect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import proiect.View;

public class Monomial {
	
		private float coef;
		private int expo;
		public static String COEFFICIENT_PATTERN = "([-+]?([0-9]*)?)";
		public static String DEGREE_PATTERN = "[xX]((\\^)[0-9]*)?";
	    Pattern monomialPattern = Pattern.compile(Polinom.MONOMIAL_PATTERN);
        Matcher monomialMatcher = monomialPattern.matcher(View.getUsercoef());
		
		
		public Monomial(float coef, int expo) {
			
				this.coef=coef;
				this.expo = expo;
		}

		public float getCoef()
		{
			return this.coef;
		}
		
		public void setCoef(float f)
		{
			this.coef = f;
		}
		
		public int getExpo()
		{
			return this.expo;
		}
		
		public void setExpo(int expo)
		{
			this.expo = expo;
		}
		
		public String toString()
		{
			String output = "";
			if(this.getCoef() == 0.0)
				return "";	
			else
				
				if(this.getCoef()<0)
				{
					output += " ";
					output += this.getCoef();
					output += "x";  //6x^2-3x^1-4
									//3x^2+2x^1+1
					output += "^";

					output += this.getExpo();
				}
				else
				{
				output +=" + ";
					
				output += this.getCoef();

				output += "x";

				output += "^";

				output += this.getExpo();
				
			}
			return output;
		}
		
		public Monomial  (String monomial) {
	        while (monomialMatcher.find()){
			//Monomial currentMonomial = new Monomial(monomialMatcher.group(0));
	        Pattern coefficientPattern = Pattern.compile(COEFFICIENT_PATTERN);
	        Matcher coefficientMatcher = coefficientPattern.matcher(monomial);

	        if (coefficientMatcher.find()) {
	            if (coefficientMatcher.group(0).length() > 0) {
	                String coefficientString = coefficientMatcher.group(0); 
	                if (coefficientString.equals("-")) {  
	                    this.setCoef(-1);
	                }
	                else if (coefficientString.equals("+")) {
	                    this.setCoef(1);
	                }
	                else this.setCoef(Integer.parseInt(coefficientString));
	            }
	            else {
	                
	                if (monomial.length() > 0) {
	                    this.setCoef(1);
	                }
	            }
	        }
	        Pattern degreePattern = Pattern.compile(DEGREE_PATTERN);
	        Matcher degreeMatcher = degreePattern.matcher(monomial);
	        if (degreeMatcher.find()) {
	            if (degreeMatcher.group(0).length() > 1) {
	                String degreeString = degreeMatcher.group(0); 
	                if (degreeString.charAt(1) == '^') {
	                    this.setExpo(Integer.parseInt(degreeString.substring(2)));
	                }
	            } else {
	                this.setExpo(1);
	            }
	        } else {
	            this.setExpo(0);
	        }
	    }
	}
		public Monomial() {
			
		}

		public void addsumMonomial(Monomial monomial) {
	        if (this.expo == monomial.expo) 
	            this.coef += monomial.coef;
	        }
	        
	    public void addsubbMonomial(Monomial monomial) {
		        if (this.expo == monomial.expo) 
		            this.coef -= monomial.coef;
		        }
	    public void addmulMonomial(Monomial monomial) {
	       this.coef *= monomial.coef;
	       this.expo *= monomial.expo;
	        }
		        
		        
		public void addderMonomial() {
			this.coef = this.coef * this.expo;
	        if (this.expo > 0) {
	        	this.expo = this.expo - 1;
	        } else {
	        	this.expo = 0;
	        }
	    }
		
		public void addintMonomial() {
			this.coef = this.coef / (this.expo + 1);
			this.expo = this.expo + 1;
		}
		
		
}
