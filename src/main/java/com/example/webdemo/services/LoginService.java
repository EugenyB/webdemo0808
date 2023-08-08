package com.example.webdemo.services;

import com.example.webdemo.data.User;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Service
public class LoginService {

    public Optional<User> login(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split(" ");
                if (s[0].equals(login) && s[1].equals(password)) {
                    return Optional.of(new User(s[2].replace('_', ' '), login, password));
                }
            }
            return Optional.empty();
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
