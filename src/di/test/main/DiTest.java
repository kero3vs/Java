package di.test.main;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import di.test.IF.Convert;

public class DiTest {

    @Inject
    private Convert convert;


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override protected void configure() {
                try {
					bind(Convert.class).to((Class<? extends Convert>) Class.forName("di.test.plugin." + args[0]));
				} catch (ClassNotFoundException e) {
					System.out.println("Pluginが存在しません");
					System.exit(0);
				}
            }
        });

        DiTest main = injector.getInstance(DiTest.class);
        System.out.println(main.convert.convert(args[1]));
    }

}
