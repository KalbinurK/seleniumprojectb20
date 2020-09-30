package com.cybertek.tests.Project;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

@Test
public class JavaFakerExamples {

    public void faker_test(){

        Faker faker = new Faker();

        String firstName= faker.name().firstName();

        System.out.println("first name: "+firstName);

        String lastName = faker.name().lastName();

        System.out.println("last name: "+lastName);

        String fullName = faker.name().fullName();
        System.out.println("full name: "+fullName);

        String fact= faker.chuckNorris().fact();
        System.out.println("fact: "+fact);

    }
}
