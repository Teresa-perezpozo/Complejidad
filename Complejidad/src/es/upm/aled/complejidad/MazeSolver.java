package es.upm.aled.complejidad;

public class MazeSolver {

	
	//hacer un método que resuelva laberintos
	public char salida S;
	public char entrada E;
	public char pared #;
	private String[] maze;
	public int ancho=n;
	public int largo =m;
	private List  <pos> solucion = new ArrayList<>();
	private Set <pos> pasados = new ArrayLIST<>();
	private boolean haySalida;
	
	public boolean solucion(pos) {
		solucion.add(pos);
		
		//caso base
		if(pos==pared) {
			pasados.add(pos);
			solucion.remove(pos);
			return false;
		}
		//estoy en pared
		if (maze[current.getY()].charAt(current.getX()) == wall ) {
			path.remove(current);
			return false;
		}
		// He estado antes?
				if (visited.contains(current)) {
					path.remove(current);
					return false;
				}
		
		if(pos.length>n|| pos[1].length>m) {
			solucion.remove(pos);
			break;
		}
		
		this.visited.add(current);
		Coordinate up = new Coordinate(current.getX(), current.getY() - 1);
		Coordinate right = new Coordinate(current.getX() + 1, current.getY());
		Coordinate down = new Coordinate(current.getX(), current.getY() + 1);
		Coordinate left = new Coordinate(current.getX() - 1, current.getY());
		Coordinate toVisit[] = new Coordinate[4];
		//hago el array de 4 posiciones de toVisit
		solucion[0] = up;
		solucion[1] = right;
		solucion[2] = down;
		solucion[3] = left;
		//y ahora recorro el tovisit de las 4 posiciones colindantes
		for (Coordinate next : toVisit) {
		if (this.solucion(next)) {
			return true;
		}
		
	}
		return false;
		
	}
	//metodo fachada
	private pos fachadaLaberinto() {
		return solucion(salida);
	}
	
	
	}
