package com.filipe.datasearch.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.filipe.datasearch.domain.User;
import com.filipe.datasearch.repository.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private UserRepository userRepository;

	@Autowired
	public DataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void run(ApplicationArguments args) {
		ArrayList<User> users = new ArrayList<>();

		if (userRepository.count() < 1) {
			try {
				File file = ResourceUtils.getFile("classpath:database.csv");
				InputStream in = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));

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

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}