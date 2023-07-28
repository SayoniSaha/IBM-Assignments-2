package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlbumDto {
	private long id;
    private String albumId;
    private String userId;
    private String name;
    private String description;
	
}
