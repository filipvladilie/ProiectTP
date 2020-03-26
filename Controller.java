package proiect;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Controller {
	
	    private View view;
	    private Model model;

	    public Controller (View view, Model model){
	        this.view = view;
	        this.model = model;

	        this.view.addSumListener(new AddListener());
	        this.view.addSubbListener(new SubbListener());
	        this.view.addMulListener(new MulListener());
	        this.view.addDivListener(new DivListener());
	        this.view.addDerListener(new DerListener());
	        this.view.addIntListener(new IntListener());
	    }

	    class AddListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String firstPolinom = View.getUsercoef();
	            String secondPolinom = View.getUserexpo();

	            if (Polinom.isValid(firstPolinom) == true && Polinom.isValid(secondPolinom) == true){
	            	Polinom firstOperand = new Polinom(firstPolinom); 
	            	Polinom secondOperand = new Polinom(secondPolinom); 
	                model.addBy(firstOperand, secondOperand); 

	                String resultPolinom = model.getValue();
	                View.setTotal(resultPolinom); 
	            }
	            else {
	                JOptionPane.showMessageDialog(null,"INVALID INPUT. TRY AGAIN");
	            }
	        }
	    }
	    
	    class SubbListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String firstPolinom = view.getUsercoef();
	            String secondPolinom = view.getUserexpo();

	            if (Polinom.isValid(firstPolinom) == true && Polinom.isValid(secondPolinom) == true){
	            	Polinom firstOperand = new Polinom(firstPolinom); 
	            	Polinom secondOperand = new Polinom(secondPolinom); 
	                model.subbBy(firstOperand, secondOperand); 

	                String resultPolinom = model.getValue();
	                view.setTotal(resultPolinom); 
	            }
	            else {
	                JOptionPane.showMessageDialog(null,"INVALID INPUT. TRY AGAIN");
	            }
	        }
	    }
	    
	    class MulListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String firstPolinom = view.getUsercoef();
	            String secondPolinom = view.getUserexpo();

	            if (Polinom.isValid(firstPolinom) == true && Polinom.isValid(secondPolinom) == true){
	            	Polinom firstOperand = new Polinom(firstPolinom); 
	            	Polinom secondOperand = new Polinom(secondPolinom); 
	                model.multiplyBy(firstOperand, secondOperand); 
	                String resultPolinom = model.getValue();
	                view.setTotal(resultPolinom); 
	            }
	            else {
	                JOptionPane.showMessageDialog(null,"INVALID INPUT. TRY AGAIN");
	            }
	        }
	    }
	    
	    class DivListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String firstPolinom = view.getUsercoef();
	            String secondPolinom = view.getUserexpo();

	            if (Polinom.isValid(firstPolinom) == true && Polinom.isValid(secondPolinom) == true){
	            	Polinom firstOperand = new Polinom(firstPolinom); 
	            	Polinom secondOperand = new Polinom(secondPolinom); 
	                model.divBy(firstOperand, secondOperand); 

	                String resultPolinom = model.getValue();
	                view.setTotal(resultPolinom); 
	            }
	            else {
	                JOptionPane.showMessageDialog(null,"INVALID INPUT. TRY AGAIN");
	            }


	        }
	    }
	    
	    class DerListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String firstPolinom = view.getUsercoef();

	            if (Polinom.isValid(firstPolinom) == true){
	            	Polinom firstOperand = new Polinom(firstPolinom); 
	                model.derBy(firstOperand); 

	                String resultPolinom = model.getValue();
	                view.setTotal(resultPolinom); 
	            }
	            else {
	                JOptionPane.showMessageDialog(null,"INVALID INPUT. TRY AGAIN");
	            }


	        }
	    }
	    
	    class IntListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String firstPolinom = view.getUsercoef();
	           
	            if (Polinom.isValid(firstPolinom) == true ){
	            	Polinom firstOperand = new Polinom(firstPolinom); 
	                model.intBy(firstOperand); 
	                String resultPolinom = model.getValue();
	                view.setTotal(resultPolinom); 
	            }
	            else {
	                JOptionPane.showMessageDialog(null,"INVALID INPUT. TRY AGAIN");
	            }


	        }
	    }
	    
	}





