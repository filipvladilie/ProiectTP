package proiect;

public class Model {
		
	public static final String INITIAL_VALUE = "1";
	private Polinom m_total;
	
	Model() {
		reset();
		}
	public void reset()
	{
		
	}
		
	public void multiplyBy(Polinom operand1,Polinom operand2) {
		 operand1.mullPolinom(operand2);
		 m_total=operand1;
		}
	public void addBy(Polinom operand1,Polinom operand2) {
		 operand1.addPolinom(operand2);
		 m_total=operand1;
		}
	public void subbBy(Polinom operand1,Polinom operand2) {
		 operand1.subbPolinom(operand2);
		 m_total=operand1;
		}
	public Polinom getTotal()
	{
		return this.m_total;
	}
	
	public void setTotal(Polinom p)
	{
		this.m_total.setMonomial(p.getMonomial());
		
	}
	
	public String getValue() 
	{	
	return m_total.toString();
	}
	public void divBy(Polinom firstOperand, Polinom secondOperand) {
				
	}
	public void derBy(Polinom firstOperand) {
		firstOperand.derPolinom();
		 m_total=firstOperand;
	}
	public void intBy(Polinom firstOperand) {
		firstOperand.intPolinom();
		 m_total=firstOperand;
	}
	
	
	
} 

