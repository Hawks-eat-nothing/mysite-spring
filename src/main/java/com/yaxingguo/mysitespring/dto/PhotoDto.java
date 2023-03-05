package com.yaxingguo.mysitespring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class firstPagePhoto {
    private Long id;
    private String resolution;
    private String position;
    private String description;
    private String url;
}
