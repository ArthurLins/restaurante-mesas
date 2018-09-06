
# restaurante-mesas
Sistema de gerenciamento de mesas. (POO)
#
* RF00 - Sistema deve possuir um **CRUD** de mesas, utilizando os seguintes dados: identificador,numero de pessoas.

  

* RF01 - O Sistema deve permitir o cadastro de novos clientes na fila sendo um deles o responsável pela reserva. Para que a reserva seja realizada o cliente responsável deve fornecer seu nome, telefone.

  

* RF02 - O Sistema deve ter um sistema de fila inteligente com margem ***X***, ou seja dar prioridades à clientes cujo a quantidade de pessoas correspondem o valor exato da mesa. 
**Exemplo**:
 
		  (1)   (2)   (3)   (4)     -- Identificador
		-------------------------
		|  2  |  3  |  3  |  4  |   -- Fila (Quantidade de pessoas)
**Processo:**   
01. Liberou mesa para 3 -> **(2)**

* ***(1)** é a próxima caso a diferença ***X*** ou se ele já foi pulado ***Y*** vezes*

02. Liberou mesa para 3 -> **(1)**

03. Liberou mesa para 2 -> Deixe livre.

04. Liberou mesa para 4 -> **(4)**

* ***(3)** é a próxima caso a diferença ***X*** ou se ele ja foi pulado ***Y*** vezes*

05. Liberou mesa pra 3 -> **(3)**

***X*** - DEFINIDO PELO SISTEMA
***Y*** - DEFINIDO PELO SISTEMA

* RF03 - O sistema deve permitir a liberação de mesas.
* RF04 - O Sistema deve permitir a remoção de um cliente da fila.
* RF05 - O sistema deve possuir um sistema de gerenciamento de fila, onde o operador ira chamar o próximo da fila, adicionar ou remover da fila.
* RF06 - O sistema deve possuir uma tela de chamada onde exibirá o numero do cliente a ser chamado.