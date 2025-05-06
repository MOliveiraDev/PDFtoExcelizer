package com.springboot.PDFtoExcelizer.Convert;

import com.springboot.PDFtoExcelizer.Convert.Singleton.FileConversionManager;
import com.springboot.PDFtoExcelizer.Convert.Strategy.Impl.PdfToExcelStrategy;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Paths;

@Service
public class PdfToExcelConvert {
    private static final Logger logger = LoggerFactory.getLogger(PdfToExcelConvert.class);

    private final FileConversionManager conversionManager;
    private final PdfToExcelStrategy pdfToExcelStrategy;

    @Autowired
    public PdfToExcelConvert(FileConversionManager conversionManager, 
                            PdfToExcelStrategy pdfToExcelStrategy) {
        this.conversionManager = conversionManager;
        this.pdfToExcelStrategy = pdfToExcelStrategy;
    }

    @PostConstruct
    public void init() {
        conversionManager.setStrategy(pdfToExcelStrategy);
    }

    @Scheduled(fixedDelay = 2000)
    public void processPdfFile() {
        String inputFolderPath = "Caminho da pasta com os arquivos";
        File inputDir = new File(inputFolderPath);
        File[] files = inputDir.listFiles(dir -> dir.isFile() && dir.getName().endsWith(".pdf"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                String pdfFilePath = file.getAbsolutePath();
                String outputFolderPath = "Caminho da pasta para salvar os arquivos";
                String outputFilePath = Paths.get(outputFolderPath, 
                    file.getName().replace(".pdf", ".xlsx")).toString();

                conversionManager.convertFile(pdfFilePath, outputFilePath);
            }
        } else {
            logger.info("No PDF files found in the input directory.");
        }
    }
}