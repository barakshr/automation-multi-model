package com.team.selenium.controls.api;


import com.team.selenium.controls.elements.Control;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.*;
import java.util.List;


public class ControlFieldDecorator implements FieldDecorator {

    protected ElementLocatorFactory factory;

    public ControlFieldDecorator(ElementLocatorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {

        if (!(WebElement.class.isAssignableFrom(field.getType()) || Control.class.isAssignableFrom(field.getType()) || isDecoratableList(field))) {
            return null;
        }
        ElementLocator locator = factory.createLocator(field);
        if (locator == null) {
            return null;
        }
        Class<?> fieldType = field.getType();
        if (WebElement.class.isAssignableFrom(fieldType) || Control.class.isAssignableFrom(field.getType())) {

            return proxyForLocator(loader, fieldType, locator);
        } else if (List.class.isAssignableFrom(fieldType)) {
            Class<?> erasureClass = getErasureClass(field);
            return proxyForListLocator(loader, erasureClass, locator);
        } else {
            return null;
        }
    }

    private Class getErasureClass(Field field) {
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }
        return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
    }


    protected boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        } else {
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return false;
            } else {
                Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                return (WebElement.class.equals(listType) || listType.getClass().isInstance(Control.class)) && (field.getAnnotation(FindBy.class) != null || field.getAnnotation(FindBys.class) != null || field.getAnnotation(FindAll.class) != null);
            }
        }
    }

    protected <T> T proxyForLocator(ClassLoader loader, Class<T> interfaceType, ElementLocator locator) {
        if (interfaceType.equals(WebElement.class)) {
            InvocationHandler handler = new LocatingElementHandler(locator);
            return interfaceType.cast(Proxy.newProxyInstance(loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class}, handler));
        } else {
            InvocationHandler handler = new ControlHandler(interfaceType, locator);
            return interfaceType.cast(Proxy.newProxyInstance(loader, new Class[]{interfaceType, WebElement.class, WrapsElement.class, Locatable.class}, handler));
        }

    }

    protected <T> List<T> proxyForListLocator(ClassLoader loader, Class<T> interfaceType, ElementLocator locator) {
        InvocationHandler handler;
        if (interfaceType.equals(WebElement.class)) {
            handler = new LocatingElementListHandler(locator);
        } else {
            handler = new ControlListHandler(interfaceType, locator);
        }
        return (List<T>) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);

    }
}
