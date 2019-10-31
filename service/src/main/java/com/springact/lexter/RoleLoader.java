package com.spring.lexter;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component
public class RoleLoader implements ApplicationListener<ContextRefreshedEvent> {
    private Logger log = Logger.getLogger(RoleLoader.class.getName());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Role role = new Role();
        role.setRole("RoleLoad");
        log.info("Saved Role - id: " + role);
    }
}