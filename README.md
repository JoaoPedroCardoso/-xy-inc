# Instruções

Chamada dos serviços via heroku:

Para chamada dos serviços sem necessidade de realizar import do projeto, realizar as requisições via client:

Operação listar todos: https://app-xy-inc.herokuapp.com/poi

Operação cadastras pontos de interesse: https://app-xy-inc.herokuapp.com/poi 

Ex json: 
 
 "name": "NewPoi",
 
 "x": 30,
 
 "y": 30

Operação listar POIs por proximidade: https://app-xy-inc.herokuapp.com/poi/findByProximity?x=VALOR&y=VALOR&distance=VALOR

Ex: https://app-xy-inc.herokuapp.com/poi/findByProximity?x=20&y=10&distance=10

Para realizar import do projeto para funcionamento local:
-> git clone https://github.com/JoaoPedroCardoso/-xy-inc.git

-> Realizar o importar do mesmo no eclipse.

-> Escolher profile no application.properties, test para rodar no bando h2 e dev pra rodar no mysql.

	Para profile test, é possivel acessar o banco após a inicialização do app pela url: localhost:8080/h2-console.
	Para profile dev, deve ser inciado o mysqlq na maquina local no ip 3306 e criado um database com o nome 'db_xy'.

-> Executar mvn install e rodar aplicação.

Para execução dos testes:

Após aplicação configurada, exeutar a classe TestZupApplicationTests via JUnit ou executar comando mvn install/package ou mvn test.
