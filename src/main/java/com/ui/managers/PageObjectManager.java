package com.ui.managers;

import lombok.extern.log4j.Log4j;
import org.reflections.Reflections;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Log4j
public class PageObjectManager {
    Map<Class<?>, Object> pages = new HashMap<>();

    public PageObjectManager(String pagesLocation) {
        Reflections reflections = new Reflections(pagesLocation);

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Page.class);
        for (Class<?> cl : annotated) {
            log.debug("Init page " + cl.getSimpleName());
            try {
                Constructor<?> constr = cl.getConstructor(String.class);
                pages.put(cl, cl.cast(constr.newInstance(cl.getSimpleName())));
            } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T get(Class<T> pageClass) {
        return pageClass.cast(pages.get(pageClass));
    }

    public Map<Class<?>, Object> getPages() {
        return pages;
    }

}