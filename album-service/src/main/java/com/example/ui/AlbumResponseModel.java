package com.example.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlbumResponseModel {
    private String albumId;
    private String userId;
    private String name;
    private String description;

}
