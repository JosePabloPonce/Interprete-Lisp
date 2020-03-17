
public class Validacion {
	
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
	
	

}

