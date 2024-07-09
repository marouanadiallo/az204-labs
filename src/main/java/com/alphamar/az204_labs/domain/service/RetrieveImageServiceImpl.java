package com.alphamar.az204_labs.domain.service;

import com.alphamar.az204_labs.application.in.RetrieveImageService;
import com.alphamar.az204_labs.application.out.RetrieveImagePort;
import com.alphamar.az204_labs.domain.model.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class RetrieveImageServiceImpl implements RetrieveImageService {

    private final RetrieveImagePort retrieveImagePort;

    @Override
    public List<ImageDto> imagesList() {

        return this.retrieveImagePort.getAll();

    }

    @Override
    public String getImagePathByName(String name) {
        if(name == null || name.isBlank()) return null;
        return this.retrieveImagePort.readResource(name.trim());
    }
}
