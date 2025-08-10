# 💰 Sistema Bancário em Java

Um **sistema bancário simples** desenvolvido em Java para praticar **programação orientada a objetos** e conceitos fundamentais.  
O projeto simula operações bancárias reais e inclui um **validador de CPF real** para o cadastro de clientes.



## 🚀 Funcionalidades

- 👤 **Cadastro de clientes e contas**
- 💵 **Depósito** em conta
- 💸 **Saque** com verificação de saldo
- 🔄 **Transferência** entre contas
- 🆔 **Validador de CPF real**
- 🏦 **Gerador aleatório de número de conta**



## 🛠️ Tecnologias Utilizadas

- **Java** (POO)
- **Java Collections** (`ArrayList`)
- **Scanner** para entrada de dados no console
- **Date** para registrar data/hora das transações



## 📂 Estrutura do Projeto

```bash
src/
└── application/
    ├── Main.java
    ├── enums/
    │   ├── AgencyLocality.java
    │   └── Bank.java
    ├── exceptions/
    │   ├── AccountAmountException.java
    │   ├── AccountBirthException.java
    │   ├── AccountCpfException.java
    │   ├── AccountInitialDepositException.java
    │   ├── AccountNameException.java
    │   ├── AccountNumberException.java
    │   ├── AccountTransferException.java
    │   ├── AccountWithdrawException.java
    │   ├── AgencyBankException.java
    │   └── MainMenuException.java
    ├── model/
    │   ├── Account.java
    │   ├── Agency.java
    │   └── Client.java
    ├── service/
    │   ├── AccountService.java
    │   └── BankingSystem.java
    ├── utils/
    │   ├── Formatter.java
    │   └── Validator.java
    └── view/
        └── Menu.java
```


## 🎯 Objetivos de Aprendizado

- Criação e uso de classes e objetos
- Encapsulamento
- Métodos e validações
- Manipulação de listas e coleções
- Estruturas de repetição e condições
- Simulação de recursos reais (validação de CPF)


## 📌 Como Executar

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/richarddherrera/banking-system.git
Abrir no seu IDE Java favorito (IntelliJ IDEA, Eclipse, NetBeans)
ou compilar/executar pelo terminal:


## 📜 Licença
Projeto criado para fins educacionais.
Sinta-se à vontade para modificar e melhorar! 🚀