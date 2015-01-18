package sample1;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * DIコンテナの勉強＠Google Guice
 * URL:http://qiita.com/opengl-8080/items/6fb69cd2493e149cac3a
 * 必要なJar
 * ・guice-3.0.jar
 * ・javax.inject.jar
 * ・aopaliance.jar
 * @author
 *
 */
public class GuiceMain {
	 @Inject
	    private HelloWorld helloWorld;

	    public static void main(String[] args) {
	        Injector injector = Guice.createInjector(new AbstractModule() {
	            @Override protected void configure() {}
	        });

	        GuiceMain main = injector.getInstance(GuiceMain.class);
	        main.helloWorld.hello();
	    }

}
