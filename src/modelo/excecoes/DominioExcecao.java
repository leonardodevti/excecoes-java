package modelo.excecoes;

public class DominioExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DominioExcecao(String msg) {
		super (msg);
	}
	
}
