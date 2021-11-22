package _00_Java_language._classLoading;

import java.net.URL;

public class ClassLoaderTest {

    public static void main(String[] args) {

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls){
            System.out.println(url.toExternalForm());
        }
    }
}