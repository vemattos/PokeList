## **🏆 PokeList**  
Bem-vindo ao PokeList! Este projeto foi desenvolvido com o objetivo de ensinar os conceitos básicos de interação entre **Front-End (Angular)** e **Back-End (Spring Boot)**, mostrando como funciona um **CRUD** (Create, Read, Update, Delete).

---

## **⚙️ Tecnologias Utilizadas**  
- 🔹 **Front-End**: Angular + TypeScript  
- 🔹 **Back-End**: Spring Boot + Java  
- 🔹 **Banco de Dados**: MariaDB  
- 🔹 **Gerenciador de Dependências**: Maven  
- 🔹 **Estilização**: CSS  

---

## **🚀 Funcionalidades**  
- ✅ **Listar Pokémon** 📜  
- ✅ **Adicionar um novo Pokémon** ➕  
- ✅ **Editar Pokémon** ✏️  
- ✅ **Deletar Pokémon** ❌  
- ✅ **Comunicação entre Angular e Spring Boot via API REST**  
- ✅ **Interface responsiva com Ionic**  

---

## **🛠️ Como Rodar o Projeto**  

### 🔹 **1. Clone o Repositório**  
```bash
git clone https://github.com/seu-usuario/PokeList.git
cd PokeList
```
### 🔹 **2. Configurar o Banco de Dados (MariaDB)**
- Instale e inicie o MariaDB.
- Crie um banco de dados chamado pokelist
- Configure a conexão no application.properties do Spring Boot:
No arquivo spring/src/main/resources/application.properties, adicione as informações do banco de dados:
```bash
spring.datasource.url=jdbc:mariadb://localhost:3306/pokelist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
### 🔹 3. Rodar o Back-End (Spring Boot)
```bash
cd poke
mvn spring-boot:run
```
### 🔹 4. Rodar o Front-End (Angular)
```bash
cd poke
npm install
ng serve --open
```

---

### 🎯 Exemplo de Uso
Ao rodar o projeto, a interface permitirá cadastrar, editar e excluir Pokémon, com os dados sendo salvos no MariaDB via API REST gerenciada pelo Spring Boot.

---

### 👨‍💻 Autor
Desenvolvido por Vinicius Mattos.
