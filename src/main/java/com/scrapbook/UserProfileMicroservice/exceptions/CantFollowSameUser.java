package com.scrapbook.UserProfileMicroservice.exceptions;/* Made by: mehtakaran9 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Can't Follow Same User")
public class CantFollowSameUser extends RuntimeException{

}
