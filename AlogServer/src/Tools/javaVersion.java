package Tools;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.BlockingQueue;

public class javaVersion {
	@SuppressWarnings("LoopStatementThatDoesntLoop")
    public static int javaVersion0() {
        int javaVersion;

        // Not really a loop
        for (;;) {
            

            try {
                Class.forName("java.time.Clock", false, getClassLoader(Object.class));
                javaVersion = 8;
                break;
            } catch (Exception e) {
                // Ignore
            }

            try {
                Class.forName("java.util.concurrent.LinkedTransferQueue", false, getClassLoader(BlockingQueue.class));
                javaVersion = 7;
                break;
            } catch (Exception e) {
                // Ignore
            }

            javaVersion = 6;
            break;
        }

        return javaVersion;
    }
	static ClassLoader getClassLoader(final Class<?> clazz) {
        if (System.getSecurityManager() == null) {
            return clazz.getClassLoader();
        } else {
            return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
                public ClassLoader run() {
                    return clazz.getClassLoader();
                }
            });
        }
    }
	
	public static void main(String args[]){
		System.out.println(javaVersion0());
	}
}
