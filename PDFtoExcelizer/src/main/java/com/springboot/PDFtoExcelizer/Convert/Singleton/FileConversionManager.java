package com.springboot.PDFtoExcelizer.Convert.Singleton;

import com.springboot.PDFtoExcelizer.Convert.Strategy.ConversionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileConversionManager {
    private static final Logger logger = LoggerFactory.getLogger(FileConversionManager.class);
    private ConversionStrategy strategy;

    public FileConversionManager() {
        logger.info("Initializing FileConversionManager");
    }

    public void setStrategy(ConversionStrategy strategy) {
        this.strategy = strategy;
        logger.info("Strategy set to: {}", strategy.getClass().getSimpleName());
    }

    public void convertFile(String inputPath, String outputPath) {
        if (strategy == null) {
            throw new IllegalStateException("Estratégia de conversão não definida");
        }
        strategy.convert(inputPath, outputPath);
    }
}