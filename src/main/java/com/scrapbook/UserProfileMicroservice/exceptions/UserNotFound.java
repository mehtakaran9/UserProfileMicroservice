package com.scrapbook.UserProfileMicroservice.exceptions;/* Made by: mehtakaran9 */


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No User Found")
public class UserNotFound extends RuntimeException {

}
