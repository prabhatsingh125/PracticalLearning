package com.example.textextractor.TextExtractor.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TextExtractionController {

    @PostMapping("/extract")
    public ResponseEntity<List<String>> extractText(@RequestParam("file") MultipartFile file) throws IOException {
        List<String> textList = new ArrayList<>();
        Object result = null;
        String fileName = file.getOriginalFilename();

//        if (fileName.endsWith(".docx")) {
//            // Extract text from Word document
//            File tempFile = File.createTempFile("temp", ".docx");
//            file.transferTo(tempFile);
//            WordExtractor extractor = new WordExtractor(tempFile);
//            String text = extractor.getText();
//            textList.add(text);
//            extractor.close();
//            tempFile.delete();
      //  } else

            if (fileName.endsWith(".pdf")) {
            // Extract text from PDF document
            File tempFile = File.createTempFile("temp", ".pdf");
            file.transferTo(tempFile);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(PDDocument.load(tempFile));
            textList.add(text);
            textList.add("\r\n");
            //stripper.close();
            tempFile.delete();
        } else {
            throw new IllegalArgumentException("File must be a Word or PDF document");
        }

        return ResponseEntity.ok(textList);
    }
}
