package exemploPolimorfismo;

public class Luzes {

	public String acender(String luz) {
		return luz = "liagada";
	}

	public String acender() {
		String luz = null;

		while (luz != null || luz != "")
			acender(luz);
		return luz;
	}
	
	public String apagar(String luz){
		return luz = "liagada";
	}
	
	public String apagar(){
		String luz = "desligada";
		
		while(luz!=null || luz!="")
			apagar();
		return luz;
	}
}
