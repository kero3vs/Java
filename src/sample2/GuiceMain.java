package sample2;

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
                try {
					bind(Speaker.class).to((Class<? extends Speaker>) Class.forName("sample2.JapaneseSpeaker"));
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
                bindInterceptor(Matchers.any(), Matchers.any(), new MyInterceptor());
            }
        });

        GuiceMain main = injector.getInstance(GuiceMain.class);
        main.speaker.thankYou();
    }
}