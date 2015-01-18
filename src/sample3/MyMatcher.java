package sample3;

import com.google.inject.matcher.AbstractMatcher;

public class MyMatcher extends AbstractMatcher<Class<?>> {

    @Override
    public boolean matches(Class<?> clazz) {
        return clazz.getSimpleName().endsWith("Speaker");
    }
}