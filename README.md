# PDFtoExcelizer

O **PDFtoExcelizer** é um projeto desenvolvido em Java com Spring Boot que automatiza o processo de conversão de arquivos PDF para o formato Excel (.xlsx). O projeto monitoriza uma pasta de entrada para identificar arquivos PDF, os converte para Excel e, em seguida, move os arquivos convertidos para uma pasta de saída. Após a conversão, o arquivo PDF original é removido automaticamente.

## Funcionalidade

- **Monitora uma pasta** de entrada (`input/`) para detectar arquivos PDF.
- **Converte automaticamente** o conteúdo de arquivos PDF para um arquivo Excel (.xlsx).
- **Armazena os arquivos convertidos** na pasta de saída (`Excel/`).
- **Remove o arquivo PDF original** após a conversão, após uma espera de 2 segundos.

## Como Rodar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/PDFtoExcelizer.git

```
## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot** (para criação da aplicação e agendamento de tarefas)
- **Apache POI** (para manipulação de arquivos Excel)
- **Lombok** (para simplificação de código)
