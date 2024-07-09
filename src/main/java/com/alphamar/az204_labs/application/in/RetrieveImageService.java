package com.alphamar.az204_labs.application.in;

import com.alphamar.az204_labs.domain.model.ImageDto;

import java.util.List;

public interface RetrieveImageService {
    List<ImageDto> imagesList();
    String getImagePathByName(String name);
}
