package com.javatest.user.model.user;

import java.util.List;

import com.javatest.user.model.profile.Profile;

public record RegisterDTO(String login, String password, String email, List<Profile> profiles) {
}
