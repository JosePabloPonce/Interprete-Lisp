import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class LeerDatos {


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

	 
	    
	    public String importText(String texto) {
			String lisp = " ";
			 
			try{
	            FileInputStream doc = new FileInputStream(System.getProperty("user.dir")+ "\\"+texto);
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
	    
	    
	    
	    
	    public Stack<String> leeryejecutar(String string) throws IOException {
	        String NuevoString = string;
	        Stack<String> stack = new Stack<String>();

	        NuevoString = NuevoString.replace("(", " ( ");
	        NuevoString = NuevoString.replace(")", " ) ");

	        StringTokenizer st = new StringTokenizer(NuevoString, " ");
	        
	        boolean isQuote = false;
	      
	        int index = 0;
	        int count = 0;
	        while (st.hasMoreTokens()) {
	            String nextString = st.nextToken();
	            stack.push(nextString);
	            if (nextString.equals("quote"))
	                isQuote = true;
	       
	            if (nextString.equals(")") && !isQuote ) {
	                stack = validar.encontrarparentesis(stack);
	            }
	            count++;
	        }
	        
	        if(isQuote) {
	            stack.pop();
	            stack = validar.encontrarq(stack);
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




