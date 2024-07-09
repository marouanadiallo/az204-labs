package com.alphamar.az204_labs.application.out;

import com.alphamar.az204_labs.domain.model.ImageDto;

import java.util.List;

public interface RetrieveImagePort {
    List<ImageDto> getAll();
    String readResource(String name);
}
