package com.springboot.PDFtoExcelizer.Convert;

import com.springboot.PDFtoExcelizer.Reader.PdfReader;
import com.springboot.PDFtoExcelizer.Writer.ExcelWriter;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;

@Service
@Builder
public class PdfToExcelConvert {

    private static final Logger logger = LoggerFactory.getLogger(PdfToExcelConvert.class);

    private final PdfReader pdfReader;
    private final ExcelWriter excelWriter;

    @Scheduled(fixedDelay = 2000)
    public void processPdfFile() {
        String inputFolderPath = "Caminho da pasta com os arquivos";
        File inputDir = new File(inputFolderPath);
        File[] files = inputDir.listFiles(dir -> dir.isFile() && dir.getName().endsWith(".pdf"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                String pdfFilePath = file.getAbsolutePath();
                String outputFolderPath = "Caminho da pasta para salvar os arquivos";
                String outputFilePath = Paths.get(outputFolderPath, file.getName().replace(".pdf", ".xlsx")).toString();

                try {
                    String extractedText = PdfReader.extractTextFromPdf(pdfFilePath);
                    ExcelWriter.writeToExcel(extractedText, outputFilePath);
                    logger.info("PDF file converted to Excel: {}", outputFilePath);
                } catch (Exception e) {
                    logger.error("Error processing file {}: {}", pdfFilePath, e.getMessage(), e);
                }
            }
        } else {
            logger.info("No PDF files found in the input directory.");
        }
    }
}
