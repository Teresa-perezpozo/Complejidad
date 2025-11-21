package es.upm.aled.complejidad;

public class recursion1 {



		private String nombre;
		private List<Persona> hijos;
		
		public Persona(String nombre) {
			super();
			this.nombre = nombre;
		}

		public String getNombre() {
			return nombre;
		}

		public List<Persona> getHijos() {
			return hijos;
		}

		public void addHijo(Persona p) {
			// TODO 
		}

		public String descendientes() {
			// TODO: Devuelve un String con todos los descendientes
			// Seguro que hay que llamar de nuevo a descendientes()
			return null;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Persona ro = new Persona("Rodrigo");
			Persona no = new Persona("Nora");
			ro.addHijo(no);
			Persona lu = new Persona("Luis");
			no.addHijo(lu);
			Persona ra = new Persona("Ramona");
			no.addHijo(ra);
			System.out.println(ro.descendientes());
			
			
			
			
		}

	}
######S#
#      #
##E#####

}
