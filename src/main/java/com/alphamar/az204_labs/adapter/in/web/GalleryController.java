package com.alphamar.az204_labs.adapter.in.web;

import com.alphamar.az204_labs.application.in.RetrieveImageService;
import com.alphamar.az204_labs.domain.model.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/galleries")
@RequiredArgsConstructor
class GalleryController {
    private final RetrieveImageService retrieveImageService;

    @GetMapping
    ResponseEntity<List<ImageDto>> images(){
        return ResponseEntity.ok(this.retrieveImageService.imagesList());
    }

    @GetMapping("/{filename}")
    ResponseEntity<Resource> downloadImage(@PathVariable("filename") String filename) {
        return null;
    }
}
