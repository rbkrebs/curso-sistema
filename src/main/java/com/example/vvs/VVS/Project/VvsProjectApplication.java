package com.example.vvs.VVS.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication()
public class VvsProjectApplication {

	public static void main(String[] args) {
		/*
		SpringApplication.run(VvsProjectApplication.class, args);*/
		new SpringApplicationBuilder()
				.profiles("dev") // and so does this
				.sources(VvsProjectApplication.class)
				.run(args);
	}


	}

