package proiect;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;;



public class MVC {
	public static void main(String[] args) {
	
	Model m = new Model();
	View v = new View(m);
	v.setVisible(true);
	Controller controller = new Controller(v,m);
	
	
 };

}
