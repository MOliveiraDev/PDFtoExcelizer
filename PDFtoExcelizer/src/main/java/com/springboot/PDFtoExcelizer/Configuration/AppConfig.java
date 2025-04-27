package com.springboot.PDFtoExcelizer.Configuration;

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
}
