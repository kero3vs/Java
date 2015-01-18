package sample3;

import sample2.MyInterceptor;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.matcher.Matchers;

public class GuiceMain {

    @Inject
    private Speaker speaker;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override protected void configure() {
                bind(Speaker.class).to(EnglishSpeaker.class);
                bindInterceptor(new MyMatcher(), Matchers.any(), new MyInterceptor());
            }
        });

        GuiceMain main = injector.getInstance(GuiceMain.class);
        main.speaker.thankYou();
    }
}