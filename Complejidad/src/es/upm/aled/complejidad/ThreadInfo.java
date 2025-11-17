package es.upm.aled.complejidad;

public class ThreadInfo {
Thread thread;
String name;
String type;
int Prioridad;

public ThreadInfo(Thread thread,String name, String type, int Prioridad){
	this.thread = thread;
    this.name = name;
    this.type = type;
    this.Prioridad = Prioridad;
	
}
public Thread getThread() {
    return thread;
}

public String getName() {
    return name;
}

public String getType() {
    return type;
}

public int getPriority() {
    return Prioridad;
}

public boolean isReader() {
    return "LECTOR".equals(type);
}

public boolean isWriter() {
    return "ESCRITOR".equals(type);
}

}
