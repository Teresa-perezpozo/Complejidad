package es.upm.aled.complejidad;

import java.util.*;
import java.util.concurrent.locks.*;
import java.util.stream.Collectors;

public class GestorThreads2_3 {

	private int valor =0;
	private final Lock accessLock = new ReentrantLock();
	//condición para esperar
	private final Condition waitingCondition = accessLock.newCondition();
	
	//estados de la máquina de estados
	private boolean isWriting = false;
	private int activeReaders =0;
	
	
}
