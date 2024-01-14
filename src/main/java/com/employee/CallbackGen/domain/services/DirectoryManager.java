package com.employee.CallbackGen.domain.services;

import com.employee.CallbackGen.utils.Common;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DirectoryManager {
    public static File[] getAllResultListFile(String path){
        File directory = new File(path);
        return directory.exists() && directory.isDirectory() ? directory.listFiles() : null;
    }

    public static String clearTheFilesInPath (String path, String dataName) {
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            assert files != null;
            for (File file : files)
                if (file.isFile()) file.delete();
            files = directory.listFiles();
            assert files != null;
            if (files.length == 0) return "Directory (" + dataName + ") has been successfully cleared";
            else return "Something wrong! File quantity: " + files.length;
        } else {
            String msg = "Directory: \"" + directory + "\" does not exist or is not a directory.";
            System.out.println(msg);
            return msg;
        }
    }

    public static ByteArrayResource createZipResource(File[] files) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            for (File file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fileInputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }
                    zipOutputStream.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayResource(byteArrayOutputStream.toByteArray());
    }

    public static HttpHeaders getZipHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", Common.getOutputZipNamePattern());
        return headers;
    }
}
