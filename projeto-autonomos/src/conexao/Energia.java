package conexao;

public class Energia {
	
	double energia;
	double valor;
	
	public Energia(double energia, double valor) {
		this.energia = energia;
		this.valor = valor;
	}
	
	@Override
	public String toString(){
		return valor + " ," + energia;
	}
}
