package rcpClient;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;



public   class loadJar {
		private URLClassLoader urlClassLoader;
		public loadJar(URLClassLoader urlClassLoader) {
			this.urlClassLoader = urlClassLoader;
		}
		
		public void loadJar(URL url) throws Exception {
			Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			addURL.setAccessible(true);
			addURL.invoke(urlClassLoader, url);
		}
	

private static void loadjar(loadJar jarLoader, String path) throws MalformedURLException, Exception{
		File libdir = new File(path);
		if (libdir != null && libdir.isDirectory()) {
			
			File[] listFiles = libdir.listFiles(new FileFilter() {
				
			
				public boolean accept(File file) {
					// TODO Auto-generated method stub
					return file.exists() && file.isFile() && file.getName().endsWith(".jar");
				}
			});
			
			for (File file : listFiles) {
				jarLoader.loadJar(file.toURI().toURL());
			}
			
		}else{
			System.out.println("[Console Message] Directory ["+path+"] does not exsit, please check it");
			System.exit(0);
		}
	}

public static void main(String[] args) throws MalformedURLException, Exception {
		loadJar jarLoader = new loadJar((URLClassLoader)ClassLoader.getSystemClassLoader());

                loadjar(jarLoader, System.getProperty("user.dir")+"\\lib");
}
}