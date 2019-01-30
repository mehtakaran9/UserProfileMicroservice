package com.scrapbook.UserProfileMicroservice.exceptions;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Null Values are not accepted")
public class NullValueException extends RuntimeException{
}
