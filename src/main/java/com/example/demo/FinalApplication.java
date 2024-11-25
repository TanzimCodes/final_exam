package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalApplication  implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// Manually test MongoDB operations here

		// 1. Create some sample Person objects
//		Person person1 = new Person("John Doe", 30);
//		Person person2 = new Person("Alice", 25);
//		Person person3 = new Person("Bob", 40);
//
//		// 2. Save them into MongoDB using the repository
//		personRepository.save(person1);
//		personRepository.save(person2);
//		personRepository.save(person3);
//
//
//		// 3. Retrieve and print all saved persons
//		System.out.println("All Persons:");
//		personRepository.findAll().forEach(person -> System.out.println(person));
//
//		// 4. Retrieve a person by name (example query)
//		Person foundPerson = personRepository.findByName("Alice");
//		System.out.println("\nPerson found by name (Alice):");
//		System.out.println(foundPerson);
//
//		// 5. Delete a person by name
//		personRepository.deleteById(person1.getId());
//		System.out.println("\nAfter Deleting John Doe:");
//		personRepository.findAll().forEach(person -> System.out.println(person));

	}
}
