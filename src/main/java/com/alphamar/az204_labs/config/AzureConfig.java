package com.alphamar.az204_labs.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.BlobServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureConfig {
    @Value("${azure.storage.blob.connection-string}")
    private String connectionString;
    @Value("${azure.storage.blob.container-name}")
    private String containerName;

    @Bean
    public BlobServiceClient blobServiceClient() {
        BlobContainerClientBuilder blobContainerClientBuilder = new  BlobContainerClientBuilder();
        return blobContainerClientBuilder.connectionString(this.connectionString)
                .buildClient()
                .getServiceClient();
    }
    @Bean
    public BlobContainerClient blobContainerClient() {
        return blobServiceClient().getBlobContainerClient(this.containerName);
    }
}
