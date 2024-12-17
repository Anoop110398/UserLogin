package com.example;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.spring.SpringWebApplication;
import org.apache.wicket.protocol.
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.example.pages.LoginPage;

public class MyApplication extends SpringWebApplication{
	public Class<? extends WebPage> getHomePage() {
        return LoginPage.class;
    }

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

}
