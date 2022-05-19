package com.filipe.datasearch.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.filipe.datasearch.domain.Priority;
import com.filipe.datasearch.domain.User;
import com.filipe.datasearch.repository.PriorityRepository;
import com.filipe.datasearch.repository.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private UserRepository userRepository;
	private PriorityRepository priorityRepository;

	@Autowired
	public DataLoader(UserRepository userRepository,PriorityRepository priorityRepository) {
		this.userRepository = userRepository;
		this.priorityRepository = priorityRepository;
		
	}

	public void run(ApplicationArguments args) {
		
		insertUsers();
		insertPriority("lista_relevancia_2.txt", 2);
		insertPriority("lista_relevancia_1.txt", 1);
		
		
	}

	private void insertUsers() {
		ArrayList<User> users = new ArrayList<>();

		if (userRepository.count() < 1) {
			File file = null;
			BufferedReader reader = null;

			try {
				file = ResourceUtils.getFile("classpath:database.csv");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try(InputStream in = new FileInputStream(file)){     
				reader = new BufferedReader(new InputStreamReader(in));

				while (reader.ready()) {
					String line = reader.readLine();
					String[] userLine = line.split(",");

					User user = new User();
					user.setId(userLine[0]);
					user.setName(userLine[1]);
					user.setPassword(userLine[2]);
					users.add(user);

				}

				userRepository.saveAll(users);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	
	private void insertPriority(String classPath, int priorityNumber) {
		ArrayList<Priority> priorities = new ArrayList<>();

		File file = null;
		BufferedReader reader = null;

		try {
			file = ResourceUtils.getFile("classpath:" + classPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try(InputStream in = new FileInputStream(file)){     
			reader = new BufferedReader(new InputStreamReader(in));

			while (reader.ready()) {
				String line = reader.readLine();
				Priority priority = new Priority();

				priority.setId(line);
				priority.setOrder(priorityNumber);
				
				Optional<Priority> findById = priorityRepository.findById(priority.getId());
				if(findById.isPresent()) {
					priority = findById.get();
					priority.setOrder(priorityNumber);

				}
				priorities.add(priority);
				
			}

			priorityRepository.saveAll(priorities);

		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}