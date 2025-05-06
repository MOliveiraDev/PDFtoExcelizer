package com.springboot.PDFtoExcelizer.Configuration;

import com.springboot.PDFtoExcelizer.Convert.Singleton.FileConversionManager;
import com.springboot.PDFtoExcelizer.Convert.Strategy.Impl.PdfToExcelStrategy;
import com.springboot.PDFtoExcelizer.Reader.PdfReader;
import com.springboot.PDFtoExcelizer.Writer.ExcelWriter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class AppConfig extends SpringBootServletInitializer {

    @Bean
    public PdfReader pdfReader() {
        return new PdfReader();
    }

    @Bean
    public ExcelWriter excelWriter() {
        return new ExcelWriter();
    }

    @Bean
    public FileConversionManager fileConversionManager() {
        return new FileConversionManager();
    }

    @Bean
    public PdfToExcelStrategy pdfToExcelStrategy(PdfReader pdfReader, ExcelWriter excelWriter) {
        return new PdfToExcelStrategy(pdfReader, excelWriter);
    }
}
