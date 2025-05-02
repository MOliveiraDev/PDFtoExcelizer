package com.springboot.PDFtoExcelizer.Convert.Strategy.Impl;

import com.springboot.PDFtoExcelizer.Convert.Strategy.ConversionStrategy;
import com.springboot.PDFtoExcelizer.Reader.PdfReader;
import com.springboot.PDFtoExcelizer.Writer.ExcelWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PdfToExcelStrategy implements ConversionStrategy {
    private static final Logger logger = LoggerFactory.getLogger(PdfToExcelStrategy.class);

    public PdfToExcelStrategy(PdfReader pdfReader, ExcelWriter excelWriter) {
    }

    @Override
    public void convert(String inputPath, String outputPath) {
        try {
            String extractedText = PdfReader.extractTextFromPdf(inputPath);
            ExcelWriter.writeToExcel(extractedText, outputPath);
            logger.info("PDF file converted to Excel: {}", outputPath);
        } catch (Exception e) {
            logger.error("Error processing file {}: {}", inputPath, e.getMessage(), e);
        }
    }
}