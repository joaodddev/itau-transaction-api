# 🚀 Desafio Itaú Backend - API de Transações

API REST desenvolvida com Java + Spring Boot para processamento de transações financeiras em tempo real.

## 📌 Funcionalidades

- ✅ Receber transações
- ✅ Limpar transações
- ✅ Calcular estatísticas dos últimos 60 segundos

## 🧠 Regras de negócio

- Não aceita valores negativos
- Não aceita datas futuras
- Armazenamento em memória
- Estatísticas apenas dos últimos 60 segundos

## 📊 Estatísticas retornadas

- Count
- Sum
- Avg
- Min
- Max

## 🚀 Tecnologias

- Java 17
- Spring Boot
- API REST
- Programação funcional (Streams)

## ▶️ Como rodar

```bash
mvn spring-boot:run
