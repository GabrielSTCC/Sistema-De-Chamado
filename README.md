---

# Sistema de Gerenciamento de Chamados

Este é um sistema de gerenciamento de chamados desenvolvido em Java, seguindo o padrão arquitetural MVC (Model-View-Controller). O sistema permite o gerenciamento de chamados de suporte, com diferentes permissões para usuários comuns e administradores. Ele utiliza uma interface gráfica (Swing) e se conecta a um banco de dados PostgreSQL para persistir os dados.

## Funcionalidades

### Usuários Comuns:
- **Login**: Autenticação de usuários para acesso ao sistema.
- **Abertura de Chamados**: Usuários comuns podem abrir novos chamados, onde os dados do usuário são preenchidos automaticamente.
- **Visualização de Chamados**: Podem visualizar apenas seus próprios chamados.
- **Cancelamento de Chamados**: Podem cancelar chamados, desde que estejam no status "Aberto".

### Administradores (UsuarioADM):
- **Login**: Autenticação com privilégios administrativos.
- **Gerenciamento de Chamados**: Podem visualizar e gerenciar os chamados de sua área.
- **Alteração de Status**: Podem atualizar o status de chamados para "Em andamento" ou "Fechado".
- **Edição de Chamados**: Podem editar os chamados de sua área.
- **Exclusão de Chamados**: Apenas chamados no status "Aberto" podem ser excluídos.

### Funcionalidades Técnicas:
- **Banco de Dados**: Conexão com PostgreSQL para persistência de dados de usuários e chamados.
- **Filtragem por Status e Área**: Administradores podem visualizar chamados por área e status.
- **Controle de Sessão**: Gerencia a sessão do usuário logado, diferenciando as permissões.
- **Interface Gráfica**: Interface intuitiva desenvolvida com Swing, ajustada conforme o tipo de usuário.
- **Pacotes MVC**: O sistema está organizado em pacotes conforme o padrão MVC:
  - **Model**: Classes que representam os dados (Usuários, Chamados, Enums).
  - **View**: Interfaces gráficas e componentes visuais.
  - **Controller**: Controladores que fazem a ligação entre a interface e a lógica de negócios.
  - **DAO**: Objetos de acesso a dados, responsáveis por interações com o banco de dados.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação principal.
- **Swing**: Biblioteca gráfica utilizada para desenvolver a interface do usuário.
- **PostgreSQL**: Sistema de banco de dados relacional.
- **Railway**: Plataforma para hospedar o banco de dados PostgreSQL.
- **Maven**: Gerenciamento de dependências e construção do projeto.
- **Padrão MVC**: Arquitetura do sistema.

## Instalação e Configuração

### Pré-requisitos:
- **Java 8+**: Certifique-se de ter o Java Development Kit (JDK) instalado.
- **PostgreSQL**: O sistema está configurado para usar o PostgreSQL como banco de dados. É necessário configurar o banco localmente ou em um serviço na nuvem (como o Railway).
- **Maven**: Para gerenciar as dependências e build do projeto.

### Passos de Instalação:

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-de-chamados.git
   cd sistema-de-chamados
   ```

2. Configure o arquivo `application.properties` (ou diretamente no código de conexão) com suas credenciais do PostgreSQL:
   ```properties
   spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
   spring.datasource.username=<seu-usuario>
   spring.datasource.password=<sua-senha>
   ```

3. Compile e execute o projeto utilizando o Maven:
   ```bash
   mvn clean install
   mvn exec:java
   ```

4. Ou gere o arquivo `.jar` para distribuição:
   ```bash
   mvn package
   ```

5. Execute o arquivo `.jar` gerado:
   ```bash
   java -jar target/sistema-de-chamados.jar
   ```

## Uso do Sistema

1. **Login**: Inicie o sistema e faça login com suas credenciais. Se você for um administrador, terá acesso a funcionalidades adicionais.
2. **Abertura de Chamados**: Usuários podem criar novos chamados preenchendo os campos necessários e enviando a solicitação.
3. **Gerenciamento de Chamados**: Administradores podem visualizar todos os chamados de sua área e atualizá-los conforme o status do atendimento.
4. **Encerramento**: Ao tentar fechar o sistema, será perguntado se deseja deslogar (retornar para a tela de login) ou encerrar o programa.

## Estrutura de Pastas

```bash
/src
   /main
      /java
         /controller    # Controladores do sistema (MVC)
         /model         # Classes de domínio e enums
         /view          # Interfaces gráficas (Swing)
         /dao           # Classes de acesso a dados
      /resources
         application.properties # Configurações do banco de dados
```

## Contribuição

Contribuições são bem-vindas! Para sugerir melhorias ou reportar bugs, por favor, abra uma [issue](https://github.com/seu-usuario/sistema-de-chamados/issues) ou envie um pull request.

## Licença

Este projeto está licenciado sob os termos da [MIT License](LICENSE).

---
