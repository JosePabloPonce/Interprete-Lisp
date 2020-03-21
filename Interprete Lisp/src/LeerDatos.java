import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class LeerDatos {


	    Calculos operaciones = new Calculos();
	    public static ArrayList<ArrayList<String>> twodlist = new ArrayList<ArrayList<String>>();
	    public static ArrayList<ArrayList<String>> dynamicTwodlist = new ArrayList<ArrayList<String>>();

	    Validacion validar = new Validacion();
	    private boolean valido = false;
		
		

		public boolean isValido() {
			return valido;
		}

		public void setValido(boolean valido) {
			this.valido = valido;
		}
		
		public boolean sintaxis(String texto) {
			int contador1 = 0;
			int contador2 = 0;
			for(int i = texto.length() -1; i> -1; i--) {
				char c = texto.charAt(i);
				if(String.valueOf(c).equals("(")) {
					contador1 ++;
				}
				if(String.valueOf(c).equals(")")) {
					contador2 ++;
				}
			}
			if(contador1 == contador2 && contador1 != 0) {
				setValido(true);
			}
			
			return valido;
			
		}

	 
	    
	    public String importText() {
			String lisp = " ";
			 
			try{
	            FileInputStream doc = new FileInputStream(System.getProperty("user.dir")+ "\\src\\numeros.txt");
	            DataInputStream ent = new DataInputStream(doc);
	            BufferedReader buffer = new BufferedReader(new InputStreamReader(ent));
	            String strLinea;
	         
	            while ((strLinea = buffer.readLine()) != null){
	                lisp = lisp+strLinea+" ";
	            }
	            ent.close();
	        }
	        catch (Exception e){ 
	            System.out.println("No se puede leer el documento" + e.getMessage());
	        }
			return lisp;
			}
	    
	    public void addRow(ArrayList<String> row) {
	        twodlist.add(row);
	    }
	    
	    public void dynamicAddRow(ArrayList<String> row) {
	        dynamicTwodlist.add(row);
	    }

	    public Stack<String> tokenizer(String string) throws IOException {
	        String newString = string;
	        Stack<String> stack = new Stack<String>();

	        newString = newString.replace("(", " ( ");
	        newString = newString.replace(")", " ) ");

	        StringTokenizer st = new StringTokenizer(newString, " ");
	        
	        boolean isQuote = false;
	      
	        int index = 0;
	        int count = 0;
	        while (st.hasMoreTokens()) {
	            String nextString = st.nextToken();
	            stack.push(nextString);
	            if (nextString.equals("quote"))
	                isQuote = true;
	       
	            if (nextString.equals(")") && !isQuote ) {
	                stack = validar.findCommand(stack);
	            }
	            count++;
	        }
	        
	        if(isQuote) {
	            stack.pop();
	            stack = validar.findQuoteCommand(stack);
	        }
	        
	        
	        if (stack.size() == 0) {
	            
	        }
	        else if (stack.size() == 1) {
	            try {
	                if (!ComprobarNumero(stack.peek()) && stack.peek() != null) {
	                    System.out.println(stack.peek());
	        
	                } else if (Double.parseDouble(stack.peek()) != -1) {
	                    if (Math.ceil(Double.parseDouble(stack.peek())) == Math.floor(Double.parseDouble(stack.peek()))) {
	                        System.out.println((int) Double.parseDouble(stack.peek()));
	                        
	                    } else {
	                        System.out.println(stack.peek());
	                    }
	                } else {
	                    System.out.println("Error en la Sintaxis");
	                   
	                }
	            } catch (Exception e) {
	                System.out.println("Error en la Sintaxis");
	                
	            }
	        } else {
	            System.out.println("Error en la Sintaxis");
	            
	   
	        }

	        return stack;
	    }

	    public static boolean ComprobarNumero(String linea) {
	        try {
	            double intento = Double.parseDouble(linea);
	            return true;
	        } catch (Exception ex) {
	            return false;
	        }
	    }
	    
	    
	    
	}



