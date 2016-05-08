package mx.edu.utng.franciscojs.juegos;

import android.util.Log;

import java.util.Set;

public class ThreadUtils {

	public static void showThreadNames() { 
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
		for(Thread t : threadArray) { 
			Log.d("THREAD", "Thread: " + t.getName());
		}
	}
	
	public static void showThreads() {

        // Sube por todo el camino hasta el grupo de hilos de raíz . Tomado de la
// Mismo artículo stackoverflow como listThreads .
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parent;
        while ((parent = rootGroup.getParent()) != null) {
            rootGroup = parent;
        }

        listThreads(rootGroup, "");
	}
	
	/**
     * Lista de todas las discusiones y de forma recursiva lista de todos los subgrupos . Este método es
     * Tomado del artículo de StackOverflow en:
     * http://stackoverflow.com/questions/1323408/get-a-list-of-all-threads-currently-running-in-java
     *
     */
    private static void listThreads(ThreadGroup group, String indent) {
        System.out.println(indent + "Group[" + group.getName() + 
                        ":" + group.getClass()+"]");
        int nt = group.activeCount();
        Thread[] threads = new Thread[nt*2 + 10]; //nt is not accurate
        nt = group.enumerate(threads, false);

        // List every thread in the group
        for (int i=0; i<nt; i++) {
            Thread t = threads[i];
            
            Log.d("THREAD", indent + "  Thread[" + t.getName() 
                        + ":" + t.getClass() + "]");
        }

        // Recursively list all subgroups
        int ng = group.activeGroupCount();
        ThreadGroup[] groups = new ThreadGroup[ng*2 + 10];
        ng = group.enumerate(groups, false);

        for (int i=0; i<ng; i++) {
            listThreads(groups[i], indent + "  ");
        }
    }
}