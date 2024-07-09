package com.alphamar.az204_labs.adapter.out;

import com.alphamar.az204_labs.application.out.RetrieveImagePort;
import com.alphamar.az204_labs.domain.model.ImageDto;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class AzStorageBlobAdapter implements RetrieveImagePort {
    private final BlobServiceClient blobServiceClient;

    private final BlobContainerClient blobContainerClient;

    public AzStorageBlobAdapter(BlobServiceClient blobServiceClient, BlobContainerClient blobContainerClient) {
        this.blobServiceClient = blobServiceClient;
        this.blobContainerClient = blobContainerClient;
    }

    @Override
    public List<ImageDto> getAll()  {
        List<ImageDto> imageDtoList = new ArrayList<>();
        for (BlobItem blob : this.blobContainerClient.listBlobs()) {
            imageDtoList.add(new ImageDto(blob.getName()));
        }


        return imageDtoList;
    }

    @Override
    public String readResource(String name) {
        return null;
    }
}
