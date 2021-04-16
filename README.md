<img src="https://uploaddeimagens.com.br/images/003/197/768/original/g%C3%A1s_online_png.png?1618521989" alt="GasOnLine" title="Clique para ampliar">
  <p align="center"> 
    <b>Logo</b> 
  </p> 
</img>


&nbsp;&nbsp;&nbsp;&nbsp;GasOnLine é um sistema online para gerenciamento de deposito de gás, auxiliando nos processos de compra, venda e controle de estoque.


&nbsp;&nbsp;&nbsp;&nbsp;Este artigo descreve como o sistema foi projetado utilizando diagrama de classes para exibição da arquitetura do projeto e a modelagem de banco de dados para exibir os relacionamentos entre as tabelas do banco de dados, tecnologias utilizadas também como as funcionalidades do sistema.


### 1. Diagrama de Classe

&nbsp;&nbsp;&nbsp;&nbsp;A **figura 1** descreve a estrutura do sistema GasOnLine modelando suas classes descrevendo seus atributos e as relações entre objetos.

<img src="https://uploaddeimagens.com.br/images/003/197/639/original/Class_Diagram.PNG?1618519282" alt="Diagrama de classe" title="Clique para ampliar">
  <p align="center"> 
    <b>Figura 1 - Diagrama de classe</b> 
  </p> 
</img>

### 2. Modelo de banco de dados
&nbsp;&nbsp;&nbsp;&nbsp;A **figura 2** representa graficamente as entidades e seus relacionamentos com as demais entidades do banco de dados

<img src="https://uploaddeimagens.com.br/images/003/197/354/original/Modelo_Logico.png?1618512571" alt="Diagrama entidade relacionamento" title="Clique para ampliar">
  <p align="center"> 
    <b>Figura 2 - Diagrama entidade relacionamento</b> 
  </p> 
</img>

### 3. Tecnologias Utilizadas
&nbsp;&nbsp;&nbsp;&nbsp;A seguir serão listadas todas as tecnologias utilizadas no desenvolvimento do sistema Brewer

 - **Java** - Linguagem de programação utilizada para o desenvolvimento do sistema.
 
 - **Angular** - Frameworks de codigo aberto para contrução do frontend. 

 - **HTML 5 e CSS3** - Usada para codificação e estilização do projeto utilizando também a biblioteca CSS do **Bootstrap**.
 
 - **Maven** - Para arquitetura inicial de projeto e controle de dependências.

 - **Postgresql** - Linguagem de banco de dados utilizada.

 - **Selenium** - Usado para validações do sistema.

 - **JUnit** - Para teste unitários.


### 4. Interface do sistema
&nbsp;&nbsp;&nbsp;&nbsp;Nesse tópico serão mostradas as principais telas do sistemas seguindo de suas funcionalidades.

#### Cadastro de usuário
&nbsp;&nbsp;&nbsp;&nbsp;A **figura 3** Tela de Cadastro de usuário

<img src="https://i.ibb.co/SNNdvR6/Cad-Usuario.png" alt="Tela de Cadastro de usuário" title="Clique para ampliar">
  <p align="center"> 
    <b>Figura 3 - Tela de Cadastro de usuário</b> 
  </p> 
</img>


#### Cadastro de cliente
&nbsp;&nbsp;&nbsp;&nbsp;A **figura 4** Tela de Cadastro de cliente

<img src="https://uploaddeimagens.com.br/images/003/197/405/original/CadCliente.jpg?1618513825" alt="Tela de Cadastro de cliente" title="Clique para ampliar">
  <p align="center"> 
    <b>Figura 3 - Tela de Cadastro de cliente</b> 
  </p> 
</img>


#### Cadastro de Venda
&nbsp;&nbsp;&nbsp;&nbsp;A **figura 5** Registro de Venda

<img src="https://uploaddeimagens.com.br/images/003/197/407/original/RegistroVenda.jpg?1618513864" alt="Registro de Venda" title="Clique para ampliar">
  <p align="center"> 
    <b>Figura 3 - Registro de Venda</b> 
  </p> 
</img>
 
#### 5 Segurança
&nbsp;&nbsp;&nbsp;&nbsp;O sistema possui alguma camadas de seguranças a qual permite uma veracidade e integridade dentro do sistema.

#### 5.1 Autenticação
&nbsp;&nbsp;&nbsp;&nbsp;Com a autenticação cada “usuário” do sistema possui seu “e-mail” e “senha” para efetuar seu login. 

&nbsp;&nbsp;&nbsp;&nbsp;**Observação:** É preciso estar autenticado para operar qualquer funcionalidade dentro do sistema.

#### 5.1.1  Segurança de senha
&nbsp;&nbsp;&nbsp;&nbsp;Ao cadastrar um usuário no sistema a senha desse usuário será transformada num “hash”.

#### 5.2 Autorização
&nbsp;&nbsp;&nbsp;&nbsp;O sistema trabalha com níveis de permissão onde o usuário comum só pode ter acesso a funções do sistema relacionado ao vendedor, enquanto os usuários com permissões de administradores podem ter acesso a todo o sistema.
