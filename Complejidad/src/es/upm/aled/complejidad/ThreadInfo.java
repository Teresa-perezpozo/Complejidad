package es.upm.aled.complejidad;

public class ThreadInfo {
Thread thread;
String name;
String type;
int priority;

public ThreadInfo(Thread thread,String name, String type, int priority){
	this.thread = thread;
    this.name = name;
    this.type = type;
    this.priority = priority;
	
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
    return priority;
}

public boolean isReader() {
    return "LECTOR".equals(type);
}

public boolean isWriter() {
    return "ESCRITOR".equals(type);
}

}
