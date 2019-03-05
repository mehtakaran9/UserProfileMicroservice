package com.scrapbook.UserProfileMicroservice.exceptions;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Already Following!")
public class AlreadyFollowing extends RuntimeException {
}
