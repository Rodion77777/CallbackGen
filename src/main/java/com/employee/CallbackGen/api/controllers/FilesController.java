package com.employee.CallbackGen.api.controllers;

import com.employee.CallbackGen.domain.services.DirectoryManager;
import com.employee.CallbackGen.utils.Common;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/files")
public class FilesController {
    @GetMapping("downloadZip")
    public ResponseEntity<Resource> downloadAllInZipFile() {
        File[] fileList = DirectoryManager.getAllResultListFile(Common.getScreenshotPath());
        if (fileList == null || fileList.length == 0)
            return ResponseEntity.notFound().build();
        HttpHeaders headers = DirectoryManager.getZipHeaders();

        ByteArrayResource zipResource = DirectoryManager.createZipResource(fileList);
        return ResponseEntity.ok()
                .headers(headers)
                .body(zipResource);
    }

    @PostMapping("clearResultStorage")
    public String clearResultStorage(){
        return DirectoryManager.clearTheFilesInPath(Common.getScreenshotPath(), "Screenshot path");
    }
}
