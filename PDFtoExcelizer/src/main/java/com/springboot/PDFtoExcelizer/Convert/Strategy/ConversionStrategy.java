package com.springboot.PDFtoExcelizer.Convert.Strategy;

public interface ConversionStrategy {

    void convert(String inputFilePath, String outputFilePath);
}
