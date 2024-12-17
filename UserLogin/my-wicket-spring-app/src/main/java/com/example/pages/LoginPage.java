package com.example.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.services.UserService;
import com.example.model.User;

@Component
public class LoginPage extends WebPage{
	@Autowired
    private UserService userService;

    private String userid;
    private String password;

    public LoginPage(final PageParameters parameters) {
        Form<Void> form = new Form<Void>("loginForm") {
            @Override
            protected void onSubmit() {
                User user = userService.findUser ByUserid(userid);
                if (user != null && user.getPassword().equals(password)) {
                    setResponsePage(HelloPage.class);
                } else {
                    error("Invalid UserId or Password");
                }
            }
        };

        form.add(new TextField<>("userid", Model.of(userid)).setRequired(true));
        form.add(new PasswordTextField("password", Model.of(password)).setRequired(true));
        add(form);
    }

}
