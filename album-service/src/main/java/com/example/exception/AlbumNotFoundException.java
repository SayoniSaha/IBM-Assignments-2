package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AlbumNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;	

}
