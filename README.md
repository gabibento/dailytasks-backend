
# DailyTasks - Backend  

Bem-vindo ao repositório do **backend** do **DailyTasks**, uma aplicação de listas de tarefas (*To-Do List*) desenvolvida para fins de aprendizado e prática em desenvolvimento full-stack. Este projeto utiliza **Java**, **Spring Boot** e **MySQL**, oferecendo funcionalidades completas de CRUD e autenticação para garantir a segurança do sistema.  

🔗 [Repositório do Frontend](https://github.com/gabibento/dailytasks-frontend)  

🔗 **Acesse o Projeto em Funcionamento:** [DailyTasks](https://task-manager-nsc1-git-main-gabriellas-projects-bb68f8bb.vercel.app/)  

---

## 📋 Sobre o Projeto  

O **DailyTasks** é uma aplicação que permite aos usuários gerenciar suas tarefas diárias de forma eficiente. O backend é responsável por gerenciar as operações de criação, leitura, atualização e exclusão (*CRUD*) das tarefas, além de implementar autenticação baseada em **JWT (JSON Web Tokens)** para proteger os dados do sistema.  

---

## 🚀 Funcionalidades  

### Funcionalidades Principais  
- **Cadastro de Usuários:** Permite que novos usuários criem suas contas.  
- **Login:** Usuários podem se autenticar com suas credenciais e obter um token JWT.  
- **Criação de Tarefas:** Adicione tarefas com informações como título, categoria, prioridade e data de vencimento.  
- **Leitura de Tarefas:** Liste todas as tarefas criadas pelo usuário autenticado.  
- **Atualização de Tarefas:** Edite as informações das tarefas existentes.  
- **Alteração de Status:** Marque tarefas como completas ou incompletas.  
- **Exclusão de Tarefas:** Exclua tarefas pelo ID.  

### 🔒 Segurança  
- Os endpoints de login e cadastro são abertos para todos.
- Todos os outros endpoints são protegidos e exigem autenticação por meio de um token JWT válido.

---

## 🛠️ Tecnologias Utilizadas  

### Backend  
- **Java 17**  
- **Spring Boot 3**  
  - **Spring Web:** Para criação da API REST.  
  - **Spring Data JPA:** Para integração com o banco de dados.  
  - **Spring Security:** Para autenticação e proteção dos endpoints.  
- **JWT (JSON Web Tokens):** Implementação de autenticação e controle de sessão.  
- **MySQL:** Banco de dados relacional para armazenamento de informações.  
- **Maven:** Gerenciamento de dependências.  

---

## 📂 Estrutura do Projeto  

```plaintext  
src  
├── main  
│   ├── java  
│   │   └── com.java.taskmanager  
│   │       ├── config            # Configurações gerais e CORS  
│   │       ├── controllers       # Controladores REST  
│   │       ├── dtos              # Classes para transferência de dados  
│   │       ├── entities          # Entidades do banco de dados  
│   │       ├── repositories      # Interfaces JPA  
│   │       ├── security          # Configurações e classes de segurança  
│   │       ├── services          # Regras de negócio  
│   │       └── TaskManagerApplication.java  # Classe principal da aplicação  

```  

---

## 🔗 Endpoints da API  

Aqui estão os principais endpoints disponíveis:  

### 🧑‍💻 Autenticação  
- **POST /auth/register:** Cadastro de novos usuários.  
- **POST /auth/login:** Autenticação e geração do token JWT.  

### ✅ Tarefas  
- **GET /tasks:** Lista todas as tarefas do usuário autenticado.  
- **POST /tasks:** Cria uma nova tarefa.  
- **PUT /tasks/{id}:** Atualiza uma tarefa existente.  
- **PATCH /tasks/{id}:** Altera o status de conclusão de uma tarefa.  
- **DELETE /tasks/{id}:** Exclui uma tarefa pelo ID.  

---

## Autor  

<div align="left">  
  <a href="https://github.com/gabibento">  
    <img alt="Gabriella Maurea Bento" src="https://avatars.githubusercontent.com/u/143539144?v=4" width="115" style="border-radius:50%">  
  </a>  
  <br>  
  <sub><b>Gabriella Maurea Bento</b></sub><br>  
</div>  

---

## 📝 Licença  

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.  

