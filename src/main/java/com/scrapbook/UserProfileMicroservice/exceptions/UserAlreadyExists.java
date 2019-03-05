package com.scrapbook.UserProfileMicroservice.exceptions;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User Already Exists!")
public class UserAlreadyExists extends RuntimeException {
}
