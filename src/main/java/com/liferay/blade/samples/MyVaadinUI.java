package com.liferay.blade.samples;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import com.vaadin.osgi.liferay.VaadinLiferayPortletConfiguration;
import com.vaadin.server.VaadinServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//@SpringUI
//@SuppressWarnings("serial")
@Theme("valo")
@VaadinLiferayPortletConfiguration(name = "Vaadin.Tutorial.1", displayName = "Vaadin Tutorial App")
@Component(service = UI.class, scope = ServiceScope.PROTOTYPE)
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    public static class Servlet extends VaadinServlet {
    }

    @WebListener
    public static class MyContextLoaderListener extends ContextLoaderListener {
    }

    @Configuration
    @EnableVaadin
    public static class MyConfiguration {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Marcin cho na fife"));
            }
        });
        layout.addComponent(button);
    }
}
